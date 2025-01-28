package krelox.metallurgychests.block;

import it.hurts.metallurgy_reforged.util.MetallurgyTabs;
import krelox.metallurgychests.MetallurgyChests;
import krelox.metallurgychests.tileentity.TileEntityMetalChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BlockMetalChest extends BlockContainer {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    private final int guiId;
    private final Supplier<TileEntityMetalChest> tileEntity;

    public BlockMetalChest(int guiId, Supplier<TileEntityMetalChest> tileEntity) {
        super(Material.IRON);

        this.guiId = guiId;
        this.tileEntity = tileEntity;

        String name = tileEntity.get().name;
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(MetallurgyTabs.tabSpecial);
        setHardness(6.0f);
        setHarvestLevel("pickaxe", 1);
        setResistance(18.0f);
        setSoundType(SoundType.METAL);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

        MetallurgyChestsBlocks.BLOCKS.add(this);
        MetallurgyChestsBlocks.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return tileEntity.get();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.875D, 0.9375D);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (stack.hasDisplayName() && worldIn.getTileEntity(pos) instanceof TileEntityMetalChest tileentity) {
            tileentity.setCustomName(stack.getDisplayName());
        }

    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntityMetalChest tileentity = (TileEntityMetalChest) worldIn.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(MetallurgyChests.instance, guiId, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Nullable
    public ILockableContainer getLockableContainer(World worldIn, BlockPos pos) {
        return this.getContainer(worldIn, pos, false);
    }

    @Nullable
    public ILockableContainer getContainer(World worldIn, BlockPos pos, boolean allowBlocking) {
        if (!(worldIn.getTileEntity(pos) instanceof TileEntityMetalChest tileentity)) {
            return null;
        }
        if (!allowBlocking && this.isBlocked(worldIn, pos)) {
            return null;
        }
        return tileentity;
    }

    public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        if (!blockState.canProvidePower()) {
            return 0;
        } else {
            int i = 0;
            TileEntity tileentity = blockAccess.getTileEntity(pos);

            if (tileentity instanceof TileEntityChest) {
                i = ((TileEntityChest) tileentity).numPlayersUsing;
            }

            return MathHelper.clamp(i, 0, 15);
        }
    }

    public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return side == EnumFacing.UP ? blockState.getWeakPower(blockAccess, pos, side) : 0;
    }

    private boolean isBlocked(World worldIn, BlockPos pos) {
        return this.isBelowSolidBlock(worldIn, pos) || this.isOcelotSittingOnChest(worldIn, pos);
    }

    private boolean isBelowSolidBlock(World worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.up()).doesSideBlockChestOpening(worldIn, pos.up(), EnumFacing.DOWN);
    }

    private boolean isOcelotSittingOnChest(World worldIn, BlockPos pos) {
        for (EntityOcelot entityocelot : worldIn.getEntitiesWithinAABB(EntityOcelot.class, new AxisAlignedBB(pos.getX(), pos.getY() + 1, pos.getZ(), pos.getX() + 1, pos.getY() + 2, pos.getZ() + 1))) {
            if (entityocelot.isSitting()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasComparatorInputOverride(IBlockState state) {
        return true;
    }

    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
        return Container.calcRedstoneFromInventory(this.getLockableContainer(worldIn, pos));
    }

    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.byIndex(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }
}

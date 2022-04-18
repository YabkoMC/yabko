package org.yabko.yabko.block;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.yabko.yabko.blockentity.BlockEntityRegistry;
import org.yabko.yabko.blockentity.MonstersShieldBlockEntity;

public class MonstersShieldBlock extends BlockWithEntity implements BlockEntityProvider {
    public static String block_name = "monsters_shield";

    public MonstersShieldBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MonstersShieldBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, BlockEntityRegistry.MONSTERS_SHIELD_BLOCK_ENTITY, MonstersShieldBlockEntity::tick);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            MonstersShieldBlockEntity be = (MonstersShieldBlockEntity) world.getBlockEntity(pos);
            if (be == null) return ActionResult.PASS;

            if (player.getStackInHand(Hand.MAIN_HAND).getItem() instanceof HoeItem) {
                be.setRadius(be.getRadius() - 5);
            } else {
                be.setRadius(be.getRadius() + 5);
            }

            player.sendMessage(new LiteralText(Integer.toString(be.getRadius())), false);
        }

        return ActionResult.SUCCESS;
    }
}

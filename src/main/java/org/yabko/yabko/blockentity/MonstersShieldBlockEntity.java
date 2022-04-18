package org.yabko.yabko.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class MonstersShieldBlockEntity extends BlockEntity {
    private int radius = 5;

    public MonstersShieldBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.MONSTERS_SHIELD_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, MonstersShieldBlockEntity be) {
        List<MobEntity> monsters = world.getEntitiesByType(
                TypeFilter.instanceOf(MobEntity.class),
                new Box(pos.getX() - be.getRadius(), pos.getY() - be.getRadius(), pos.getZ() - be.getRadius(),
                        pos.getX() + be.getRadius(), pos.getY() + be.getRadius(), pos.getZ() + be.getRadius()),
                EntityPredicates.VALID_LIVING_ENTITY
        );

        for (MobEntity e : monsters) {
            if (e instanceof Monster)
                e.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;

        if (this.radius <= 5)
            this.radius = 5;
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        tag.putInt("radius", this.getRadius());

        super.writeNbt(tag);
    }
    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);

        this.setRadius(tag.getInt("radius"));
    }
}

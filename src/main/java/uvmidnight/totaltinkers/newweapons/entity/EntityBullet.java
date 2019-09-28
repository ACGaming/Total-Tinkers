package uvmidnight.totaltinkers.newweapons.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;

public class EntityBullet extends EntityProjectileBase {

    public EntityBullet(World world) {
        super(world);
    }

    public EntityBullet(World world, double d, double d1, double d2) {
        super(world, d, d1, d2);
    }

    public EntityBullet(World world, EntityPlayer player, float speed, float inaccuracy, ItemStack stack, ItemStack launchingStack) {
        super(world, player, speed, inaccuracy, 1f, stack, launchingStack);
    }

    @Override
    protected ItemStack getArrowStack() {
        return null;
    }

    @Override
    protected void playHitEntitySound() {//nothing here
    }

    @Override
    public double getGravity() {
        return 0.01;
    }
}

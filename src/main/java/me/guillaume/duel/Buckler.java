package me.guillaume.duel;

import static me.guillaume.duel.Weapon.ONE_HAND_AXE;

public class Buckler implements BlocksDamage{
    private boolean isActive = false;
    private int numOfAxeBlocks = 0;


    @Override
    public Damage tryBlockDamage(Damage initialDamage) {
        if (isDestroyed()){
            return initialDamage;
        }
        Weapon weapon = initialDamage.weapon();
        block(weapon);
        return Damage.of(isActive ? 0 : initialDamage.hitPoints(), weapon);
    }

    private boolean isDestroyed() {
        return numOfAxeBlocks == 3;
    }

    private void block(Weapon weapon)  {
        isActive = !isActive;
        if (isActive && weapon == ONE_HAND_AXE){
            ++numOfAxeBlocks;
        }
    }


}

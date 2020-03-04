package me.guillaume.duel;

import static me.guillaume.duel.Weapon.ONE_HAND_AXE;

public class Viking extends Warrior {
    public Viking() {
        super(120, null, ONE_HAND_AXE);
    }

    public Viking(String enhancement) {
        super(120, enhancement, ONE_HAND_AXE);
    }

    Viking equip(String equipment) {
        doEquip(equipment);
        return this;
    }
}

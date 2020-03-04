package me.guillaume.duel;

import static me.guillaume.duel.Weapon.ONE_HAND_SWORD;

public class Swordsman extends Warrior{

    public Swordsman() {
        super(100, null, ONE_HAND_SWORD);
    }

    public Swordsman(String enhancement) {
        super(100, enhancement, ONE_HAND_SWORD);
    }

    Swordsman equip(String equipment) {
        doEquip(equipment);
        return this;
    }
}

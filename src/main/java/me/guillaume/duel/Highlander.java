package me.guillaume.duel;


import static me.guillaume.duel.Weapon.twoHandedSword;

public class Highlander extends Warrior{
    public Highlander() {
        super(150, null, twoHandedSword());
    }

    public Highlander(String enhancement) {
        super(150, enhancement, twoHandedSword());
    }
}

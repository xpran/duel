package me.guillaume.duel;

import static me.guillaume.duel.Weapon.TWO_HANDED_SWORD;

public class Highlander extends Warrior{
    public Highlander() {
        super(150, null, TWO_HANDED_SWORD);
    }

    public Highlander(String enhancement) {
        super(150, enhancement, TWO_HANDED_SWORD);
    }
}

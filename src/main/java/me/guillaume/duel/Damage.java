package me.guillaume.duel;

public class Damage {
    private final int hitPoints;
    private final Weapon weapon;

    private Damage(int hitPoints, Weapon weapon) {
        this.hitPoints = hitPoints;
        this.weapon = weapon;
    }

    int hitPoints() {
        return hitPoints;
    }

    Weapon weapon() {
        return weapon;
    }

    static Damage of(int hitPoints, Weapon weapon){
        return new Damage(hitPoints, weapon);
    }

    static Damage of(Damage damage, int damageAdjust){
        return new Damage(damage.hitPoints + damageAdjust, damage.weapon());
    }
}

package me.guillaume.duel;

public class Weapon implements DeliversDamage {
    static final Weapon ONE_HAND_SWORD = new Weapon(5, false);
    static final Weapon ONE_HAND_AXE = new Weapon(6, true);

    protected final int hitPoints;
    private final boolean isAxe;

    private Weapon(int hitPoints, boolean isAxe) {
        this.hitPoints = hitPoints;
        this.isAxe = isAxe;
    }

    @Override
    public Damage deliverDamage() {
        return Damage.of(hitPoints, this);
    }

    public boolean isAxe() {
        return isAxe;
    }

    static Weapon twoHandedSword() {
        return new Weapon(12, false) {
            private int numOfAttacks = 0;

            @Override
            public Damage deliverDamage() {
                use();
                return Damage.of(canAttack() ? hitPoints : 0, this);
            }

            boolean canAttack() {
                return numOfAttacks > 0;
            }

            void use() {
                numOfAttacks = ++numOfAttacks % 3;
            }

        };

    }
}

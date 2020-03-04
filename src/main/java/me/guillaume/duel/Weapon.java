package me.guillaume.duel;

public enum Weapon implements DeliversDamage {
    ONE_HAND_SWORD(5),
    ONE_HAND_AXE(6),
    TWO_HANDED_SWORD(12){
        private int numOfAttacks = 0;
        @Override
        public Damage deliverDamage() {
            use();
            return Damage.of(canAttack() ? hitPoints : 0, this);
        }
        boolean canAttack(){
            return numOfAttacks > 0;
        }

        void use(){
            numOfAttacks = ++numOfAttacks % 3;
        }

    };
    protected final int hitPoints;
    Weapon(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    @Override
    public Damage deliverDamage() {
        return Damage.of(hitPoints, this);
    }
}

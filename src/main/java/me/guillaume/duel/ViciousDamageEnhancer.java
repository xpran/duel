package me.guillaume.duel;

public class ViciousDamageEnhancer implements EnhancesDamage {
    private int numOfBlows = 0;

    @Override
    public Damage enhance(Damage initialDamage) {
        if (numOfBlows < 2){
            ++numOfBlows;
            return Damage.of(initialDamage, +20);
        }
        return initialDamage;
    }
}

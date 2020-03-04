package me.guillaume.duel;

public class NoopDamageEnhancer implements EnhancesDamage {
    @Override
    public Damage enhance(Damage damage) {
        return damage;
    }
}

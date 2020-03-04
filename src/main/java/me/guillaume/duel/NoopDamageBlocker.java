package me.guillaume.duel;

public class NoopDamageBlocker implements BlocksDamage {
    @Override
    public Damage tryBlockDamage(Damage damage) {
        return damage;
    }
}

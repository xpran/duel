package me.guillaume.duel;

public class NoopDamageReducer implements ReducesReceivedDamage, ReducesDeliveredDamage {
    @Override
    public Damage reducedReceivedDamage(Damage initialDamage) {
        return initialDamage;
    }

    @Override
    public Damage reducedDeliveredDamage(Damage initialDamage) {
        return initialDamage;
    }
}

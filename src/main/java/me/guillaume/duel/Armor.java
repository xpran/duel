package me.guillaume.duel;

public class Armor implements ReducesReceivedDamage, ReducesDeliveredDamage{
    @Override
    public Damage reducedReceivedDamage(Damage initialDamage) {
        return Damage.of(initialDamage,  initialDamage.hitPoints() == 0 ? 0 : -3);
    }

    @Override
    public Damage reducedDeliveredDamage(Damage initialDamage) {
        return Damage.of(initialDamage,  -1);
    }
}

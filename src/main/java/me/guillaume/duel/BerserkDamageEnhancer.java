package me.guillaume.duel;

public class BerserkDamageEnhancer implements EnhancesDamage {
    private final HasHitPoints hasHitPoints;

    public BerserkDamageEnhancer(HasHitPoints hasHitPoints) {
        this.hasHitPoints = hasHitPoints;
    }

    @Override
    public Damage enhance(Damage initialDamage) {
        if (hasHitPoints.hitPoints() < hasHitPoints.initialHitPoints() * 0.3){
            return Damage.of(initialDamage, initialDamage.hitPoints());
        }
        return initialDamage;
    }
}

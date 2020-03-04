package me.guillaume.duel;

public abstract class Warrior implements DeliversDamage, HasHitPoints{
    protected int hitPoints;
    protected final int initialHitPoints;
    protected Weapon weapon;
    protected BlocksDamage damageBlocker = new NoopDamageBlocker();
    protected ReducesReceivedDamage receivedDamageReducer = new NoopDamageReducer();
    protected ReducesDeliveredDamage deliveredDamageReducer = new NoopDamageReducer();
    protected final EnhancesDamage damageEnhancer;

    Warrior(int hitPoints, String enhancement, Weapon weapon) {
        initialHitPoints = hitPoints;
        this.hitPoints = hitPoints;
        this.weapon = weapon;
        switch (enhancement != null ? enhancement :"NOOP"){
            case "Vicious":
                damageEnhancer = new ViciousDamageEnhancer();
                break;
            case "Veteran":
                damageEnhancer = new BerserkDamageEnhancer(this);
                break;
            default:
                damageEnhancer = new NoopDamageEnhancer();
                break;
        }
    }

    void engage(Warrior other) {
        Combat.of(this, other).start();
    }

    public int hitPoints() {
        return hitPoints;
    }

    @Override
    public int initialHitPoints() {
        return initialHitPoints;
    }

    boolean isAlive(){
        return hitPoints > 0;
    }

    void takeBlow(Damage damage){
        Damage damageToTake = damageBlocker.tryBlockDamage(damage);
        Damage reducedDamage = receivedDamageReducer.reducedReceivedDamage(damageToTake);
        hitPoints -= reducedDamage.hitPoints();
        hitPoints = hitPoints > 0 ? hitPoints : 0;
    }


     void doEquip(String equipment) {
        switch (equipment){
            case "buckler" :
                this.damageBlocker = new Buckler();
                break;
            case "armor" :
                Armor armor = new Armor();
                this.receivedDamageReducer = armor;
                this.deliveredDamageReducer = armor;
                break;
            case "axe" :
                this.weapon = Weapon.ONE_HAND_AXE;
                break;
            default:
                break;
        }
    }

    @Override
    public Damage deliverDamage() {
        return deliveredDamageReducer.reducedDeliveredDamage(damageEnhancer.enhance(weapon.deliverDamage()));
    }

    void giveBlow(Warrior otherWarrior){
        if (this.isAlive() && otherWarrior.isAlive()){
            otherWarrior.takeBlow(this.deliverDamage());
        }
    }
}

package me.guillaume.duel;

public final class Combat {
    private final Warrior warriorA;
    private final Warrior warriorB;

    private Combat(Warrior warriorA, Warrior warriorB) {
        this.warriorA = warriorA;
        this.warriorB = warriorB;
    }

    static Combat of(Warrior warriorA, Warrior warriorB){
        return new Combat( warriorA,  warriorB);
    }

    void start(){
        while(warriorA.isAlive() && warriorB.isAlive()){
            warriorA.giveBlow(warriorB);
            if (warriorB.isAlive()){
                warriorB.giveBlow(warriorA);
            }
        }
    }
}

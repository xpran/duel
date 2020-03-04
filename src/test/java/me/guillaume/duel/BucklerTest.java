package me.guillaume.duel;

import org.junit.Test;

import static org.junit.Assert.*;

public class BucklerTest {

    @Test
    public void tryBlockDamage() {
        Buckler buckler = new Buckler();
        Weapon weapon = Weapon.twoHandedSword();
        assertEquals(0, buckler.tryBlockDamage(weapon.deliverDamage()).hitPoints());
        assertEquals(12, buckler.tryBlockDamage(weapon.deliverDamage()).hitPoints());
    }
}
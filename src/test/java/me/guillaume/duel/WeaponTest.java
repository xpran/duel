package me.guillaume.duel;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {

    @Test
    public void deliverDamageTwoHandedSword() {
        Weapon w = Weapon.twoHandedSword();
        assertEquals(12, w.deliverDamage().hitPoints());
        assertEquals(12, w.deliverDamage().hitPoints());
        assertEquals(0, w.deliverDamage().hitPoints());
        assertEquals(12, w.deliverDamage().hitPoints());

    }
}
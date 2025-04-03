package org.example;

import java.util.Random;

public class Warrior extends CharacterClass implements IAttacker {

    Random random = new Random();
    private int stamina = random.nextInt(41) + 10;
    private int strength=random.nextInt(10)+1;

    public Warrior( int stamina, int strength) {
        super(name,hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    @Override
    public void attack() {

    }
}

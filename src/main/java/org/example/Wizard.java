package org.example;

import java.util.Random;

// Wizard class extending Character and implementing Attacker interface
public class Wizard /*extends Character implements Attacker*/ {
    Random random = new Random();
    private int mana;
    private int intelligence;


    // Constructor
    public Wizard(String name) {
        super(name, random.nextInt(51) + 50); // HP between 50-100
        this.mana = random.nextInt(41) + 10; // Mana between 10-50
        this.intelligence = random.nextInt(50) + 1; // Intelligence between 1-50
    }

    // Getters
    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    // Setters
    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
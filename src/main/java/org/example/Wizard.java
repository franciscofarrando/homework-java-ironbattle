package org.example;

import java.util.Random;

// Wizard class extending Character and implementing Attacker interface
public class Wizard extends CharacterClass implements IAttacker {
    Random random = new Random();
    private int mana= random.nextInt(41) + 10; // Mana between 10-50
    private int intelligence= random.nextInt(50) + 1; // Intelligence between 1-50;


    // Constructor
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp); // HP between 50-100
        this.mana=mana;
        this.intelligence=intelligence;
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

    @Override
    public void attack() {

    }
}
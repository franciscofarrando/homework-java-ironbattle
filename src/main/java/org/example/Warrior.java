package org.example;
import java.util.Random;

public class Warrior extends CharacterClass implements IAttacker {
    private int stamina;
    private final int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    @Override
    public void attack(CharacterClass target) {
        if (stamina >= 5) {
            target.setHp(target.getHp() - strength);
            stamina -= 5;
            System.out.println(getName() + " usó Ataque Pesado, daño: " + strength);
        } else if (stamina >= 1) {
            int damage = strength / 2;
            target.setHp(target.getHp() - damage);
            stamina += 1;
            System.out.println(getName() + " usó Ataque Débil, daño: " + damage);
        } else {
            stamina += 2;
            System.out.println(getName() + " está agotado y no pudo atacar. Recuperó 2 de energía.");
        }
    }

    public String getStats() {
        return "HP: " + getHp() + ", Stamina: " + stamina + ", Strength: " + strength;
    }
}

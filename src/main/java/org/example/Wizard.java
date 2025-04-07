package org.example;

public class Wizard extends CharacterClass implements IAttacker {
    private int mana;
    private final int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    @Override
    public void attack(CharacterClass target) {
        if (mana >= 5) {
            target.setHp(target.getHp() - intelligence);
            mana -= 5;
            System.out.println(getName() + " lanzó Bola de Fuego, daño: " + intelligence);
        } else if (mana >= 1) {
            target.setHp(target.getHp() - 2);
            mana += 1;
            System.out.println(getName() + " golpeó con Bastón, daño: 2");
        } else {
            mana += 2;
            System.out.println(getName() + " no tiene maná y no pudo atacar. Recuperó 2 de maná.");
        }
    }

    public String getStats() {
        return "HP: " + getHp() + ", Mana: " + mana + ", Intelligence: " + intelligence;
    }
}
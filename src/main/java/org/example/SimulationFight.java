package org.example;

import java.util.Random;

public class SimulationFight extends CharacterClass {
    public SimulationFight(String name, int hp) {
        super(name, hp);
    }

    public static String generateNameRandom() {
        Random rand = new Random();
        // random names for Warrior and Wizards
        String[] names = {"Juan Jose", "Francisco", "Jose", "Maria", "Pedro", "Lucia",
                "Luis"};
        int indexName = rand.nextInt(names.length);
        // random Name
        return names[indexName];
    }

    public static String generateTypeRandom() {
        Random rand = new Random();
        // types
        String[] typePlayer = {"Warrior", "Wizard"};
        int indexType = rand.nextInt(typePlayer.length);
        // random Type
        return typePlayer[indexType];
    }

    public static Object generateCharacter() {
        Object character;
        Random rand = new Random();
        int hp = rand.nextInt(101) + 100;          // 100-200
        int stamina = rand.nextInt(41) + 10;       // 10-50
        int strength = rand.nextInt(10) + 1;
        String randomName = generateNameRandom();
        String playerType = generateTypeRandom();


        if (playerType.equals("Wizard")) {
            Wizard wz = new Wizard(randomName, hp, stamina, strength);
            character = wz;
            return character;
        }

        Warrior wr = new Warrior(randomName, hp, stamina, strength);
        character = wr;
        return character;


    }
    public static void startBattle(CharacterClass fighter1,
                                    CharacterClass fighter2) {
        if (fighter1 == null || fighter2 == null) {
            System.out.println("Debes crear dos personajes antes de batallar.");
            return;
        }

        CharacterClass c1 =  fighter1;
        CharacterClass c2 =  fighter2;

        System.out.println("\n¡BATALLA INICIA!");
        System.out.println(c1.getName() + " vs " + c2.getName());

        int ronda = 1;
        while (c1.isAlive() && c2.isAlive()) {
            System.out.println("\n--- Ronda " + ronda + " ---");
//            fighter1.attack(c2);
//            fighter2.attack(c1);
            System.out.println(c1.getName() + " HP: " + c1.getHp());
            System.out.println(c2.getName() + " HP: " + c2.getHp());
            ronda++;
        }

        if (!c1.isAlive() && !c2.isAlive()) {
            System.out.println("\n¡Empate! Ambos personajes cayeron.");
        } else if (c1.isAlive()) {
            System.out.println("\n¡" + c1.getName() + " ha ganado!");
        } else {
            System.out.println("\n¡" + c2.getName() + " ha ganado!");
        }

        fighter1 = null;
        fighter2 = null;
    }


    public static void simulator() {
        // generate Character
        CharacterClass fight1 = (CharacterClass)generateCharacter();
        CharacterClass fight2 = (CharacterClass)generateCharacter();
        startBattle(fight1,fight2);

    }




}

package org.example;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static IAttacker fighter1 = null;
    static IAttacker fighter2 = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n== MENÚ RPG BATTLE ==");
            System.out.println("1. Crear Guerrero");
            System.out.println("2. Crear Mago");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Importar personajes desde CSV");
            System.out.println("5. Simular Batalla");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (option) {
                case 1 -> createWarrior();
                case 2 -> createWizard();
                case 3 -> startBattle();
                case 4 -> importCharactersFromCvs();
                case 5 ->simulator();
                case 6 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    public static void createWarrior() {
        if (fighter1 != null && fighter2 != null) {
            System.out.println("Ya tienes dos personajes.");
            return;
        }

        System.out.print("Nombre del Guerrero: ");
        String name = scanner.nextLine();

        Random rand = new Random();
        int hp = rand.nextInt(101) + 100;          // 100-200
        int stamina = rand.nextInt(41) + 10;       // 10-50
        int strength = rand.nextInt(10) + 1;       // 1-10

        Warrior warrior = new Warrior(name, hp, stamina, strength);

        if (fighter1 == null) fighter1 = warrior;
        else fighter2 = warrior;

        System.out.println("Guerrero creado:");
        System.out.println(name + " - HP: " + hp + ", Stamina: " + stamina + ", Strength: " + strength);
    }

    public static void createWizard() {
        if (fighter1 != null && fighter2 != null) {
            System.out.println("Ya tienes dos personajes.");
            return;
        }

        System.out.print("Nombre del Mago: ");
        String name = scanner.nextLine();

        Random rand = new Random();
        int hp = rand.nextInt(51) + 50;            // 50-100
        int mana = rand.nextInt(41) + 10;          // 10-50
        int intelligence = rand.nextInt(50) + 1;   // 1-50

        Wizard wizard = new Wizard(name, hp, mana, intelligence);

        if (fighter1 == null) fighter1 = wizard;
        else fighter2 = wizard;

        System.out.println("Mago creado:");
        System.out.println(name + " - HP: " + hp + ", Mana: " + mana + ", Intelligence: " + intelligence);
    }

    public static void startBattle() {
        if (fighter1 == null || fighter2 == null) {
            System.out.println("Debes crear dos personajes antes de batallar.");
            return;
        }

        CharacterClass c1 = (CharacterClass) fighter1;
        CharacterClass c2 = (CharacterClass) fighter2;

        System.out.println("\n¡BATALLA INICIA!");
        System.out.println(c1.getName() + " vs " + c2.getName());

        int ronda = 1;
        while (c1.isAlive() && c2.isAlive()) {
            System.out.println("\n--- Ronda " + ronda + " ---");
            fighter1.attack(c2);
            fighter2.attack(c1);
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

    public static void importCharactersFromCvs() {
        if (fighter1 != null && fighter2 != null) {
            System.out.println("Ya tienes dos personajes.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                "src/main/java/org/example/characters.csv"))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // skip header
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length < 2) continue;

                String type = parts[0].trim().toLowerCase();
                String name = parts[1].trim();

                Random rand = new Random();

                if (type.equals("warrior")) {
                    int hp = rand.nextInt(101) + 100;
                    int stamina = rand.nextInt(41) + 10;
                    int strength = rand.nextInt(10) + 1;
                    Warrior warrior = new Warrior(name, hp, stamina, strength);
                    if (fighter1 == null) fighter1 = warrior;
                    else fighter2 = warrior;
                } else if (type.equals("wizard")) {
                    int hp = rand.nextInt(51) + 50;
                    int mana = rand.nextInt(41) + 10;
                    int intelligence = rand.nextInt(50) + 1;
                    Wizard wizard = new Wizard(name, hp, mana, intelligence);
                    if (fighter1 == null) fighter1 = wizard;
                    else fighter2 = wizard;
                }

                if (fighter1 != null && fighter2 != null) break;
            }

            System.out.println("Personajes importados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV.");
            e.printStackTrace();
        }
    }
    public static void simulator() {
        // generate Character
         fighter1 = (IAttacker) generateCharacter();
         fighter2 = (IAttacker) generateCharacter();
        startBattle();

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





}
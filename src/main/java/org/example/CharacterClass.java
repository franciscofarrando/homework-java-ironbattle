package org.example;

public class CharacterClass {
    private String id;
    private String name;
    private int hp;
    private final boolean isAlive = true;

    public CharacterClass(String name, int hp) {
        setName(name);
        setHp(hp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

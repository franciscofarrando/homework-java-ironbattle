package org.example;

import java.util.UUID;

public abstract class CharacterClass {
    private final String id;
    private final String name;
    private int hp;
    private boolean isAlive;

    public CharacterClass(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public boolean isAlive() { return isAlive; }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
        this.isAlive = this.hp > 0;
    }
}

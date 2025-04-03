package org.example;

import java.util.UUID;

public class CharacterClass {
    private String id;
    private String name;
    private int hp;
    private final boolean isAlive = true;


//constructor method
    public CharacterClass(String name, int hp) {
        this.id= UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
    }




   //getters y setters
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

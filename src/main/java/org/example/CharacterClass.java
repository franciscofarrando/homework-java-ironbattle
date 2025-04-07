package org.example;

import java.util.UUID;

public class CharacterClass {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;



//constructor method
    public CharacterClass(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.isAlive=true;

add
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

    public boolean hasAlive() {
        return isAlive;
    }
    public void setAlive(boolean isAlive){
        this.isAlive=isAlive;
    }
}

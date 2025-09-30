/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author User
 */
public class Animal {
        private String name;
    protected int weight;
    protected String id;
    protected String sound;
 
    public Animal(int weight, String id, String sound) {
        // валидиране
        this.weight = weight;
        this.id = id;
        this.sound = sound;
    }
     protected void setName(String value) {
        name = value;
    }
 
    @Override
    public String toString() {
        return String.format("%s with id: %s, weight: %3d, sound: %s",
                name, id, weight, sound);
    }
}

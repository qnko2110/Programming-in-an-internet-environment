/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals.pkg3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Animals3 {

    public static void main(String[] args) {
        
        final int NUM_OF_PIGS = 10;
        List<Animal> pigFarm = new ArrayList<>();
        // ------------------------------------------- Add pigs to farm
        for (int i = 1; i <= NUM_OF_PIGS; i++) {
            String idValue = String.format("'BG S34 %08d'", i);
            int weightValue
                    = Utils.getRandomInRange(Utils.PIG_MIN_WEIGHT,
                            Utils.PIG_MAX_WEIGHT);
            String soundValue = "oink";
            Animal pig = new Pig(weightValue, idValue, soundValue);
            pigFarm.add(pig);
        }
        // ------------------------------------- Show pigs' information
        for (Animal pig : pigFarm) {
            System.out.println(pig);
        }
        // ------------------------------------------------------------
    }

}

class Animal {

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

class Cow extends Animal {

    public Cow(int weight, String id, String sound) {
        super(weight, id, sound);
        setName(this.getClass().getSimpleName());
    }
}

class Pig extends Animal {

    public Pig(int weight, String id, String sound) {
        super(weight, id, sound);
        setName(this.getClass().getSimpleName());
    }
}

class Utils {

    public final static int PIG_MIN_WEIGHT = 80;
    public final static int PIG_MAX_WEIGHT = 140;

    static int getRandomInRange(int start, int end) {
        final Random generator = new Random();
        return start + generator.nextInt(end - start + 1);
    }
}

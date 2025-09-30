/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import animalsexamplewithcommands.Animal;
import animalsexamplewithcommands.Utils;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    private final List<Animal> pigFarm;

    public Filter(List<Animal> pigFarm) {
        this.pigFarm = pigFarm;
    }

    public void execute() {
        System.out.print("Filter: ");
        System.out.println("\nFirst 3 big pigs:");
        pigFarm.stream()
                .filter(pig -> pig.getWeight() > Utils.BIG_PIGS_WEIGHT_TH)
                .peek(System.out::println)
                .limit(3)
                .collect(Collectors.toList());   
    }
}

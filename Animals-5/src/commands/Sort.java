/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import animalsexamplewithcommands.Animal;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

    private final List<Animal> pigFarm;

    public Sort(List<Animal> pigFarm) {
        this.pigFarm = pigFarm;
    }

    public void execute() {
        System.out.print("Sort: ");
        System.out.println("\nSort the pigs by their weight:");
        pigFarm.stream()
                .sorted((pig1, pig2) -> pig2.getWeight() - pig1.getWeight())
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}

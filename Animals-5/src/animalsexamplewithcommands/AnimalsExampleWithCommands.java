/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsexamplewithcommands;

import commands.*;
import java.util.ArrayList;
import java.util.List;


public class AnimalsExampleWithCommands {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int NUM_OF_PIGS = 10;
        List<Animal> pigFarm = new ArrayList();
        // -------------------------------------------------------- Build a farm
        int counter = 0;
        while (counter < NUM_OF_PIGS) {

            String idValue = String.format("'BG S34 %08d'", counter);
            int weightValue
                    = Utils.getRandomInRange(Utils.MIN_WEIGHT, Utils.MAX_WEIGHT);
            String soundValue = "oink";

            Animal pig = new AnimalFactory.build(AnimalType.PIG)
                    .weight(weightValue)
                    .id(idValue)
                    .sound(soundValue)
                    .create();
            if (pig != null) {
                pigFarm.add(pig);
                counter++;
            }
        }
        
        // ---------------------------------- Show information about all animals
        System.out.println("\nList of all pigs:");
        pigFarm.forEach(System.out::println);

        // ------------------------------------------------------- Send commands
        ThreadPool pool = new ThreadPool(5);

        SortJob sortJob = new SortJob();
        Sort sort = new Sort(pigFarm);
        sortJob.setSort(sort);

        FilterJob filterJob = new FilterJob();
        Filter filter = new Filter(pigFarm);
        filterJob.setFilter(filter);

        pool.addJob(sortJob);
        pool.addJob(filterJob);

        pool.shutdownPool();
        // ---------------------------------------------------------------------

    }

}

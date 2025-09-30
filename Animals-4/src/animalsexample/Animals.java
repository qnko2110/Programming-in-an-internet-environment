package animalsexample;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Animals {
    
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
        System.out.println("\nList of all animals:");
        pigFarm.forEach(System.out::println);
        // ------------------------------- Filter: Sort the pigs by their weight
        System.out.println("\nSort the animals by their weight:");
        pigFarm.stream()
                .sorted((pig1, pig2) -> pig1.weight - pig2.weight)
                .peek(System.out::println)
                .collect(Collectors.toList());

        // ----------------------Filter: Finding the lightest and heaviest pigs.
        System.out.println("\nFinding the lightest and heaviest animal:");
        Animal lightestPig = pigFarm
                .stream()
                .min((pig1, pig2) -> pig1.weight - pig2.weight)
                .orElseThrow(NoSuchElementException::new);
        Animal heaviestPig = pigFarm
                .stream()
                .max((pig1, pig2) -> pig1.weight - pig2.weight)
                .orElseThrow(NoSuchElementException::new);
        System.out.println(String.format("Lightest animal is %s, weight: %d",
                lightestPig.id, lightestPig.weight));
        System.out.println(String.format("Heaviest animal is %s, weight: %d",
                heaviestPig.id, heaviestPig.weight));
        // -------------------------------------- Filter: Get a list of big pigs
        System.out.println("\nList of big animals:");
        pigFarm.stream()
                .filter(pig -> pig.weight > Utils.BIG_PIGS_WEIGHT_TH)
                .peek(System.out::println)
                .collect(Collectors.toList());
        // ---------------------------------------- Filter: Get first 3 big pigs
        System.out.println("\nFirst 3 big animals:");
        pigFarm.stream()
                .filter(pig -> pig.weight > Utils.BIG_PIGS_WEIGHT_TH)
                .peek(System.out::println)
                .limit(3)
                .collect(Collectors.toList());
        // --------------------- Filter: Get number of pigs with specific weight
        System.out.print("\nNumber of animals with weight between 80 and 90 kg: ");
        long count = pigFarm
                .stream()
                .filter(pig -> pig.weight > 80 && pig.weight < 90)
                .count();
        System.out.println(count);
        // ---------------- Filter: find the first pig weighting exactly 100 kg.
        System.out.print("\nThe first animal, which weighs exactly 100 kg.: ");
        Animal pig100 = pigFarm
                .stream()
                .filter(pig -> pig.weight == 100)
                .findFirst()
                .orElse(null);
        System.out.println(pig100 != null ? pig100.id : "none");

        // -------------------- Filter: Is there a pig weighting exactly 100 kg.
        System.out.print("\nIs there an animal that weighs exactly 100 kg: ");
        boolean pig100kgFlag = pigFarm
                .stream()
                .anyMatch(pig -> pig.weight == 100);
        System.out.println(pig100kgFlag ? "yes" : "no");

        // ---------------- Filter: Print IDs of pigs weighing more than 130 kg.
        System.out.println("\nPrint IDs of animals weighing more than 130 kg:");
        String pigIds = pigFarm
                .stream()
                .filter(pig -> pig.weight > 130)
                .map(Animal::getId)
                .collect(Collectors.joining("\n"));
        System.out.println(pigIds);
        // ---------------------------------------------------------------------
        
    }
}

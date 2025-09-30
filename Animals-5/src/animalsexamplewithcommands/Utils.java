
package animalsexamplewithcommands;

import java.util.Random;

public class Utils {

    public final static int MIN_WEIGHT = 80;
    public final static int MAX_WEIGHT = 140;
    public final static int BIG_PIGS_WEIGHT_TH = 130;

    static int getRandomInRange(int start, int end) {
        final Random generator = new Random();
        return start + generator.nextInt(end - start + 1);
    }

}


package animalsexamplewithcommands;

public class Cow extends Animal {

    public Cow(int weight, String id, String sound) {
        
        super(weight, id, sound);
        setName(this.getClass().getSimpleName());
        
    }

}


package animalsexample;

public class Pig extends Animal {

    public Pig(int weight, String id, String sound) {
        
        super(weight, id, sound);
        setName(this.getClass().getSimpleName());
        
    }
    
}

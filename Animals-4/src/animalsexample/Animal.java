package animalsexample;

public class Animal {
    
    private String name;
    protected int weight;
    protected String id;
    protected String sound;

    public Animal(int weight, String id, String sound) {    
        
        if (weight < Utils.MIN_WEIGHT || weight > Utils.MAX_WEIGHT) {
            throw new AnimalException("Invalid weight value!");
        }
        if (id == null || id.length() == 0) {
            throw new AnimalException("Invalid id value!");
        }
        if (sound == null || sound.length() == 0) {
            throw new AnimalException("Invalid sound value!");
        }
        this.weight = weight;
        this.id = id;
        this.sound = sound;
  
    }
    
    protected void setName(String value) {
        name = value;
    }
    
    protected String getId() {
        return id;
    }
    
    public int getWeight() {
        return weight;
    }
    
    @Override   
    public String toString() {
        return String.format("%s with id: %s, weight: %3d, sound: %s",
                name, id, weight, sound);
    }

}

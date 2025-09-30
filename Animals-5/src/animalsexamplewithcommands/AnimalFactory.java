
package animalsexamplewithcommands;

class AnimalFactory {

    // -------------------------------------------------------------------------
    public static class build {

        private final AnimalType type;
        private int weight;
        private String id;
        private String sound;
       
        // ---------------------------------------------------------------------
        public build(AnimalType value) {
            type = value;
        }
        // ---------------------------------------------------------------------
        public build weight(int value) {
            weight = value;
            return this;
        }
        public build id(String value) {
            id = value;
            return this;
        }
        public build sound(String value) {
            sound = value;
            return this;
        }

        // ---------------------------------------------------------------------
        public Animal create() {
            Animal instance = null;
            
            try {
                if (type == null) {
                    throw new AnimalException("The type of animal is not specified.");
                }
                switch (type) {
                    case PIG:
                        instance = new Pig(weight, id, sound);
                        break;
                    case COW:
                        instance = new Cow(weight, id, sound);
                        break;
                    default:
                        throw new AnimalException("Invalid animal type");
                }
            } catch (AnimalException | NullPointerException e) {
                
                instance = null;
                System.out.print("Error (" + type + "): ");
                String info = e.getMessage();
                if (info == null) {
                    info = "Uninitialized parameter!";
                }
                System.out.println(info);
                
            }
            return instance;
            
        }
        // ---------------------------------------------------------------------
    }
}



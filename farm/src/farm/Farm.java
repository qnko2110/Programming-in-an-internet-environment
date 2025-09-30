/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm;

/**
 *
 * @author User
 */
public class Farm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
abstract class Животно {
    int тегло;
    String id, звук, име;
    public Животно(int тегло, String id, String звук) {
        this.тегло = тегло;
        this.id = id;
        this.звук = звук;
    }
    abstract void звук();
    abstract void информация();
}

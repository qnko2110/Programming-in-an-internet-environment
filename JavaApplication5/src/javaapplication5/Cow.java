/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author User
 */
public class Cow  extends Animal{
      public Cow(int weight, String id, String sound) {
        super(weight, id, sound);
        setName(this.getClass().getSimpleName());
      }
}

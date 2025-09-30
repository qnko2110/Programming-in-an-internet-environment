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
public class JavaApplication5 {

    
    public static void main(String[] args) {
		Animal pig1 = new Pig(120, "123456", "oink, oink");
        Animal cow1 = new Cow(240, "234567", "moo, moooo");
        System.out.println(pig1);
        System.out.println(cow1);
    }
    
}

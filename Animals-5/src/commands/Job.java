/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;



public interface Job {
    
    static Object lock = new Object();
    public void run();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author User
 */
public class JavaApplication1 {

    public static void main(String[] args) {
     int[] array1 = {12, 344, 3, 0, 98, -23}; 
     int n = array1.length;
     for (int index =0; index<n; index++){
         int digit =array1[index];
         if (digit % 2==0){
             System.out.println(index+":"+digit);
         }
    }
    }  
}

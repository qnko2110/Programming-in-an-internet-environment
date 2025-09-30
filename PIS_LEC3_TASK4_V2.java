/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pis_lec3_task4_v2;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class PIS_LEC3_TASK4_V2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Моля, въведете годините:" );
        Scanner input =new Scanner(System.in);
        int n =input.nextInt();
        if(n<=0) {
            System.out.println("Очаква се да се въведе цяло положително число!");
          return;  
        }
       int i=0;
       int[]years=new int[n];
       do{
          System.out.print("Година"+(i+1)+":");
          int year =input.nextInt();
          if (year>0) {
              years[i]=year;
              i++;
          } else{
              System.out.println( "Невалидна година:"+year);
          }
         
       }
       while(i!=n);
          }
          
       }

         
       
       
       
       


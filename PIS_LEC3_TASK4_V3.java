/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pis_lec3_task4_v3;

import java.util.InputMismatchException;
import java.util.Scanner;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author User
 */
public class PIS_LEC3_TASK4_V3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Моля, въведете броя на годините: ");
            try {
                n = input.nextInt();
            } catch (InputMismatchException e) {
                input.next();
            }
        } while (n <= 0);
        int i = 0;
        int years[] = new int[n];
        do {
            System.out.print("Година " + (i + 1) + ": ");
            try {
                int year = input.nextInt();
                if (year >= 0) {
                    years[i] = year;
                    i++;
                } else {
                    System.out.println("Годината трябва да е полижително число");
                }
            } catch (InputMismatchException e) {
                System.out.println("Годината трябва да е число");
                input.next();
            }
        } while (i != n);
        String status;
         for ( i = 0; i < n; i++) {
            int year = years[i];
            if (isLeap(year)) {
                status = "е високосна";
            }
            else {
                status = "не е високосна";
            }
            String info = String.format("Годината %d %s.", year, status);
            System.out.println(info);
        }

    }
    private static boolean isLeap(int year) {
        boolean result = false;
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            result = true;
        }
        return result;
    }
}

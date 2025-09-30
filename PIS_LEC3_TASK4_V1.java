/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pis_lec3_task4_v1;

/**
 * @доц. Р.Иванов
 */
public class PIS_LEC3_TASK4_V1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int years[] = {2019, 2020, 2021};
        String status;
        
        int N = years.length;
        for (int i = 0; i < N; i++) {
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
    // -------------------------------------------------------------------------
    private static boolean isLeap(int year) {
        boolean result = false;
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            result = true;
        }
        return result;
    }
    // -------------------------------------------------------------------------

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modulusanimation;

/**
 *
 * @author apprentice
 */
public class ModulusAnimation {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 80; i++) {
            if (i % 13 == 0) {
                System.out.print(" *       \r");
            } else if (i % 13 == 1) {
                System.out.print("  *      \r");
            } else if (i % 13 == 2) {
                System.out.print("   *     \r");
            } else if (i % 13 == 3) {
                System.out.print("    *    \r");
            } else if (i % 13 == 4) {
                System.out.print("     *   \r");
            } else if (i % 13 == 5) {
                System.out.print("      *  \r");
            } else if (i % 13 == 6) {
                System.out.print("       * \r");
            } else if (i % 13 == 7) {
                System.out.print("      *  \r");
            } else if (i % 13 == 8) {
                System.out.print("     *   \r");
            } else if (i % 13 == 9) {
                System.out.print("    *    \r");
            } else if (i % 13 == 10) {
                System.out.print("   *     \r");
            } else if (i % 13 == 11) {
                System.out.print("  *      \r");
            } else if (i % 13 == 12) {
                System.out.print(" *       \r");
            } else if (i % 13 == 13) {
                System.out.print("*       \r");
            }

            Thread.sleep(200);
        }
    }
}

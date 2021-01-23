package com.company;

public class Homework_Shapes {
    public static void main(String[] args) {

        //74. Hm - pattern 1 (chess table pattern)
        //Create algorithm, which can create similar pattern from 2d array


        for (int i = 1; i <= 5; i++) { // rows
            for (int j = 1; j <= 5; j++) { //columns
                if (j == i || j == i + 2 || j == 5 - i + 1 || j == i - 2)
                    System.out.print("#");
                System.out.print(" ");
            }
            System.out.println();
        }



        //76. Hm - pattern 3 (Latvian trad.sign pattern)
        //Create algorithm, which can create similar pattern from 2d array


        char[][] sign = new char[6][6];
        char ch1 = '\u220E';
        char ch2 = ' ';

        for (int i = 0; i<=4; i++) { //Outer for loop for number of lines
            for (int j = 0; j<= 4; j++) { // Inner for loop for logic execution

                if (j == 1 || j == 3 ) {
                    if (i == 1 || i == 2 || i == 3) {
                        sign[j][i] = ch1; //j0=x i0=x; j1=x i0=x, j3=x i0=x; j4=x i0=x
                    } else
                        sign[j][i] = ch2; // empty middle in 0 and 4 row
                }
                else if (i == 2)
                    sign[j][i] = ch2; //j2=0 i0=0; this makes empty in the middle
                else
                    sign[j][i] = ch1; // this makes 0,1 and 3,4 places full
            }
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(sign[i][j]);
            }
            System.out.println();
        }






        System.out.println(); //space start zīmēm
        //75. Hm - pattern 1 (X pattern)
        //Create algorithm, which can create similar pattern from 2d array (5x5)


        for (int i = 1; i <= 5; i++) { // rows
            for (int j = 1; j <= 5; j++) { //columns
                if (j == i || j == 5 - i + 1)
                    System.out.print("#");
                System.out.print(" ");
            }
            System.out.println();
        }


    }
}











//
//        int n = 5;
//        for (int i = 0; i < n; i++) { //outer loop for rows
//            for (int j = n - 1; j >= i; j--) { // inner loop for columns
//                System.out.print("# "); //prints #
//            }
//            for (int j = 0; j <= i; j++) {
//                System.out.print("  "); //prints space ; print and not println
//            }
//            System.out.println(); // puts cursor in new line after each line
//        }
//        System.out.println();


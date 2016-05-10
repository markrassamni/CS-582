package com.markrassamni;

public class Main {
    public static void main(String[] args) {
        double arrayA[][] = {{0.1, 0.2, 0.5, 0.2}, {0.4, 0.2, 0.2, 0.2}, {0.2, 0.2, 0.3, 0.3}, {0.2, 0.1, 0.3, 0.4}};
        double arrayB[][] = {{0.5, 0.2, 0.4, 0.3}, {0.3, 0.4, 0.5, 0.3}, {0.2, 0.4, 0.1, 0.4}};
                            //P(G)                  P(L)                    P(U)
        double arrayPi[][] = {{0.25, 0.25, 0.25, 0.25}};
        double arrayC[][] = new double[100][100]; //C = alpha
        //String[] Obv = {"H", "H", "T"};
        //String[] Obv = {"H", "T", "T"};
        //String[] Obv = {"H", "H", "H"};
        //String[] Obv = {"T", "H", "H"};
        //String[] Obv = {"H","T","H","H"};
        String[] Obv = {"U", "U", "L", "L", "U", "U", "U", "G", "G", "U", "U", "L", "L", "U", "U", "U", "G", "G"};
        int state;
        int initialState;

        //Initialization
        if (Obv[0].equals("G")) {
            initialState = 0;
        }
        else if(Obv[0].equals("L")){
            initialState = 1;
        }
        else {  //if Obv[0] = "U"
            initialState = 2;
        }
        arrayC[0][0] = arrayPi[0][0] * arrayB[initialState][0];
        arrayC[0][1] = arrayPi[0][1] * arrayB[initialState][1];
        arrayC[0][2] = arrayPi[0][2] * arrayB[initialState][2];
        arrayC[0][3] = arrayPi[0][3] * arrayB[initialState][3];

        //Induction
        for (int i = 1; i < Obv.length; i++) {
            if (Obv[i].equals("G")) {
                state = 0;
            }
            else if(Obv[i].equals("L")){
                state = 1;
            }
            else {  //if Obv[i] = "U"
                state = 2;
            }

            arrayC[i][0] = ((arrayC[i - 1][0] * arrayA[0][0]) + (arrayC[i - 1][1] * arrayA[1][0])) * arrayB[state][0];
            arrayC[i][1] = ((arrayC[i - 1][0] * arrayA[0][1]) + (arrayC[i - 1][1] * arrayA[1][1])) * arrayB[state][1];
            arrayC[i][2] = ((arrayC[i - 1][0] * arrayA[0][2]) + (arrayC[i - 1][1] * arrayA[1][2])) * arrayB[state][2];
            arrayC[i][3] = ((arrayC[i - 1][0] * arrayA[0][3]) + (arrayC[i - 1][1] * arrayA[1][3])) * arrayB[state][3];


            double P = arrayC[i][0] + arrayC[i][1] + arrayC[i][2] + arrayC[i][3];
            if (i == Obv.length - 1) {
                System.out.println("P(Obv|Lambda) = " + P);
            }
        }
    }
}
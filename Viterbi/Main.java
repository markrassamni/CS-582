package com.markrassamni;

public class Main {

    public static void main(String[] args) {
        double arrayA[][] = {{0.1, 0.2, 0.5, 0.2}, {0.4, 0.2, 0.2, 0.2}, {0.2, 0.2, 0.3, 0.3}, {0.2, 0.1, 0.3, 0.4}};
        double arrayB[][] = {{0.5, 0.2, 0.4, 0.3}, {0.3, 0.4, 0.5, 0.3}, {0.2, 0.4, 0.1, 0.4}};
                              //P(G)                  P(L)                    P(U)
        double arrayPi[][] = {{0.25, 0.25, 0.25, 0.25}};
        double arrayDelta[][] = new double[100][100];
        double arrayPsi[][] = new double[100][100];
        int arrayPath[] = new int[100];
        double score;
        double score1;
        double score2;
        int q;

        //String[] Obv = {"H", "H", "T"};
        //String[] Obv = {"H", "T", "T"};
        //String[] Obv = {"H", "H", "H"};
        //String[] Obv = {"T", "H", "H"};
        //String[] Obv = {"H","T","H","H"};
        //String[] Obv = {"H","T"};
        String[] Obv = {"U", "U", "L", "L", "U", "U", "U", "G", "G", "U", "U", "L", "L", "U", "U", "U", "G", "G"};


        int state = -1;
        int initialState = -1;

        //Initialization
        if (Obv[0].equals("G")) {
            initialState = 0;
        }
        else if(Obv[0].equals("L")){
            initialState = 1;
        }
        else if(Obv[0].equals("U")){  //if Obv[0] = "U"
            initialState = 2;
        }

        arrayDelta[0][0] = arrayPi[0][0] * arrayB[initialState][0];
        arrayDelta[0][1] = arrayPi[0][1] * arrayB[initialState][1];
        arrayDelta[0][2] = arrayPi[0][2] * arrayB[initialState][2];
        arrayDelta[0][3] = arrayPi[0][3] * arrayB[initialState][3];
        arrayPsi[0][0] = 0;
        arrayPsi[0][1] = 0;
        arrayPsi[0][2] = 0;
        arrayPsi[0][3] = 0;

        //Induction
        for (int i = 1; i < Obv.length; i++) {
            if (Obv[i].equals("G")) {
                state = 0;
            }
            else if(Obv[i].equals("L")){
                state = 1;
            }
            else if(Obv[i].equals("U")){  //if Obv[i] = "U"
                state = 2;
            }

            double delta1 = Math.max(arrayDelta[i - 1][0] * arrayA[0][0], arrayDelta[i - 1][1] * arrayA[1][0]);
            double delta2 = Math.max(arrayDelta[i - 1][2] * arrayA[2][0], arrayDelta[i - 1][3] * arrayA[3][0]);
            arrayDelta[i][0] = Math.max(delta1, delta2) * arrayB[state][0];

            double delta3 = Math.max(arrayDelta[i - 1][0] * arrayA[0][1], arrayDelta[i - 1][1] * arrayA[1][1]);
            double delta4 = Math.max(arrayDelta[i - 1][2] * arrayA[2][1], arrayDelta[i - 1][3] * arrayA[3][1]);
            arrayDelta[i][1] = Math.max(delta3, delta4) * arrayB[state][1];

            double delta5 = Math.max(arrayDelta[i - 1][0] * arrayA[0][2], arrayDelta[i - 1][1] * arrayA[1][2]);
            double delta6 = Math.max(arrayDelta[i - 1][2] * arrayA[2][2], arrayDelta[i - 1][3] * arrayA[3][2]);
            arrayDelta[i][2] = Math.max(delta5, delta6) * arrayB[state][2];

            double delta7 = Math.max(arrayDelta[i - 1][0] * arrayA[0][2], arrayDelta[i - 1][1] * arrayA[1][2]);
            double delta8 = Math.max(arrayDelta[i - 1][2] * arrayA[2][2], arrayDelta[i - 1][3] * arrayA[3][2]);
            arrayDelta[i][3] = Math.max(delta7, delta8) * arrayB[state][3];


            //arrayDelta[i][0] = Math.max(arrayDelta[i - 1][0] * arrayA[0][0], arrayDelta[i - 1][1] * arrayA[1][0]) * arrayB[state][0];
            //arrayDelta[i][1] = Math.max(arrayDelta[i - 1][0] * arrayA[0][1], arrayDelta[i - 1][1] * arrayA[1][1]) * arrayB[state][1];
            //arrayDelta[i][2] = Math.max(arrayDelta[i - 1][0] * arrayA[0][2], arrayDelta[i - 1][1] * arrayA[1][2]) * arrayB[state][2];
            //arrayDelta[i][3] = Math.max(arrayDelta[i - 1][0] * arrayA[0][3], arrayDelta[i - 1][1] * arrayA[1][3]) * arrayB[state][3];
            score1 = Math.max(arrayDelta[i][0], arrayDelta[i][1]);
            score2 = Math.max(arrayDelta[i][2], arrayDelta[i][3]);
            score = Math.max(score1, score2);


            double arg1 = arrayDelta[i - 1][0] * arrayA[0][0];
            double arg2 = arrayDelta[i - 1][1] * arrayA[1][0];
            double arg3 = arrayDelta[i - 1][2] * arrayA[2][0];
            double arg4 = arrayDelta[i - 1][3] * arrayA[3][0];

            double arg5 = arrayDelta[i - 1][0] * arrayA[0][1];
            double arg6 = arrayDelta[i - 1][1] * arrayA[1][1];
            double arg7 = arrayDelta[i - 1][2] * arrayA[2][1];
            double arg8 = arrayDelta[i - 1][3] * arrayA[3][1];

            double arg9 = arrayDelta[i - 1][0] * arrayA[0][2];
            double arg10 = arrayDelta[i - 1][1] * arrayA[1][2];
            double arg11 = arrayDelta[i - 1][2] * arrayA[2][2];
            double arg12 = arrayDelta[i - 1][3] * arrayA[3][2];

            double arg13 = arrayDelta[i - 1][0] * arrayA[0][3];
            double arg14 = arrayDelta[i - 1][1] * arrayA[1][3];
            double arg15 = arrayDelta[i - 1][2] * arrayA[2][3];
            double arg16 = arrayDelta[i - 1][3] * arrayA[3][3];


            double argmax1 = Math.max(arg1, arg2);
            double argmax2 = Math.max(arg3, arg4);
            double argmax3 = Math.max(argmax1, argmax2);

            if (argmax3 == arg1){
                arrayPsi[i][0] = 1;
            }
            else if (argmax3 == arg2){
                arrayPsi[i][0] = 2;
            }
            else if (argmax3 == arg3){
                arrayPsi[i][0] = 3;
            }
            else if (argmax3 == arg4){
                arrayPsi[i][0] = 4;
            }

            double argmax4 = Math.max(arg5, arg6);
            double argmax5 = Math.max(arg7, arg8);
            double argmax6 = Math.max(argmax4, argmax5);
            if (argmax6 == arg5){
                arrayPsi[i][1] = 1;
            }
            else if (argmax6 == arg6){
                arrayPsi[i][1] = 2;
            }
            else if (argmax6 == arg7){
                arrayPsi[i][1] = 3;
            }
            else if (argmax6 == arg8){
                arrayPsi[i][1] = 4;
            }

            double argmax7 = Math.max(arg9, arg10);
            double argmax8 = Math.max(arg11, arg12);
            double argmax9 = Math.max(argmax7, argmax8);
            if (argmax9 == arg9){
                arrayPsi[i][2] = 1;
            }
            else if (argmax9 == arg10){
                arrayPsi[i][2] = 2;
            }
            else if (argmax9 == arg11){
                arrayPsi[i][2] = 3;
            }
            else if (argmax9 == arg12){
                arrayPsi[i][2] = 4;
            }

            double argmax10 = Math.max(arg13, arg14);
            double argmax11 = Math.max(arg15, arg16);
            double argmax12 = Math.max(argmax10, argmax11);
            if (argmax12 == arg13){
                arrayPsi[i][3] = 1;
            }
            else if (argmax12 == arg14){
                arrayPsi[i][3] = 2;
            }
            else if (argmax12 == arg15){
                arrayPsi[i][3] = 3;
            }
            else if (argmax12 == arg16){
                arrayPsi[i][3] = 4;
            }





            //Termination
            if (i == Obv.length -1) {

                double arg17 = arrayDelta[i][0] * arrayA[0][0];
                double arg18 = arrayDelta[i][1] * arrayA[1][0];
                double arg19 = arrayDelta[i][2] * arrayA[2][0];
                double arg20 = arrayDelta[i][3] * arrayA[3][0];
                double argmax13 = Math.max(arg17, arg18);
                double argmax14 = Math.max(arg19, arg20);
                double argmax15 = Math.max(argmax13, argmax14);
                if (argmax15 == arg17){
                    arrayPath[i] = 1;
                }
                else if (argmax15 == arg18){
                    arrayPath[i] = 2;
                }
                else if (argmax15 == arg19){
                    arrayPath[i] = 3;
                }
                else if (argmax15 == arg20){
                    arrayPath[i] = 4;
                }
                //else arrayPath[i] = 1;


                q = arrayPath[i];
                for (int j = Obv.length -2; j >= 0; j--) {
                    arrayPath[j] = (int) arrayPsi[j+1][q-1];
                    q = arrayPath[j];
                }


                System.out.println("Score is " + score);
                System.out.println("The best path is: ");
                for (int j = 0; j < arrayPath.length; j++) {
                    if (arrayPath[j] != 0/*== 1 || arrayPath[j] == 2*/) {
                        System.out.print(arrayPath[j]+ " ");
                    }
                }
            }
        }
    }
}
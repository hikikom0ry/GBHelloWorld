package com.company;

import java.util.Arrays;

public class Main {
    //task6-----------------------------------------------------------
    static boolean checkBalance (int[] arr){
        int leftSide = 0, sum = 0;
        boolean balanced;
        sum = sumElements(arr);

        for (int el : arr) {
            leftSide += el;
            sum -= el;
            if (leftSide == sum) return true;

        } return false;
    }

    static int sumElements(int[] arr){
        int sum = 0;
        for (int el : arr){
            sum += el;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr6 = {1, 1, 1, 2, 1};
        System.out.println(checkBalance(arr6));

//        //task1-----------------------------------------------------------
//        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
//        for(int i =0; i<arr.length; i++){
//            if (arr[i] == 1){
//                arr[i] = 0;
//            } else if (arr[i] == 0){
//                arr[i] = 1;
//            }
//        }
//        for (int el:arr){
//            System.out.println(el);
//        }
//        //task2-----------------------------------------------------------
//        int[] arr2 = new int[8];
//        {
//            for(int i = 0; i<arr2.length; i++){
//                arr2[i] = i*3;
//            }
//        }
//        for (int el:arr2){
//            System.out.println(el);
//        }
        //task3-----------------------------------------------------------
//        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        for (int i = 0; i < arr3.length; i++){
//            if (arr3[i] < 6){
//                arr3[i]*=2;
//            }
//        }
//        for (int el:arr3){
//            System.out.println(el);
//        }
        //task4-----------------------------------------------------------
//        int[][] arr4 = new int[5][5];
//        for (int i = 0; i < 5; i++){
//            for (int j = 0; j < 5; j++){
//                if((i == j) || (i+j==4)){
//                    arr4[i][j] = 1;
//
//                }
//
//            }
//
//        }
//        for (int i = 0; i < 5; i++){
//            System.out.println(Arrays.toString(arr4[i]));
//        }
        //task5-----------------------------------------------------------
//        int[] arr5 = {12, 8, 16, 3, 7, 25, 4, 22, 17, 11};
//        int min = arr5[0];
//        int max = arr5[0];
//        for (int i = 0; i < arr5.length; i++){
//            if (arr5[i] < min){
//                min = arr5[i];
//            } else if (arr5[i] > max){
//                max = arr5[i];
//            }
//        }
//        System.out.println("Минимум = "+min +" Максимум = "+max);

    }


}

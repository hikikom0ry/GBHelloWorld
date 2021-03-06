package com.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {
    static char[][] map;
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 4;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    public static void main(String[] args) {
        initMap();
        printMap();
        while(true){
            if (humanTurn()){
                System.out.println("Победил человек");
                break;
            };
            printMap();
//            if (checkWinEx(DOT_X)){
//                System.out.println("Победил человек");
//                break;
//            }
            if (isMapFull()){
                System.out.println("Ничья");
                break;
            }

            if (aiTurn()){
                System.out.println("Победил компьютер");
                break;
            };
            printMap();

//            if (checkWinEx(DOT_O)){
//                System.out.println("Победил компьютер");
//                break;
//            }
            if (isMapFull()){
                System.out.println("Ничья");
                break;
            }

        }
    }

    static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++){
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    static void printMap(){
        for (int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++){
            System.out.print(i + 1 + " ");

            for (int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean humanTurn(){
        int x, y;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Введите координаты в формате X, Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
        if (x == y || x + y == SIZE-1){
            return checkWinEx(DOT_X, y, x);
        } else return checkWin(DOT_X, y, x);
    }

    static boolean aiTurn(){
        Random random = new Random();
        int x, y;
        do{
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        if (x == y || x + y == SIZE-1){
            return checkWinEx(DOT_O, y, x);
        } else return checkWin(DOT_O, y, x);
    }

    static boolean isCellValid(int x, int y){
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE){
            return false;
        }

        if (map[y][x] == DOT_EMPTY) {
            return true;
        };
        return false;
    }

    static boolean checkWin(char sym, int y ,int x){
        int countY = 0, countX = 0;
        for (int i = 0; i <SIZE; i++){

            if (map[y][i] == sym) {
                countY++;
            }
            if (map[i][x] == sym){
                countX++;
            }
        }
        if (countX == DOTS_TO_WIN || countY == DOTS_TO_WIN){
            printMap();
            return true;
        }
        return false;
    }

    static boolean checkWinEx(char sym, int y, int x){
        checkWin(sym, y, x);
        int mainDiag = 0, alterDiag = 0;
        for (int i = 0; i < SIZE; i++){
            if (map[i][i] == sym){
                mainDiag++;
            }
            if (map[SIZE-i-1][i] == sym){
                alterDiag++;
            }
        }
        if (mainDiag == DOTS_TO_WIN || alterDiag == DOTS_TO_WIN){
            printMap();
            return true;
        }
        return false;
    }

    static boolean isMapFull(){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map.length; j++){
                if (map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
}

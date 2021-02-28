package com.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {
    static char[][] map;
    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    public static void main(String[] args) {
        initMap();
        printMap();
        while(true){
            humanTurn();
            printMap();
            if (checkWin(DOT_X)){
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()){
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();

            if (checkWin(DOT_O)){
                System.out.println("Победил компьютер");
                break;
            }
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

    static void humanTurn(){
        int x, y;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Введите координаты в формате X, Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    static void aiTurn(){
        Random random = new Random();
        int x, y;
        do{
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
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

    static boolean checkWin(char sym){
        //Проверка строк на наличие 3 одинаковых символов
        if (map[0][0] == sym && map[0][1] == sym && map[0][2] == sym){
            return true;
        }
        if (map[1][0] == sym && map[1][1] == sym && map[1][2] == sym){
            return true;
        }
        if (map[2][0] == sym && map[2][1] == sym && map[2][2] == sym){
            return true;
        }

        //Проверка столбцов на наличие 3 одинаковых символов
        if (map[0][0] == sym && map[1][0] == sym && map[2][0] == sym){
            return true;
        }
        if (map[0][1] == sym && map[1][1] == sym && map[2][1] == sym){
            return true;
        }
        if (map[0][2] == sym && map[1][2] == sym && map[2][2] == sym){
            return true;
        }

        //Проверка диагоналей на наличие 3 одинаковых символов
        if (map[0][0] == sym && map[1][1] == sym && map[2][2] == sym){
            return true;
        }
        if (map[0][2] == sym && map[1][1] == sym && map[2][0] == sym){
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

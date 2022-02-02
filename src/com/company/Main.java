package com.company;

import java.util.*;

public class Main {
    static List<Integer> playerPositions = new ArrayList<>(); //создадим список для определения победителя
    static List<Integer> CPUpositions = new ArrayList<>();

    public static void main(String[] args) {
        // Array List
        /*
        ArrayList<String> people = new ArrayList<String>();
        people.add("Tom");
        people.add("Alice");
        people.add("Alina");
        people.add("Albina");
        people.add("Lia");
        people.add("Firkat");

        System.out.printf("Array has %d list elements", people.size());
        for(String person : people ){
            System.out.println(person + ".");
        }

        people.remove(0);
        people.remove("Alice");

        Object[] peopleArray = people.toArray();
        for(Object person : peopleArray){ // должен быть одинаковый тип
                System.out.print(person +"\t");
        } */

        //создать двумерный массив для отрисовки игры
        char[][] gameBoard = new char[][]{{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        // printGameBoard(gameBoard);
        //вводить с консоли числа и с помощью switch определять место

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your position (1-9) :");
            int playerPos = scanner.nextInt();
            //System.out.println(position);
            pieceGame(gameBoard, "player", playerPos);



            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos)||CPUpositions.contains(cpuPos)){

                cpuPos = rand.nextInt(9) + 1;

            }
            pieceGame(gameBoard, "CPU", cpuPos);

            printGameBoard(gameBoard);

            String result = checkWinner();
            if(result.length()>0) {
                System.out.println(result);
            }
        }

    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    //создаем метод, где мы определяем игрока и определяем ход
    public static void pieceGame(char[][] gameBoard, String user, int position) {


        char Symbol = ' ';
        if (user.equals("player")) {
            Symbol = 'X';
            playerPositions.add(position);

        } else if (user.equals("CPU")) {
            Symbol = '0';
            CPUpositions.add(position);

        }
        switch (position) {
            case 1:
                gameBoard[0][0] = Symbol;
                break;
            case 2:
                gameBoard[0][2] = Symbol;
                break;
            case 3:
                gameBoard[0][4] = Symbol;
                break;
            case 4:
                gameBoard[2][0] = Symbol;
                break;
            case 5:
                gameBoard[2][2] = Symbol;
                break;
            case 6:
                gameBoard[2][4] = Symbol;
                break;
            case 7:
                gameBoard[4][0] = Symbol;
                break;
            case 8:
                gameBoard[4][2] = Symbol;
                break;
            case 9:
                gameBoard[4][4] = Symbol;
                break;
            default:
                break;
        }
    }

    //определяем победителя
    public static String checkWinner() {


        List toprow = Arrays.asList(1, 2, 3);
        List midrow = Arrays.asList(4, 5, 6);
        List botrow = Arrays.asList(7, 8, 9);
        List col1 = Arrays.asList(1, 4, 7);
        List col2 = Arrays.asList(2, 5, 8);
        List col3 = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        List<List> Winner = new ArrayList<List>();
        Winner.add(toprow);
        Winner.add(midrow);
        Winner.add(botrow);
        Winner.add(col1);
        Winner.add(col2);
        Winner.add(col3);
        Winner.add(cross1);
        Winner.add(cross2);
        for(List l : Winner){
            if(playerPositions.containsAll(l)){
                System.out.println("Congratulations! You won!");
            }
            else if(CPUpositions.containsAll(l)){
                System.out.println("Cpu wins. Sorry:(");
            }
            else if(playerPositions.size()+CPUpositions.size()==9){
                System.out.println("CUT!");
            }
        }
        return "";
    }
}




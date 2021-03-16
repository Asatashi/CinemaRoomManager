package cinema;

import java.util.Scanner;

public class Cinema {

    public static void display(String[][] x) {
        for (String[] strings : x) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        int totalSeats = rows * seats;
        String[][] sits = new String[rows + 1][seats + 1];
        String s = "S";
        String sitsNum = "0123456789";
        System.out.println("Cinema:");
        for (int i = 0; i < sits.length; i++) {         //filling 2d array with sits and rows numbers
            for (int j = 0; j < sits[i].length; j++) {
                sits[i][j] = s;
                sits[0][j] = String.valueOf(sitsNum.indexOf(String.valueOf(j)));
                sits[i][0] = String.valueOf(sitsNum.indexOf(String.valueOf(i)));
                sits[0][0] = "";
            }
        }
        while (true) {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                System.out.println("1. Show the seats");
                System.out.println("Cinema:");
                display(sits);
                break;
            case 2:
                System.out.println("2. Buy a ticket");
                System.out.println("Enter a row number:");
                int myRow = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                int mySeat = scanner.nextInt();
                if (totalSeats <= 60) {
                    System.out.println("Ticket price: $10");
                } else if (rows / myRow < 2) {
                    System.out.println("Ticket price: $8");
                } else {
                    System.out.println("Ticket price: $10");
                }
                sits[myRow][mySeat] = "B";
                break;
            case 0:
                return;
            default:
                System.out.println("Please choose between valid options");
                break;
        }
        }
    }
}
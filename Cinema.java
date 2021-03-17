package cinema;

import java.util.Arrays;
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
        for (int i = 0; i < sits.length; i++) {
            for (int j = 0; j < sits[i].length; j++) {
                sits[i][j] = s;
                sits[0][j] = String.valueOf(sitsNum.indexOf(String.valueOf(j)));
                sits[i][0] = String.valueOf(sitsNum.indexOf(String.valueOf(i)));
                sits[0][0] = "";
            }
        }
        StringBuilder sitsTaken = new StringBuilder(sits.length);
        sitsTaken.append(Arrays.deepToString(sits));
        while (true) {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                System.out.println("1. Show the seats");
                System.out.println("Cinema:");
                display(sits);
                break;
            case 2:
                try {
                    System.out.println("2. Buy a ticket");
                    System.out.println("Enter a row number:");
                    int myRow = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int mySeat = scanner.nextInt();
                    if (sits[myRow][mySeat].equals("B")) {
                        System.out.println("That ticket has already been purchased!");
                        System.out.println("Enter a row number:");
                        int myAnotherRow = scanner.nextInt();
                        System.out.println("Enter a seat number in that row: ");
                        int myAnotherSeat = scanner.nextInt();
                        sits[myAnotherRow][myAnotherSeat] = "B";
                        if (totalSeats <= 60) {
                            System.out.println("Ticket price: $10");
                        } else if (rows / myAnotherRow < 2) {
                            System.out.println("Ticket price: $8");
                        } else {
                            System.out.println("Ticket price: $10");
                        }
                    } else {
                        if (totalSeats <= 60) {
                            System.out.println("Ticket price: $10");
                        } else if (rows / myRow < 2) {
                            System.out.println("Ticket price: $8");
                        } else {
                            System.out.println("Ticket price: $10");
                        }
                        sits[myRow][mySeat] = "B";
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Wrong input!");
                }
                sitsTaken.append(Arrays.deepToString(sits));
                break;
            case 3:
                //TODO 3. Statistics
                int tickets = 0;
                if (tickets == 0) {
                for (int i = 0; i < sitsTaken.length(); i++) {
                    if (sitsTaken.charAt(i) == 'B') {
                        tickets++;
                    }
                }
            }   else { //TODO the tickets are doubling themselfs so i need to think about how to solve it
                    for (int i = 0; i < sitsTaken.length(); i++) {
                        if (sitsTaken.charAt(i) == 'B') {
                            tickets++;
                        }
                    }
                }       //TODO There are also some problems with printing too much income, i have to think about changing it's logic, but the rest seems ok
                double ticketsAsDouble = tickets;
                System.out.println("Number of purchased tickets: " + tickets);
                double percentage;
                String percentageSign = "%";
                percentage = (ticketsAsDouble * 100 / ((double) seats * (double) rows));
                System.out.printf("Percentage: %.2f%s%n",
                        percentage, percentageSign);
                int currentIncome = 0;
                int income;
                int allSeats = rows * seats;
                int frontRows = rows / 2;
                int backRows = rows - frontRows;
                int backRowsIncome = backRows * seats * 8;
                int frontRowsIncome = frontRows * seats * 10;
                if (allSeats <= 60) {
                    income = allSeats * 10;
                    for (int i = 0; i < tickets; i++) {
                        currentIncome = i * 10;
                        for (int j = 0; j < 1; j++) {
                            System.out.println("Current income: $" + currentIncome);
                        }
                    }
                } else  {
                    income = backRowsIncome + frontRowsIncome;
                    for (int i = 0; i < tickets; i++) {
                            if (sitsTaken.indexOf("B") < sitsTaken.length() / 2) {
                                currentIncome = i * 10;
                            } else {
                                currentIncome = i * 8;
                            }
                            for (int j = 0; j < 1; j++) {
                                System.out.println("Current income: $" + currentIncome);
                            }
                    }
                }
                System.out.println("Total income: $" + income);
                System.out.println("Current income: $" + currentIncome);
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
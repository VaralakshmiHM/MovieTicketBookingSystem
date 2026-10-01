package movieticket;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Theatre {

    boolean[][] seats = new boolean[5][5];

    void displaySeats() {

        System.out.println("\nAvailable Seats:");

        for (int i = 0; i < seats.length; i++) {

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j] == false) {

                    System.out.print("O ");

                } else {

                    System.out.print("X ");

                }

            }

            System.out.println();

        }

    }

    void bookSeat(Scanner sc, int numberOfTickets) {

        for (int i = 1; i <= numberOfTickets; i++) {

            try {

                System.out.println("\nBooking ticket " + i);

                System.out.print("Enter row number (1-5): ");
                int row = sc.nextInt();

                System.out.print("Enter seat number (1-5): ");
                int seat = sc.nextInt();

                if (row < 1 || row > 5 || seat < 1 || seat > 5) {

                    throw new IllegalArgumentException(
                        "Row and seat number must be between 1 and 5."
                    );

                }

                if (seats[row - 1][seat - 1] == false) {

                    seats[row - 1][seat - 1] = true;

                    System.out.println("Seat booked successfully.");

                } else {

                    System.out.println(
                        "Seat is already booked. Please select another seat."
                    );

                    i--;

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter numbers only.");

                sc.nextLine();

                i--;

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());

                i--;

            }

        }

    }

    void cancelSeat(Scanner sc) {

        try {

            System.out.print("\nEnter row number to cancel (1-5): ");

            int row = sc.nextInt();

            System.out.print("Enter seat number to cancel (1-5): ");

            int seat = sc.nextInt();

            if (row < 1 || row > 5 || seat < 1 || seat > 5) {

                throw new IllegalArgumentException(
                    "Row and seat number must be between 1 and 5."
                );

            }

            if (seats[row - 1][seat - 1] == true) {

                seats[row - 1][seat - 1] = false;

                System.out.println("Ticket cancelled successfully.");

            } else {

                System.out.println("This seat is not booked.");

            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please enter numbers only.");

            sc.nextLine();

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

    }

}
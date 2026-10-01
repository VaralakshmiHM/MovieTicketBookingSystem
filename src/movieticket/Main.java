package movieticket;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int bookingId = 1001;

        System.out.println("===== MOVIE TICKET BOOKING SYSTEM =====");

        Movie movie = new Movie("Kantara", 9.5);

        movie.displayMovie();

        Theatre theatre = new Theatre();

        theatre.displaySeats();

        System.out.print("\nEnter number of tickets: ");

        int numberOfTickets = sc.nextInt();

        theatre.bookSeat(sc, numberOfTickets);

        System.out.print("Enter show timing: ");

        String showTiming = sc.next();

        System.out.print("Is today a weekend? (yes/no): ");

        String weekend = sc.next();

        int ticketPrice;

        if (weekend.equalsIgnoreCase("yes")) {

            ticketPrice = 200;

        } else {

            ticketPrice = 150;

        }

        int totalAmount = numberOfTickets * ticketPrice;

        System.out.print("Enter discount coupon (or enter NO): ");

        String coupon = sc.next();

        double discount = 0;

        if (coupon.equalsIgnoreCase("MOVIE10")) {

            discount = totalAmount * 0.10;

            System.out.println("10% discount applied.");

        } else {

            System.out.println("No discount applied.");

        }

        double finalAmount = totalAmount - discount;

        System.out.println("\n===== BOOKING DETAILS =====");

   
        System.out.println("Booking ID: MTB" + bookingId);

        System.out.println("Show Timing: " + showTiming);

        System.out.println("Movie: " + movie.movieName);

        System.out.println("Rating: " + movie.rating + "/10");

        System.out.println("Ticket Price: ₹" + ticketPrice);

        System.out.println("Number of Tickets: " + numberOfTickets);

        System.out.println("Total Amount: ₹" + totalAmount);

        System.out.println("Discount: ₹" + discount);

        System.out.println("Final Amount: ₹" + finalAmount);

        theatre.displaySeats();

        theatre.cancelSeat(sc);

        theatre.displaySeats();

    }

}
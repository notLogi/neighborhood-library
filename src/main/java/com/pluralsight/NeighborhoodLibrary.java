package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    private static Book[] books = new Book[20];

    private static int bookCount = 0;

    public static void main(String[] args) {
        books[bookCount++] = new Book(1001, "0374606345", "Goodbye, Vitamin", true, "Roger");
        books[bookCount++] = new Book(1002, "0811237016", "The Grapes of Wrath", true, "W");
        books[bookCount++] = new Book(1003, "125010916X", "The Book of Goose", true, "W");
        books[bookCount++] = new Book(1004, "159463193X", "The Kite Runner", true, "R");
        books[bookCount++] = new Book(1005, "0143039431", "Kairos", false, "");

        Scanner myScanner = new Scanner(System.in);

        menuList(myScanner);
    }

    public static void menuList(Scanner scanner){
        boolean isFinished = false;
        while(!isFinished){
            System.out.println("Choose your option:\nShow available books(Enter 1)\nShow checked out books(Enter 2)\nExit(Enter 3)\nEnter your command: ");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch(command){
                case 1:
                    showAvailableBooks(scanner);
                    break;
                case 2:
                    showCheckedOutBooks(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye");
                    isFinished = true;
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    public static void showAvailableBooks(Scanner scanner){
        boolean available = false;
        for(int i = 0; i < bookCount; i++){
           if(!books[i].isItCheckedOut()) {
               System.out.println(books[i].availableBooks());
               available = true;
           }
        }
        if(!available){
            System.out.println("No available books");
            return;
        }
        checkOutBook(scanner);
    }

    public static void showCheckedOutBooks(Scanner scanner){
        boolean checked = false;
        for(int i = 0; i < bookCount; i++){
            if(books[i].isItCheckedOut()) {
                System.out.println(books[i].checkedOutBooks());
                checked = true;
            }
        }
        if(!checked){
            System.out.println("All books are available");
            return;
        }
            System.out.println("Do you want to check in a book?\nC - to check in a book\nX - to go back to the home screen");
            String prompt = scanner.nextLine();
            switch(prompt.toUpperCase()){
                case "C":
                    checkInBook(scanner);
                    break;
                case "X":
                    System.out.println("Going back to home screen");
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
        }
    }

    public static void checkOutBook(Scanner scanner){
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("What book do you want to check out?(Enter \"X\" if you want to go back.");
        String title = scanner.nextLine();
        if(title.equalsIgnoreCase("X")) return;
        for(int i = 0; i < bookCount; i++){
            if(books[i].getTitle().equalsIgnoreCase(title)){
                books[i].checkOut(name);
                System.out.println("you checked out: " + books[i].getTitle());
            }
        }
    }

    public static void checkInBook(Scanner scanner){
        System.out.println("Enter ID of the book: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == bookId) {
                books[i].checkIn();
                System.out.println("Thank you for returning : " + books[i].getTitle());
                return;
            }
        }
        System.out.println("Book doesn't exist");
    }
}

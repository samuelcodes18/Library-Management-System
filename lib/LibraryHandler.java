package lib;

import java.util.Scanner;
import lib.items.Book;
import lib.items.InventoryException;
import lib.users.InvalidUserException;
import lib.users.User;

public class LibraryHandler {
    private static Book[] bookInventory = new Book[5];
    private static User[] userRegistry = new User[3];
    private static int bookCount = 0, userCount = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary System");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Rent Book");
            System.out.println("4. Present All Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1 -> addBook(s);
                case 2 -> registerMember(s);
                case 3 -> borrowBook(s);
                case 4 -> displayRecords();
                case 5 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice! Please select again.");
            }

        } while (choice != 5);

        s.close();
    }

    private static void addBook(Scanner s) {
        if (bookCount >= bookInventory.length) {
            System.out.println("Books inventory is full!");
            return;
        }
        try {
            System.out.print("Enter title: ");
            String title = s.nextLine();
            System.out.print("Enter ID: ");
            int id = s.nextInt();
            s.nextLine();
            System.out.print("Enter author: ");
            String author = s.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = s.nextInt();
            s.nextLine();

            bookInventory[bookCount++] = new Book(title, id, author, quantity);
            System.out.println("Book successfully added!");
        } catch (InventoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registerMember(Scanner s) {
        if (userCount >= userRegistry.length) {
            System.out.println("Member registration is full!");
            return;
        }
        try {
            System.out.print("Enter user ID: ");
            int id = s.nextInt();
            s.nextLine();
            System.out.print("Enter name: ");
            String name = s.nextLine();
            System.out.print("Enter age: ");
            int age = s.nextInt();
            s.nextLine();

            userRegistry[userCount++] = new User(id, name, age);
            System.out.println("Member registered successfully!");
        } catch (InvalidUserException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void borrowBook(Scanner s) {
        System.out.print("Enter book title: ");
        String title = s.nextLine();
        Book book = findBookByTitle(title);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        System.out.print("Enter quantity to borrow: ");
        int amount = s.nextInt();
        s.nextLine();

        if (book.borrowItem(amount)) {
            System.out.println("Book borrowed successfully! Remaining stock: " + book.getQuantity());
        } else {
            System.out.println("Insufficient stock!");
        }
    }

    private static Book findBookByTitle(String title) {
        for (Book book : bookInventory) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private static void displayRecords() {
        System.out.println("\nBooks in Library:");
        for (Book book : bookInventory) {
            if (book != null) {
                book.showDetails();
            }
        }

        System.out.println("\nRegistered Members:");
        for (User user : userRegistry) {
            if (user != null) {
                user.displayUserInfo();
            }
        }
    }
}

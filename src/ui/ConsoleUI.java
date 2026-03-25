package ui;

import service.LibraryService;


import java.util.List;
import java.util.Scanner;
import model.Member;

import model.Book;

public class ConsoleUI {

    private LibraryService libraryService;
    private Scanner scanner;

    public ConsoleUI(LibraryService libraryService) {
        this.libraryService = libraryService;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Add Member");
            System.out.println("6. List Members");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    addMember();
                    break;
                case 6:
                    listMembers();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
private void addBook() {
    System.out.print("Enter book ID: ");
    String id = scanner.nextLine();

    System.out.print("Enter title: ");
    String title = scanner.nextLine();

    System.out.print("Enter author: ");
    String author = scanner.nextLine();

    System.out.print("Enter ISBN: ");
    String isbn = scanner.nextLine();

    Book book = new Book(id, title, author, isbn,true);

    libraryService.addBook(book);

    System.out.println("Book added successfully!");
}

private void listBooks() {
    List<Book> books = libraryService.getAllBooks();

    if (books.isEmpty()) {
        System.out.println("No books available.");
        return;
    }

    for (Book b : books) {
        System.out.println(b.getDetails());
    }
}

private void borrowBook() {
    System.out.print("Enter book ID: ");
    String bookId = scanner.nextLine();

    System.out.print("Enter member ID: ");
    String memberId = scanner.nextLine();

    try {
        libraryService.borrowBook(bookId, memberId);
        System.out.println("Book borrowed successfully!");
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

private void returnBook() {
    System.out.print("Enter book ID: ");
    String bookId = scanner.nextLine();

    System.out.print("Enter member ID: ");
    String memberId = scanner.nextLine();

    try {
        libraryService.returnBook(bookId, memberId);
        System.out.println("Book returned successfully!");
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

private void addMember() {
    System.out.print("Enter member ID: ");
    String id = scanner.nextLine();

    System.out.print("Enter member name: ");
    String name = scanner.nextLine();

    System.out.print("Enter member email: ");
    String email = scanner.nextLine();

    Member member = new Member(id, name, email);

    libraryService.addMember(member);

    System.out.println("Member added successfully!");
}


private void listMembers() {
    List<Member> members = libraryService.getAllMembers();

    if (members.isEmpty()) {
        System.out.println("No members found.");
        return;
    }

    for (Member m : members) {
        System.out.println(m.getDetails());
    }
}

}
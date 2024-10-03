package LibraryCatalogSystemPackage;

import java.util.*;

public class BookCatalog {
	private ArrayList<Books> booksList;
	private int nextBookId;
	
//	Constructor
	public BookCatalog() {
		booksList = new ArrayList<>();
		nextBookId=101;
	}
	
//	Method to add new book in our Catalog
	public void AddNewBook(String bookTitle, String bookAuthorName) {
		Books book = new Books(bookTitle, bookAuthorName, nextBookId);
		booksList.add(book);
		nextBookId++;
		System.out.println("\nBook Added Successfully\t\t\n" + book + "\n");
	}
	
//	Method to search a book using its title
	public void SearchBookByBookName(String bookTitle) {
		boolean found = false;
        for (Books book : booksList) {
            if (book.getBookTitle().equalsIgnoreCase(bookTitle)) {
                System.out.println("\n"+book+"\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with book title: " + bookTitle + "\n");
        }
	}

//	Method to search a book using its author name
	public void SearchBookByBookAuthorName(String bookAuthorName) {
		boolean found = false;
        for (Books book : booksList) {
            if (book.getBookAuthorName().equalsIgnoreCase(bookAuthorName)) {
                System.out.println("\n"+book+"\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with author name: " + bookAuthorName + "\n");
        }
	}
	
//	Displaying the list of all books present in our catalog
	public void ListAllBooks() {
        if (booksList.isEmpty()) {
            System.out.println("\nNo books available in the catalog.\n");
            return;
        }

        // Print the table header
        System.out.printf("\n%-10s %-30s %-20s%n", "Book ID", "Book Title", "Author Name");
        System.out.println("---------------------------------------------------------------");

        // Print each book in tabulated format
        for (Books book : booksList) {
            System.out.printf("%-10d %-30s %-20s%n", book.getBookId(), book.getBookTitle(), book.getBookAuthorName() + "\n");
        }
    }
}

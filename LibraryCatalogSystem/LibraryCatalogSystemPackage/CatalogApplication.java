package LibraryCatalogSystemPackage;

import java.util.*;

public class CatalogApplication {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BookCatalog catalog = new BookCatalog();
		boolean flag=true;
		
		System.out.println("\nWelcome to the Library Catalog System!");
		while(flag) {
			System.out.println("Options: -");
			System.out.println("1. Add new Book");
			System.out.println("2. Search for a book by book title");
			System.out.println("3. Search for a book by author name");
			System.out.println("4. List all books");
			System.out.println("5. Exit");
			System.out.print("Choose any one option: ");			
			int option = s.nextInt();
			s.nextLine();
			switch(option) {
//			Adding new Book
			case 1:
				 System.out.print("\nEnter book title: ");
                 String BookTitle = s.nextLine();
                 System.out.print("Enter book author: ");
                 String BookAuthor = s.nextLine();
                 catalog.AddNewBook(BookTitle, BookAuthor);
				 break;
				 
//		    Searching book by its title
			case 2:
				 System.out.print("\nEnter book title to search: ");
                 String searchBookTitle = s.nextLine();
                 catalog.SearchBookByBookName(searchBookTitle);
				 break;
				 
//	        Searching book by its author name
			case 3:
				 System.out.print("\nEnter book author name to search: ");
                 String searchBookAuthor = s.nextLine();
                 catalog.SearchBookByBookAuthorName(searchBookAuthor);
				 break;
				 
//		    Displaying list of all books in catalog
			case 4:
				 catalog.ListAllBooks();
				 break;
				 
//		    Exiting the application
			case 5:
				 flag = false;
                 System.out.println("\nExiting the Library Catalog System.");
				 break;
				 
//			Default Case	 
		    default: 
		    	 System.out.println("Invalid choice! Please try again...\n");
		    	 break;
			}
		}
		
//		Closing the Scanner instance
		s.close();
	}
}

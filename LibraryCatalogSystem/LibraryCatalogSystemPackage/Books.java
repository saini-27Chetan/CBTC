package LibraryCatalogSystemPackage;

public class Books {
	private String BookTitle;
	private String BookAuthorName;
	private int BookId;

//	Books Constructor
	public Books(String bookTitle, String bookAuthorName, int bookId) {
		BookTitle = bookTitle;
		BookAuthorName = bookAuthorName;
		BookId = bookId;
	}

//	Getters
	public String getBookTitle() {
		return BookTitle;
	}

	public String getBookAuthorName() {
		return BookAuthorName;
	}

	public int getBookId() {
		return BookId;
	}

//	It provides a custom representation of string when we print our Books class object
	@Override
	public String toString() {
		return "Book ID: " + BookId + ", Title: '" + BookTitle + "', Author: '" + BookAuthorName + "'";
	}
	
}

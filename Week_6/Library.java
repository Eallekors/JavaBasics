package Week_6;

import java.util.ArrayList;


public class Library {
    private Book[] booklist = new Book[10];  // Changed variable name to follow Java naming conventions
    private int bookCount = 0;  // To keep track of the number of books added

    public void addBook(Book newBook) {
        if (bookCount < booklist.length) {
            booklist[bookCount] = newBook;
            bookCount++;
        } else {
            System.out.println("Library is full, cannot add more books.");
        }
    }

    public void printBooks() {
        System.out.println("Books:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(booklist[i]);
        }
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> found = new ArrayList<Book>();

        // iterate the list of books and add all the matching books to the list found
        for (int i = 0; i < bookCount; i++) {
            Book book = booklist[i];
            // Check if the book's title matches the search title
            if (book.title().toLowerCase().contains(title.toLowerCase())) {
                found.add(book); // Add matching books to the list
            }
        }

        return found;
    }

    public ArrayList<Book> searchByPublisher(String publisher) {
        ArrayList<Book> found = new ArrayList<Book>();

        String trimmedPublisher = publisher.trim();
        // iterate the list of books and add all the matching books to the list found
        for (int i = 0; i < bookCount; i++) {
            Book book = booklist[i];
            // Check if the book's title matches the search title
            if (book.publisher().toLowerCase().contains(trimmedPublisher.toLowerCase())) {
                found.add(book); // Add matching books to the list
            }
        }

        return found;
    }

    public ArrayList<Book> searchByYear(int year) {
        ArrayList<Book> found = new ArrayList<Book>();

        // iterate the list of books and add all the matching books to the list found
        for (int i = 0; i < bookCount; i++) {
            Book book = booklist[i];
            // Check if the book's title matches the search title
            if (book.year() == (year)) {
                found.add(book); // Add matching books to the list
            }
        }

        return found;
    }

    public static void main(String[] args) {
        Library Library = new Library();

        Library.addBook(new Book("Cheese Problems Solved", "Woodhead Publishing", 2007));
        Library.addBook(new Book("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        Library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));

        for (Book book: Library.searchByTitle("CHEESE")) {
            System.out.println(book);
        }

        System.out.println("---");
        for (Book book: Library.searchByPublisher("PENGUIN  ")) {
            System.out.println(book);
        }


    }
}


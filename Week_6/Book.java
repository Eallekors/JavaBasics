package Week_6;

public class Book {
    String inPublisher;
    String inTitle;
    int inYear;
    public Book(String title,String publisher,int year) {
        inTitle = title;
        inPublisher = publisher;
        inYear = year;
    }

    private String title() {
        return inTitle;
    }

    private String publisher() {
        return inPublisher;
    }

    private int year() {
        return inYear ;
    }

    @Override
    public String toString() {
        return this.inTitle + ", " + this.inPublisher + ", " + this.inYear;
    }

    public static void main(String[] args) {
        Book cheese = new Book("Cheese Problems Solved", "Woodhead Publishing", 2007);
        System.out.println(cheese.title());
        System.out.println(cheese.publisher());
        System.out.println(cheese.year());

        System.out.println(cheese);
    }




}

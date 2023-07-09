package System.Book;

public class Book {

    private String nameOfTheBook;
    private int price;
    private String placeOfPrint;
    private String author;
    private String genre;
    private int printYear;
    private int number;
    private String ISBN;
    private boolean borrowed;


    public Book(String nameOfTheBook, int price, String placeOfPrint, String author, String genre, int printYear, int number, String ISBN) {
        this.nameOfTheBook = nameOfTheBook;
        this.price = price;
        this.placeOfPrint = placeOfPrint;
        this.author = author;
        this.genre = genre;
        this.printYear = printYear;
        this.number = number;
        this.ISBN = ISBN;
        borrowed = false;
    }

    public Book() {
    }


    public String getNameOfTheBook() {
        return nameOfTheBook;
    }

    public int getPrice() {
        return price;
    }

    public String getPlaceOfPrint() {
        return placeOfPrint;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPrintYear() {
        return printYear;
    }

    public int getNumber() {
        return number;
    }

    public String getISBN() {
        return ISBN;
    }


    @Override
    public String toString() {
        return
                "nameOfTheBook:" + nameOfTheBook + '\t' +
                "price:" + price +'\t'+
                "placeOfPrint:" + placeOfPrint + '\t' +
                "author:" + author + '\t' +
                "genre:" + genre + '\t' +
                "printYear:" + printYear+'\t' +
                "number:" + number ;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a single book.
 * Contains title, date, author, and length information.
 * Implements Comparable class to compare two books together with published date.
 * 
 * @author John Choi choi.1655@osu.edu
 * @version Jan 11, 2022
 */
public class Book implements Comparable<Book> {
    
    private String title;
    private Date publicationDate;
    private Author author;
    private int length;

    public Book(String title, String publication, String author, int length) throws ParseException {
        this.title = title;
        // convert publication string to date object
        publicationDate = new SimpleDateFormat("MM/dd/yyyy").parse(publication);
        switch (author.toLowerCase()) {
            case "steven king":
                this.author = Author.STEVEN_KING;
                break;
            case "rudyard kipling":
                this.author = Author.RUDYARD_KIPLING;
                break;
            case "isaac asimov":
                this.author = Author.ISSAC_ASIMOV;
                break;
            case "suzanne collins":
                this.author = Author.SUZANNE_COLLINS;
                break;
            default:
                throw new IllegalArgumentException("Invalid Author Name!");
        }
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getDate() {
        return new SimpleDateFormat("MM/dd/yyyy").format(getPublicationDate());
    }

    public Author getAuthor() {
        return author;
    }

    public String getAuthorName() {
        switch (getAuthor()) {
            case ISSAC_ASIMOV:
                return "Isaac Asimov";
            case RUDYARD_KIPLING:
                return "Rudyard Kipling";
            case STEVEN_KING:
                return "Steven King";
            case SUZANNE_COLLINS:
                return "Suzanne Collins";
            default:
                return "";
        }
    }

    public String getGenre() {
        switch (getAuthor()) {
            case ISSAC_ASIMOV:
                return "Science Fiction";
            case RUDYARD_KIPLING:
                return "Adventure";
            case STEVEN_KING:
                return "Horror";
            case SUZANNE_COLLINS:
                return "YA Fiction";
            default:
                return "";
        }
    }

    public int getLength() {
        return length;
    }

    /**
     * Compares two books together.
     * Used to sort books by oldest publication date.
     * 
     * @param o other book to compare this book.
     * @return difference between two books
     */
    @Override
    public int compareTo(Book o) {
        return this.publicationDate.compareTo(o.publicationDate);
    }
}

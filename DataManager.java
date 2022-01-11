import java.text.ParseException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Receives, stores, and prints book data.
 * 
 * @author John Choi choi.1655@osu.edu
 * @version Jan 11, 2022
 */
public class DataManager {
    
    private PriorityQueue<Book> stevenKings;
    private PriorityQueue<Book> rudyardKiplings;
    private PriorityQueue<Book> issacAsimovs;
    private PriorityQueue<Book> suzanneCollins;

    private static DataManager instance;

    /**
     * Private constructor.
     * Initializes 4 priority queues (one for each author).
     */
    private DataManager() {
        stevenKings = new PriorityQueue<>();
        rudyardKiplings = new PriorityQueue<>();
        issacAsimovs = new PriorityQueue<>();
        suzanneCollins = new PriorityQueue<>();
    }

    /**
     * There should be only one instance of this manager class so singleton pattern selected.
     * 
     * @return singleton instance of this class
     */
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    /**
     * Continuously read input from the user until user hits Enter.
     * Input format: TITLE,DATE,AUTHOR,LENGTH
     */
    public void readInput() {
        System.out.println("Input:");
        Scanner keyboard = new Scanner(System.in);
        String line = keyboard.nextLine();
        while (!line.isEmpty()) {
            String[] delimited = line.split(",");
            String title = delimited[0].trim();
            String date = delimited[1].trim();
            String author = delimited[2].trim();
            int length = Integer.parseInt(delimited[3].trim());
            try {
                Book newBook = new Book(title, date, author, length);
                switch (newBook.getAuthor()) {
                    case STEVEN_KING:
                        stevenKings.add(newBook);
                        break;
                    case RUDYARD_KIPLING:
                        rudyardKiplings.add(newBook);
                        break;
                    case ISSAC_ASIMOV:
                        issacAsimovs.add(newBook);
                        break;
                    case SUZANNE_COLLINS:
                        suzanneCollins.add(newBook);
                        break;
                    default:
                        System.out.println("Invalid Author Name! Book not added");
                }
            } catch (ParseException e) {
                System.out.println("Invalid Date format! Book not added");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            // grab another input
            line = keyboard.nextLine();
        }
        // close keyboard
        keyboard.close();

        // print the summary
        printSummary();
    }

    /**
     * Prints the summary statement at the end of the program.
     * Identifies the oldest book by the author with the most books.
     */
    private void printSummary() {
        // determine the longest pq
        PriorityQueue<Book> pq = stevenKings;
        // compare with rudyard
        if (pq.size() < rudyardKiplings.size()) {
            pq = rudyardKiplings;
        }
        // compare with issac
        if (pq.size() < issacAsimovs.size()) {
            pq = issacAsimovs;
        }
        // compare with suzanne
        if (pq.size() < suzanneCollins.size()) {
            pq = suzanneCollins;
        }
        
        Book oldestBook = pq.peek();
        System.out.printf("%s, written by %s writer %s on %s is %d pages long.\n", 
            oldestBook.getTitle(), 
            oldestBook.getGenre(), 
            oldestBook.getAuthorName(), 
            oldestBook.getDate(), 
            oldestBook.getLength()
        );
    }
}


/**
 * 2022 AT&T TDP (Software Engineer) OOP Assignment.
 * Language used: Java
 *
 * @author John Choi choi.1655@osu.edu
 * @version Jan 11, 2022
 */
public class Main {
    
    private static DataManager manager;

    public static void main(String[] args) {
        manager = DataManager.getInstance();
        manager.readInput();
    }
}
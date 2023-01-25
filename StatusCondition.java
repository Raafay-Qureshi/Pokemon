import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class StatusCondition {

    private static HashMap<String, String> statuses = new HashMap<>();

    public static void initializeStatusConditions() {
        try {
            Scanner scanner = new Scanner(new File("files/special_status_pokemon.csv"));
            boolean firstLine = true;
            while (scanner.hasNextLine()) {
                String[] splitInput = scanner.nextLine().split(",");
                if (firstLine) {firstLine=false; continue;}
                statuses.put(splitInput[0], splitInput[1]);
            }
            scanner.close();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getStatusWithMove(String move) {
        if (statuses.containsKey(move)) {
            return statuses.get(move);
        } else {
            return "";
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Multiplier {

    public float getMultiplier(String attackType, String defendingType) {
        try {
            Scanner scanner = new Scanner(new File("files/multiplier.csv"));
            int i = 0;
            int defendingIndex = 0;
            while (scanner.hasNextLine()) {
                String[] splitInput = scanner.nextLine().split(",");
                if (i == 0) {
                    for (int j = 0; j < splitInput.length; j++) {
                        if (splitInput[j].equals(defendingType)) {
                            defendingIndex = j; break;
                        }
                    }
                } else {
                    if (splitInput[0].equals(attackType)) {
                        float damageMultiplier = Float.valueOf(splitInput[defendingIndex]);
                        return damageMultiplier;
                    }
                }
                i++;
            }
            scanner.close();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println(e.getMessage());
            }
        }
        return -1;
    }
}

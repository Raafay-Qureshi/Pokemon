import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Moves {
    private ArrayList<Move> moves = new ArrayList<>();

    public Moves() {
        moves = getRandomMoves();
    }

    public ArrayList<Move> getRandomMoves() {
        ArrayList<Move> moves = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            while (true) {
                Move move = getRandomMove();
                if (!moveInList(move.getName(), moves)) {
                    moves.add(move);
                    break;
                }
            }
        }
        return moves;
    }

    public Move getRandomMove() {
        Move move = new Move("", "", 0);
        try {
            Scanner scanner = new Scanner(new File("files/moves.csv"));
            Random rand = new Random();
            int num = rand.nextInt(1, 165);
            int i = 0;
            while (scanner.hasNextLine()) {
                String[] splitInput = scanner.nextLine().split(",");
                if (i == 0) {i++; continue;}
                if (i == num) {
                    move = new Move(splitInput[0], splitInput[1], Integer.valueOf(splitInput[2]));
                    return move;
                }
                i++;
            }
            scanner.close();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println(e.getMessage());
            }
        }
        return move;
    }

    public boolean moveInList(String name, ArrayList<Move> moves) {
        for (Move move : moves) {
            if (move.getName().equalsIgnoreCase(name)) {return true;}
        }
        return false;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }
}

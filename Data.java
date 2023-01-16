import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Data {

    private ArrayList<Pokemon> pokemons = getRandomPokemons();

    public Data() {
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.getName() + " " + pokemon.getType() + " " + pokemon.getHP() + " " + pokemon.getAttack() + " " + pokemon.getDefense());
        }
    }

    public ArrayList<Pokemon> getRandomPokemons() {
        ArrayList<Pokemon> pokemonsList = getRandomPokemons();
        try {
            Scanner scanner = new Scanner(new File("files/pokemon.csv"));
            Random rand = new Random();
            for (int i = 0; i < 4; i++) {
                upper:
                while (true) {
                    int num = rand.nextInt(1, 152);
                    boolean firstLine = true;
                    System.out.println(num);
                    while (scanner.hasNextLine()) {
                        String[] splitInput = scanner.nextLine().split(",");
                        if (firstLine) {firstLine=false; continue;}
                        if (Integer.valueOf(splitInput[0]) == num) {
                            if (pokemonInList(splitInput[1])) {continue;}
                            Pokemon pokemon = new Pokemon(splitInput[1], splitInput[2], Integer.valueOf(splitInput[3]), Integer.valueOf(splitInput[4]), Integer.valueOf(splitInput[5]));
                            pokemonsList.add(pokemon);
                            break upper;
                        }
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println(e.getMessage());
            }
        }
        return pokemonsList;
    }

    public boolean pokemonInList(String name) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getName() == name) {return true;}
        }
        return false;
    }
}

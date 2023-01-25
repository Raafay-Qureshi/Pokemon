import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pokemons {

    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    private Pokemon currentPokemon;

    public Pokemons() {
        pokemons = getRandomPokemons();
        currentPokemon = pokemons.get(0);
    }

    public String toString() {
        return pokemons.toString();
    }

    public boolean takeDamage(double damage) {
        if (!pokemons.isEmpty()) {
            currentPokemon.loseHealth(damage);
            if (currentPokemon.isDead()) {
                System.out.println(currentPokemon + " feinted and is no longer able to battle!");
                pokemons.remove(0);
                if (pokemons.isEmpty()) {
                    return true;
                }
                currentPokemon = pokemons.get(0);
            }
        }
        return false;
    }

    public ArrayList<Pokemon> getRandomPokemons() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            while (true) {
                Pokemon pokemon = getRandomPokemon();
                if (!pokemonInList(pokemon.getName(), pokemons)) {
                    pokemons.add(pokemon);
                    break;
                }
            }
        }
        return pokemons;
    }

    public Pokemon getRandomPokemon() {
        Pokemon pokemon = new Pokemon(0, "", "", 0, 0, 0);
        try {
            Scanner scanner = new Scanner(new File("files/pokemon.csv"));
            Random rand = new Random();
            int num = rand.nextInt(1, 152);
            boolean firstLine = true;
            while (scanner.hasNextLine()) {
                String[] splitInput = scanner.nextLine().split(",");
                if (firstLine) {firstLine=false; continue;}
                if (Integer.valueOf(splitInput[0]) == num) {
                    pokemon = new Pokemon(Integer.valueOf(splitInput[0]),splitInput[1], splitInput[2],
                    Double.valueOf(splitInput[3]), Integer.valueOf(splitInput[4]), Integer.valueOf(splitInput[5]));
                    return pokemon;
                }
            }
            scanner.close();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println(e.getMessage());
            }
        }
        return pokemon;
    }

    public boolean pokemonInList(String name, ArrayList<Pokemon> pokemons) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getName().equalsIgnoreCase(name)) {return true;}
        }
        return false;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public Pokemon getCurrentPokemon() {
        return currentPokemon;
    }
}

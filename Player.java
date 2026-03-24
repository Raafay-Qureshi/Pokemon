import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;

    private Pokemons pokemons;
    private Multiplier multiplier;
    private Bag bag;

    public Player(String name) {
        this.name = name;
        this.pokemons = new Pokemons();
        this.multiplier = new Multiplier();
        this.bag = new Bag();
    }

    public Object getChoiceFromRange(Scanner scanner, String message, Object[] choices) {
        while (true) {
            try {
                System.out.println(message);
                for (int i = 0; i < choices.length; i++) {
                    System.out.println((i+1) + ". " + choices[i]);
                }
                int choice = Integer.valueOf(scanner.nextLine());
                if (choice < 1 || choice > choices.length) {
                    System.out.println("Choice is not in range [1-" + choices.length + "]");
                    continue;
                }
                return choices[choice - 1];
            } catch (NumberFormatException e) {
                System.out.println("Choice is not a number!");
            }
        }
    }

    public void chooseAction(Scanner scanner, Player enemy) {
        System.out.println("\n" + name + "'s turn!");
        System.out.println(name + "'s' pokemon: " + pokemons);
        Pokemon playerPokemon = this.getPokemons().getCurrentPokemon();
        String choice = "";
        while (true) {
            if (playerPokemon.getCondition() != "") {
                String[] choices = {"Use Bag", "Change Pokemon", "Run Away"};
                choice = (String) getChoiceFromRange(scanner, playerPokemon
                + " currently has the " + playerPokemon.getCondition() + " status condition so it's unable to battle.\nChoose an option!", choices);
            } else {
                String[] choices = {"Fight", "Use Bag", "Change Pokemon", "Run Away"};
                choice = (String) getChoiceFromRange(scanner, "Choose an option!", choices);
            }
    
            switch (choice) {
                case "Fight":
                    fight(scanner, enemy); break;
                case "Use Bag":
                    useBag(); break;
                case "Change Pokemon":
                    changePokemon(); break;
                case "Run Away":
                    runAway(); break;
            }
        }
    }

    public void fight(Scanner scanner, Player enemy) {
        Pokemon playerPokemon = this.getPokemons().getCurrentPokemon();
        ArrayList<Move> movesList = playerPokemon.getMoves().getMovesList();
        Move[] moveList = new Move[movesList.size()];
        for (int i = 0; i < movesList.size(); i++) {
            moveList[i] = movesList.get(i);
        }
        Move move = (Move) getChoiceFromRange(scanner, "Choose a move!", moveList);
        attackPlayer(enemy, move);
    }

    public void useBag() {
        Pokemon pokemon = this.getPokemons().getCurrentPokemon();
        if (bag.useItem(name, pokemon)) {
            
        }
    }

    public void changePokemon() {

    }

    public void runAway() {

    }

    public void attackPlayer(Player enemy, Move move) {
        Pokemon playerPokemon = this.getPokemons().getCurrentPokemon();
        Pokemon enemyPokemon = enemy.getPokemons().getCurrentPokemon();
        float multi = multiplier.getMultiplier(playerPokemon.getType(), enemyPokemon.getType());
        double damage = (2 * move.getPower() * ((Double.valueOf(playerPokemon.getAttack())/Double.valueOf(enemyPokemon.getDefense())) / 50.0) + 2) * multi * 5;
        if (enemy.getPokemons().takeDamage(damage)) {
            Game.endGame(this);
        } else {
            String condition = StatusCondition.getStatusWithMove(move.getName());
            System.out.println(this.name + "'s " + playerPokemon + " used " + move + " on " + enemy.name + "'s " + enemyPokemon + " for a total damage of " + damage + ". "
            + (enemyPokemon.getHP() + damage) + " --> " + enemyPokemon.getHP());
            if (!condition.equals("")) {
                enemyPokemon.setCondition(condition);
                System.out.println(enemyPokemon + " recieved " + condition + " status condition from the move " + move);
            }
        }
    }

    public Pokemons getPokemons() {
        return pokemons;
    }

    public String getName() {
        return name;
    }
}

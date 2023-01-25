import java.util.ArrayList;
import java.util.HashMap;

public class Bag {

    private HashMap<String, String> itemsToCondition = new HashMap<>();
    private ArrayList<String> items = new ArrayList<>();

    public Bag() {
        initializeBag();
    }

    public boolean useItem(String item, Pokemon pokemon) {
        if (items.contains(item)) {
            if (pokemon.getCondition().equals(itemsToCondition.get(item))) {
                items.remove(item);
                System.out.println("Removed condition: " + pokemon.getCondition() + " from " + pokemon);
                pokemon.setCondition("");
                return true;
            } else {
                System.out.println("Pokemon does not have condition: " + itemsToCondition.get(item));
            }
        } else {
            System.out.println("Player does not have item: " + item);
        }
        return false;
    }

    public void initializeBag() {
        itemsToCondition.put("Antidote", "Poison");
        itemsToCondition.put("Awakening", "Sleep");
        itemsToCondition.put("Burn Heal", "Burn");
        itemsToCondition.put("Full Heal", "All");
        itemsToCondition.put("Ice Heal", "Frozen");
        itemsToCondition.put("Paralyze Heal", "Paralysis");
        itemsToCondition.put("Persim Berry", "Confusion");
        for (String item : itemsToCondition.keySet()) {
            items.add(item);
        }
    }
}

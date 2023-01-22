public class Pokemon {

    private int index;
    private String name;
    private String type;
    private int HP;
    private int attack;
    private int defense;
    private Moves moves;

    public Pokemon(int index, String name, String type, int HP, int attack, int defense) {
        this.index = index;
        this.name = name;
        this.type = type;
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        if (name != "") {
            moves = new Moves();
        }
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHP() {
        return HP;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public Moves getMoves() {
        return moves;
    }
}
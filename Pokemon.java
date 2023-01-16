public class Pokemon {

    private String name;
    private String type;
    private int HP;
    private int attack;
    private int defense;

    public Pokemon(String name, String type, int HP, int attack, int defense) {
        this.name = name;
        this.type = type;
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
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
}
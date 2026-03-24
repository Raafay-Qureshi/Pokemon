public class Pokemon {

    private int index;
    private String name;
    private String type;
    private double HP;
    private int attack;
    private int defense;
    private Moves moves;
    private boolean dead;
    private String condition;

    public Pokemon(int index, String name, String type, double HP, int attack, int defense) {
        this.index = index;
        this.name = name;
        this.type = type;
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.dead = false;
        this.condition = "";
        if (name != "") {
            moves = new Moves();
        }
    }

    public String toString() {
        return name;
    }

    public void loseHealth(double damage) {
        this.HP -= damage;
        System.out.println(HP);
        if (this.HP <= 0) {
            this.dead = true;
        }
    }

    public void setCondition(String condition) {
        this.condition = condition;
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

    public double getHP() {
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
    
    public boolean isDead() {
        return dead;
    }

    public String getCondition() {
        return condition;
    }
}
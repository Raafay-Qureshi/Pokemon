public class Move {
    
    private String name;
    private String type;
    private int power;

    public Move(String name, String type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }
}

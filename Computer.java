public class Computer extends Player {

    public Computer(String name) {
        super(name);
    }

    public void chooseAction() {
        System.out.println("mhm" + this.getName());
    }
}

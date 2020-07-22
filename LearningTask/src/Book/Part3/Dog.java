package Book.Part3;

public class Dog extends Animals {
    private String name;

    public Dog() {}

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ("Dog: " + this.name);
    }
}

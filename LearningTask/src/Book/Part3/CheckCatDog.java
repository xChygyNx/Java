package Book.Part3;

public class CheckCatDog {
    public static void main (String[] args) {
        System.out.println(Animals.getAnimals());
        Animals.add(new Dog("Good Boy"));
        Animals.add(new Cat("Prohor"));
        Animals.add(new Dog("Bully"));
        Animals.add(new Dog("Bethoven"));
        Animals.add(new Cat("Markiza"));
        Animals.add(new Dog("Polkan"));
        Animals.add(new Dog("Banana"));
        Animals.add(new Cat("Pirate"));
        System.out.println(Animals.getAnimals());
        System.out.println(Animals.getCat());
        System.out.println(Animals.getAnimals());
        System.out.println(Animals.getDog());
        System.out.println(Animals.getDog());
        System.out.println(Animals.getDog());
        System.out.println(Animals.getAnimals());
        System.out.println(Animals.getDog());
        System.out.println(Animals.getDog());
        System.out.println(Animals.getDog());
        System.out.println(Animals.getAnimals());
    }
}

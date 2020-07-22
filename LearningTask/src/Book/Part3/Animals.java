package Book.Part3;
import java.util.LinkedList;
import java.util.Iterator;

public class Animals {
    private static LinkedList<Animals> animals = new LinkedList<Animals>();

    public static void add (Animals animal) {
        animals.add(animal);
    }

    public static Animals get() {
        return animals.getFirst();
    }

    public static Cat getCat() {
        Iterator<? extends Animals> iter = animals.iterator();
        while (iter.hasNext()) {
            Animals instance = iter.next();
            if (instance instanceof Cat) {
                Cat cat = (Cat)instance;
                iter.remove();
                return cat;
            }
        }
        return null;
    }

    public static Dog getDog() {
        Iterator<? extends Animals> iter = animals.iterator();
        while (iter.hasNext()) {
            Animals instance = iter.next();
            if (instance instanceof Dog) {
                Dog dog = (Dog)instance;
                iter.remove();
                return dog;
            }
        }
        return null;
    }

    public static LinkedList<? extends Animals> getAnimals() {
        return animals;
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


public class AnimalTest {
    static Animals animals = new Animals();

    @BeforeAll
    static void init(){
        ArrayList<String> characteristics1 = new ArrayList<>();
        characteristics1.add("It Barks");
        characteristics1.add("Has a tail");
        Animal animal1 = new Animal("Dog", characteristics1);
        animals.addAnimal(animal1);

        ArrayList<String> characteristics2 = new ArrayList<>();
        characteristics2.add("Has a tail");
        Animal animal2 = new Animal("Monkey", characteristics2);
        animals.addAnimal(animal2);
    }
    @Test
    public void AnimalShouldBeAddedToList(){
        ArrayList<String> characteristics = new ArrayList<>();
        characteristics.add("It Swims");
        Animal animal = new Animal("Fish", characteristics);

        animals.addAnimal(animal);
        Assertions.assertTrue(animal.getName().equals(animals.findAnimalByName("Fish").getName()));
    }

    @Test
    public void MustReturnAnimalWithMoreMatchingCharacteristics(){
        List<String> characteristics = new ArrayList<>();
        characteristics.add("It Barks");
        characteristics.add("Has a tail");

        Animal animal = animals.getAnimalWithMoreMatchingCharacteristic(characteristics);

        Assertions.assertEquals("Dog", animal.getName(), "Animal returned should be dog");
    }

    @Test
    public void MustReturnCorrectAmountOfCharacteristics(){
        ArrayList<String> characteristics = new ArrayList<>();
        characteristics.add("It Barks");
        characteristics.add("Has a tail");

        Animal animal = new Animal("Dog", characteristics);

        Assertions.assertEquals(2, animal.getNumberOfMatchingCharacteristics(characteristics), "Number of Characteristics should be 2");
    }
}

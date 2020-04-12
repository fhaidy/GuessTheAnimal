import java.util.ArrayList;
import java.util.List;

public class Animals {
    List<Animal> animals;

    public Animals() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public Animal findAnimalByName(String animalName){
        for (Animal animal: animals) {
            if (animalName.toUpperCase().equals(animal.getName().toUpperCase()))
                return animal;
        }
        return null;
    }

    public List<Animal> toList(){
        return animals;
    }

    public Animal getAnimalWithMoreMatchingCharacteristic(List<String> characteristics){
        int matchingCharacteristic = 0;
        Animal animalToBeReturned = null;
        for (Animal animal:animals) {
            int numberOfCharacteristics = animal.getNumberOfMatchingCharacteristics(characteristics);
            if (numberOfCharacteristics > matchingCharacteristic){
                matchingCharacteristic = numberOfCharacteristics;
                animalToBeReturned = animal;
            }
        }
        return animalToBeReturned;
    }
}

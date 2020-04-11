import java.util.ArrayList;
import java.util.List;

public class Animal {
    List<String> characteristics;
    String name;

    public Animal(String name, ArrayList<String> characteristic) {
        this.characteristics = characteristic;
        this.name = name;
    }

    public int getNumberOfMatchingCharacteristics(List<String> characteristics){
        int numberOfMatchingCharacteristics = 0;
        for (String characteristic:characteristics) {
            if (this.characteristics.contains(characteristic))
                numberOfMatchingCharacteristics++;
        }
        return numberOfMatchingCharacteristics;
    }

    /*public void addCharacteristic(String characteristic) {
        this.characteristics.add(characteristic);
    }*/
    public String getName() {
        return name;
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;

    public ToyShop() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy selectToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        double winningNumber = random.nextDouble() * totalWeight;
        double currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (currentWeight >= winningNumber) {
                return toy;
            }
        }

        return null;
    }

    public void issueToy() throws IOException {
        Toy toy = selectToy();
        if (toy != null && toy.getQuantity() > 0) {
            toy.setQuantity(toy.getQuantity() - 1);

            String fileName = toy.getName() + ".txt";
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(toy.getName());
            fileWriter.close();

            System.out.println("You won a " + toy.getName() + "! It has been added to your collection.");
        } else {
            System.out.println("Sorry, there are no more " + toy.getName() + " left.");
        }
    }
}
    

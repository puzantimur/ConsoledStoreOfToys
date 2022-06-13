import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {


  public static void main(String[] args) {

    // hardcoded data
    Costumer costumer = new Costumer("Boomblerf", "Trusiki189", 1, 0, null);
    Map<String, String> whatINeed = new HashMap<>();
    whatINeed.put(costumer.getNick(), costumer.getPassword());

    // create a list of users
    ArrayList<Costumer> costumers = new ArrayList<>();
    costumers.add(costumer);

    //create a list of products
    ArrayList<Product> toys = new ArrayList<>();
    Product toy1 = new Product("Doll LOL", Type.DOLLS, 2020, 2, 5, 34);
    toys.add(toy1);
    Product toy2 = new Product("Porshe", Type.CARS, 2021, 9, 8, 12);
    toys.add(toy2);
    Product toy3 = new Product("Teddy", Type.SOFT_TOY, 2021, 3, 2, 11);
    toys.add(toy3);
    Product toy4 = new Product("Transformer Bumblebee", Type.CONSTRUCTOR, 2022, 3, 7, 46);
    toys.add(toy4);
    Product toy5 = new Product("Bionicle", Type.LEGO, 2020, 2, 18, 41);
    toys.add(toy5);
    Product toy6 = new Product("Star Wars", Type.LEGO, 2022, 3, 27, 21);
    toys.add(toy6);
    Product toy7 = new Product("Vehicle", Type.CONSTRUCTOR, 2020, 5, 25, 7);
    toys.add(toy7);
    Product toy8 = new Product("Lambo URUS", Type.CARS, 2022, 4, 21, 9);
    toys.add(toy8);
    Product toy9 = new Product("Barbie", Type.CARS, 2022, 3, 12, 56);
    toys.add(toy9);

    //show the main menu
    {
      try {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        toys = (ArrayList) objectInputStream.readObject();
        whatINeed = (Map) objectInputStream.readObject();
        costumers = (ArrayList) objectInputStream.readObject();
      } catch (IOException | ClassNotFoundException e) {
        System.out.println("Сохранений не было");
      }
    }
    Console.menu(toys, whatINeed, costumers);




  }

  // 1.open
// read file
// deserialize the list
// OR if empty
// create a customers list
// create a list of products
// 2.show the login menu
// 3.login / registration
// 4.save a Customer to the local variable
// 5.show the main menu
// 6.show menu cases
// 7.logout
// serialize customers list
// write to file

//list cutomers
// cuistomer
// product
// product
// cuistomer
// product
// product
// product
// product
// product
// cuistomer
// cuistomer

}

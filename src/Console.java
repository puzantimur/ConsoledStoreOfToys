import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Console {

  static Costumer currentCostumer = new Costumer();
  static Product currentProduct = new Product();
  static ArrayList<Product> currentListOfPurchasedProducts = new ArrayList<>();

  public static void menu(ArrayList products, Map usersNP, ArrayList users) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Добро пожаловать в Timur's Toys Store (TTS)!!!\nДля вашего удобства в "
        + "нашем интернет-магазине имеется консольное меню для Вас!Выберите один из"
        + " пунктов (просто цифра)\n1 - Если Вы уже прошли регистрацию и "
        + "имеете аккаунт, просим вас ввести логин и пароль =)\n2 - Если вы хотите зарегистрироваться,"
        + " так же введите новый логин и пароль!\n3 - Если хотите покинуть программу");
    System.out.println("Введите цифру (1-3): ");
    try {
      int x = scanner.nextInt();
      switch (x) {
        case 1:
          entry(products, usersNP, users);
          cabinet();
          cabinet1(products, usersNP, users);
          break;
        case 2:
          registry(products, usersNP, users);
          cabinet();
          cabinet1(products, usersNP, users);
          break;
        case 3:
          System.out.println("До свидания, приходите к нам ещё");
          saveProgress(products, usersNP, users);
          return;
        default:
          System.out.println("Вы ввели неверное значение меню, запустите программу снова");
      }
    } catch (InputMismatchException e) {
      System.out.println("Постарайтесь попасть точно цифры");
      menu(products, usersNP, users);
    }
  }

  public static void entry(ArrayList products, Map usersNP, ArrayList users) {
    String nick;
    String pass;
    int id;
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите логин ниже: ");
    nick = sc.nextLine();
    System.out.println("Введите пароль ниже: ");
    pass = sc.nextLine();
    System.out.println("Введите ваш уникальный ID");
    id = sc.nextInt();
    try {
      currentCostumer = (Costumer) users.get(id);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Такого айди не существует");
    }
    if (((usersNP.containsKey(nick) && usersNP.containsValue(pass)) &&
        (currentCostumer.getNick().equals(nick) && currentCostumer.getPassword().equals(pass))
        && currentCostumer.getUniqId() == id) == false) {
      System.out.println("Вы ввели неверный логин или пароль");
      System.out.println(" Попробовать снова - 1 \n Выйти назад - 2");
      int r = sc.nextInt();
      switch (r) {
        case 1:
          entry(products, usersNP, users);
          break;
        case 2:
          menu(products, usersNP, users);
          break;
        default:
          System.out.println("Неверная цифра. Запустите программу снова");
      }
    }
    if (((usersNP.containsKey(nick) && usersNP.containsValue(pass)) &&
        (currentCostumer.getNick().equals(nick) && currentCostumer.getPassword().equals(pass)
            && currentCostumer.getUniqId() == id)) == true) {
      System.out.println("Добрый день, " + nick + " !");
      currentCostumer = (Costumer) users.get(id);
    }
  }

  public static void registry(ArrayList products, Map usersNP, ArrayList users) {
    Scanner sc9 = new Scanner(System.in);
    String pass1;
    String nick1;
    System.out.println("Введите логин ниже: ");
    nick1 = sc9.nextLine();
    System.out.println(
        "Введите пароль ниже: \n(напоминаем, что при регистрации - пароль должен "
            + "содержать не менее одной цифры и буквы верхнего и нижнего регистра");
    pass1 = sc9.nextLine();
    if (usersNP.containsKey(nick1)) {
      System.out.println(
          "К сожалению пользователь с таким никнеймом уже есть. Либо измените ник "
              + "для регистрации, либо вспомните ваш пароль и пройдите авторизацию");
      System.out.println("Введите 1 для повторной попытки. \nВведите 2 для выхода обратно");
      Scanner sc1234 = new Scanner(System.in);
      int re = sc1234.nextInt();
      switch (re) {
        case 1:
          registry(products, usersNP, users);
          break;
        case 2:
          menu(products, usersNP, users);
          break;
        default:
          System.out.println("Неверно выбран пункт меню");
          registry(products, usersNP, users);
      }
    }
    if (pass1.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$") &&
        nick1.matches("[A-Za-z_]+")) {
      usersNP.put(nick1, pass1);
      System.out.println(
          "Поздравляем с успешной регистрацией в магазине игрушек от Тимура! \nВаш "
              + "логин - " + nick1 + " Ваш пароль - " + pass1 + " Ваш уникальный ID - "
              + users.size());
      Costumer costumer = new Costumer(nick1, pass1, 0.00, (users.size()), null);
      currentCostumer = costumer;
      users.add(costumer);
    } else {
      System.out.println("Некорректно введены логин или пароль.");
      System.out.println(
          "Введите 1 для повторного ввода, или 2 для выхода на первую страницу");
      Scanner sc4 = new Scanner(System.in);
      int qwert = sc4.nextInt();
      switch (qwert) {
        case 1:
          registry(products, usersNP, users);
          break;
        case 2:
          menu(products, usersNP, users);
          break;
        default:
          System.out.println("Неверно выбран пункт меню");
          registry(products, usersNP, users);
      }
    }
  }

  public static void cabinet() {
    System.out.println("--- Личный кабинет ---");
    System.out.println("Выберите следующий пункт в МЕНЮ: ");
    System.out.println(" 1. Вывести корзину покупок \n 2. Вывести список товаров магазина "
        + "\n 3. Баланс и его пополнение $ \n 4. Купить товар по номеру ID \n 5. Закончить работу и "
        + "вернуться на главную страницу ВХОДА ");
  }

  public static void saveProgress(ArrayList products, Map usersNP, ArrayList users) {
    FileOutputStream fileOutputStream = null;
    try {
      fileOutputStream = new FileOutputStream(new File("test.txt"));
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(products);
      objectOutputStream.writeObject(usersNP);
      objectOutputStream.writeObject(users);
      objectOutputStream.flush();
      objectOutputStream.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



    //create stream
    //serialize list
    //write to stream



  public static void cabinet1(ArrayList products, Map usersNP, ArrayList users) {
    Scanner scanner21 = new Scanner(System.in);
    int x = scanner21.nextInt();
    switch (x) {
      case 1:
        purchasedProducts(products, usersNP, users);
        break;
      case 2:
        productsList(products);
        Scanner scanner11 = new Scanner(System.in);
        System.out.println("Для возврата в меню нажмите 1");
        int sda = scanner11.nextInt();
        switch (sda) {
          case 1:
            cabinet();
            cabinet1(products, usersNP, users);
            break;
          default:
            System.out.println("Вы ввели неверное значенмя меню");
        }
        break;
      case 3:
        money(products, usersNP, users);
        break;
      case 4:
        purchaseById(products, usersNP, users);
        break;
      case 5:
        menu(products, usersNP, users);
        break;
      default:
        System.out.println("Неверная цифра");

    }
  }

  public static void purchaseById(ArrayList products, Map usersNP, ArrayList users) {
    System.out.println("Введите ID товара для покупки");
    Scanner sc111 = new Scanner(System.in);
    try {
      int pbi = sc111.nextInt();
      currentProduct = (Product) products.get(pbi-1);
      System.out.println("Вы выбрали товар " + currentProduct);
      if (currentCostumer.getAmountOfMoney() < currentProduct.getPrice()) {
        throw new DeficiencyAmountOfMoneyException("Недостаточно денег");
      }
      System.out.println("Поздравляем с успешной покупкой товара ");
      products.remove(pbi-1);
      currentListOfPurchasedProducts.add(currentProduct);
      currentCostumer.setPurchasedProducts(currentListOfPurchasedProducts);
      currentCostumer.setAmountOfMoney(
          currentCostumer.getAmountOfMoney() - currentProduct.getPrice());
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Вы ввели несуществующий индекс товара");
    } catch (DeficiencyAmountOfMoneyException e) {
      System.out.println("Недостаточно денег");
      money(products, usersNP, users);
    }
      System.out.println("1 - Вернуться в меню\n2 - Купить ещё один товар. ");
      Scanner sc1234567 = new Scanner(System.in);
      int i = sc1234567.nextInt();
      switch (i) {
        case 1:
          cabinet();
          cabinet1(products, usersNP, users);
          break;
        case 2:
          purchaseById(products, usersNP, users);
          break;
        default:
          System.out.println("Попадай по кнопкам!");
      }
    }


  public static void money(ArrayList products, Map usersNP, ArrayList users) {
    Scanner sss = new Scanner(System.in);
    System.out.println(
        "Для проверки баланса нажмите 1\nДля пополнения баланса нажмите 2\nДля выхода "
            + "в главное меню нажмите 3");
    int m = sss.nextInt();
    switch (m) {
      case 1:
        System.out.println("Ваш баланс: " + currentCostumer.getAmountOfMoney());
        money(products, usersNP, users);
        break;
      case 2:
        System.out.println("Введите сумму для пополнения баланса");
        Scanner scannerBalance = new Scanner(System.in);
        double balance = scannerBalance.nextDouble();
        currentCostumer.setAmountOfMoney(currentCostumer.getAmountOfMoney() + balance);
        System.out.println("Ваш баланс теперь составляет: " + (currentCostumer.getAmountOfMoney() +
            "$"));
        money(products, usersNP, users);
        break;
      case 3:
        cabinet();
        cabinet1(products, usersNP, users);
        break;
      default:
        System.out.println("Попадай по кнопкам!");
        money(products, usersNP, users);
    }

    // saveProgress();
  }

  public static void purchasedProducts(ArrayList products, Map usersNP, ArrayList users) {
    if (currentCostumer.getPurchasedProducts() == null) {
      System.out.println("Вы пока ничего не покупали");
    } else {
      System.out.println(currentCostumer.getPurchasedProducts());
    }
    System.out.println("Для возврата в меню нажмите 1");
    Scanner scs = new Scanner(System.in);
    int xvc = scs.nextInt();
    switch (xvc) {
      case 1:
        cabinet();
        cabinet1(products, usersNP, users);
        break;
    }
  }

  public static void productsList(ArrayList products) {
    System.out.println("К вашему выбору следующий список игрушек:");
    for (int i = 0; i < products.size(); i++) {
      System.out.println("Игрушка: " + " id " + (i + 1) + " " + products.get(i));
    }


  }
}



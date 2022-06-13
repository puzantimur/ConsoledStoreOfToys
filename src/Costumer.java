import java.io.Serializable;
import java.util.ArrayList;

// Customer
public class Costumer implements Serializable {

  private String nick;
  private String password;
  private double amountOfMoney;
  private int uniqId;
  private ArrayList<Product> purchasedProducts = new ArrayList<>();

  public Costumer() {
  }

  public Costumer(String nick, String password, double amountOfMoney, int uniqId,
      ArrayList<Product> purchasedProducts) {
    this.nick = nick;
    this.password = password;
    this.amountOfMoney = amountOfMoney;
    this.uniqId = uniqId;
    this.purchasedProducts = purchasedProducts;
  }

  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public double getAmountOfMoney() {
    return amountOfMoney;
  }

  public void setAmountOfMoney(double amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }

  public int getUniqId() {
    return uniqId;
  }

  public void setUniqId(int uniqId) {
    this.uniqId = uniqId;
  }

  public ArrayList<Product> getPurchasedProducts() {
    return purchasedProducts;
  }

  public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
    this.purchasedProducts = purchasedProducts;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Costumer{");
    sb.append("nick='").append(nick).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", amountOfMoney=").append(amountOfMoney);
    sb.append(", uniqId=").append(uniqId);
    sb.append(", purchasedProducts=").append(purchasedProducts);
    sb.append('}');
    return sb.toString();
  }
}

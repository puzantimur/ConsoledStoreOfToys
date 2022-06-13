import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


public class Product implements Serializable {

  private static int serialNumber;

  private String name;
  private Type type;
  private Date dateOfCreation;
  private double price;

  public Product() {
  }

  public Product(String name, Type type, int year, int month, int day, double price) {
    this.name = name;
    this.type = type;
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, day);
    this.dateOfCreation = new Date();
    this.dateOfCreation.setTime(calendar.getTimeInMillis());
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getDate() {
    return UtilDate.getFormattedDate(dateOfCreation);
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public static int getSerialNumber() {
    return serialNumber;
  }

  public static void setSerialNumber(int serialNumber) {
    Product.serialNumber = serialNumber;
  }
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder(" ");
    sb.append(" наименование: ").append(name).append(", ");
    sb.append(" тип ").append(type);
    sb.append(", дата изготовления: ").append(getDate());
    sb.append(", цена $ ").append(price);
    return sb.toString();
  }
}

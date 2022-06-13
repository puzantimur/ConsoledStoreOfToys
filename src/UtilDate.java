import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {

  public static final String DATE_FORMAT_PATTER = "dd-MM-yyyy";
  public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTER);

  public static String getFormattedDate(Date date) {
    return DATE_FORMAT.format(date);
  }

}



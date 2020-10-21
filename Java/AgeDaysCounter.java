import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: rsv
 * Date: 03.10.2020
 * Time: 19:27
 */
public class AgeDaysCounter {

    public static void main(String[] args) throws IOException, ParseException {
        String string = System.console().readLine("Write your date of birth DD/MM/YYYY: ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dob = simpleDateFormat.parse(string);
        Date now = new Date();
        long numberOfDays = ChronoUnit.DAYS.between(dob.toInstant(), now.toInstant());
        System.out.printf("You are %s days old!", numberOfDays);
    }
}

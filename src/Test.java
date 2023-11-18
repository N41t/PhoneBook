import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//    //regex: \d\d(-|\/)\d\d\1\d\d\d\d  (25-05-1997 или 25/05/1997)  или такой \d{2}(-|\/)\d{2}\1\d{4}
//regex for phone: (\+7|8)-\d{3}-\d{3}-\d{2}-\d{2}  (+7-456-654-76-89 или 8-435-632-23-42)

public class Test {
    public static void main(String[] args) throws ParseException {


        Scanner scannerTest = new Scanner(System.in);

        String dateInput = scannerTest.next();

            Pattern pattern = Pattern.compile("(\\+7|8)-\\d{3}-\\d{3}-\\d{2}-\\d{2}");  //достраиваем ДАННУЮ СТРОКУ

            Matcher matcher = pattern.matcher(dateInput);

            boolean answer = matcher.matches(); //выдает true или false

        System.out.println(answer);



//        while (true) {
//            System.out.print("Введите дату в формате (dd-mm-yyyy). Минимальный год 1900, Максимальный 2022" +
//                    "         \nВвод: ");
//            String dateInput = scannerTest.next();
//
//            Pattern pattern = Pattern.compile("(([0-2][1-9])|(3[0-1]))(-|/)(([0][1-9])|([1][0-2]))(-|/)(([1][9][0-9][0-9])|([2][0][0-2][0-2]))");  //достраиваем ДАННУЮ СТРОКУ
//
//            Matcher matcher = pattern.matcher(dateInput);
//
//            boolean answer = matcher.matches(); //выдает true или false
//
//            if (answer == true) {
//                System.out.println("Дата задана");
//
//                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//                Date date = format.parse(dateInput);
//
//
//                LocalDate dateNow = LocalDate.now();
//
//                LocalDate localDate1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//                long answerDate = ChronoUnit.YEARS.between(localDate1, dateNow);
//                System.out.println("Years between: " + answerDate);
//                break;
//            } else {
//                System.out.println("Дата введена не корректно");
//            }
//
//
//        }


    }
}
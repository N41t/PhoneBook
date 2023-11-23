package util;

import model.Contact;
import model.Type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    static Scanner scanner = new Scanner(System.in);

    public static String validateDate() throws ParseException {

        while (true) {
            System.out.print("Input the date in the format (dd-mm-yyyy). Min year 1900, Max year 2022" +
                    "         \nInput: ");
            String dateInput = scanner.next();

            Pattern pattern = Pattern.compile("(([0-2][1-9])|(3[0-1]))(-|/)(([0][1-9])|([1][0-2]))(-|/)(([1][9][0-9][0-9])|([2][0][0-2][0-2]))");

            Matcher matcher = pattern.matcher(dateInput);

            boolean answer = matcher.matches();

            if (answer == true) {
                return dateInput;

            } else {
                System.out.println("Date inputted incorrectly");
            }


        }
    }

    public static int calculateBirthday(String inputDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(inputDate);


                LocalDate dateNow = LocalDate.now();

                LocalDate localDate1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                long answerDate = ChronoUnit.YEARS.between(localDate1, dateNow);
        return (int)answerDate;
    }

    public static String validatePhoneNumber(Contact contact) {

        Pattern pattern;



        while (true) {

            if (contact.getType() == Type.MOB) {
                pattern = Pattern.compile("(\\+7|8)-\\d{3}-\\d{3}-\\d{2}-\\d{2}");
                System.out.print("Input the mobile number in format 8-ııı-ııı-ıı-ıı or +7-xxx-xxx-xx-xx." +
                        "         \nInput: ");
            } else if (contact.getType() == Type.HOME) {
                pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{2}");
                System.out.print("Input the home number in format xx-xx-xx." +
                        "         \n¬‚Ó‰: ");
            } else {
                pattern = Pattern.compile("\\d-\\d{3}-\\d{7}");
                System.out.print("Input the fax number in format x-xxx-xxxxxxx." +
                        "         \n¬‚Ó‰: ");
            }


            String phoneNumberInput = scanner.next();

            Matcher matcher = pattern.matcher(phoneNumberInput);

            boolean answer = matcher.matches();

            if (answer == true) {
                return phoneNumberInput;

            } else {
                System.out.println("Number inputted incorrectly");
            }
        }

    }
}

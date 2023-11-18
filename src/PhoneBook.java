import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Contact;
import model.Gender;
import model.Type;
import util.Util;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class PhoneBook {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Contact> contactList = new ArrayList<>();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("ТЕЛЕФОННЫЙ СПРАВОЧНИК: ");

        while (true) {
            System.out.println("1 - Добавить номер\n" +
                    "2 - Показать контакт\n" +
                    "3 - Сохранить контакты в json\n" +
                    "4 - Exit");

            while (true) {
                System.out.print("Input: ");
                int input = scanner.nextInt();
                if (input == 1) {
                    createContact();
                    break;
                } else if (input == 2) {
                    showContact();
                    break;
                } else if (input == 3) {
                    saveJson();
                    break;
                } else if (input == 4){
                    System.exit(1);
                } else {
                    System.out.println("Неверный ввод, повторите снова!");
                }
            }
        }




    }

    //Для начала и общего понимания всего, необходимо реализовать создание-сохранение-отправку в файл. А после остальные методы
    public static void createContact() throws IOException, ParseException { //возможно придется возвращать contact
        Contact contact = new Contact();

        System.out.print("Введите имя: ");
        String nameContact = scanner.next();
        contact.setName(nameContact);

        System.out.print("Введите фамилию: ");
        String surnameContact = scanner.next();
        contact.setSurname(surnameContact);

        System.out.print("Введите отчество: ");
        String fathernameContact = scanner.next();
        contact.setFatherName(fathernameContact);

        System.out.print("Введите дату рождения: ");
        String inputBirthday = Util.validateDate();
        contact.setBirthday(inputBirthday);


        contact.setAge(Util.calculateBirthday(inputBirthday));

        while (true) {
            System.out.println("Выберите тип телефонного номера: ");
            System.out.println("1 - сотовый \n" +
                    "2 - домашний \n" +
                    "3 - факс");

            System.out.print("Ввод: ");
            int input = scanner.nextInt();
            if (input == 1) {
                contact.setType(Type.MOB);
                break;
            } else if (input == 2) {
                contact.setType(Type.HOME);
                break;
            } else if (input == 3) {
                contact.setType(Type.FAX);
                break;
            } else {
                System.out.println("Введите другое значение");
            }
        }

        System.out.print("Введите номер телефона: ");
        //String phoneContact = scanner.next();
        String phoneContact = Util.validatePhoneNumber(contact);
        contact.setPhone(phoneContact);

        while (true) {
            System.out.println("Выберите пол: ");
            System.out.println("1 - мужской \n" +
                               "2 - женский \n");

            System.out.print("Ввод: ");
            int input = scanner.nextInt();
            if (input == 1) {
                contact.setGender(Gender.MALE);
                break;
            } else if (input == 2) {
                contact.setGender(Gender.FEMALE);
                break;
            } else {
                System.out.println("Введите другое значение");
            }
        }


        contactList.add(contact);


    }

    public static void showContact() {
        for (Contact contact : contactList) {
            System.out.println(contact.toString());
        }

    }

    //метод сохранения файла в json
    public static void saveJson() {
        String json = GSON.toJson(contactList);
        System.out.println(json);

        File file = new File("src/model/save/list.json");

        if (file.exists() && file.isFile()) {
            System.out.println("File has been created");
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("File was created successfully\n");
        }

        try(FileWriter writer = new FileWriter(file, false)) {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}

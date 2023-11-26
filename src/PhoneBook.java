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
        System.out.println("PhoneBook: ");

        while (true) {
            System.out.println("1 - Create contact\n" +
                    "2 - Show contacts\n" +
                    "3 - Update contact\n" +
                    "4 - Delete contact\n" +
                    "5 - Save contacts in json\n" +
                    "6 - Exit");

            while (true) {
                System.out.print("Input: ");
                String input = scanner.next();
                if (input.equals("1")) {
                    createContact();
                    break;
                } else if (input.equals("2")) {
                    showContact();
                    break;
                } else if (input.equals("3")) {
                    updateContact();
                    break;
                } else if (input.equals("4")) {
                    deleteContact();
                    break;
                } else if (input.equals("5")) {
                    saveJson();
                    break;
                } else if (input.equals("6")){
                    System.exit(1);
                } else {
                    System.out.println("Wrong input, repeat again!");
                }
            }
        }


    }



    public static void createContact() throws IOException, ParseException {
        Contact contact = new Contact();

        System.out.print("Input name: ");
        String nameContact = scanner.next();
        contact.setName(nameContact);

        System.out.print("Input surname: ");
        String surnameContact = scanner.next();
        contact.setSurname(surnameContact);

        System.out.print("(Input # - if you want to skip)\nInput fathername: ");
        String fathernameContact = scanner.next();
        if (fathernameContact.equals("#")) {
            contact.setFatherName(null);
        } else {
            contact.setFatherName(fathernameContact);
        }


        System.out.print("(Input # - if you want to skip)\nInput date of birthday: ");
        String inputBirthday = Util.validateDate();
        if (inputBirthday.equals("#")) {
            contact.setBirthday(null);
            contact.setAge(0);
        } else {
            contact.setBirthday(inputBirthday);
            contact.setAge(Util.calculateBirthday(inputBirthday));
        }



        while (true) {
            System.out.println("Input phone number type: ");
            System.out.println("1 - mobile \n" +
                    "2 - home \n" +
                    "3 - fax");

            System.out.print("Input: ");
            String input = scanner.next();
            if (input.equals("1")) {
                contact.setType(Type.MOB);
                break;
            } else if (input.equals("2")) {
                contact.setType(Type.HOME);
                break;
            } else if (input.equals("3")) {
                contact.setType(Type.FAX);
                break;
            } else {
                System.out.println("Wrong input, repeat again!");
            }
        }

        System.out.print("Input phone number: ");
        String phoneContact = Util.validatePhoneNumber(contact);
        contact.setPhone(phoneContact);

        while (true) {

            System.out.println("(Input # - if you want to skip)\nInput gender: ");
            System.out.println("1 - MALE \n" +
                               "2 - FEMALE \n");

            System.out.print("Input: ");

            String input = scanner.next();

            if (input.equals("1")) {
                contact.setGender(Gender.MALE);
                break;
            } else if (input.equals("2")) {
                contact.setGender(Gender.FEMALE);
                break;
            } else if (input.equals("#")){
                contact.setGender(null);
                break;
            } else {
                System.out.println("Wrong input, repeat again!");
            }
        }

        contactList.add(contact);

        System.out.println("Contact has been created!\n");

    }

    public static void updateContact() throws ParseException {

        while (true) {
            System.out.println("Search or show all contacts? 1 - Search, 2 - Show All Contact, 3 - Exit");
            String answer = scanner.next();
            if (answer.equals("1")) {
                Util.search(contactList);
            } else if (answer.equals("2")) {
                for (Contact value : contactList) {
                    System.out.println(value.shortToString() + "\n");
                }
            } else if (answer.equals("3")) {
                break;
            } else {
                System.out.println("Wrong input, repeat again!");
            }
        }


        while (true) {
            System.out.print("Input the id number to update contact: ");
            int updateInput = scanner.nextInt();
            int count = updateInput-1;
            if (updateInput <= 0) {
                System.out.println("Input incorrectly. Id is greater than 0");
            }else if (updateInput > contactList.size()) {
                System.out.println("Contact this id is doesn't exist");
                System.out.print("Input 1 - for return to main page or 2 - to continue.\n Input: ");
                int exitCycle = scanner.nextInt();
                if (exitCycle == 1) {
                    break;
                } else if (exitCycle == 2) {

                }
            } else if (contactList.contains(contactList.get(count))) {
                System.out.print("(Input # - if you want to skip)\nInput new name: ");
                String nameContact = scanner.next();
                if (nameContact.equals("#")) {

                } else {
                    contactList.get(count).setName(nameContact);
                }


                System.out.print("(Input # - if you want to skip)\nInput new surname: ");
                String surnameContact = scanner.next();
                if (surnameContact.equals("#")) {

                } else {
                    contactList.get(count).setSurname(surnameContact);
                }


                System.out.print("(Input # - if you want to skip)\nInput new fathername: ");
                String fathernameContact = scanner.next();
                if (fathernameContact.equals("#")) {

                } else {
                    contactList.get(count).setFatherName(fathernameContact);
                }


                System.out.print("(Input # - if you want to skip)Input date of birthday: ");

                String inputBirthday = Util.validateDate();

                if (inputBirthday.equals("#")) {

                } else {
                    contactList.get(count).setBirthday(inputBirthday);
                    contactList.get(count).setAge(Util.calculateBirthday(inputBirthday));
                }


                while (true) {
                    System.out.println("(Input # - if you want to skip)\nInput phone number type: ");
                    System.out.println("1 - mobile \n" +
                            "2 - home \n" +
                            "3 - fax");

                    if (surnameContact.equals("#")) {
                        break;
                    } else {
                        System.out.print("Input: ");
                        int input = scanner.nextInt();
                        if (input == 1) {
                            contactList.get(count).setType(Type.MOB);
                            break;
                        } else if (input == 2) {
                            contactList.get(count).setType(Type.HOME);
                            break;
                        } else if (input == 3) {
                            contactList.get(count).setType(Type.FAX);
                            break;
                        } else {
                            System.out.println("Wrong input, repeat again!");
                        }
                    }


                }

                System.out.print("(Input # - if you want to skip)\nInput phone number: ");
                String phoneContact = Util.validatePhoneNumber(contactList.get(count));

                contactList.get(count).setPhone(phoneContact);

                while (true) {

                    System.out.println("(Input # - if you want to skip)\nInput gender: ");
                    System.out.println("1 - MALE \n" +
                            "2 - FEMALE \n");

                    System.out.print("Input: ");

                    String input = scanner.next();

                    if (input.equals("1")) {
                        contactList.get(count).setGender(Gender.MALE);
                        break;
                    } else if (input.equals("2")) {
                        contactList.get(count).setGender(Gender.FEMALE);
                        break;
                    } else if (input.equals("#")){
                        contactList.get(count).setGender(null);
                        break;
                    } else {
                        System.out.println("Wrong input, repeat again!");
                    }
                }

                System.out.println("Contact has been updated!\n");
                break;
            }

        }


    }

    public static void deleteContact() {

        while (true) {
            System.out.println("Search or show all contacts? 1 - Search, 2 - Show All Contact, 3 - Exit");
            String answer = scanner.next();
            if (answer.equals("1")) {
                Util.search(contactList);
            } else if (answer.equals("2")) {
                for (Contact value : contactList) {
                    System.out.println(value.shortToString() + "\n");
                }
            } else if (answer.equals("3")) {
                break;
            } else {
                System.out.println("Wrong input, repeat again!");
            }
        }


        while (true) {
            System.out.print("Input the id number to delete contact: ");
            int updateInput = scanner.nextInt();
            int count = updateInput-1;
            if (updateInput <= 0) {
                System.out.println("Input incorrectly. Id is greater than 0");
            }else if (updateInput > contactList.size()) {
                System.out.println("Contact this id is doesn't exist");
                System.out.print("Input 1 - for return to main page or 2 - to continue.\n Input: ");
                int exitCycle = scanner.nextInt();
                if (exitCycle == 1) {
                    break;
                } else if (exitCycle == 2) {

                }
            } else if (contactList.contains(contactList.get(count))) {
                contactList.remove(count);
                System.out.println("Contact has been deleted!\n");
                break;
            }

        }


    }

    public static void showContact() {

        if (contactList.isEmpty()) {
            System.out.println("Contact list is empty");
        }



        while (true) {
            System.out.println("Search or show all contacts? 1 - Search, 2 - Show All Contact, 3 - Exit");
            String answer = scanner.next();
            if (answer.equals("1")) {
                Util.search(contactList);
            } else if (answer.equals("2")) {
                for (Contact value : contactList) {
                    System.out.println(value.shortToString() + "\n");
                }
                Util.sort(contactList);
            } else if (answer.equals("3")) {
                break;
            } else {
                System.out.println("Wrong input, repeat again!");
            }
        }


        while (true) {
            System.out.println("view detailed information about the contact?");
            System.out.println("1 - yes, 2 - no");
            System.out.print("Input: ");
            String answer = scanner.next();
            if (answer.equals("1")) {
                while (true) {
                    System.out.print("enter contact ID: ");
                    int idContact = scanner.nextInt();
                    int count = idContact-1;
                    if (contactList.contains(contactList.get(count))) {
                        System.out.println(contactList.get(count).toString() + "\n");
                        break;
                    } else {
                        System.out.println("Contact this id is doesn't exist");
                    }
                }

                break;
            } else if (answer.equals("2")) {

                break;
            } else {
                System.out.println("Wrong input, repeat again!");
            }
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

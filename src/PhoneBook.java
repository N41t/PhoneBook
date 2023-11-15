import model.Contact;
import model.Gender;
import model.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Contact> contactList = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("���������� ����������: ");

        while (true) {
            System.out.println("1 - �������� �����\n" +
                    "2 - �������� �������\n" +
                    "3 - Exit");

            while (true) {
                System.out.print("Input: ");
                int input = scanner.nextInt();
                if (input == 1) {
                    createContact();
                    break;
                } else if (input == 2) {
                    showContact();
                    break;
                } else if (input == 3){
                    System.exit(1);
                } else {
                    System.out.println("�������� ����, ��������� �����!");
                }
            }
        }




    }

    //��� ������ � ������ ��������� �����, ���������� ����������� ��������-����������-�������� � ����. � ����� ��������� ������
    public static void createContact() { //�������� �������� ���������� contact
        Contact contact = new Contact();

        System.out.print("������� ���: ");
        String nameContact = scanner.next();
        contact.setName(nameContact);

        System.out.print("������� �������: ");
        String surnameContact = scanner.next();
        contact.setSurname(surnameContact);

        System.out.print("������� ��������: ");
        String fathernameContact = scanner.next();
        contact.setFatherName(fathernameContact);

        System.out.print("������� ����� ��������: ");
        String phoneContact = scanner.next();
        contact.setPhone(phoneContact);

        System.out.print("������� ���� ��������: ");
        String birthdayContact = scanner.next();
        contact.setBirthday(birthdayContact);

        //� ����� util ������� �������� ��� ������������ ���� �������� � ������ ��� ����

        while (true) {
            System.out.println("�������� ���: ");
            System.out.println("1 - ������� \n" +
                               "2 - ������� \n");

            System.out.print("����: ");
            int input = scanner.nextInt();
            if (input == 1) {
                contact.setGender(Gender.MALE);
                break;
            } else if (input == 2) {
                contact.setGender(Gender.FEMALE);
                break;
            } else {
                System.out.println("������� ������ ��������");
            }
        }

        while (true) {
            System.out.println("�������� ��� ����������� ������: ");
            System.out.println("1 - ������� \n" +
                               "2 - �������� \n" +
                               "3 - ����");

            System.out.print("����: ");
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
                System.out.println("������� ������ ��������");
            }
        }

        contactList.add(contact);

    }

    public static void showContact() {
        for (Contact contact : contactList) {
            System.out.println(contact.toString());
        }

//        System.out.println(contactList.get(0).getName());
    }
}

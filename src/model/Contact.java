package model;


import java.util.Date;

public class Contact {

    private long id;
    private String name;
    private String surname;
    private String fatherName;
    private String phone;


    private String birthday;




    private int age;

    private Gender gender;

    private Type type;



    public Contact() {
        id = CountId.addCountId();
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "\nContact: \n" +
                "id: " + id +
                "\nSurname: " + surname +
                "\nName: " + name +
                "\nFatherName: " + fatherName +
                "\nType of number: " + type +
                "\nNumber: " + phone +
                "\nDate birthday: " + birthday +
                "\nAge: " + age +
                "\nGender: " + gender;

    }

    public String shortToString() {
        return "id: " + id + " - " + surname + " " + name;
    }

}

class CountId {
    private static int id = 1;

    public static int addCountId() {
        return id++;
    }
}

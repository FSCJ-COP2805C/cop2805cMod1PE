// HappyBirthdayApp.java
// D. Singletary
// 1/22/23
// wish a user happy birthday

package edu.fscj.cop2805c.birthday;

import java.util.Arrays;

public class HappyBirthdayApp {
    private final Integer MAX_USERS = 10;
    private User[] userList;

    public HappyBirthdayApp() {
        userList = new User[MAX_USERS];
    }
    public static void main(String[] args) {
        var numUsers = 0;

        HappyBirthdayApp birthdayApp = new HappyBirthdayApp();
        numUsers = birthdayApp.getUsers();
        System.out.println(birthdayApp);
    }

    public Integer getUsers() {
        final Integer NUM_USERS = 3;
        this.userList[0] = new User("John", "Smith", 3, 6);
        this.userList[1] = new User("Sally", "Roberts", 12, 3);
        this.userList[2] = new User("Rodney", "Allen", 7, 5);

        return NUM_USERS;
    }

    public String getGreeting(User u) {
        final String WISHES_PRE = "Today is ";
        var greeting = """
                Today is\s""" +
                u.getBirthMonth() + "/" + u.getBirthDay() + "\n" +
                """
                Happy Birthday\s""" +
                u.getFriendlyName() +
                """
                !\sHope all of your birthday wishes come true!\n""";

        return greeting;
    }

    @Override
    public String toString() {
        var s = "";

        for (User u : userList) {
            if (u == null)
                break;
            //s += u + "\n";
            s += getGreeting(u);
        }
        return s;
    }
}

// user class
class User {
    private String fName;
    private String lName;
    private Integer birthMonth; // 1 = January, 12 = December
    private Integer birthDay; // month day, e.g. 1, 15, 30

    public User(String fName, String lName, Integer birthMonth, Integer birthDay) {
        this.fName = fName;
        this.lName = lName;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public String getFriendlyName() {
        return fName + " " + lName;
    }

    @Override
    public String toString() {
        String s = getFriendlyName();
        return s;
    }
}

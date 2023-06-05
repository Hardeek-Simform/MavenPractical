package org.example.entity;

public class User {
    private int age;
    private String userName, gender;

    public User(int age, String userName, String gender) {
        this.age = age;
        this.userName = userName;
        this.gender = gender;
    }

    // ---------- Getter ------------
    public int getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

// ---------- Getter & setter --------------


    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                "}\n";
    }
}

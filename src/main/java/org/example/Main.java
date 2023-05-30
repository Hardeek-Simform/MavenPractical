package org.example;


import org.example.User.classes.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private void validateGender(String gender, int age, String uName, ArrayList<User> users) {
        if (gender == "F" || gender == "f") {
            users.add(new User(age, uName, "Female"));
        } else {
            users.add(new User(age, uName, "Male"));
        }
    }

    private void updateGender(String gender, int age, String uName, User object) {
        if (gender == "F" || gender == "f") {
            object.setAge(age);
            object.setGender("Female");
            object.setUserName(uName);

        } else {
            object.setAge(age);
            object.setGender("Male");
            object.setUserName(uName);
        }
    }

    public static void main(String[] args) {
        Main currentClassObj = new Main();
        int option = 6;

        ArrayList<User> users = new ArrayList();
        Scanner optionReader = new Scanner(System.in);
        do {
            System.out.print("\n1. Insert\n" +
                    "2. Display\n" +
                    "3. Search\n" +
                    "4. Delete\n" +
                    "5. Update\n" +
                    "Enter your choice (To exit enter 6 or any other number):");

            try {
                option = optionReader.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter number only without floating value or character:");
                option = optionReader.nextInt();
            } catch (Exception e) {
                System.out.print("\nPlease enter number only without floating value or character:");
                option = optionReader.nextInt();
            }
            Scanner dataReader = new Scanner(System.in);
            String uName;
            int age;
            String gender;
            try {
                switch (option) {


                    case 1: // Add

                        System.out.print("\nenter Name:");
                        uName = dataReader.nextLine();
                        System.out.print("\nEnter Age:");
                        age = Integer.parseInt(dataReader.next("[0-9]{2}$"));
                        System.out.print("\nEnter F for female and M for male:");
                        gender = dataReader.next("[f,F,m,M]");
                        currentClassObj.validateGender(gender, age, uName, users);
                        break;

                    case 2: // Display
                        users.stream().forEach(System.out::println);
                        break;

                    case 3: // Search
                        System.out.print("enter Name to search:");
                        uName = dataReader.nextLine();
                        users.stream().filter(e -> e.getUserName().toLowerCase().equals(uName.toLowerCase()))
                                .forEach(e -> System.out.println(e));
                        break;

                    case 4: // Delete
                        uName = dataReader.nextLine();
                        users.stream().filter(e -> e.getUserName().toLowerCase().equals(uName.toLowerCase()))
                                .forEach(e -> users.remove(e));
                        break;
                    case 5: // Update
                        uName = dataReader.nextLine();
                        System.out.println("\n enter details all the details");

                        System.out.print("\nname:");
                        String uNameForUpdate = dataReader.nextLine();
                        System.out.print("\nage:");
                        age = Integer.parseInt(dataReader.next("[0-9]{2}$"));
                        System.out.print("\nGender(enter f or m):");
                        gender = dataReader.next("[f,F,m,M]");
                        currentClassObj.validateGender(gender, age, uName, users);
                        users.stream().filter(e -> e.getUserName().toLowerCase().equals(uName.toLowerCase()))
                                .forEach(e -> currentClassObj.updateGender(gender, age, uNameForUpdate, e));
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Process cancelled !!! Please enter data correctly to perform operation correctly.");
            } catch (Exception e) {
                System.out.println("Process cancelled. Please try again");
            }

        } while (option < 6 && option >= 1);
    }

}

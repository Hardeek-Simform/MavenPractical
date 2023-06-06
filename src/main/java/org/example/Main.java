package org.example;

import org.example.entity.User;

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
        if (gender.equalsIgnoreCase("F")) {
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
                        System.out.println("\nPlease enter the following details to add:");
                        System.out.print("Enter Name:");
                        uName = dataReader.nextLine();
                        System.out.print("Enter Age:");
                        age = Integer.parseInt(dataReader.next("[0-9]{2}$"));
                        System.out.print("Enter F for female and M for male:");
                        gender = dataReader.next("[f,F,m,M]");
                        currentClassObj.validateGender(gender, age, uName.trim(), users);
                        break;

                    case 2: // Display
                        System.out.println("\nHere below are the details that was requested:");
                        if (users.isEmpty()) {
                            System.out.println("No records found !!!\n");
                        } else {
                            for (User user : users) {
                                System.out.println(user);
                            }
                        }
                        break;

                    case 3: // Search
                        System.out.println("\nPlease enter the name to search:");
                        uName = dataReader.nextLine();
                        users.stream().filter(e -> e.getUserName().toLowerCase().equals(uName.trim().toLowerCase()))
                                .forEach(e -> System.out.println(e));
                        break;

                    case 4: // Delete
                        System.out.println("\nPlease enter the name whose data you want to delete:");
                        Scanner dataReader1 = new Scanner(System.in);
                        String DName = dataReader1.nextLine();
//                        users.stream().filter(e -> DName.trim().toLowerCase().equals(e.getUserName().trim().toLowerCase()))
//                                .forEach(e -> users.remove(e));
                        users.removeIf(e -> e.getUserName().trim().equalsIgnoreCase(DName.trim()));
                        break;

                    case 5: // Update
                        System.out.println("Please enter name to update its data:");
                        uName = dataReader.nextLine();
                        System.out.println("Enter all the details:");
                        System.out.print("Name:");
                        String uNameForUpdate = dataReader.nextLine();
                        System.out.print("Age:");
                        age = Integer.parseInt(dataReader.next("[0-9]{2}$"));
                        System.out.print("Enter F for female and M for male:\n");
                        gender = dataReader.next("[f,F,m,M]");

                        users.stream().filter(e -> e.getUserName().trim().toLowerCase().equals(uName.trim().toLowerCase())).findFirst()
                                .ifPresent(user -> currentClassObj.updateGender(gender, age, uNameForUpdate, user));
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Process cancelled !!! Please enter data correctly to perform operation correctly.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Process cancelled. Please try again");
            }
        } while (option < 6 && option >= 1);
        System.out.println("Thank you for choosing our service. Have a great day.");
    }
}

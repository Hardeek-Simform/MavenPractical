package main.java.org.example;

import org.junit.internal.runners.statements.Fail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.fail;

public class MainTest {
    @org.junit.Test
    public void checkRegularExpressionForAgeValidation() {
        Pattern pattern1 = Pattern.compile("^[0-9]{2}$");
        Matcher testingAgeInput23 = pattern1.matcher("23");
        if (testingAgeInput23.find() == true) {
            System.out.println("age: 23 is validated successfully");
        } else {
            System.out.println("Inside else");
            fail("age: 999 is rejected");
        }

        Matcher testingAgeInput999 = pattern1.matcher("999");
        if (testingAgeInput999.find() == false) {
            System.out.println("age: 999 is rejected");
        } else {
            System.out.println("age: 999 is validated");
            fail("age: 999 is rejected");
        }
    }

}

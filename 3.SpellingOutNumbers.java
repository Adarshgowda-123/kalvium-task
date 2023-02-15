/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adarsh K
 */
import java.util.Scanner;

public class SpellingOutNumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        System.out.println(spellNumber(num));
    }

    public static String spellNumber(int num) {
        if (num == 0) {
            return "zero";
        } else if (num < 10) {
            return ones[num];
        } else if (num < 20) {
            return teens[num - 10];
        } else if (num < 100) {
            int tens = num / 10;
            int ones = num % 10;
            String hyphen = (ones > 0) ? "-" : "";
            return tensNames[tens - 2] + hyphen + ones(ones);
        } else if (num < 1000) {
            int hundreds = num / 100;
            int remainder = num % 100;
            String and = (remainder > 0) ? " and " : "";
            return ones[hundreds] + " hundred" + and + spellNumber(remainder);
        } else {
            int thousands = num / 1000;
            int remainder = num % 1000;
            String comma = (remainder > 0 && remainder < 100) ? " and " : ", ";
            return spellNumber(thousands) + " thousand" + comma + spellNumber(remainder);
        }
    }

    private static String ones(int num) {
        return (num == 0) ? "" : ones[num];
    }

    private static final String[] ones = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] teens = {
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
        "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tensNames = {
        "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

}


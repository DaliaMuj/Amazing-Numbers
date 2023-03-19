package numbers;

import java.util.Scanner;
class Property{
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("* the first parameter represents a starting number;");
        System.out.println("* the second parameter show how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        String num;
        long number;
        do {
            System.out.println("\nEnter a request:");
            num = scanner.nextLine();
            if (num.contains(" ")) {
                String[] numm = num.split(" ");
                number = Long.valueOf(numm[0]);
                int howMany =Integer.valueOf(numm[1]);
                if (numm.length == 2) {
                    if (number < 0) {
                        System.out.println("The first parameter should be a natural number or zero.");
                    }else if (howMany < 0) {
                        System.out.println("The second parameter should be a natural number.");
                    } else {
                        firstOption(number, howMany);
                    }
                } else if (numm.length == 3) {
                    String property = numm[2];
                    String properties = "BUZZ EVEN ODD DUCK SPY GAPFUL PALINDROMIC SUNNY SQUARE";
                    if (!properties.contains(property.toUpperCase())){
                        System.out.println("The property " + property.toUpperCase() + " is wrong.\nAvailable properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
                    } else {
                        properties1(number, howMany, property);
                    }
                } else if (numm.length == 4) {
                    String property1 = numm[2];
                    String property2 = numm[3];
                    String properties = "BUZZ EVEN ODD DUCK SPY GAPFUL PALINDROMIC SUNNY SQUARE";
                    if ((!properties.contains(property1.toUpperCase())) && (!properties.contains(property2.toUpperCase()))) {
                        System.out.println("The properties [" + property1.toUpperCase() + ", " + property2.toUpperCase() + "] are wrong.\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
                    } else if (!properties.contains(property1.toUpperCase())) {
                        System.out.println("The property " + property1.toUpperCase() + " is wrong.\nAvailable properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
                    } else if (!properties.contains(property2.toUpperCase())) {
                        System.out.println("The property " + property2.toUpperCase() + " is wrong.\nAvailable properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
                    } else if (mutualExclusive(property1, property2)) {
                        System.out.println("The request contains mutually exclusive properties: [" + property1.toUpperCase() + property2.toUpperCase()+ "] \nThere are no numbers with these properties.");
                    } else {
                        properties2(number, howMany, property1, property2);
                    }
                }
            } else {
                number = Long.valueOf(num);
                if (number < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else if (number == 0) {
                    System.out.println("Goodbye!\nProcess finished with exit code 0");
                    System.exit(0);
                } else {
                    secondOption(number);
                }
            }
        } while (number != 0);
        scanner.close();

    }
    static void firstOption(long number, int howMany) {
        for (int i = 0; i < howMany; i++) {
            print(number);
            number++;
        }
    }
    static void secondOption(long number) {
        System.out.println("Properties of " + number);
        System.out.println("even: " + even(number));
        System.out.println("odd: " + odd(number));
        System.out.println("buzz: " + buzz(number));
        System.out.println("duck: " + duck(number));
        System.out.println("palindromic: " + palindromic(number));
        System.out.println("gapful: " + gapful(number));
        System.out.println("spy: " + spy(number));
        System.out.println("sunny: " + sunny(number));
        System.out.println("square: " + square(number));
    }

    static void properties1(long number, int howMany, String property) {
        int count = 0;
        while (count < howMany) {
            switch(property.toUpperCase()) {
                case "SPY":
                    if(spy(number)) {
                        print(number);
                        count++;
                    }
                    break;
                case "PALINDROMIC":
                    if (palindromic(number)) {
                        print(number);
                        count++;
                    }
                    break;
                case "DUCK":
                    if (duck(number)) {
                        print(number);
                        count++;
                    }
                    break;
                case "GAPFUL":
                    if (gapful(number)) {
                        print(number);
                        count++;
                    }
                    break;
                case "BUZZ":
                    if (buzz(number)) {
                        print(number);
                        count++;
                    }
                    break;
                case "ODD":
                    if (odd(number)) {
                        print(number);
                        count++;
                    }
                    break;
                case "EVEN" :
                    if (even(number)) {
                        print(number);
                        count++;
                    }
                    break;
                case "SUNNY":
                    if (sunny(number)) {
                        print(number);
                        count++;
                    }
                    break;
                case "SQUARE":
                    if (square(number)) {
                        print(number);
                        count++;
                    }
                    break;
                default:
                    break;
            }
            number++;
        }
    }
    static void properties2(long number, int howMany, String property1, String property2) {
        int count2 = 0;
        while (count2 < howMany){
            boolean buzz = buzz(number);
            boolean duck = duck(number);
            boolean palindromic = palindromic(number);
            boolean even = even(number);
            boolean gapful = gapful(number);
            boolean spy = spy(number);
            boolean square = square(number);
            boolean sunny = sunny(number);
            switch(property1.toUpperCase()) {
                case "SPY":
                    if(spy) {
                        if(check(number, property2)){
                            print(number);
                            count2++;
                        }
                    }
                    break;
                case "PALINDROMIC":
                    if (palindromic) {
                        if(check(number, property2)){
                            print(number);
                            count2++;
                        }
                    }
                    break;
                case "DUCK":
                    if (duck) {
                        if(check(number, property2)){
                            print(number);
                            count2++;
                        }
                    }
                    break;
                case "GAPFUL":
                    if (gapful) {
                        if(check(number, property2)){
                            print(number);
                            count2++;
                        }
                    }
                    break;
                case "BUZZ":
                    if (buzz) {
                        if(check(number, property2)){
                            print(number);
                            count2++;
                        }
                    }
                    break;
                case "ODD":
                    if (!even) {
                        if(check(number, property2)){
                            print(number);
                            count2++;
                        }
                    }
                    break;
                case "EVEN" :
                    if (even) {
                        if(check(number, property2)){
                            print(number);
                            count2++;
                        }
                    }
                    break;
                case "SUNNY":
                    if (sunny) {
                        if(check(number, property2)){
                            print(number);
                            count2++;
                        }
                    }
                    break;
                case "SQUARE":
                    if (square) {
                        if(check(number, property2)){
                            print(number);
                            count2++;
                        }
                    }
                    break;
                default:
                    break;
            }
            number++;
        }
    }

    static boolean check(long number, String property2) {
        boolean buzz = buzz(number);
        boolean duck = duck(number);
        boolean palindromic = palindromic(number);
        boolean even = even(number);
        boolean gapful = gapful(number);
        boolean spy = spy(number);
        boolean square = square(number);
        boolean sunny = sunny(number);
        switch(property2.toUpperCase()) {
            case "SPY":
                    return spy;
            case "PALINDROMIC":
                    return palindromic;
            case "DUCK":
                    return duck;
            case "GAPFUL":
                    return gapful;
            case "BUZZ":
                    return buzz;
            case "ODD":
                    return !even;
            case "EVEN" :
                    return even;
            case "SQUARE":
                    return square;
            default:
                return sunny;
        }
    }

    static void print(long number) {
        boolean fuzzyNumber = buzz(number);
        boolean duckNumber = duck(number);
        boolean palindromic = palindromic(number);
        boolean isNumberEven = even(number);
        boolean gapfulNumber = gapful(number);
        boolean spyNumber = spy(number);
        boolean sunnyNumber = sunny(number);
        boolean squareNumber = square(number);
        String evenNumber = (isNumberEven ? "even" : "odd");
        System.out.println(number + " is " + (fuzzyNumber ? "buzz, " : "") + (duckNumber ? "duck, " : "")
                + (palindromic ? "palindromic, " : "") + (gapfulNumber ? "gapful, " : "") + (spyNumber ? "gapful, " : "")
                + (sunnyNumber ? "sunny, " : "") + (squareNumber ? "square, " : "") + evenNumber);
    }
    static boolean even(long number) {
        return number % 2 == 0;
    }
    static boolean odd(long number) {
        return number % 2 != 0;

    }
    static boolean buzz(long number) {
       return number % 7 == 0 || number % 10 == 7;
    }
    static boolean gapful(long number) {
        int length = String.valueOf(number).length();
        return length >= 3 && number % (number % 10 +(int)(number / Math.pow(10, length - 1)) * 10) == 0;

    }
    static boolean duck(long number) {
        String s = String.valueOf(number);
        int i = s.length() - 1;
        while (i != 0) {
            if (s.charAt(i) == '0') {
                return true;
            }
            i--;
        }
        return false;
    }
    static boolean palindromic(long number) {
        long reverseNumber = reverseDigits(number);
        long numberOfDigits = String.valueOf(number).length();
        if (numberOfDigits != 1) {
            if (number == reverseNumber) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    static boolean spy(long number) {
        long sum = 0L;
        long product = 1L;
        while (number != 0) {
            sum += (number % 10);
            product *= (number % 10);
            number /= 10;
        }
        if (sum == product) {
            return true;
        }
        return false;
    }
    static boolean square(long number) {
        double sqrt = Math.sqrt(number);
        return (sqrt - Math.floor(sqrt) == 0);
    }
    static boolean sunny(long number) {
        return square(number+1);

    }
    static long reverseDigits(long number) {
        long reverseNumber = 0L;
        while (number > 0) {
            reverseNumber= reverseNumber * 10 + number % 10;
            number = number / 10;
        }
        return reverseNumber;
    }
    static boolean mutualExclusive(String property1, String property2) {
        String[] mutualParameters1 = new String[]{"even odd", "spy duck", "sunny square"};
        String[] mutualParameters2 = new String[]{"odd even", "duck spy", "square sunny"};
        String parameter = property1 + " " + property2;
        for (int i = 0; i < mutualParameters1.length; i++) {
            if (parameter.equals(mutualParameters1[i]) || parameter.equals(mutualParameters2[i])) {
                return true;
            }level
        }
        return false;
    }

}
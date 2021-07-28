import java.util.Scanner;

class Palindrome {
    static Scanner sc; 

    // Method that checks if the number is a fuzzy number 
    public static boolean fuzzNumber(long number) {
        long lastDigit = number % 10;
        return lastDigit == 7 || number % 7 == 0;
    }

    // Method that checks if the number is a duck number
    public static boolean duckNumber(long number) {
        while (number > 9) {
            long rem = number % 10;
            if(rem == 0) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }

    // Method that 
    public static boolean palindrome(long number) {
        // Reverse the number through a while loop
        long reverse = 0;
        long temp = number;
        while (temp != 0) {  
            long remainder = temp % 10;  
            reverse = reverse * 10 + remainder;  
            temp = temp / 10;  
        }  
        // Checks if the reverse is equal to the original number
        // If it is, then the number is a palindrome 
        return number == reverse;
    }

    // Method that checks if the number is even or odd 
    public static boolean evenNumber(long number) {
        return number % 2 == 0;
    }

    // Method for running the program
    public static void runProgram() {
        System.out.println("Welcome to Amazing Numbers\n");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties");
        System.out.println("- enter 0 to exit.\n");

        sc = new Scanner(System.in);
        long number;
        boolean runProgram = true;

        while (runProgram) {
            System.out.print("Enter a request: ");
            number = sc.nextLong();
            System.out.println();
            if (number == 0) {
                System.out.println("Goodbye");
                runProgram = false;
            } else if (number < 0){
                System.out.println("The first parameter should be a natural number or zero.\n");
            } else { // If number is natural it checks all properties of number through the different methods 
                boolean fuzzyNumber = fuzzNumber(number);
                boolean duckNumber = duckNumber(number);
                boolean palindrome = palindrome(number);
                boolean isNumberEven = evenNumber(number);
                System.out.println("Properties of " + number);
                System.out.println("    even: " + (isNumberEven ? "true" : "false"));
                System.out.println("    odd: " + (!isNumberEven ? "true" : "false"));
                System.out.println("    buzz: " + (fuzzyNumber ? "true" : "false"));
                System.out.println("    duck: " + (duckNumber ? "true" : "false"));
                System.out.println("    palindromic: " + (palindrome ? "true\n" : "false\n"));
            }
        }
    }
    public static void main(String[] args) {
        runProgram();
    }
}
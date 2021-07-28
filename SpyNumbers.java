import java.util.Scanner;

public class SpyNumbers {
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

    // Method that checks if a number is gapful 
    public static boolean gapfulNumber(long number) {
        // Check first if the numbers is less that 100, if it is, 
        // then it can't be a gapful numbers
        if (number < 100) {
            return false;
        } else {
            // else it converts the numbers to strings and creates an array to 
            // get the first and last numbers and concatinate these together. 
            String convertedNumber = Long.toString(number);
            String [] convertedNumbers = convertedNumber.split("");
            String concatinatedNum = convertedNumbers[0] + convertedNumbers[convertedNumbers.length - 1];
            // From here it converts back to long and checks if the original number is 
            // a multiple of this concatinated one.
            long newNumber = Long.parseLong(concatinatedNum);
            if (number % newNumber == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    // Method that checks if the number is even or odd 
    public static boolean evenNumber(long number) {
        return number % 2 == 0;
    }

    public static boolean spyNumber(long number) {


        return false;
    }

    // Method for running the program if only one number has been entered
    public static void oneNumber(long number) {
        // If number is natural it checks all properties of number through the different methods 
        boolean fuzzyNumber = fuzzNumber(number);
        boolean duckNumber = duckNumber(number);
        boolean palindrome = palindrome(number);
        boolean isNumberEven = evenNumber(number);
        boolean gapfulNumber = gapfulNumber(number);
        boolean spyNumber = spyNumber(number);
        System.out.println("Properties of " + number);
        System.out.println("    buzz: " + fuzzyNumber);
        System.out.println("    duck: " + duckNumber);
        System.out.println("    palindromic: " + palindrome);
        System.out.println("    gapful: " + gapfulNumber);
        System.out.println("    spy: " + spyNumber);
        System.out.println("    even: " + isNumberEven);
        System.out.println("    odd: " + !isNumberEven + "\n");  
    }

    public static void twoNumbers(long number1, long number2) {
        // Using a for loop to go through each of the numbers from the first number 
        // pluss the second number to output their properties 
        for (int i = 0; i < (int)number2; i++) {
            boolean fuzzyNumber = fuzzNumber(number1);
            boolean duckNumber = duckNumber(number1);
            boolean palindrome = palindrome(number1);
            boolean isNumberEven = evenNumber(number1);
            boolean gapfulNumber = gapfulNumber(number1);
            boolean spyNumber = spyNumber(number1);
            // Output of whether it is an even or odd number
            String evenNumber = (isNumberEven ? "even" : "odd");
            // Outputting values in the format that is expected 
            System.out.println(number1 + " is " + (fuzzyNumber ? "buzz, " : "") + (duckNumber ? "duck, " : "") 
            + (palindrome ? "palindromic, " : "") + (gapfulNumber ? "gapful, " : "") + (spyNumber ? "gapful, " : "") 
            + evenNumber);
            number1++;
        }
    }

    // Introduction method that greets the user
    public static void introduction() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameters show how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for; ");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        boolean runProgram = true;
        // Showing introduction to user 
        introduction();
        
        // Keeps running until the user enters 0 to exit the number
        while (runProgram) {
            System.out.print("Enter a request: > ");
            // Takes the input in the form of a string, so that this can be split into an array
            String number = sc.nextLine();
            // Creates string array for numbers, if we receive one or two
            String [] numbers = number.split(" ");
            System.out.println();
            // Create a switch that checks the length of the string array numbers created above.
            switch (numbers.length) {
                // If there is a single number, this case is run
                case 1:
                // Creates a try/catch sequence, where if the value cannot be converted to a number
                // it will output an error message 
                try {
                    if (Long.parseLong(number) == 0) {
                        System.out.println("Goodbye");
                        System.out.println();
                        System.out.println("Process finished with exit code 0");
                        runProgram = false; 
                    } else if (Long.parseLong(number) < 0) {
                        System.out.println("The first parameter should be a natural number or zero.\n");
                    } else {
                        oneNumber(Long.parseLong(number));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("The first parameter should be a natural number or zero.\n");
                }
                break;

                case 2:
                // Similar try/catch sequences as above. Checks if the two numbers in the array are 
                // numbers. Runs the twoNumbers methods if this is the case. If the first numbers is 
                // 0 then the program exits. If the first numbers is below zero, it returns an error,
                // and this also occurs when we enter a 
                try {
                    if (Long.parseLong(numbers[0]) == 0) {
                        System.out.println("Goodbye");
                        System.out.println();
                        System.out.println("Process finished with exit code 0");
                    } else if (Long.parseLong(numbers[0]) < 0) {
                        System.out.println("The first parameter should be a natural number or zero.\n");
                    } else if (Long.parseLong(numbers[1]) < 1) {
                        System.out.println("The second parameter should be a natural number.\n");
                    } else {
                        twoNumbers(Long.parseLong(numbers[0]),Long.parseLong(numbers[1]));
                        System.out.println();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("The parameters should be a natural number.\n");
                }
                break;

                // Same try/catch as above, however, this time it also checks whether the parameter is correct
                case 3:
                try {

                } catch (NumberFormatException e) {
                    System.out.println("Hello");
                }
                break;
                default:
                    System.out.println("Only enter a single number or two numbers seperated by a space\n");
            }
        }
    }   
    public static void main(String[] args) {
        run();
    }
}



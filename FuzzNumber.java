import java.util.Scanner;

public class FuzzNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number");
        int number = sc.nextInt();
        boolean multipleOfSeven = false;
        boolean lastNumberSeven = false;
        boolean isNumberEven = false;

        if (number < 2) {
            System.out.println("This is not a natural number");
        }
        else {
            int lastDigit = number % 10;
            int firstDigits = number / 10;
            if(lastDigit == 7) {
                lastNumberSeven = true;
            }
            if((firstDigits - (lastDigit*2)) % 7 == 0) {
                multipleOfSeven = true;
            }
            if(number % 2 == 0) {
                isNumberEven = true;
            }

            if(isNumberEven) {
                System.out.println("This number is Even");
            }
            else {
                System.out.println("This number is Odd");
            }

            if(multipleOfSeven || lastNumberSeven){
                System.out.println("This is a Buzz number");
                System.out.println("Explanation:");
                if(multipleOfSeven && !lastNumberSeven) System.out.println(number + " is divisible by 7");
                if(!multipleOfSeven && lastNumberSeven) System.out.println(number + " ends with 7");
                if(multipleOfSeven && lastNumberSeven) System.out.println(number + " is divisible by 7 and ends with 7");

            }
            else{
                System.out.println("This is not a buzz number");
                System.out.println("Explanation:");
                System.out.println(number + " is neither divisible by 7 nor does it end with 7");
            }

        }


    }

}

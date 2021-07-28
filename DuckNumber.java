import java.util.Scanner;

public class DuckNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number");
        int number = sc.nextInt();
        int lastDigit = number%10;
        boolean buzzWord = false;
        boolean duckWord = false;
        boolean isNumberEven = false;

        if(number < 1){
            System.out.println("This number is not natural!");
        }
        else{
            if(lastDigit == 7 || number%7 == 0){
                buzzWord = true;
            }
            if(number % 2 == 0){
                isNumberEven = true;
            }
            int temp = number;
            while (temp > 9){
                int rem = temp%10;
                if(rem == 0){
                    duckWord = true;
                }
                temp = temp/10;
            }
            System.out.println("Properties of " + number);
            System.out.println("even: " + (isNumberEven ? "true" : "false"));
            System.out.println("odd: " + (!isNumberEven ? "true" : "false"));
            System.out.println("buzz: " + (buzzWord ? "true" : "false"));
            System.out.println("duck: " + (duckWord ? "true" : "false"));
        }


    }

}


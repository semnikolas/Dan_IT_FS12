package java_core_hw_3;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {

        int lowerLimit = -1;
        int upperLimit = 101;
        int secretNumber = (int) (Math.random() * 101);
        int[] userEnteredNumbers = new int[1];
        int attempt = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name, please:");
        String name = scan.nextLine();
        System.out.println("Let the game begin!");

        while (true) {
            System.out.println("Please, enter the number:");
            String someValue = scan.nextLine();

            try {
                int variant = Integer.parseInt(someValue);
                userEnteredNumbers[attempt] = variant;
                int[] tempResults = new int[userEnteredNumbers.length];

                System.arraycopy(userEnteredNumbers, 0, tempResults, 0, tempResults.length);

                if (variant == secretNumber) {
                    System.out.println("Congratulations," + name);
                    System.out.println("All numbers you have entered:");
                    for (int i = 0; i < userEnteredNumbers.length; i++) {
                        System.out.print(userEnteredNumbers[i] + ", ");
                    }
                    break;
                } else if (lowerLimit < variant && variant < secretNumber) {
                    System.out.println("Your number too small. Please try again.");
                    ++attempt;
                } else if (upperLimit > variant && variant > secretNumber) {
                    System.out.println("Your number too big. Please try again.");
                    ++attempt;
                } else {
                    System.out.println("Your number is out of range. Please try again.");
                }

                userEnteredNumbers = new int[tempResults.length + 1];
                System.arraycopy(tempResults, 0, userEnteredNumbers, 0, userEnteredNumbers.length - 1);
            } catch (NumberFormatException e) {
                System.out.println("You enter some string!!!");
            }
        }
    }
}

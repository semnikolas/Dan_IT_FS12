package java_core_hw_3;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        int cycle = 0;
        int pitofhell = -1;
        int heaven = 101;
        int random = (int) (Math.random() * 101);
        int[] results = new int[1];
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
                results[attempt] = variant;
                int[] tempResults = new int[results.length];

                System.arraycopy(results, 0, tempResults, 0, tempResults.length);

                if (variant == random) {
                    System.out.println("Congratulations," + name);
                    System.out.println("All numbers you have entered:");
                    for (int i = 0; i < results.length; i++) {
                        System.out.print(results[i] + ", ");
                    }
                    break;
                } else if (pitofhell < variant && variant < random) {
                    System.out.println("Your number too small. Please try again.");
                    ++attempt;
                } else if (heaven > variant && variant > random) {
                    System.out.println("Your number too big. Please try again.");
                    ++attempt;
                } else {
                    System.out.println("Your number is out of range. Please try again.");
                }

                results = new int[tempResults.length + 1];
                System.arraycopy(tempResults, 0, results, 0, results.length - 1);
            } catch (NumberFormatException e) {
                System.out.println("You enter some string!!!");
            }
        }
    }
}

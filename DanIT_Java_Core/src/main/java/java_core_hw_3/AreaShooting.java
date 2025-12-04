package java_core_hw_3;

import java.util.Objects;
import java.util.Scanner;

public class AreaShooting {
    public static void main(String[] args) {

        int lowerLimit = 0;
        int upperLimit = 4;
        int userShotLine;
        int userShotColumn;
        Scanner scan = new Scanner(System.in);
        int secretShotLine = shotRandom();
        int secretShotColumn = shotRandom();
        String[][] shotField = {{"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}};

        System.out.println("All Set. Get ready to rumble!");
        showField(shotField);

        while (true) {
            while (true) {
                System.out.println("Please, enter the line number (0-4):");
                String someValue = scan.nextLine();
                try {
                    int lineNumber = Integer.parseInt(someValue);

                    if (lowerLimit > lineNumber || lineNumber > upperLimit) {
                        System.out.println("Your number is out of range. Please try again.");
                    } else {
                        userShotLine = lineNumber;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You enter some string!!! Try again");
                }
            }
            while (true) {
                System.out.println("Please, enter the column number (0-4):");
                String someValue = scan.nextLine();
                try {
                    int columnNumber = Integer.parseInt(someValue);

                    if (lowerLimit > columnNumber || columnNumber > upperLimit) {
                        System.out.println("Your number is out of range. Please try again.");
                    } else {
                        userShotColumn = columnNumber;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You enter some string!!!");
                }
            }

            if (Objects.equals(userShotLine, secretShotLine) && Objects.equals(userShotColumn, secretShotColumn)) {
                shotField[userShotLine][userShotColumn] = "X";
                showField(shotField);
                System.out.println("You have won!");
                break;
            } else {
                shotField[userShotLine][userShotColumn] = "*";
                showField(shotField);
                System.out.println("You have missed! Please try again!");
            }
        }
    }

    public static int shotRandom() {
        return (int) (Math.random() * 4) + 1;
    }

    public static void showField(String[][] name) {
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < name[i].length; j++) {
                System.out.print(" " + name[i][j] + " ");
            }
            System.out.println();
        }
    }

}

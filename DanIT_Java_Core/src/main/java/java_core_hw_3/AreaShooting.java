package java_core_hw_3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class AreaShooting {
    public static void main(String[] args) {
        int[] check = new int[2];
        int[] shot = new int[2];
        int pitofhell = 0;
        int heaven = 4;
        int shotLine = 0;
        int shotColumn = 0;
        Scanner scan = new Scanner(System.in);
        String[][] secretField = {{"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}};
        String[][] shotField = {{"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}};
        secretField[shotRandom()][shotRandom()] = "*";
        check = index(secretField);

        System.out.println("All Set. Get ready to rumble!");
        showField(shotField);

        while (true) {
            while (true) {
                System.out.println("Please, enter the line number (0-4):");
                String someValue = scan.nextLine();
                try {
                    int lineNumber = Integer.parseInt(someValue);

                    if (pitofhell > lineNumber || lineNumber > heaven) {
                        System.out.println("Your number is out of range. Please try again.");
                    } else {
                        shotLine = lineNumber;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You enter some string!!!");
                }
            }
            while (true) {
                System.out.println("Please, enter the column number (0-4):");
                String someValue = scan.nextLine();
                try {
                    int columnNumber = Integer.parseInt(someValue);

                    if (pitofhell > columnNumber || columnNumber > heaven) {
                        System.out.println("Your number is out of range. Please try again.");
                    } else {
                        shotColumn = columnNumber;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You enter some string!!!");
                }
            }
            shot[0] = shotLine;
            shot[1] = shotColumn;
            System.out.println(Arrays.toString(shot));
            if (Arrays.equals(shot, check)) {
                shotField[shotLine][shotColumn] = "X";
                showField(shotField);
                System.out.println("You have won!");
                break;
            } else {
                shotField[shotLine][shotColumn] = "*";
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

    public static int[] index(String[][] name) {
        int line = 0;
        int column = 0;
        int[] shotPossition = new int[2];
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < name[i].length; j++) {
                if (Objects.equals(name[i][j], "*")) {
                    line = i;
                    column = j;
                }
            }
        }
        shotPossition[0] = line;
        shotPossition[1] = column;
        return shotPossition;
    }
}

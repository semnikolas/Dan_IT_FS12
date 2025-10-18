package java_core_hw_3;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class AreaShootingLine {
    public static void main(String[] args) {
        int[] check = new int[2];
        int[] shot = new int[2];
        int pitofhell = 0;
        int heaven = 4;
        int shotLine = 0;
        int shotColumn = 0;
        int wounded = 0;
        Scanner scan = new Scanner(System.in);
        String[][] secretField = {{".", ".", ".", ".", "."}, {".", ".", ".", ".", "."}, {".", ".", ".", ".", "."}, {".", ".", ".", ".", "."}, {".", ".", ".", ".", "."}};
        String[][] shotField = {{"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}, {"o", "o", "o", "o", "o"}};
        secretField[shotRandom()][shotRandom()] = "*";
        check = index(secretField);
        int firstCondition = check[0] % 2;
        int secondCondition = (check[0] + check[1]) % 2;
        if (firstCondition == 0 || secondCondition != 0) {
            if (check[1] == 0) {
                secretField[check[0]][1] = "*";
                secretField[check[0]][2] = "*";
            } else if (check[1] == 4) {
                secretField[check[0]][2] = "*";
                secretField[check[0]][3] = "*";
            } else {
                secretField[check[0]][check[1] + 1] = "*";
                secretField[check[0]][check[1] - 1] = "*";
            }
        } else {
            if (check[0] == 0) {
                secretField[1][check[1]] = "*";
                secretField[2][check[1]] = "*";
            } else if (check[1] == 4) {
                secretField[2][check[1]] = "*";
                secretField[3][check[1]] = "*";
            } else {
                secretField[check[0] + 1][check[1]] = "*";
                secretField[check[0] - 1][check[1]] = "*";
            }
        }

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
                        shot[0] = shotLine;
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
                        shot[1] = shotColumn;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You enter some string!!!");
                }
            }

            System.out.println(Arrays.toString(shot));
            shotField[shotLine][shotColumn] = "*";
            String secret = secretField[shotLine][shotColumn];
            String userShot = shotField[shotLine][shotColumn];
            if (Objects.equals(secret, userShot)) {
                System.out.println("Wounded!");
                shotField[shotLine][shotColumn] = "X";
                showField(shotField);
                ++wounded;
            } else {
                shotField[shotLine][shotColumn] = "*";
                showField(shotField);
                System.out.println("You have missed! Please try again!");
            }
            if (wounded == 3) {
                System.out.println("You have won!");
                break;
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

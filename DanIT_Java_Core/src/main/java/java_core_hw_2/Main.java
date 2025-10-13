package java_core_hw_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Оберіть напій з переліку запропонованих (натисніть порядковий номер:");
        System.out.println("1. Алкогольні напої");
        System.out.println("2. Холодні безалкогольні напої");
        System.out.println("3. Горячі безалкогольні напої");

        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        if (choice == 1) {
            System.out.println("Введіть свій вік:");
            int age = scan.nextInt();
            if (age < 18) {
                System.out.println("Ви недостатньо дорослі щоб купувати алкоголь");
            } else {
                System.out.println("Оберіть напій з переліку запропонованих (натисніть порядковий номер:");
                System.out.println("1. Пиво");
                System.out.println("2. Водка");
                System.out.println("3. Джин");
                int alcoholChoice = scan.nextInt();
                switch (alcoholChoice) {
                    case 1:
                        System.out.println("Вартість напою 50 грн");
                        break;
                    case 2:
                        System.out.println("Вартість напою 70 грн");
                        break;
                    case 3:
                        System.out.println("Вартість напою 100 грн");
                        break;
                    default:
                        System.out.println("Недійсний вибір. Програму буде завершено");
                }
            }
        } else if (choice == 2) {
            System.out.println("Оберіть напій з переліку запропонованих (натисніть порядковий номер:");
            System.out.println("1. Лимонад");
            System.out.println("2. Морс");
            System.out.println("3. Квас");
            int lemonadeChoice = scan.nextInt();
            switch (lemonadeChoice) {
                case 1:
                    System.out.println("Вартість напою 50 грн");
                    break;
                case 2:
                    System.out.println("Вартість напою 30 грн");
                    break;
                case 3:
                    System.out.println("Вартість напою 35 грн");
                    break;
                default:
                    System.out.println("Недійсний вибір. Програму буде завершено");
            }

        } else {
            System.out.println("Нажаль наразі відсутні горячі напої");
        }
    }
}

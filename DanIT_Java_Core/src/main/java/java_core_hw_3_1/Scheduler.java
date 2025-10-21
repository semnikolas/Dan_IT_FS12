package java_core_hw_4;

import java.util.Objects;
import java.util.Scanner;

public class Scheduler {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String subChoice = new String();
        String dayTitle = new String();
        String dayTask = new String();
        String[][] weekTasks = {{"Sunday", "Task#1"}, {"Monday", "Task#2"}, {"Tuesday", "Task#3"}, {"Wednesday", "Task#4"}, {"Thursday", "Task#5"}, {"Friday", "Task#6"}, {"Saturday", "Task#7"}};

        System.out.println("Welcome to your personal weekly scheduler!");
        System.out.println("Please, chose an option:");
        System.out.println("    1. Show list");
        System.out.println("    2. Show day");
        System.out.println("    3. Change day schedule");
        System.out.println("    4. Help menu");
        System.out.println("    5. Exit");

        while (true) {
            System.out.println();
            System.out.println("Enter the command:");
            System.out.println();
            String choice = (String) scan.nextLine().toLowerCase().trim();
            if (Objects.equals(choice, "1")) {
                choice = "show list";
            } else if (Objects.equals(choice, "2")) {
                choice = "show day";
            } else if (Objects.equals(choice, "3")) {
                choice = "change";
            } else if (Objects.equals(choice, "4")) {
                choice = "help";
            } else if (Objects.equals(choice, "5")) {
                choice = "exit";
            } else if (Objects.equals(choice, "show")) {
                System.out.println("Chose operator:");
                System.out.println("                day");
                System.out.println("                list");
                subChoice = (String) scan.nextLine().toLowerCase().trim();
                if (Objects.equals(subChoice, "list")) {
                    choice = "show list";
                } else if (Objects.equals(subChoice, "day")) {
                    choice = "show day";
                }
            }

            switch (choice) {
                case "show list":
                    showScheduler(weekTasks);
                    break;
                case "show day":
                    System.out.println("Enter day title:");
                    dayTitle = (String) scan.nextLine().toLowerCase().trim();
                    if (Objects.equals(dayTitle, "sunday")) {
                        showDayTask(weekTasks, "Sunday");
                    } else if (Objects.equals(dayTitle, "monday")) {
                        showDayTask(weekTasks, "Monday");
                    } else if (Objects.equals(dayTitle, "tuesday")) {
                        showDayTask(weekTasks, "Tuesday");
                    } else if (Objects.equals(dayTitle, "wednesday")) {
                        showDayTask(weekTasks, "Wednesday");
                    } else if (Objects.equals(dayTitle, "thursday")) {
                        showDayTask(weekTasks, "Thursday");
                    } else if (Objects.equals(dayTitle, "friday")) {
                        showDayTask(weekTasks, "Friday");
                    } else if (Objects.equals(dayTitle, "saturday")) {
                        showDayTask(weekTasks, "Saturday");
                    }
                    break;
                case "change":
                    System.out.println("Enter day title:");
                    dayTitle = (String) scan.nextLine().toLowerCase().trim();
                    System.out.println("Enter task:");
                    dayTask = (String) scan.nextLine().toLowerCase().trim();
                    if (Objects.equals(dayTitle, "sunday")) {
                        changeDayTask(weekTasks, "Sunday", dayTask);
                    } else if (Objects.equals(dayTitle, "monday")) {
                        changeDayTask(weekTasks, "Monday", dayTask);
                    } else if (Objects.equals(dayTitle, "tuesday")) {
                        changeDayTask(weekTasks, "Tuesday", dayTask);
                    } else if (Objects.equals(dayTitle, "wednesday")) {
                        changeDayTask(weekTasks, "Wednesday", dayTask);
                    } else if (Objects.equals(dayTitle, "thursday")) {
                        changeDayTask(weekTasks, "Thursday", dayTask);
                    } else if (Objects.equals(dayTitle, "friday")) {
                        changeDayTask(weekTasks, "Friday", dayTask);
                    } else if (Objects.equals(dayTitle, "saturday")) {
                        changeDayTask(weekTasks, "Saturday", dayTask);
                    }
                    break;
                case "help":
                    System.out.println("The list of operators:");
                    System.out.println("show - show current list of tasks or day task");
                    System.out.println("       usage - show list");
                    System.out.println("               show day");
                    System.out.println("change - allows you to change day task");
                    System.out.println("       usage - change [day of week]");
                    System.out.println("exit - exit the program");
                    System.out.println("help - show help menu");
                    System.out.println("menu - show menu");
                    break;
                case "exit":
                    System.out.println("Exiting.... See you...");
                    System.exit(0);
                case "menu":
                    System.out.println("Please, chose an option:");
                    System.out.println("    1. Show list");
                    System.out.println("    2. Show day");
                    System.out.println("    3. Change day schedule");
                    System.out.println("    4. Help menu");
                    System.out.println("    5. Exit");
                    break;
                default:
                    System.out.println("No such command!");
                    break;
            }
        }
    }

    public static void showScheduler(String[][] name) {
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < name[i].length; j++) {
                System.out.print(name[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void showDayTask(String[][] name, String value) {
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < name[i].length; j++) {
                if (Objects.equals(name[i][j], value)) {
                    System.out.print(name[i][j] + " " + name[i][++j]);
                    return;
                }
            }
        }
    }

    public static void changeDayTask(String[][] name, String value, String task) {
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < name[i].length; j++) {
                if (Objects.equals(name[i][j], value)) {
                    name[i][++j] = task;
                    return;
                }
            }
        }
    }
}

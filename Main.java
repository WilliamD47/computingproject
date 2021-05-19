package net.williamd47.computingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String username = "username";
        String password = "password";

        Boolean IsAddDone = false;
        Boolean IsListDone = false;

        List<Integer> score1only = new ArrayList<>();
        List<Integer> score2only = new ArrayList<>();
        List<Integer> score3only = new ArrayList<>();

        List<String> students = new ArrayList<>();
        List<String> averages = new ArrayList<>();

        Integer MaxScore1 = 0;
        Integer MaxScore2 = 0;
        Integer MaxScore3 = 0;

        System.out.println("Please enter a username: \n");
        String enteredusername = input.next();
        System.out.print("Please enter a password: \n");
        String enteredpass = input.next();
        if (enteredpass.equals(password) & enteredusername.equals(username)) {
            System.out.println("Correct username and password\n");
        } else {
            System.out.println("Incorrect username and password. Please run the program again");
            System.exit(0);
        }
        while (true) {
            System.out.println("Please enter either Add, List or Done: \n");
            String choice = input.next();
            if (choice.equals("Add")) {
                IsAddDone = true;
                System.out.println("Please enter the Student's name: \n");
                String name = input.next();
                System.out.println("Please enter the Student's first score \n");
                int score1 = input.nextInt();
                if (MaxScore1 == 0) {
                    System.out.println("Please enter the max score for this subject: \n");
                    MaxScore1 = input.nextInt();
                }
                System.out.println("Please enter the Student's second score \n");
                int score2 = input.nextInt();
                if (MaxScore2 == 0) {
                    System.out.println("Please enter the max score for this subject: \n");
                    MaxScore2 = input.nextInt();
                }
                System.out.println("Please enter the Student's third score \n");
                int score3 = input.nextInt();
                if (MaxScore3 == 0) {
                    System.out.println("Please enter the max score for this subject: \n");
                    MaxScore3 = input.nextInt();
                }
                String message = name + "'s first score was " + Integer.toString(score1) + " out of " + Integer.toString(MaxScore1) + ". Their second score was" + Integer.toString(score2) + " out of " + Integer.toString(MaxScore2) + ". Their third score was " + Integer.toString(score3) + " out of " + Integer.toString(MaxScore3) + ".";
                students.add(message);
                score1only.add(score1);
                score2only.add(score2);
                score3only.add(score3);


            } else if (choice.equalsIgnoreCase("List")) {
                if (IsAddDone) {
                    IsListDone = true;

                    System.out.println("Student scores: \n");
                    for (String item : students) {
                        System.out.println(item);
                    }

                    System.out.println("Averages: \n");

                    Integer average1 = score1only.stream().mapToInt(Integer::intValue).sum();
                    Integer average2 = score2only.stream().mapToInt(Integer::intValue).sum();
                    Integer average3 = score3only.stream().mapToInt(Integer::intValue).sum();

                    averages.add("For score 1: " + average1);
                    averages.add("For score 2: " + average2);
                    averages.add("For score 3: " + average3);

                    for (String average : averages) {
                        System.out.println(average);
                    }

                } else {

                    System.out.println("You have not added a student yet!");

                }


            } else if (choice.equalsIgnoreCase("Done")) {
                if (IsListDone) {
                    System.out.println("Bye! 👋");
                    System.exit(0);
                } else {
                    System.out.println("Are you sure you want to exit without viewing the students?");
                    String choice2 = input.next();
                    if (choice2.equalsIgnoreCase("Yes")) {
                        System.out.println("Bye! 👋");
                        System.exit(0);
                    } else {
                        ;
                    }
                }
            }

        }

    }
}

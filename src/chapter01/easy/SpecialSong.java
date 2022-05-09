package chapter01.easy;

import java.util.Scanner;

public class SpecialSong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String song = "Happy birthday to you Happy birthday to you Happy birthday to Rujia Happy birthday to you";
        String[] letters = song.split(" ");
        int totalPeople = Integer.parseInt(scanner.nextLine());
        String[] people = new String[totalPeople];
        for (int i = 0; i < totalPeople; i++) {
            people[i] = scanner.nextLine();
        }
        int round = (totalPeople % 16) > 0 ? (totalPeople / 16) + 1 : totalPeople / 16;
        int totalTurn = 16 * round;
        for (int i = 0; i < totalTurn; i++) {
            System.out.println(people[i % totalPeople] + ": " + letters[i]);
        }
    }
}

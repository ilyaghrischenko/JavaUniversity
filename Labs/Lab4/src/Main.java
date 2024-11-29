import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1
        /*String[] dates = {
                "29/02/2000", "30/04/2003", "01/01/2003",
                "29/02/2001", "30-04-2003", "1/1/1899",
                "31/04/2020", "31/06/2020", "00/01/2020"
        };

        String datePattern = "^(?:(?:31/(?:0?[13578]|1[02]))|(?:(?:29|30)/(?:0?[1,3-9]|1[0-2]))|(?:0?[1-9]|1\\d|2[0-8])/(?:0?[1-9]|1[0-2]))/(?:1[6-9]|[2-9]\\d)\\d{2}$|^29/02/(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:1600|2000|2400|2800|3200|3600|4000|4400|4800|5200|5600|6000|6400|6800|7200|7600|8000|8400|8800|9200|9600))$";

        Pattern pattern = Pattern.compile(datePattern);

        for (String date : dates) {
            if (pattern.matcher(date).matches()) {
                System.out.println(date + " is a valid date.");
            } else {
                System.out.println(date + " is not a valid date.");
            }
        }*/

        //2
        /*Scanner scanner = new Scanner(System.in);
        String inputText = "";

        System.out.println("Виберіть спосіб введення тексту:");
        System.out.println("1. З клавіатури");
        System.out.println("2. З файлу");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Введіть речення:");
            inputText = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Введіть ім'я файлу:");
            String filename = scanner.nextLine();
            try {
                inputText = readFile(filename);
            } catch (IOException e) {
                System.out.println("Помилка при читанні файлу: " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Невірний вибір.");
            return;
        }

        double percentage = calculatePercentageOfLetterA(inputText);
        System.out.printf("Відсоток літер 'а' у реченні: %.2f%%\n", percentage);*/

        //3
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        System.out.println("Виберіть спосіб введення рядків:");
        System.out.println("1. З клавіатури");
        System.out.println("2. З файлу");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Введіть рядки (для завершення введення введіть порожній рядок):");
            String line;
            while (!(line = scanner.nextLine()).isEmpty()) {
                strings.add(line);
            }
        } else if (choice == 2) {
            System.out.println("Введіть ім'я файлу:");
            String filename = scanner.nextLine();
            try {
                strings = readFile(filename);
            } catch (IOException e) {
                System.out.println("Помилка при читанні файлу: " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Невірний вибір.");
            return;
        }

        if (strings.isEmpty()) {
            System.out.println("Рядки не введено.");
            return;
        }

        int minLength = findMinLength(strings);
        List<String> shortenedStrings = shortenStrings(strings, minLength);

        System.out.println("Оброблені рядки:");
        for (String str : shortenedStrings) {
            System.out.println(str);
        }
    }

        //2
    /*private static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static double calculatePercentageOfLetterA(String text) {
        int totalLetters = 0;
        int countA = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                totalLetters++;
                if (Character.toLowerCase(c) == 'a' || Character.toLowerCase(c) == 'а') {
                    countA++;
                }
            }
        }

        if (totalLetters == 0) {
            return 0.0;
        }
        return (double) countA / totalLetters * 100;
    }*/

        //3
    private static List<String> readFile(String filename) throws IOException {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }
        }
        return strings;
    }

    private static int findMinLength(List<String> strings) {
        int minLength = Integer.MAX_VALUE;
        for (String str : strings) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        return minLength;
    }

    private static List<String> shortenStrings(List<String> strings, int minLength) {
        List<String> shortenedStrings = new ArrayList<>();
        for (String str : strings) {
            if (str.length() > minLength) {
                shortenedStrings.add(str.substring(0, minLength));
            } else {
                shortenedStrings.add(str);
            }
        }
        return shortenedStrings;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1
        /*Scanner scanner = new Scanner(System.in);
        int[] array = new int[0];
        int N;

        System.out.println("Виберіть спосіб введення даних:");
        System.out.println("1. З клавіатури");
        System.out.println("2. З файлу");
        System.out.println("3. Випадкові числа");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Введіть розмір масиву:");
                N = scanner.nextInt();
                array = new int[N];
                System.out.println("Введіть елементи масиву:");
                for (int i = 0; i < N; i++) {
                    array[i] = scanner.nextInt();
                }
                break;
            case 2:
                System.out.println("Введіть ім'я файлу:");
                String filename = scanner.next();
                try {
                    Scanner fileScanner = new Scanner(new File(filename));
                    N = fileScanner.nextInt();
                    array = new int[N];
                    for (int i = 0; i < N; i++) {
                        if (fileScanner.hasNextInt()) {
                            array[i] = fileScanner.nextInt();
                        } else {
                            System.out.println("Помилка: файл не містить достатньо чисел.");
                            return;
                        }
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не знайдено.");
                    return;
                }
                break;
            case 3:
                System.out.println("Введіть розмір масиву:");
                N = scanner.nextInt();
                array = new int[N];
                Random random = new Random();
                for (int i = 0; i < N; i++) {
                    array[i] = random.nextInt(200) - 100;
                }
                System.out.println("Згенерований масив: " + Arrays.toString(array));
                break;
            default:
                System.out.println("Неправильний вибір.");
                return;
        }

        processArray(array);*/

        //2
        /*int[][] matrixA = new int[10][10];
        int[][] matrixB = new int[10][10];

        try {
            readMatrixFromFile("matrixA.txt", matrixA);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
            return;
        }

        double ratio = calculatePositiveNegativeRatio(matrixA);
        System.out.printf("Відношення кількості додатних елементів до кількості від’ємних: %.2f%n", ratio);

        createSymmetricMatrix(matrixA, matrixB);

        try {
            writeMatrixToFile("matrixB.txt", matrixB);
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }*/

        //3
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть елементи універсальної множини U, розділені пробілами:");
        Set<Integer> setU = readSet(scanner);

        System.out.println("Введіть елементи множини X, розділені пробілами:");
        Set<Integer> setX = readSet(scanner);

        System.out.println("Введіть елементи множини Y, розділені пробілами:");
        Set<Integer> setY = readSet(scanner);

        if (!setU.containsAll(setX) || !setU.containsAll(setY)) {
            System.out.println("Некоректне введення: елементи X і Y повинні бути підмножинами U.");
            return;
        }

        Set<Integer> unionXY = new HashSet<>(setX);
        unionXY.addAll(setY);
        System.out.println("Об'єднання множин X і Y: " + unionXY);

        Set<Integer> intersectionXY = new HashSet<>(setX);
        intersectionXY.retainAll(setY);
        System.out.println("Перетин множин X і Y: " + intersectionXY);

        Set<Integer> differenceXY = new HashSet<>(setX);
        differenceXY.removeAll(setY);
        System.out.println("Різниця множин X і Y (X \\ Y): " + differenceXY);

        Set<Integer> differenceYX = new HashSet<>(setY);
        differenceYX.removeAll(setX);
        System.out.println("Різниця множин Y і X (Y \\ X): " + differenceYX);

        Set<Integer> complementX = new HashSet<>(setU);
        complementX.removeAll(setX);
        System.out.println("Доповнення множини X до U: " + complementX);

        Set<Integer> complementY = new HashSet<>(setU);
        complementY.removeAll(setY);
        System.out.println("Доповнення множини Y до U: " + complementY);

        List<String> cartesianProduct = new ArrayList<>();
        for (Integer x : setX) {
            for (Integer y : setY) {
                cartesianProduct.add("(" + x + ", " + y + ")");
            }
        }
        System.out.println("Прямий добуток множин X і Y: " + cartesianProduct);
    }

    //1
    /*public static void processArray(int[] array) {
        int maxPositiveIndex = -1;
        int maxPositiveValue = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] > maxPositiveValue) {
                maxPositiveValue = array[i];
                maxPositiveIndex = i;
            }
        }

        if (maxPositiveIndex == -1) {
            System.out.println("У масиві немає додатніх елементів.");
            return;
        }

        System.out.println("Найбільший додатній елемент: " + maxPositiveValue);

        int negativeCount = 0;
        for (int i = 0; i < maxPositiveIndex; i++) {
            if (array[i] < 0) {
                negativeCount++;
            }
        }

        System.out.println("Кількість від'ємних елементів перед найбільшим додатнім елементом: "
                + negativeCount);

        if (negativeCount == 0) {
            int[] subArray = Arrays.copyOfRange(array, maxPositiveIndex + 1, array.length);
            Arrays.sort(subArray);
            for (int i = 0; i < subArray.length / 2; i++) {
                int temp = subArray[i];
                subArray[i] = subArray[subArray.length - 1 - i];
                subArray[subArray.length - 1 - i] = temp;
            }
            System.arraycopy(subArray, 0, array, maxPositiveIndex + 1, subArray.length);
            System.out.println("Відсортований масив: " + Arrays.toString(array));
        }
    }*/

    //2
    /*public static void readMatrixFromFile(String filename, int[][] matrix) throws IOException, FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (fileScanner.hasNextInt()) {
                    matrix[i][j] = fileScanner.nextInt();
                } else {
                    throw new IOException("Неправильний формат даних у файлі.");
                }
            }
        }
        fileScanner.close();
    }

    public static double calculatePositiveNegativeRatio(int[][] matrix) {
        int positiveCount = 0;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element > 0) {
                    positiveCount++;
                } else if (element < 0) {
                    negativeCount++;
                }
            }
        }

        if (negativeCount == 0) {
            return positiveCount > 0 ? Double.POSITIVE_INFINITY : 0;
        }
        return (double) positiveCount / negativeCount;
    }

    public static void createSymmetricMatrix(int[][] matrixA, int[][] matrixB) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrixB[i][j] = matrixA[9 - i][j];
            }
        }
    }

    public static void writeMatrixToFile(String filename, int[][] matrix) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (int[] row : matrix) {
            for (int element : row) {
                writer.write(element + " ");
            }
            writer.newLine();
        }
        writer.close();
    }*/

    //3
    private static Set<Integer> readSet(Scanner scanner) {
        String line = scanner.nextLine();
        String[] tokens = line.split("\\s+");
        Set<Integer> set = new HashSet<>();
        for (String token : tokens) {
            try {
                set.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                System.out.println("Некоректний елемент: " + token);
            }
        }
        return set;
    }
}
import java.io.IOException;
import java.util.*;
import java.io.*;

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
                    ArrayDataHandler dataHandler = new ArrayDataHandler(array);
                    dataHandler.readFromFile(filename);
                    array = dataHandler.getArray();
                } catch (IOException e) {
                    System.out.println("Помилка при читанні файлу: " + e.getMessage());
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

        try {
            ArrayDataHandler dataHandler = new ArrayDataHandler(array);
            dataHandler.writeToFile("output.txt");
            System.out.println("Дані успішно записані у файл output.txt.");
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }*/

        //2
        List<Matrix> matrices = new ArrayList<>();

        try {
            readMatricesFromFile("matrices.txt", matrices);
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
            return;
        }

        Collections.sort(matrices);

        for (Matrix matrix : matrices) {
            System.out.println(matrix);
        }

        Matrix newMatrix = generateMatrix();
        matrices.add(newMatrix);

        try {
            writeMatricesToFile("matrices.txt", matrices);
            System.out.println("Дані успішно записані у файл matrices.txt.");
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    public static void readMatricesFromFile(String filename, List<Matrix> matrices) throws IOException {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                Matrix matrix = new Matrix();
                for (int i = 0; i < 10; i++) {
                    if (!fileScanner.hasNextLine()) {
                        throw new IOException("Неправильний формат даних у файлі.");
                    }
                    String line = fileScanner.nextLine();
                    String[] elements = line.split("\\s+");
                    if (elements.length != 10) {
                        throw new IOException("Неправильний формат даних у файлі.");
                    }
                    for (int j = 0; j < 10; j++) {
                        matrix.setElement(i, j, Integer.parseInt(elements[j]));
                    }
                }
                matrices.add(matrix);
            }
        }
    }

    //2
    public static void writeMatricesToFile(String filename, List<Matrix> matrices) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Matrix matrix : matrices) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        writer.write(matrix.getElement(i, j) + " ");
                    }
                    writer.newLine();
                }
            }
        }
    }

    public static Matrix generateMatrix() {
        Matrix matrix = new Matrix();
        return matrix;
    }
}

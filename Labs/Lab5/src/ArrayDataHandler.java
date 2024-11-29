import java.io.*;
import java.util.Scanner;

public class ArrayDataHandler implements DataHandler {
    private int[] array;

    public ArrayDataHandler(int[] array) {
        this.array = array;
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(array.length + "\n");
            for (int num : array) {
                writer.write(num + " ");
            }
        }
    }
    @Override
    public void readFromFile(String filename) throws IOException {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            int N = fileScanner.nextInt();
            array = new int[N];
            for (int i = 0; i < N; i++) {
                if (fileScanner.hasNextInt()) {
                    array[i] = fileScanner.nextInt();
                } else {
                    throw new IOException("Файл не містить достатньо чисел.");
                }
            }
        }
    }
    public int[] getArray() {
        return array;
    }
}

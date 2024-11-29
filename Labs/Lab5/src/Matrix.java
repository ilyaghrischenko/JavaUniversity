import java.util.ArrayList;
import java.util.List;

public class Matrix implements Comparable<Matrix> {
    private List<List<Integer>> matrix;

    public Matrix() {
        this.matrix = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                matrix.get(i).add(0);
            }
        }
    }

    public int getElement(int i, int j) {
        return matrix.get(i).get(j);
    }

    public void setElement(int i, int j, int element) {
        matrix.get(i).set(j, element);
    }

    @Override
    public int compareTo(Matrix other) {
        int sumThis = this.matrix.stream().flatMapToInt(row -> row.stream().mapToInt(Integer::intValue)).sum();
        int sumOther = other.matrix.stream().flatMapToInt(row -> row.stream().mapToInt(Integer::intValue)).sum();
        return Integer.compare(sumThis, sumOther);
    }
}

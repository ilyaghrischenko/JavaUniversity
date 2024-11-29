import java.io.IOException;

public interface DataHandler {
    void writeToFile(String filename) throws IOException;
    void readFromFile(String filename) throws IOException;
}

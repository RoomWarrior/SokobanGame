import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LevelsFromLocal {

    public int[][] nextLevel(String fileName) throws Exception {
        File file = new File(fileName);
        String contentFile = getContentFile(file);
        return convertStringIntoTwoDimensionalArray(contentFile);
    }

    private int[][] convertStringIntoTwoDimensionalArray(String line) {
        int row = 0;
        int n = line.length();
        for (int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if (symbol == '\n') {
                row = row + 1;
            }
        }

        int[][] array = new int[row][];
        int index = 0;
        int column = 0;
        for (int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if (symbol != '\n') {
                column = column + 1;
            } else {
                array[index] = new int[column];
                index = index + 1;
                column = 0;
            }
        }

        row = 0;
        column = 0;
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (symbol != '\n') {
                array[row][column] = Integer.parseInt("" + symbol);
                column = column + 1;
            } else {
                row = row + 1;
                column = 0;
            }
        }
        return array;
    }

    private String getContentFile(File file) throws Exception {
        try (FileInputStream in = new FileInputStream(file)) {
            int size = (int) file.length();
            char[] array = new char[size];
            int index = 0;
            int unicode;
            while ((unicode = in.read()) != -1) {
                char symbol = (char) unicode;
                if (('0' <= symbol && symbol <= '4') || symbol == '\n') {
                    array[index] = symbol;
                    index = index + 1;
                }
            }
            array[index++] = '\n';
            return new String(array, 0, index);
        } catch (FileNotFoundException fileNotFoundException) {
            throw new Exception("FileNotFoundException: " + fileNotFoundException);
        } catch (IOException ioException) {
            throw new Exception("IOException: " + ioException);
        }
    }
}

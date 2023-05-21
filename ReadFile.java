package Simulator;
/*
 * Contains the method for reading the values from a file
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    //exaple:
    //double[][] velocity = ReadFile.readFile("file.txt", "VELOCITY");

    public static void main(String[] args) {
        String filename = "Simulator/qq.txt";

        String valueName = "VELOCITY";

        double[][] velocity = readFile(filename, valueName);

        for (int i = 0; i < velocity.length; i++) {
            for (int j = 0; j < velocity[i].length; j++) {
                System.out.print(velocity[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] readFile(String filename, String valueName) {
        double[][] data = null;

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String record;

            //Searches for a specific word
            while ((record = br.readLine()) != null) {
                if (record.trim().equals(valueName)) {
                    data = readData(br);
                    break;
                }
            }

            br.close();
        } catch (IOException ex) {
            System.out.println("Error! Problem reading file " + filename);
            System.exit(0);
        }

        return data;
    }

    private static double[][] readData(BufferedReader br) throws IOException {
        String record;
        int numRows = 0;

        //Counts the number of rows until an empty line or end of file is encountered
        while ((record = br.readLine()) != null && !record.trim().isEmpty()) {
            numRows++;
        }

        br.close();
        br = new BufferedReader(new FileReader("Simulator/qq.txt"));

        double[][] data = new double[numRows][];

        for (int i = 0; i < numRows; i++) {
            record = br.readLine();
            String[] values = record.split("[{}, ]+");
            data[i] = new double[values.length - 1];

            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = Double.parseDouble(values[j + 1]);
            }
        }

        return data;
    }
}
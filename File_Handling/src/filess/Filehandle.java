package filess;

import java.io.*;

public class Filehandle {

    public static void main(String[] args) {
        String fileName = "handle.txt";

        // Writing to a file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("This is a text file!\n");
            writer.write("File Handling. \n");
        } catch (IOException e) {
            System.out.println("Error writing to the file.");
            e.printStackTrace();
        }

        // Reading from a file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Contents of " + fileName + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }

        // Appending to a file
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("Appending new data to the existing file.\n");
        } catch (IOException e) {
            System.out.println("Error appending to the file.");
            e.printStackTrace();
        }
        
     // Reading after appending
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nContents of " + fileName + " after appending:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file after appending.");
            e.printStackTrace();
        }
    }
}

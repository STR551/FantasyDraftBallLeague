

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Player {
  static int idCount = 0;

  int id;
  String name;

  public static void main(String[] args) {
  }

  public Player(){
    id = idCount;
    idCount += 1;

  }





public static String[][] nameList() {

        // Specify the path to the file
        String filePath = "namesList.txt"; // Change this to the actual file path

        // Create a File object
        File file = new File(filePath);

        // Check if the file exists
        if (file.exists()) {
            try {
                // Create FileReader and BufferedReader
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Read and iterate through each line
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                // Close the BufferedReader
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } else {
            System.out.println("File not found.");
        }
        return null;
}


}

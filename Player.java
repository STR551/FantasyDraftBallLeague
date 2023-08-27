import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Player {
  static int idCount = 0;
  static String[][] nameList = getNameList();
  static Random r = new Random();

  int id;
  String name;
  int age = 10;
  int[] skills = new int[2]; // off def 
  int[] potentials = new int[2];

  LinkedList<String> offPossesions = new LinkedList<String>();
  LinkedList<String> defPossesions = new LinkedList<String>();

  int offPlays = 0;
  int pointsScored = 0;
  int defPlays = 0;
  int defStops = 0;


  public static void main(String[] args) {
  }

  public Player(){
    id = idCount;
    idCount += 1;
    name = nameList[0][r.nextInt(nameList[0].length)]+" "+nameList[1][r.nextInt(nameList[0].length)];
    for (int i = 0; i < skills.length;i++){

      double n1 =  Math.pow(r.nextFloat(),5)*100;
      double n2 = Math.pow(r.nextFloat(),5)*100;

      if (n1 < n2){
        double temp = n1;
        n1 = n2;
        n2 = temp;
      }

      
      skills[i] = (int) ((n2*2/3+n1/3)*.75);
      potentials[i] = (int) (n2/3+n1*2/3);

      

    }

  }





public static String[][] getNameList() {

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

                String[][] retList = new String[2][397];
                int i = 0;
                
                // Read and iterate through each line
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] namesSplit = line.split(" ");
                    //System.out.println(line);
                    retList[0][i] = namesSplit[0];
                    retList[1][i] = namesSplit[1];
                    i+=1;
                }

                // Close the BufferedReader
                bufferedReader.close();
                return retList;
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } else {
            System.out.println("File not found.");
        }
        return null;
}

public String toString() {
  return id + " " + name + " " + (int) skills[0] + " " + (int) skills[1] + " "
   + pointsScored + " " + String.format("%.2f",(float)pointsScored/offPlays) + " "
   + defStops + " " + String.format("%.2f",1-(float)defStops/defPlays);
}

}


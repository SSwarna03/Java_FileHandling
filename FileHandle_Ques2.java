import java.io.*;


public class FileHandle_Ques2 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Please enter the file path: ");
            String fileDestination = br.readLine();
            File file = new File(fileDestination);
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                int characterTotalCount = 0;
                int chara;
                while ((chara = fr.read()) != -1) {
                    characterTotalCount++;
                }
                System.out.println("Total number of characters in file are: " + characterTotalCount);
                fr.close();
            } else {
                System.out.println("File does not exist at the specified location.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}


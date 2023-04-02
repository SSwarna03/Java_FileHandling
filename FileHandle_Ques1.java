import java.io.*;

public class FileHandle_Ques1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char choice;
        do {
            System.out.println("\nMenu based app - File Operations in Java\n");
            System.out.println("1. Create a new folder");
            System.out.println("2. Create a new text file");
            System.out.println("3. Write into a text file");
            System.out.println("4. Append data to a text file");
            System.out.println("5. Rename a file");
            System.out.println("6. Delete a File");
            System.out.print("\nPlease enter the Menu: ");
            try {
                int main = Integer.parseInt(br.readLine());
                switch (main) {
                    case 1:
                        createNewDataFolder(br);
                        break;
                    case 2:
                        createNewTextFile(br);
                        break;
                    case 3:
                        writeDataFileToTextFile(br);
                        break;
                    case 4:
                        appendDataFileToTextFile(br);
                        break;
                    case 5:
                        renameFile(br);
                        break;
                    case 6:
                        deleteFile(br);
                        break;
                    default:
                        System.out.println("Invalid menu option entered.");
                }
            } 
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu option.");
            } 
            catch (IOException e) {
                System.out.println("Error reading user input.");
            }
            System.out.print("\nPress 'Y' to go back to the Main File-Operations Menu: ");
            try {
                choice = br.readLine().toUpperCase().charAt(0);
            } 
            catch (IOException e) {
                choice = 'N';
            }
        } while (choice == 'Y');
    }

    public static void createNewDataFolder(BufferedReader br) {
        try {
            System.out.print("\nPlease enter the Folder-name to be Created: ");
            String folderName = br.readLine();
            System.out.print("Please enter the Path where you wish to save a new folder: ");
            String folderPath = br.readLine();
            File dir = new File(folderPath, folderName);
            if (dir.mkdir()) {
                System.out.println("\nFolder is created Successfully!");
            } else {
                System.out.println("\nFailed to create a new folder. Please try again.");
            }
        } 
        catch (IOException e) {
            System.out.println("\nError reading user input.");
        }
    }

    public static void createNewTextFile(BufferedReader br) {
        try {
            System.out.print("\nPlease enter the File-Name to be Created: ");
            String fileName = br.readLine();
            System.out.print("Please enter the Path where you wish to create a new file: ");
            String filePath = br.readLine();
            File file = new File(filePath, fileName + ".txt");
            if (file.createNewFile()) {
                System.out.println("\nText file is created Successfully!");
            } else {
                System.out.println("\nFailed to create a new text file. Please try again.");
            }
        } 
        catch (IOException e) {
            System.out.println("\nError reading user input.");
        }
    }

    public static void writeDataFileToTextFile(BufferedReader br) {
        try {
            System.out.print("\nPlease enter the path: ");
            String filePath = br.readLine();
            System.out.print("Please enter the File-Name: ");
            String fileName = br.readLine();
            System.out.print("Please enter the text to be written in the file: ");
            String fileContent = br.readLine();
            File file =new File(filePath, fileName);
	        if (file.exists()) {
	            FileWriter writer = new FileWriter(file);
	            writer.write(fileContent);
	            writer.close();
	            System.out.println("\nText is written to the file Successfully!");
 	        } 
	        else {
 	            System.out.println("\nThe specified file does not exist. Please try again.");
	        }
	    } 
	    catch (IOException e) {
	        System.out.println("\nError reading user input.");
	    }
    }
    public static void appendDataFileToTextFile(BufferedReader br) {
        try {
            System.out.print("\nPlease enter the path: ");
            String filePath = br.readLine();
            System.out.print("Please enter the File-Name: ");
            String fileName = br.readLine();
            System.out.print("Please enter the text to be appended to the file: ");
            String fileContent = br.readLine();
            File file = new File(filePath, fileName);
            if (file.exists()) {
                FileWriter writer = new FileWriter(file, true);
                writer.write(fileContent);
                writer.close();
                System.out.println("\nText is appended to the file Successfully!");
            } else {
                System.out.println("\nThe specified file does not exist. Please try again.");
            }
        } 
        catch (IOException e) {
            System.out.println("\nError reading user input.");
        }
    }

    public static void renameFile(BufferedReader br) {
        try {
            System.out.print("\nPlease enter the path: ");
            String filePath = br.readLine();
            System.out.print("Please enter the File-Name: ");
            String oldFileName = br.readLine();
            System.out.print("Please enter new File-Name: ");
            String newFileName = br.readLine();
            File oldFile = new File(filePath, oldFileName);
            File newFile = new File(filePath, newFileName);
            if (oldFile.exists()) {
                if (oldFile.renameTo(newFile)) {
                    System.out.println("\nFile is renamed Successfully!");
                } else {
                    System.out.println("\nFailed to rename the file. Please try again.");
                }
            } else {
                System.out.println("\nThe specified file does not exist. Please try again.");
            }
        } catch (IOException e) {
            System.out.println("\nError reading user input.");
        }
    }

    public static void deleteFile(BufferedReader br) {
        try {
            System.out.print("\nPlease enter the path: ");
            String filePath = br.readLine();
            System.out.print("Please enter the File-Name: ");
            String fileName = br.readLine();
            File file = new File(filePath, fileName);
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("\nFile is deleted Successfully!");
                } else {
                    System.out.println("\nFailed to delete the file. Please try again.");
                }
            } else {
                System.out.println("\nThe specified file does not exist. Please try again.");
            }
        } catch (IOException e) {
            System.out.println("\nError reading user input.");
        }
    }

}

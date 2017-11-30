import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.Paths;

public class Salaries implements Raiseable {

// Implemented methods

    public void create(String fileName){
        String path = fileName;
        File f = new File(path);
        if (f.exists()){return;}
        try {
            f.createNewFile();
        }
        /**
         * If the file throws an I/O Exception maybe the user
         * only gave us the filename, we will kindly try to write
         * a new file in the current directory.
         */
         catch (IOException eio) {
            path = System.getProperty("user.dir") +
                    File.separator + fileName;
            f = new File(path);
            try {
                f.createNewFile();
            } catch (Exception e) { e.printStackTrace(); }
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    public void display(String fileName){
       try( Scanner fileIn = new Scanner(Paths.get(fileName))){
           while(fileIn.hasNextLine()){
               String[] outPut = fileIn.nextLine().split(":");
               System.out.printf("id: %s" +
                       "\nSalary: $%.2f" +
                       "\nYear of service: %s\n\n",
                       outPut[0], Float.parseFloat(outPut[1]), outPut[2]);
           }
       } catch(Exception e){
           System.out.println("***** ERROR ****");
           e.printStackTrace(); // This look pretty bad, maybe I'll change it.
       }
    }

    public boolean addTo(String inFileName, String outFileName,
                         int id, double salary, int yearsOfService){
        try(Scanner fileIn = new Scanner(Paths.get(inFileName));
            PrintWriter fileOut = new PrintWriter(outFileName);){
            while(fileIn.hasNextLine()){
                String currLine = fileIn.nextLine();
                if(Integer.parseInt(currLine.split(":")[0]) < id){
                  // TODO add the line to the new file
                } // TODO else an then what do I do with all the lines after?
            }
        } catch(Exception e){
            System.out.println("***** ERROR ****");
            e.printStackTrace(); // This look pretty bad, maybe I'll change it.
            return false;
        } return true;
    }

    public boolean removeFrom(String inFileName, String outFileName,
                              int id, double salary, int yearsOfService){

        return true; //TODO this method ...
    }

    public int raise(String inFileName, String outFileName, int yearsOfService,
                     double salaryIncPercent){

        return 1; // TODO this method ...
    }

    public void mergeFiles(String inFileName1, String inFileName2,
                           String outFileName){
        // TODO this method ...
    }
}

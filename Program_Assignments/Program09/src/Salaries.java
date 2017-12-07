import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class Salaries implements Raiseable {

// Implemented methods

    public void create(String fileName){
        File f = new File(fileName);
        // Edge case check if the file already exists
        if (f.exists()){return;}
        try {
            f.createNewFile();
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
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFileName));
            PrintWriter fileOut = new PrintWriter(bw);){

            ArrayList <String[]> data = new ArrayList <>();
            while(fileIn.hasNextLine()){ data.add(fileIn.nextLine().split(":"));}
            data.add(new String[] {id+"",salary+"",yearsOfService+""}); // add the new data
            int duplicateId = 0;
            // Insertion sort, good for small n values or partially sorted lists
            for(int i=1; i<data.size(); i++){
                int j=i-1;
                String[] key = data.get(i);
                if(Integer.parseInt(key[0]) == id){
                    duplicateId +=1;
                    if(duplicateId > 1){return false;}
                } // quick check for double id
                while(j >=0 && Integer.parseInt(data.get(j)[0]) > Integer.parseInt(key[0])){
                    data.set(j+1, data.get(j));
                    j-=1;
                }
                data.set(j+1,key);
            }
            // Print the data to the outfile
            for(String[] line : data){
                fileOut.println(String.join(":",line));
            }
        } catch(Exception e){
            System.out.println("***** ERROR ****");
            e.printStackTrace(); // This look pretty bad, maybe I'll change it.
            return false;
        } return true;
    }

    public boolean removeFrom(String inFileName, String outFileName,
                              int id, double salary, int yearsOfService){
        boolean returnVal = false;
        try(Scanner fileIn = new Scanner(Paths.get(inFileName));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFileName));
            PrintWriter fileOut = new PrintWriter(bw);){
            ArrayList <String[]> data = new ArrayList <>();
            while(fileIn.hasNextLine()){
                String[] addition = fileIn.nextLine().split(":");
                if(Integer.parseInt(addition[0]) != id){
                    data.add(addition);
                } else{ returnVal = true;}
            }
            if (!returnVal){return false;} // quick check to make sure the id was found
            // Print the data to the outfile
            for(String[] line : data){
                fileOut.println(String.join(":",line));
            }
        } catch(Exception e){
            System.out.println("***** ERROR ****");
            e.printStackTrace(); // This look pretty bad, maybe I'll change it.
            return false;
        } return true;
    }

    public int raise(String inFileName, String outFileName, int yearsOfService,
                     double salaryIncPercent){
        int numRaise = 0;
        try(Scanner fileIn = new Scanner(Paths.get(inFileName));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFileName));
            PrintWriter fileOut = new PrintWriter(bw);){
            while(fileIn.hasNextLine()) {
                String[] addition = fileIn.nextLine().split(":");
                if(Integer.parseInt(addition[2]) >= yearsOfService){
                    addition[1] = Integer.parseInt(addition[1])*(salaryIncPercent/100) + "";
                    numRaise++;
                }
                fileOut.println(String.join(":",addition));
            }
        }catch(Exception e){
            System.out.println("***** ERROR ****");
            e.printStackTrace();
            return numRaise;
        } return numRaise;
    }

    public void mergeFiles(String inFileName1, String inFileName2,
                           String outFileName){
        try(Scanner file1In = new Scanner(Paths.get(inFileName1));
            Scanner file2In = new Scanner(Paths.get(inFileName2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFileName));
            PrintWriter fileOut = new PrintWriter(bw);){

            String line1 = file1In.nextLine();
            String line2 = file2In.nextLine();
            while (line1 != null || line2 != null) {
                if (line1 == null) {
                    fileOut.println(line2);
                    line2 = readLine(file2In);
                } else if (line2 == null) {
                    fileOut.println(line1);
                    line1 = readLine(file1In);
                } else if (Integer.parseInt(line2.split(":")[0]) <
                           Integer.parseInt(line1.split(":")[0])) {
                    fileOut.println(line2);
                    line2 = readLine(file2In);
                } else if (Integer.parseInt(line2.split(":")[0]) >
                        Integer.parseInt(line1.split(":")[0])) {
                    fileOut.println(line1);
                    line1 = readLine(file1In);
                } else {
                    if(Double.parseDouble(line1.split(":")[1]) >
                            Double.parseDouble(line2.split(":")[1])){
                        fileOut.println(line1);
                        line1 = readLine(file1In);
                        line2 = readLine(file2In);
                    } else {
                        fileOut.println(line2);
                        line1 = readLine(file1In);
                        line2 = readLine(file2In);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Private helper function for the merge function.
     * It will return the next line of a file, but if there is no next
     * line is kindly returns null and this can be tested for
     * @param Scanner object
     * @return Next line of the file or null is there is no more lines
     */
    private static String readLine(Scanner reader) {
        if (reader.hasNextLine())
            return reader.nextLine();
        else
            return null;
    }
}

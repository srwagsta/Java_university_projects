import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.nio.file.Paths;

public class Files
{
  public static void main(String[] args)
  {
    Scanner stdIn = new Scanner(System.in);

    // get output file's name
    String outFileName;
    System.out.print("Enter a file name for output: ");
    outFileName = stdIn.nextLine();

    // get append file's name
    String appendFileName;
    System.out.print("Enter a file name to append to: ");
    appendFileName = stdIn.nextLine();

    // get input file's name
    String inFileName;
    System.out.print("Enter a file name for input: ");
    inFileName = stdIn.nextLine();


    String[] words = {"hello", "world", "and", "stuff"};
    String[] moreWords = {"the", "end"};

// Write words the test output file
    try(
        FileWriter fw = new FileWriter(outFileName, false); // Set append to false
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)
        ){
        for(int i=0; i<words.length;i++){
            out.printf("words[%d] = " + words[i], i);
            if(i != words.length-1)
                out.print("\n"); // print a new line except for the last line
        }
    }catch ( Exception e){
        System.out.print("\n\n" + e.getClass() + " : ");
        System.out.println(e.getMessage());
    }

// Append moreWords to the append file
    try(
          FileWriter fw = new FileWriter(appendFileName, true); // Set append to true
          BufferedWriter bw = new BufferedWriter(fw);
          PrintWriter out = new PrintWriter(bw)
    ){
      out.print("\n"); // Point to a new line in the file, otherwise we would append to the last line
      for(int i=0; i<moreWords.length;i++){
          out.printf("moreWords[%d] = " + moreWords[i], i);
          if(i != moreWords.length-1)
              out.print("\n"); // print a new line except for the last line
      }
    }catch ( Exception e){
      System.out.print("\n\n" + e.getClass() + " : ");
      System.out.println(e.getMessage());
    }

// Read from the input file
    String line;
    try ( // use the auto close feature - try with resources
          Scanner fileIn = new Scanner(Paths.get(inFileName));
//          PrintWriter fileOut = new PrintWriter(outFileName);
        )
    {
      while ( fileIn.hasNextLine() )  // while the input file is not empty
      {
//        line = fileIn.nextLine(); // read a line from input file
//        fileOut.println(line);    // write a line to the output file
          System.out.println(fileIn.nextLine());
      }
    }
    catch (Exception e) // catch any exception that may be thrown
    {
      System.out.print("\n\n" + e.getClass() + " : ");
      System.out.println(e.getMessage());
    }
    
    stdIn.close();
  }
}

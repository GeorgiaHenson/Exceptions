import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FormatChecker {

    public FormatChecker(String fileName) throws FileNotFoundException {

        
            Scanner fileScan = new Scanner(new File(fileName));

            int rows = fileScan.nextInt();
            int cols = fileScan.nextInt();

            double tester;

            int rowCounter = 0;
            int colCounter = 0;
            
            while(fileScan.hasNextLine()){
                rowCounter++;
                while(fileScan.hasNext()){
                    colCounter++;
                    tester = fileScan.nextDouble();
                }
            }


         

    }
}
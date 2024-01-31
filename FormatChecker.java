import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FormatChecker {

    public FormatChecker(String fileName)
            throws FileNotFoundException, IncorrectRowCountException, IncorrectColumnCountException {

        Scanner fileScan = new Scanner(new File(fileName));

        int rows = fileScan.nextInt();
        int cols = fileScan.nextInt();

        int rowCounter = 0;
        int colCounter = 0;

        while (fileScan.hasNextLine()) {
            rowCounter++;
            while (fileScan.hasNext()) {
                colCounter++;
                double tester = fileScan.nextDouble();
            }
        }
        if (rowCounter < rows) {
            throw new IncorrectRowCountException("Not enough rows in file");
        } else if (rowCounter > rows) {
            throw new IncorrectRowCountException("Too many rows in file");
        }

        if (colCounter < cols) {
            throw new IncorrectColumnCountException("Not enough columns in file");
        } else if (colCounter > cols) {
            throw new IncorrectColumnCountException("Not enough columns in file");
        }

    }

    public static void main(String[] args) {
        if (args.length > 1) {
            for (String x : args) {
                try {
                    System.out.println(x);
                    FormatChecker checkFormat = new FormatChecker(x);
                    System.out.println("VALID");
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                    System.out.println("INVALID");
                } catch (IncorrectColumnCountException e) {
                    System.out.println(e.getMessage());
                    System.out.println("INVALID");
                } catch (IncorrectRowCountException e) {
                    System.out.println(e.getMessage());
                    System.out.println("INVALID");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("INVALID");
                } finally {
                    System.out.println();
                }
            }

        } else {
            System.out.println(
                    "Usage:$ java FormatChecker file1 [file2 ... fileN]\n where the names of one or more input files are given.");
            return;
        }
    }
}

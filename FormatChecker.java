import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The FormatChecker class takes a filename and tests for proper formatting of the file
 * 
 * @author Georgia Henson
 * @version 1.0 CS221 Spring 2024
 */

public class FormatChecker {

    /**
     * Constructor for FormatChecker
     * @param fileName is the name of the file being tested in FormatChecker
     * @throws FileNotFoundException
     * @throws IncorrectRowCountException
     * @throws IncorrectColumnCountException
     * @throws IncorrectFirstLineException
     */

    public FormatChecker(String fileName)
            throws FileNotFoundException, IncorrectRowCountException, IncorrectColumnCountException,
            IncorrectFirstLineException {

        Scanner fileScan = new Scanner(new File(fileName));

        String rowColLine = fileScan.nextLine();
        Scanner rowColLineScan = new Scanner(rowColLine);
        int rows = Integer.parseInt(rowColLineScan.next());
        int cols = Integer.parseInt(rowColLineScan.next());
        if (rowColLineScan.hasNext()) {
            rowColLineScan.close();
            throw new IncorrectFirstLineException("Extra integer on first line");
        } else {
            rowColLineScan.close();
        }

        int rowCounter = 0;
        int colCounter = 0;

        while (fileScan.hasNextLine()) {
            colCounter = 0;
            String line = fileScan.nextLine();
            if (line.length() > 0) {
                Scanner lineScan = new Scanner(line);
                rowCounter++;
                while (lineScan.hasNext()) {
                    double tester = Double.parseDouble(lineScan.next());
                    colCounter++;

                }
                lineScan.close();

                if (colCounter < cols) {
                    throw new IncorrectColumnCountException("Not enough columns in file");
                } else if (colCounter > cols) {

                    throw new IncorrectColumnCountException("Too many columns in file");
                }
            }
        }
        if (rowCounter < rows) {
            throw new IncorrectRowCountException("Not enough rows in file");
        } else if (rowCounter > rows) {
            throw new IncorrectRowCountException("Too many rows in file");
        }

    }

    /**
     * main method validates command lines and runs the FormatChecker class
     * @param args
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            for (var x : args) {
                try {
                    System.out.println(x);
                    FormatChecker checkFormat = new FormatChecker(x);
                    System.out.println("VALID");

                } catch (FileNotFoundException e) {
                    System.out.println(e);

                    System.out.println("INVALID");
                } catch (IncorrectColumnCountException e) {
                    System.out.println(e);

                    System.out.println("INVALID");
                } catch (IncorrectRowCountException e) {
                    System.out.println(e);

                    System.out.println("INVALID");
                } catch (Exception e) {
                    System.out.println(e);

                    System.out.println("INVALID");
                } finally {
                    System.out.println();

                }

            }

        } else {
            System.out.println(
                    "Usage:$  java FormatChecker <filename1> [filename2 .. filenameN]");
            return;
        }

    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FormatChecker {

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

        

        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);
            rowCounter++;
            int colCounter = 0;
            while (lineScan.hasNext()) {
                colCounter++;
                double tester = Double.parseDouble(lineScan.next());
            }
            lineScan.close();
            if (colCounter < cols) {

                throw new IncorrectColumnCountException("Not enough columns in file");
            } else if (colCounter > cols) {
                throw new IncorrectColumnCountException("Too many columns in file");
            }

        }
        if (rowCounter < rows) {
            throw new IncorrectRowCountException("Not enough rows in file");
        } else if (rowCounter > rows) {
            throw new IncorrectRowCountException("Too many rows in file");
        }

    }

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
                    "Usage:$ java FormatChecker file1 [file2 ... fileN]\n where the names of one or more input files are given.");
            return;
        }

    }
}

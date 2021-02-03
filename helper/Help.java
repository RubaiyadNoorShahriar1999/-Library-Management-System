package helper;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Help {

    private final static String ROOT = "database";

    public final static int bookLimit = 500;
    public final static int studentLimit = 100;
    public final static int teacherLimit = 50;

    public final static String BOOK_PATH = Help.ROOT + "/books.txt";
    public final static String STUDENT_PATH = Help.ROOT + "/students.txt";
    public final static String TEACHER_PATH = Help.ROOT + "/teachers.txt";
    public final static String TRANSACTION_PATH = Help.ROOT + "/transaction.txt";

    public static void echo(String str) {
        System.out.print(str);
    }

    public static void echo(int str) {
        System.out.print(str);
    }

    public static void echo(double str) {
        System.out.print(str);
    }

    public static void echoLn(String str) {
        System.out.println(str);
    }

    public static void echoLn(int str) {
        System.out.println(str);
    }

    public static void echoLn(double str) {
        System.out.println(str);
    }

    public static void generateOptionsList(String options[]) {
        Help.echoLn("==================");
        Help.echoLn("Choose your opiton: ");
        Help.echoLn("==================");
        for (int i = 0; i < options.length; i++) {
            Help.echoLn((i + 1) + ". " + options[i]);
        }
        Help.echo("Enter your Option: ");
    }


    public static String readString() {

        try {
            String line = null;
            Scanner input = new Scanner(System.in);
            if (input.hasNextLine()) {
                line = input.nextLine();
                // Help.echoLn("\n\nString ==> " + line + " DONE!!");
            } else if (!input.hasNextLine()) {
                input.close();
                line = Help.readString();
            } else {
                input.close();
                throw new IOException();
            }
            return line;
        } catch (InputMismatchException err) {
            Help.echoLn("\nError: InputMismatchException\nTry to input a UTF-8 format String\n");
            // err.printStackTrace();
        } catch (IOException err) {
            Help.echoLn("\nError: IOException!!\n");
            err.printStackTrace();
        } catch (Exception err) {
            Help.echoLn("\nError: Exception!!\n");
            err.printStackTrace();
        }

        return null;
    }

    public static int readInteger() {
        try {
            int line = -1;
            Scanner input = new Scanner(System.in);
            if (input.hasNextLine()) {
                line = input.nextInt();
                // Help.echoLn("\n\nString ==> " + line + " DONE!!");
            } else if (!input.hasNextLine()) {
                input.close();
                line = Help.readInteger();
            } else {
                input.close();
                throw new IOException();
            }
            return line;
        } catch (InputMismatchException err) {
            Help.echoLn("\nError: InputMismatchException\nTry to input an Integer Number\n");
            // err.printStackTrace();
        } catch (IOException err) {
            Help.echoLn("\nError: IOException!!\n");
            err.printStackTrace();
        } catch (Exception err) {
            Help.echoLn("\nError: Exception!!\n");
            err.printStackTrace();
        }

        return -1;
    }

    public static double readDouble() {
        try {
            double line = -1.0;
            Scanner input = new Scanner(System.in);
            if (input.hasNextLine()) {
                line = input.nextDouble();
                // Help.echoLn("\n\nString ==> " + line + " DONE!!");
            } else if (!input.hasNextLine()) {
                input.close();
                line = Help.readDouble();
            } else {
                input.close();
                throw new IOException();
            }
            return line;
        } catch (InputMismatchException err) {
            Help.echoLn("\nError: InputMismatchException\nTry to input a Float Number\n");
            // err.printStackTrace();
        } catch (IOException err) {
            Help.echoLn("\nError: IOException!!\n");
            err.printStackTrace();
        } catch (Exception err) {
            Help.echoLn("\nError: Exception!!\n");
            err.printStackTrace();
        }
        return -1.0;
    }

    public static void writeFile(String path, String line, boolean mode) {
        try {
            File file = new File(path);
            FileWriter fWriter = new FileWriter(file, mode);

            if (file.exists()) {
                if (file.canWrite()) {  // Writting permition
                    fWriter.write(line);
                } else {
                    Help.echoLn("\nCan't Write to " + file.getAbsolutePath() + "\n");
                }
            } else {
                Help.echoLn("\n" + file.getName() + "File Does not exists!!\n");
            }
            fWriter.close();
        } catch (FileNotFoundException err) {
            Help.echoLn("\nError: FileNotFoundException\n");
            // err.printStackTrace();
        } catch (IOException err) {
            Help.echoLn("\nError: IOException!!\n");
            err.printStackTrace();
        }
    }

    public static String[] readFile(String path, int length) {
        /*
        retrun data format:
        {
            5    Rahim Uddiin    4    CSE    rahim@gmail.com    01934256389    Uttora,Dhaka    100.0    bookid-empty
            10    Al Masud    5    EEE    almasud@gmail.com    014368095342    Kuril.Dhaka    80.0    bookid-empty
            20    Bijoy Roy    6    BBA    bijoyroy@gmail.com    01543278546    Kurmitola,Dhaka    120.0    bookid-empty
        }
         */
        try {
            int i = 0;
            File file = new File(path);
            if (file.exists()) {
                Scanner fRead = new Scanner(file);

                String[] line = new String[length];

                while (fRead.hasNextLine()) {
                    if (!(line[i] = fRead.nextLine()).equals(null)) {
                        i++;
                    } else {
                        break;
                    }
                }
                fRead.close();
                return line;
            } else {
                return new String[0];   //Empty array
            }

        } catch (FileNotFoundException err) {
            Help.echoLn("\nError: FileNotFoundException\n");
            // err.printStackTrace();
        } catch (Exception err) {
            Help.echoLn("\nError: Exception!!\n");
            err.printStackTrace();
        }

        return new String[0];   // Empty array
    }
}
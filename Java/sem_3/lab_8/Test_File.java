package lab_8;

import java.io.*;
import java.util.Scanner;

public class Test_File {
    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter("Test.txt", false)) {
            Scanner sc = new Scanner(System.in);
            String text = sc.nextLine();
            writer.write(text);
            writer.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


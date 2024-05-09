package Project;


import java.io.*;
import java.util.*;

import java.io.*;
import static Project.Librarian.librarian; 

public class ReadWrite {
    public static void writeLibrariansToFile( String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Librarian librarian : librarian) {
                writer.println(librarian.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
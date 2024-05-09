package Project;


import java.io.*;
import java.util.*;

import java.io.*;
import static Project.Librarian.librarian;
import static Project.Book.books;
import static Project.User.users; 

public class ReadWrite{
	
	public static void writeToFileU(String fileName, LinkedList<User> list) throws IOException {
	    try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
	        for (User u : list) {
	            out.println(u.getName() + "," + u.getAge() + "," + u.getGender());
	        }
	    }
	}

	public static void writeToFileL(String fileName, LinkedList<Librarian> list) throws IOException {
	    try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
	        for (Librarian librarian : list) {
	            out.println(librarian.getName() + "," + librarian.getAge() + "," + librarian.getGender());
	        }
	    }
	}
public static void writeToFileB(String fileName, LinkedList<Book> list) throws IOException {
    try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
        for (Book b : books) {
            out.println(b.getISBN() + "," + b.getAuthor() + "," + b.getTitle()+ ","+b.getGenre());
        }
    }
}

public static LinkedList<User> readFromFileU(String fileName) throws IOException {
    LinkedList<User> list = new LinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            User user = new User(values[0], Integer.parseInt(values[1]), values[2],0);
            list.add(user);
        }
    }
    return list;
}

public static LinkedList<Librarian> readFromFileL(String fileName) throws IOException {
    LinkedList<Librarian> list = new LinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
        	String[] values = line.split(" ");
        	if (values.length < 4) {
        	    System.out.println("Invalid data format: " + line);
        	    continue;
        	}

            try {
               int employeeID = Integer.parseInt(values[3]);
               Librarian librarian = new Librarian(values[0], Integer.parseInt(values[1]), values[2], employeeID);
                list.add(librarian);
            } catch (NumberFormatException e) {
                System.err.println("test");
            }
        }
    }
    return list;
}

public static LinkedList<Book> readFromFileB(String fileName) throws IOException {
    LinkedList<Book> list = new LinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            Book b = new Book(Integer.parseInt(values[0]), values[1], values[2],values[3],true,false);
            list.add(b);
        }
    }
    return list;
}

}
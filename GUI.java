package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.*;
import java.io.*;
import static Project.Librarian.librarian; 
import static Project.Book.books;
import static Project.User.users; 

public class GUI extends JFrame  {
	private JButton librarianButton;
    private JButton userButton;
    private JButton start;
    private JPanel imagePanel;
    

  
    Book book1 = new Book(111,"test","Rafik","scifi",true,false);
    
User userq = new User("rafik",22,"male",345);

Librarian lib = new Librarian("ali",22,"male",34545);

    public GUI() {
       
 //add the JPanel (panel) to the content pane of the JFrame
     
        
  	    }
 }


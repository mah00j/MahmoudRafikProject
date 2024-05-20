package Project;
import static Project.Book.books;
import static Project.Librarian.librarian;
import static Project.User.users;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities; 

public class TESTING extends JFrame  {
	private JButton librarianButton;
    private JButton userButton;
    private JButton exit;

  
    Book book1 = new Book(111,"test","ra","scifi",true,false);
    Book book2 = new Book(222,"testing","ra","fiction",true,false);
User userq = new User("rafik",22,"male",345);

Librarian lib = new Librarian("ali",22,"male",34545);
Librarian lib1 = new Librarian("test",29,"male",33333);

    public TESTING() {
        setTitle("Library Management System");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(2, 2));
JPanel test = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,175)); //sets the alignment of the components in the panel to the center.
librarianButton = new JButton("Librarian");


librarianButton.setFont(new Font("Times New Roman", Font.BOLD,16));

        
        userButton = new JButton("User");
        userButton.setFont(new Font("Times New Roman", Font.BOLD,16));
        
        exit= new JButton("Exit");
        exit.setFont(new Font("Times New Roman", Font.BOLD,16));
        librarianButton.addActionListener(new ActionListener() { // when librarian is clicked it opens the librarian section
        	
            public void actionPerformed(ActionEvent e) {
                handleRoleSelection("Librarian");
                dispose();
            }
        });

        userButton.addActionListener(new ActionListener() { // when user is clicked it opens the user section
            public void actionPerformed(ActionEvent e) {
                handleRoleSelection("User");
                dispose();
            }
        });
    exit.addActionListener(new ActionListener() { // when user is clicked it exits
            public void actionPerformed(ActionEvent e) {
             	try {
           		 ReadWrite w = new ReadWrite();
           	   ReadWrite.writeToFileB("Books.txt", books);
           	    ReadWrite.writeToFileU("User.txt", users);
           	   ReadWrite.writeToFileL("Librarian.txt", librarian);
           	  
           	} catch (IOException S) {
           	    S.printStackTrace();
           	 System.err.print("I am here");
           	}
                dispose();
            }
        });

        librarianButton.setPreferredSize(new Dimension(100, 50));
        userButton.setPreferredSize(new Dimension(100, 50));
        exit.setPreferredSize(new Dimension(100, 50));
        mainPanel.add(librarianButton);
        mainPanel.add(userButton);
        test.add(exit);
        mainPanel.add(test);
;
mainPanel.setBackground(new Color(122,178,178));
    getContentPane().add(mainPanel); //allowing the user to interact with the buttons and other components contained within mainPanel.

        books.add(book1);
        books.add(book2);
       users.add(userq);
       librarian.add(lib);
       try {
   	        
    	    ReadWrite.readFromFileB("books.txt");
    	    ReadWrite.readFromFileU("Users.txt");
    	    ReadWrite. readFromFileL("Librarian.txt");
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}  



      
       
//lezim nhot b2lba shi
        setVisible(true);
    }

    private void handleRoleSelection(String role) {
        JFrame roleFrame = new JFrame(role + " Selection"); // if the user selects librarian the title will be librarian selection and same thing for user
        roleFrame.setSize(600, 500);
        roleFrame.setLocationRelativeTo(null);
        roleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mainPanel1 = new JPanel(new GridLayout(3, 1));

        
        JButton createAccountButton = new JButton("Create New Account");
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  if (role.equalsIgnoreCase("Librarian")) {
                      openNewAccount();
                  } else if (role.equalsIgnoreCase("User")) {
                      openNewAccountUser();
                  }
            	setLocationRelativeTo(null);
                roleFrame.dispose();
             dispose(); //close window
            }
        });

        JButton loginButton = new JButton("Login");


        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setLocationRelativeTo(null);
            	openLoginWindow();
                roleFrame.dispose();
                dispose();
            }
        });
        JButton BackButton = new JButton("Go Back");


        BackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new TESTING().setVisible(true);
            	roleFrame.dispose();

                
            }
        });

        mainPanel1.add(createAccountButton);
        mainPanel1.add(loginButton);
mainPanel1.add(BackButton);
        roleFrame.getContentPane().add(mainPanel1);
        roleFrame.setVisible(true);
    }
        
    
    private void openNewAccount() {
        CreateAccountWindow AccW = new CreateAccountWindow();
        AccW.setVisible(true); //make objects visible on the screen.
    	setLocationRelativeTo(null); //totla3 bl nos

    }
    private void openLoginWindow() {
        LoginWindow lw = new LoginWindow();
        lw.setVisible(true);
        setLocationRelativeTo(null);
    }
    private void openNewAccountUser() {
        CreateAccountUser AccW = new CreateAccountUser();
        AccW.setVisible(true);
        setLocationRelativeTo(null);
    }
    private void openUserPanel() {
        UserPanel up = new UserPanel();
        up.setVisible(true);
        setLocationRelativeTo(null);
    }
    private void openLibrarianPanel() {
        LibrarianPanel ol = new LibrarianPanel();
        ol.setVisible(true);
        setLocationRelativeTo(null);
    }
private void AddLib2() {
LibAccount w = new LibAccount();
w.setVisible(true);
setLocationRelativeTo(null);
}
private void AddUser2() {
UserAccount w = new UserAccount();
w.setVisible(true);
setLocationRelativeTo(null);
}
private void AddBook() {
AddBook w = new AddBook();
w.setVisible(true);
setLocationRelativeTo(null);
}
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               
					new TESTING();
				
            }
        });
    }
    
    
    
    class LoginWindow extends JFrame {
    	private JTextField Field;
    	private JTextField nameField1;
        public LoginWindow() {
            setTitle("Login Window");
            setSize(600, 500);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	setLocationRelativeTo(null);
            JPanel panel = new JPanel(new GridLayout(6, 2));
            JLabel label = new JLabel("Are you a user or librarian? :");
            Field = new JTextField();
            
            JLabel labelID = new JLabel("Enter your ID :");
            nameField1 = new JTextField();
            
            JButton oB = new JButton("Submit");
          JButton backButton = new JButton("Back");
          nameField1 = new JTextField();
          nameField1.setBackground(new Color(205,232, 229)); // Darker background color for text field
          nameField1.setForeground(Color.BLACK); // Black text color
          Field = new JTextField();
          Field.setBackground(new Color(238, 253, 255)); 
          Field.setForeground(Color.BLACK); 

;
          
          oB.setBackground(new Color(122, 178, 178)); 
          oB.setForeground(Color.WHITE); // White text
          oB.setFont(new Font("Times New Roman", Font.BOLD, 22)); // Bold, size 14
          oB.setBorderPainted(false); // Remove button border
          
          backButton.setBackground(new Color(77, 134, 156)); 
          backButton.setForeground(Color.WHITE); // White text
          backButton.setFont(new Font("Times New Roman", Font.BOLD, 22)); // Plain, size 14
          backButton.setBorderPainted(false); // Remove button border

          backButton.addActionListener(new ActionListener() {
 	            public void actionPerformed(ActionEvent e) {
 	                // Dispose of the current window
 	                dispose();
 	                // Go back to the previous window (in this case, assuming it's the role selection window)
 	                handleRoleSelection("user");
 	            }
 	        });
	                
            oB.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String w;
                	w= Field.getText();
   
                	if(!w.equalsIgnoreCase("user") && !w.equalsIgnoreCase("librarian") &&!w.isEmpty()) {
                		 JOptionPane.showMessageDialog(null, "you can be either a user or librarian !!");
                	}
                	if(w.isEmpty() || nameField1.getText().isEmpty()) {
                		 JOptionPane.showMessageDialog(null, "Please fill in the blank ");
                	}
                	else {
 
                  int id;
               int IDlength;
               try {
                   id = Integer.parseInt(nameField1.getText());
                   IDlength = nameField1.getText().length();
               } catch (NumberFormatException ex) {
                   JOptionPane.showMessageDialog(null, "ID must be a number.");
                   return;
               }
               if (IDlength!=3 && IDlength!=5) {
             JOptionPane.showMessageDialog(null,"ID must be of "+3+" or "+5+" digits");
              return;
            	                   }
                  if(Field.getText().equalsIgnoreCase("user")) {
                	  if(IDlength==3) {
                		 boolean found=false;
                  for(User s : users) {
          
            		  if(s.getLibraryCardNum()==id) {
            			  JOptionPane.showMessageDialog(null,"Welcome back, " + s.getName() + "!");
            			  openUserPanel();
            			  dispose();
                        found=true;
                        break;
            		  }
            		
            	  }
                  if(!found) {
                	  JOptionPane.showMessageDialog(null, "library card number not found, please create an account");
                  }
                 
                	  }
                	  else if(IDlength!=3) {
                		  JOptionPane.showMessageDialog(null,"library card number needs to be of 3 digits");
                	  return;
                	  }
                  }
                 
                  if(Field.getText().equalsIgnoreCase("librarian")) {
                	  if(IDlength==5) {
                		 boolean found=false;
                  for(Librarian l : librarian) {
          
            		  if(l.getEmployeeID()==id) {
            			  JOptionPane.showMessageDialog(null,"Welcome back, " + l.getName() + "!");
            			  openLibrarianPanel();
            			  dispose(); // Close the window after account creation

                        found=true;
                        break;
            		  }
            		
            	  }
                  if(found==false) {
                	  JOptionPane.showMessageDialog(null, "ID not found, please create an account");
                  }
                 
                	  }
                	  else if(IDlength!=5) {
                		  JOptionPane.showMessageDialog(null,"ID needs to be of 5 digits");
                	  return;
                	  }
                  }
                 
                
                }
                
                }});
            panel.add(label);
            panel.add(Field);
            panel.add(labelID);
            panel.add(nameField1);
            panel.add(oB);
            panel.add(backButton);
             
           
            add(panel);
            
        }
    }
    
    
    class UserPanel extends JFrame {    
    	public UserPanel() {
    		 setTitle("Login Window");
             setSize(600, 500);
             setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         	setLocationRelativeTo(null);
JFrame f = new JFrame();
         	JPanel panel = new JPanel(new GridLayout(9, 1));
            panel.setBackground(new Color(240, 240, 240)); // Light gray background
            
            
            JButton checkInfo = new JButton("Check Information");
            JButton searchByTitle = new JButton("Search Book by Title");
            JButton searchByAuthor = new JButton("Search Book by Author");
            JButton searchByGenre = new JButton("Search Book by Genre");
            JButton borrowBook = new JButton("Borrow Book");
            JButton returnBook = new JButton("Return Book");
            JButton reserveBook = new JButton("Reserve Book");
            JButton goBack = new JButton("Go Back");
            JButton exit = new JButton("Exit");
                     
                 checkInfo.setBackground(new Color(189, 195, 199)); 
                 searchByTitle.setBackground(new Color(189, 195, 199)); 
                 searchByAuthor.setBackground(new Color(189, 195, 199)); 
                 searchByGenre.setBackground(new Color(189, 195, 199)); 
                 borrowBook.setBackground(new Color(189, 195, 199)); 
                 returnBook.setBackground(new Color(189, 195, 199)); 
                 reserveBook.setBackground(new Color(189, 195, 199)); 
                 goBack.setBackground(new Color(189, 195, 199));
                 exit.setBackground(new Color(189, 195, 199));

            
            checkInfo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String Info = userq.Check_Information();
                    JOptionPane.showMessageDialog(null, Info);
                    }
            });
            searchByTitle.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	 String Title=JOptionPane.showInputDialog(f,"Enter the Title of the book");  
                	 if(Title.isEmpty()) {
                		 JOptionPane.showMessageDialog(null, "Title cannot be empty");
                         return;
                	 }
                	 else
                	 JOptionPane.showMessageDialog(null,userq.SearchBookByTitle(Title));
                }
            });
            searchByAuthor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	 String a=JOptionPane.showInputDialog(f,"Enter the name of the author");  
                	 if(a.isEmpty()) {
                		 JOptionPane.showMessageDialog(null, "author cannot be empty");
                         return;
                	 }
                	 else
                	 JOptionPane.showMessageDialog(null,userq.SearchBookByAuthor(a));
                }
            });
            searchByGenre.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	 String g=JOptionPane.showInputDialog(f,"Enter the Genre");  
                	 if(g.isEmpty()) {
                		 JOptionPane.showMessageDialog(null, "genre cannot be empty");
                         return;
                	 }
                	 else
                	 JOptionPane.showMessageDialog(null,userq.SearchBookByGenre(g));
                }
            });
            borrowBook.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String g=JOptionPane.showInputDialog(f,"Enter the the title of the book");  
                	if(g.isEmpty()) {
               		 JOptionPane.showMessageDialog(null, "Title cannot be empty");
                        return;
               	 }
               	 else
                	JOptionPane.showMessageDialog(null, userq.BorrowBook(g));
                }
            });
            returnBook.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String g=JOptionPane.showInputDialog(f,"Enter the title of the book");  
                	if(g.isEmpty()) {
               		 JOptionPane.showMessageDialog(null, "Title cannot be empty");
                        return;
               	 }
               	 else
                	JOptionPane.showMessageDialog(null,userq.ReturnBook(g));
                }
            });
            reserveBook.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String g=JOptionPane.showInputDialog(f,"Enter the title of the book");  
                	if(g.isEmpty()) {
               		 JOptionPane.showMessageDialog(null, "Title cannot be empty");
                        return;
               	 }
               	 else
                	JOptionPane.showMessageDialog(null,userq.ReserveBook(g));
                }
            });
            goBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
      			  openLoginWindow();
                dispose();
                
                }
            });
            exit.addActionListener(new ActionListener() { // when user is clicked it exits
                public void actionPerformed(ActionEvent e) {
                 	try {
               		 ReadWrite w = new ReadWrite();
               	   ReadWrite.writeToFileB("Books.txt", books);
               	    ReadWrite.writeToFileU("User.txt", users);
               	   ReadWrite.writeToFileL("Librarian.txt", librarian);
               	  
               	} catch (IOException S) {
               	    S.printStackTrace();
               	 System.err.print("I am here");
               	}
                    dispose();
                }
            });
            
            
            
            
            panel.add(checkInfo);
            panel.add(searchByTitle);
            panel.add(searchByAuthor);
            panel.add(searchByGenre);
            panel.add(borrowBook);
            panel.add(returnBook);
            panel.add(reserveBook);
            panel.add(goBack);
panel.add(exit);
            getContentPane().add(panel);
    	}
    }

    	
    class LibrarianPanel extends JFrame{
    	public LibrarianPanel() {
    		 setTitle("Login Window");
             setSize(600, 500);
             setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         	setLocationRelativeTo(null);
 JFrame f = new JFrame();
         	JPanel panel = new JPanel(new GridLayout(12, 1,10,10));
            panel.setBackground(new Color(240, 240, 240)); // Light gray background
            
            JButton addLibrarian = new JButton("Add Librarian");
            JButton addUser = new JButton("Add User");
            JButton checkInfo = new JButton("Check Information");
            JButton searchByTitle = new JButton("Search Book by Title");
            JButton searchByAuthor = new JButton("Search Book by Author");
            JButton searchByGenre = new JButton("Search Book by Genre");
            JButton borrowBook = new JButton("Borrow Book");
            JButton returnBook = new JButton("Return Book");
            JButton reserveBook = new JButton("Reserve Book");
            JButton AddBook = new JButton("Add Book");
            JButton goBack = new JButton("go back");
            JButton exit = new JButton("exit");

                     addLibrarian.setBackground(new Color(189, 195, 199)); //grey color 
                     addUser.setBackground(new Color(189, 195, 199)); 
                     checkInfo.setBackground(new Color(189, 195, 199)); 
                     searchByTitle.setBackground(new Color(189, 195, 199)); 
                     searchByAuthor.setBackground(new Color(189, 195, 199)); 
                     searchByGenre.setBackground(new Color(189, 195, 199)); 
                     borrowBook.setBackground(new Color(189, 195, 199)); 
                     returnBook.setBackground(new Color(189, 195, 199)); 
                     reserveBook.setBackground(new Color(189, 195, 199)); 
                     AddBook.setBackground(new Color(189, 195, 199));   
                     goBack.setBackground(new Color(189, 195, 199)); 
                     exit.setBackground(new Color(189, 195, 199)); 
                     
                     addLibrarian.addActionListener(new ActionListener() {
                    	 
                    	    public void actionPerformed(ActionEvent e) {
                    	        String name = JOptionPane.showInputDialog("Enter the user's name:");
                    	       String ageInput = JOptionPane.showInputDialog("Enter the user's age:");
                    	        String gender = JOptionPane.showInputDialog("Enter the user's gender:");
                    	        int lcd = (int) (Math.random() * 90000) + 10000;
                    	        JOptionPane.showMessageDialog(null, "The ID is " + lcd);

                    	     int age=0;
                    	       try {
                    	           age = Integer.parseInt(ageInput);
                    	       } catch (NumberFormatException e1) {
                    	           JOptionPane.showMessageDialog(null, "Age must be a number!");
                    	           return;
                    	       }
                	       if (age<18|| age>100) {
                   	            JOptionPane.showMessageDialog(null, "Age must be between 18 and 100!");
                   	          return;
                   	        }
                   	       if (name == null || name.isEmpty() || gender == null || gender.isEmpty()) {
                   	           JOptionPane.showMessageDialog(null, "Name and gender cannot be empty!");
                   	           return;
                   	       }
                   	       try {
                            JOptionPane.showMessageDialog(null, lib.AddUser(name, age, gender, lcd));
                 	       } catch (IllegalArgumentException e2) {
                    	           JOptionPane.showMessageDialog(null, e2.getMessage());
                    	        }
                    	    }
                    	});
            
            addUser.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

            String name = JOptionPane.showInputDialog("Enter the users name:");
           String age = JOptionPane.showInputDialog("Enter the users age:");
           String gender = JOptionPane.showInputDialog("Enter the users gender:");
           int lcd= (int) (Math.random() * 900) + 100;
           JOptionPane.showMessageDialog(null,"The library card number is "+ lcd);
int aage=0;
           try {
               aage=Integer.parseInt(age);
}
catch(IllegalArgumentException e1){ JOptionPane.showMessageDialog(null,"age mus be greater than 18!!");
return;
}
           if (age.isEmpty() || name.isEmpty() || gender.isEmpty()) {
        	   JOptionPane.showMessageDialog(null,"cant be empty");
        	   return;
        	  
           }
           
           JOptionPane.showMessageDialog(null,  lib.AddUser(name, aage, gender, lcd));


                }
            });
            checkInfo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String Info = lib.Check_Information();
                    JOptionPane.showMessageDialog(null, Info);
                }
            });
            
            searchByTitle.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
               String title=JOptionPane.showInputDialog(f,"Enter the Title of the book"); 
                 if (title.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Title cannot be empty");
                        return;
                     }
                	 String result =lib.SearchBookByTitle(title);  //Changed to String so i could show it to user, it was void.
                  JOptionPane.showMessageDialog(null,result);
                	 
                }
            });
            searchByAuthor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	 String a=JOptionPane.showInputDialog(f,"Enter the name of the author");  
                	 if(a.isEmpty()) {
                		 JOptionPane.showMessageDialog(null, "author cannot be empty");
                         return;
                	 }
                	 else
                	 JOptionPane.showMessageDialog(null, lib.SearchBookByAuthor(a));
                }
            });
            searchByGenre.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	 String g=JOptionPane.showInputDialog(f,"Enter the Genre");  
                	 if(g.isEmpty()) {
                		 JOptionPane.showMessageDialog(null, "genre cannot be empty");
                         return;
                	 }
                	 else
                		 JOptionPane.showMessageDialog(null,lib.SearchBookByGenre(g));
                }
            });
            AddBook.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
               	 AddBook();
                	
                	
               }
           });
            goBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
      			  openLoginWindow();
                dispose();
                
                }
            });
            exit.addActionListener(new ActionListener() { // when user is clicked it exits
                public void actionPerformed(ActionEvent e) {
                 	try {
               		 ReadWrite w = new ReadWrite();
               	   ReadWrite.writeToFileB("Books.txt", books);
               	    ReadWrite.writeToFileU("User.txt", users);
               	   ReadWrite.writeToFileL("Librarian.txt", librarian);
               	  
               	} catch (IOException S) {
               	    S.printStackTrace();
      	 
               	}
                    dispose();
                }
            });
           
            
            
            panel.add(addLibrarian);
            panel.add(addUser);
            panel.add(checkInfo);
            panel.add(searchByTitle);
            panel.add(searchByAuthor);
            panel.add(searchByGenre);
            panel.add(borrowBook);
            panel.add(returnBook);
            panel.add(reserveBook);
            panel.add(AddBook);
            panel.add(goBack);
            panel.add(exit);
            getContentPane().add(panel);
    	}
    }
    
    class AddBook extends JFrame{
    	 private JTextField nameField;
 	    private JTextField nameField1;
 	   private JTextField nameField2;
 	  private JTextField nameField3;
 	    
 	    public AddBook() {
 	    	setTitle("Add New Book");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       	setLocationRelativeTo(null);
       	
        JPanel panel = new JPanel(new GridLayout(9, 1,10,10));
	       panel.setBackground(new Color(240, 240, 240));
	        JLabel title = new JLabel("title of book:");
	        title.setBackground(new Color(71, 147, 175));
	        nameField = new JTextField();
	        nameField.setBackground(new Color(255, 196, 112));
	       
	        JLabel author = new JLabel("author of book:");
	        author.setBackground(new Color(71, 147, 175));
	        nameField1 = new JTextField();
	        nameField1.setBackground(new Color(255, 196, 112));
	        JLabel genre = new JLabel("genre of book:");
	        genre.setBackground(new Color(71, 147, 175));
	        nameField2 = new JTextField();
	        nameField2.setBackground(new Color(255, 196, 112));
	        JLabel ISBN = new JLabel("ISBN of book:");
	        ISBN.setBackground(new Color(71, 147, 175));
	        nameField3 = new JTextField();
	        nameField3.setBackground(new Color(255, 196, 112));

	        JButton submitButton = new JButton("Submit");

	       submitButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
	       submitButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String name ;
	                String author;
	                String genre;
	                String ISBN;
	                try {
	                name= nameField.getText(); //get text from the textfield whih is inputed.
	                author = nameField1.getText();
	                genre = nameField2.getText();
	                }
	                catch(InputMismatchException eq) {
	                	 JOptionPane.showMessageDialog(null,"please enter a string not anything else");
	                	 return;
	                }
 ISBN=nameField3.getText();
	                if (name.isEmpty() || author.isEmpty() || genre.isEmpty() || ISBN.isEmpty() ) {
                       JOptionPane.showMessageDialog(null, "You cant leave any thing empty");
                       return;
                   }
                  
                  
                  

                   int isbn;
                  try {
                       isbn = Integer.parseInt(nameField3.getText());
                       for(Book bo: books) {
                       if (isbn==bo.getISBN() || name.equals(bo.getTitle()) ) {
                           JOptionPane.showMessageDialog(null, "This book Already Exists");
                           return;
                       }
                       }
                       }
                  catch(NumberFormatException ex) {
                	  JOptionPane.showMessageDialog(null, "Please enter a number");
                	  return;
                  }
                   
                   

                   if (nameField3.getText().isEmpty()) {
                       JOptionPane.showMessageDialog(null, "You need to enter an ISBN!!");
                       return;
                   }
	                


	    
	    Book n = new Book(isbn,name,author,genre,true,false);
	   
	    JOptionPane.showMessageDialog(null, "Book Added successfully!"); //show message
	    JOptionPane.showMessageDialog(null, "The book you added: "+ n.toString());
	    dispose(); // Close the window after account creation
	    
	            }
	            });
	       panel.add(title);
	       panel.add(nameField);
	       panel.add(author);
	       panel.add(nameField1);
	       panel.add(genre);
	       panel.add(nameField2);
	       panel.add(ISBN);
	       panel.add(nameField3);
	       panel.add(submitButton);
	       getContentPane().add(panel);
 	    }
    }
    
    class CreateAccountUser extends JFrame {
   	 private JTextField nameField;
	    private JTextField ageField;
	    private JComboBox<String> genderCombo;
       public CreateAccountUser() {
       	 setTitle("Create New Account");
	        setSize(600, 500);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       	setLocationRelativeTo(null);

	        JPanel panel = new JPanel(new GridLayout(8, 1));
	       panel.setBackground(new Color(240, 240, 240));
	        JLabel nameLabel = new JLabel("Name of user:");
	        nameLabel.setBackground(new Color(190, 215, 220));
	        nameField = new JTextField();
	        nameField.setBackground(new Color(179, 200, 207)); // light gray

	        JLabel ageLabel = new JLabel("Age:");
	        ageLabel.setBackground(new Color(190,215,220));
	        ageField = new JTextField();
	        ageField.setBackground(new Color(179, 200, 207));

	        JLabel genderLabel = new JLabel("Gender:");
	       
	        String[] genders = {"Male", "Female", "Walmart Bag","Other"}; // Options for gender selection
	        genderCombo = new JComboBox<>(genders); // Combo box initialized with gender options
	        genderCombo.setBackground(new Color(245, 245, 245));

	        JButton submitButton = new JButton("Submit");

	       submitButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        JButton backButton = new JButton("Go Back");

	       backButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
	       backButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Close the current window
	                dispose();
	                // Go back to the previous window (in this case, assuming it's the role User)
	                handleRoleSelection("User");
	            }
	        });
	        submitButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String name ;
	                try {
	                name= nameField.getText(); //get text from the textfield whih is inputed.
	                }
	                catch(InputMismatchException eq) {
	                	 JOptionPane.showMessageDialog(null,"please enter a string not anything else");
	                	 return;
	                }
  
	                if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a name to create an account.");
                        return;
                    }
                    try {
                    Integer.parseInt(name);
                    JOptionPane.showMessageDialog(null, "Name must be a string.");
                    return;
                   }
                    catch (NumberFormatException ex) {
                    // Name is not a number, so its valid.
                    	       }

                    int age;
                    try {
                        age = Integer.parseInt(ageField.getText());
                        if (age < 18 || age > 100) {
                            JOptionPane.showMessageDialog(null, "Age must be between 18 and 100.");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, " Please enter a number.");
                        return;
                    }

                    if (ageField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You need to enter an age!!");
                        return;
                    }
	                String gender = (String) genderCombo.getSelectedItem();


	    int lcd = (int) (Math.random() * 900) + 100;
	    User n = new User(name,age,gender,lcd);
	    users.add(n);
	    JOptionPane.showMessageDialog(null, "Account created successfully!"); //show message
	    JOptionPane.showMessageDialog(null, "Your Library card number is "+lcd+ " (MEMORIZE IT!!) ");
	    dispose(); // Close the window after account creation
	    openUserPanel();
	            }
	            });

panel.add(nameLabel);
panel.add(nameField);
panel.add(ageLabel);
panel.add(ageField);
panel.add(genderLabel);
panel.add(genderCombo);
panel.add(submitButton);
panel.add(backButton);
getContentPane().add(panel);
//add the JPanel (panel) to the content pane of the JFrame
    
       }
   }
    class CreateAccountWindow extends JFrame {
        private JTextField nameField;
        private JTextField ageField;
        private JComboBox<String> genderCombo;

        public CreateAccountWindow() {
            setTitle("Create New Account");
            setSize(600, 500);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(8, 2));

            JLabel nameLabel = new JLabel("Name:");
            nameField = new JTextField();
nameField.setBackground(new Color(245, 245, 245)); // light gray
            JLabel ageLabel = new JLabel("Age:");
            ageField = new JTextField();
ageField.setBackground(new Color(245,245,245));
            JLabel genderLabel = new JLabel("Gender:");
            String[] genders = {"Male", "Female", "Walmart Bag", "Other"};
            genderCombo = new JComboBox<>(genders);
genderCombo.setBackground(new Color(245,245,245));
            JButton submitButton = new JButton("Submit");
            JButton backButton = new JButton("Go Back");

            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    handleRoleSelection("Librarian");
                }
            });

            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a name to create an account.");
                        return;
                    }
                    try {
                    Integer.parseInt(name);
                    JOptionPane.showMessageDialog(null, "Name must be a string.");
                    return;
                   }
                    catch (NumberFormatException ex) {
                    // Name is not a number, so its valid.
                    	       }
                    int age;
                    try {
                        age = Integer.parseInt(ageField.getText());
                        if (age < 18 || age > 100) {
                            JOptionPane.showMessageDialog(null, "Age must be between 18 and 100.");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a number.");
                        return;
                    }

                    if (ageField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You need to enter an age!!");
                        return;
                    }

                    String gender = (String) genderCombo.getSelectedItem();

                    int id;
                    try {
                        id = (int) (Math.random() * 90000) + 10000;
                    } catch (ArithmeticException ex) {
                        JOptionPane.showMessageDialog(null, "Error generating ID. Please try again.");
                        return;
                    }

                    try {
                       Librarian newLibrarian = new Librarian(name, age, gender, id);
                       librarian.add(newLibrarian);
                      // newLibrarian.readDataFromFileL();
                     //  newLibrarian.writeDataToFileL();
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, "Error creating Librarian. Please try again.");
                        return;
                    }

                    JOptionPane.showMessageDialog(null, "Account created successfully!");
                    JOptionPane.showMessageDialog(null, "Your ID is " + id + " (MEMORIZE THE ID!!) ");
                    dispose();
                    openLibrarianPanel();
                }
            });

            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(ageLabel);
            panel.add(ageField);
            panel.add(genderLabel);
            panel.add(genderCombo);
            panel.add(submitButton);
            panel.add(backButton);

            getContentPane().add(panel);
        }
    }
    class LibAccount extends JFrame {
 	   private JTextField nameField;
 	    private JTextField ageField;
 	    private JComboBox<String> genderCombo;
 	    public LibAccount() {
 	    	 setTitle("Create New Account");
             setSize(400, 300);
             setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             setLocationRelativeTo(null);

             JPanel panel = new JPanel(new GridLayout(8, 2));

             JLabel nameLabel = new JLabel("Name:");
             nameField = new JTextField();

             JLabel ageLabel = new JLabel("Age:");
             ageField = new JTextField();

             JLabel genderLabel = new JLabel("Gender:");
             String[] genders = {"Male", "Female", "Walmart Bag", "Other"};
             genderCombo = new JComboBox<>(genders);

             JButton submitButton = new JButton("Submit");

             submitButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     String name = nameField.getText();
                     if (name.isEmpty()) {
                         JOptionPane.showMessageDialog(null, "Please enter a name to create an account.");
                         return;
                     }
                     try {
                     Integer.parseInt(name);
                     JOptionPane.showMessageDialog(null, "Name must be a string.");
                     return;
                    }
                     catch (NumberFormatException ex) {
                     // Name is not a number, so its valid.
                     	       }

                     int age;
                     try {
                         age = Integer.parseInt(ageField.getText());
                         if (age < 18 || age > 100) {
                             JOptionPane.showMessageDialog(null, "Age must be between 18 and 100.");
                             return;
                         }
                     } catch (NumberFormatException ex) {
                         JOptionPane.showMessageDialog(null, "Please enter a number.");
                         return;
                     }

                     if (ageField.getText().isEmpty()) {
                         JOptionPane.showMessageDialog(null, "You need to enter an age!!");
                         return;
                     }

                     String gender = (String) genderCombo.getSelectedItem();

                     int id;
                     try {
                         id = (int) (Math.random() * 90000) + 10000;
                     } catch (ArithmeticException ex) {
                         JOptionPane.showMessageDialog(null, "Error generating ID. Please try again.");
                         return;
                     }


                     try {
                        Librarian newLibrarian = new Librarian(name, age, gender, id);
                        librarian.add(newLibrarian);
                     } catch (IllegalArgumentException ex) {
                         JOptionPane.showMessageDialog(null, "Error creating Librarian. Please try again.");
                         return;
                     }

                     JOptionPane.showMessageDialog(null, "Account created successfully!");
                     JOptionPane.showMessageDialog(null, "Your ID is " + id + " (MEMORIZE THE ID!!) ");
                     dispose();
                 }
             });

             panel.add(nameLabel);
             panel.add(nameField);
             panel.add(ageLabel);
             panel.add(ageField);
             panel.add(genderLabel);
             panel.add(genderCombo);
             panel.add(submitButton);

             getContentPane().add(panel);
         }
    
 }
    class UserAccount extends JFrame {
  	   private JTextField nameField;
  	    private JTextField ageField;
  	    private JComboBox<String> genderCombo;
  	    public UserAccount() {
  	    	 setTitle("Create New Account");
 	        setSize(400, 300);
 	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	setLocationRelativeTo(null);

 	        JPanel panel = new JPanel(new GridLayout(7, 1));
 	       panel.setBackground(new Color(240, 240, 240));
 	        JLabel nameLabel = new JLabel("Name of user:");
 	        nameLabel.setBackground(new Color(71, 147, 175));
 	        
 	        nameField = new JTextField();
 nameField.setBackground(new Color(255, 196, 112));

 	        JLabel ageLabel = new JLabel("Age:");
 	        ageField = new JTextField();
 	      
 	        JLabel genderLabel = new JLabel("Gender:");
 	        
 	        
 	        String[] genders = {"Male", "Female", "Walmart Bag","Other"}; // Options for gender selection
 	        genderCombo = new JComboBox<>(genders); // Combo box initialized with gender options

 	        JButton submitButton = new JButton("Submit");

 	       submitButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
 	        

 	    
 	        submitButton.addActionListener(new ActionListener() {
 	            public void actionPerformed(ActionEvent e) {
 	                String name ;
 	                try {
 	                name= nameField.getText(); //get text from the textfield whih is inputed.
 	                }
 	                catch(InputMismatchException eq) {
 	                	 JOptionPane.showMessageDialog(null,"please enter a string not anything else");
 	                	 return;
 	                }
   
 	                if (name.isEmpty()) {
                         JOptionPane.showMessageDialog(null, "Please enter a name to create an account.");
                         return;
                     }
                     try {
                     Integer.parseInt(name);
                     JOptionPane.showMessageDialog(null, "Name must be a string.");
                     return;
                    }
                     catch (NumberFormatException ex) {
                     // Name is not a number, so its valid.
                     	       }

                     int age;
                     try {
                         age = Integer.parseInt(ageField.getText());
                         if (age < 18 || age > 100) {
                             JOptionPane.showMessageDialog(null, "Age must be between 18 and 100.");
                             return;
                         }
                     } catch (NumberFormatException ex) {
                         JOptionPane.showMessageDialog(null, " Please enter a number.");
                         return;
                     }

                     if (ageField.getText().isEmpty()) {
                         JOptionPane.showMessageDialog(null, "You need to enter an age!!");
                         return;
                     }
 	                String gender = (String) genderCombo.getSelectedItem();

 	    int lcd = (int) (Math.random()*900)+100;
 	    
 	    lib.AddUser(name, age, gender, lcd);
 	    
 	    JOptionPane.showMessageDialog(null, "Account created successfully!"); //show message
 	    JOptionPane.showMessageDialog(null, "Your Library card number is "+lcd+ " (MEMORIZE IT!!) ");
 	    dispose(); // Close the window after account creation
 	            }
 	            });
 panel.add(nameLabel);
 panel.add(nameField);
 panel.add(ageLabel);
 panel.add(ageField);
 panel.add(genderLabel);
 panel.add(genderCombo);
 panel.add(submitButton);

 getContentPane().add(panel);
 //add the JPanel (panel) to the content pane of the JFrame
  
 
        }
  	    }
 }

package Project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import static Project.Book.books;
import static Project.User.users;

public class Librarian extends Person implements Librarian_Procedures {
	private int employeeID;
    static LinkedList<Librarian> librarian = new LinkedList<>();

    
	public Librarian(String n, int a, String g, int empID) {
		super(n, a, g);
		this.employeeID=empID;
	}
	public Librarian(Librarian newLib) {
		 super(newLib.getName(), newLib.getAge(), newLib.getGender());
	        this.employeeID = newLib.employeeID;
	}

	public String AddLibrarian(String name,int age,String gender, int eid) {
		
		if (age < 18 || age>100) {
	        throw new IllegalArgumentException("Age must be between 18 and 100");
	    }

		else {
			boolean ID=false;
		 for (Librarian librarians: librarian) {
	  if (eid==librarians.getEmployeeID()) {
		  ID=true;
		  break;
	  }
	  
	  }
		
			 
		Librarian lib_jdid = new Librarian(name, age, gender, eid);
		boolean flag = false;
        for (Librarian u : librarian) {
        	
            if (lib_jdid.getName().equalsIgnoreCase(u.getName())) {
             flag = true;  
             return "already esmak mawjud 3enna";
            }
            }
             if (!flag) {
 	            librarian.add(lib_jdid);
 	            return "librarian added successfully!";
             }
             }
 	      return "Library card exists already";
 	}
	
	
	@Override
	public String toString() {
		return super.toString()+ " ,employeeID: " + employeeID ;
	}
	//HAVE A flag here if book does not exist
	@Override
	public String SearchBookByTitle(String title) {
		boolean flag=false;
    for(Book book: books) {
    	if(book.getTitle().equalsIgnoreCase(title)) {
    		flag=true;
    		return "book with this title: "+book.getTitle().toString()+" is found";
    	}
    }
    
   return "No book found by this title: "+title;
    
		
	}
	//HAVE A flag here if books do not exist

	@Override
	public String SearchBookByAuthor(String authorName) {
	    StringBuilder result = new StringBuilder();
	    boolean flag = false;
	    for (Book book : books) {
	        if (book.getAuthor().equalsIgnoreCase(authorName)) {
	            flag = true;
	         result.append("Book: ").append(book.getTitle()).append("\n");
	        result.append("Author: ").append(book.getAuthor()).append("\n");
	      result.append("--------------------\n");
	        }
	    }
	    if (flag) {
	        return "Books by author " + authorName + ":\n" + result.toString();
	    } else {
	        return "No books found by author " + authorName;
	    }
	}
	//HAVE A flag here if books do not exist (done)

	@Override
	public String SearchBookByGenre(String genre) {
		boolean flag =false;
		for(Book book: books) {
	   if(book.getGenre().equalsIgnoreCase(genre)) {
		   flag=true;
		 return "book in "+book.getGenre().toString()+"genre is found" ;

			   }
		   	}
 return "book in this genre: "+genre+" not found";
			   
		
	}

	@Override
	public String AddUser(String name, int age, String gender, int lcnum) {
	    if (age < 18 || age>100) {
	        throw new IllegalArgumentException("Age must be between 18 and 100");
	     
	    }
	    boolean IDuserE= false;
	    for (User u : users) {
	        if (lcnum==u.getLibraryCardNum()) {
	            IDuserE= true;
	            break;
	        }
	    }
	    if (IDuserE) {
	        User u_jdid = new User(name, age, gender, lcnum);
	        boolean flag = false;
	        for (User u : users) {
	        	
	            if (u_jdid.getName().equalsIgnoreCase(u.getName())) {
	             flag = true;  
	             return "already esmak mawjud 3enna";
	                
	                
	            }
	        }
	        if (flag) {
	            users.add(u_jdid);
	            return "librarian added successfully!";
	            
	        }
	    }
	      return "Library card number already exists.";
	       
	    
	}

	@Override
	public void AddBooks(int ISBN, String title, String author, String genre, boolean availability, boolean reserved) {
		 Book newBook = new Book(ISBN, title, author, genre, availability, reserved);
		 books.add(newBook);
		 System.out.println("book added successfully!");
		
	}

	@Override
    public String Check_Information() {
        return toString();
    }

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	 public void readDataFromFileL() {
		         String folderPath = "C:\\Users\\user\\eclipse-workspace\\SEM2\\src\\Project";
		         String fileName = "Librarian.txt";
		 
		         try (BufferedReader reader = new BufferedReader(new FileReader(folderPath + "\\" + fileName))) {
		             String line;
		           while ((line = reader.readLine()) != null) {
		                 String[] parts = line.split(",");
		                int id = Integer.parseInt(parts[0]);
		                 String name = parts[1];
		                 int age = Integer.parseInt(parts[2]);
		                 String gender = parts[3];
		               Librarian librarian = new Librarian(name, age, gender, id);
		                 Librarian.librarian.add(librarian);
		            }
		         } catch (IOException e) {
		            
		         }
		     }
		 
		     public void writeDataToFileL() {
		         String folderPath = "C:\\Users\\user\\eclipse-workspace\\SEM2\\src\\Project";
		         String fileName = "Librarian.txt";
		 
		         try (PrintWriter writer = new PrintWriter(new FileWriter(folderPath + "\\" + fileName))) {
		             for (Librarian librarian : Librarian.librarian) {
		                 writer.println(librarian.getEmployeeID() + "," + librarian.getName() + "," + librarian.getAge() + "," + librarian.getGender());
		             }
		         } catch (IOException e) {
		             
		         }
		     }
}

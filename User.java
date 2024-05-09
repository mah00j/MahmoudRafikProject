package Project;

import static Project.Book.books;

import java.util.LinkedList;

public class User extends Person implements User_Procedures {
private int LibraryCardNum;
static LinkedList<User> users = new LinkedList<>();


	public User(String n, int a, String g, int lcn) {
		super(n, a, g);
		this.LibraryCardNum=lcn;
	}
	
	public User(User users) {
		super(users.getName(),users.getAge(),users.getGender());
		this.LibraryCardNum=users.LibraryCardNum;
	}
	
	public int getLibraryCardNum() {
		return LibraryCardNum;
	}
	public void setLibraryCardNym(int lcn) {
		LibraryCardNum = lcn;
	}
	// copied the searching classes from the librarian class
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
	public String BorrowBook(String title) {
for(Book book: books) {
	if(book.getTitle().equalsIgnoreCase(title)) {
		if(book.getAvailability() && !book.getReserved()) {
			book.setAvailability(false);
			return "Book "+ title+ " is borrowed";
		}
	}
}
		return title+ "Cant be borrowed";
	}
	
	@Override
	public String ReturnBook(String title) {
for(Book book: books) {
	if(book.getTitle().equalsIgnoreCase(title)) {
		if(!book.getAvailability() && !book.getReserved()) {
			book.setAvailability(true);
			return "Book "+ title+ " is returned";
		}
		
		
		
	}
}
		return title+" cant be returned";
	}
	@Override
	public String ReserveBook(String title) {
		for(Book book: books) {
	if(book.getTitle().equalsIgnoreCase(title)) {
		if(book.getAvailability() && !book.getReserved()) {
		    book.setReserved(true);;
			return "Book "+title+ " is reserved";
				}
		
		
				}
		}
		return title+" Cant be reserved";
	}
	@Override
	public String Check_Information() {
return toString()+ " ,library card number: "+ LibraryCardNum;

		
	}

	@Override
	public String toString() {
		return super.toString();
	}



}

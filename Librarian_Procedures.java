package Project;

public interface Librarian_Procedures {

   public String SearchBookByTitle(String title);
   public String SearchBookByAuthor(String name);
   public String SearchBookByGenre(String genre);
   public String AddUser(String name,int age,String gender, int lcnum);
   public void AddBooks(int ISBN, String title, String author, String genre, boolean availability, boolean reserved);
	
}

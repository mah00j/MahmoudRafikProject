package Project;

public interface User_Procedures {
   public String SearchBookByTitle(String title);
   public String SearchBookByAuthor(String name);
   public String SearchBookByGenre(String genre);
   public String BorrowBook(String title);
   public String ReturnBook(String title);
   public String ReserveBook(String title);

}

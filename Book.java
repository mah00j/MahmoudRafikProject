package Project;
import java.util.*;
public class Book {
private int ISBN;
private String title;
private String Author;
private String genre;
private Boolean Availability;
private Boolean Reserved;
static LinkedList<Book> books = new LinkedList<>();

public Book(int ISBN, String title, String author, String genre, boolean availability, boolean reserved) {
    this.ISBN = ISBN;
    this.title = title;
    this.Author = author;
    this.genre = genre;
    this.Availability = availability;
    this.Reserved = reserved;
}

public Book(Book otherBook) {
    this.ISBN = otherBook.ISBN;
    this.title = otherBook.title;
    this.Author = otherBook.Author;
    this.genre = otherBook.genre;
    this.Availability = otherBook.Availability;
    this.Reserved = otherBook.Reserved;
}

public int getISBN() {
	return ISBN;
}
public void setISBN(int iSBN) {
	ISBN = iSBN;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public String getAuthor() {
	return Author;
}

public void setAuthor(String author) {
	Author = author;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public Boolean getAvailability() {
	return Availability;
}

public void setAvailability(Boolean availability) {
	Availability = availability;
}

public Boolean getReserved() {
	return Reserved;
}

public void setReserved(Boolean reserved) {
	Reserved = reserved;
}

@Override
public String toString() {
    return " Title: " + title +","+ " ISBN: " + ISBN +","+ " Author: " + Author +","+ " Genre: " + genre;
}

}

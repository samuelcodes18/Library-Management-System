package lib.items; 
 
// Parent class representing a library items(books) 
public class LibraryEntity { 
    protected String title; 
    protected int identifier; 
 
    public LibraryEntity(String title, int identifier) { 
        this.title = title; 
        this.identifier = identifier; 
    } 
 
    public void showDetails() { 
        System.out.println("Title: " + title + ", ID: " + identifier); 
    } 
}
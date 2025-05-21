package lib.items; 
 
// Book class inheriting from LibraryEntity and implementing Rentable 
public class Book extends LibraryEntity implements Rentable { 
    private final String writer; 
    private int quantittyy; 
 
    public Book(String title, int identifier, String writer, int quantittyy) throws InventoryException { 
        super(title, identifier); 
        this.writer= writer; 
        if (quantittyy<0) { 
            throw new InventoryException("Stock cannot be negative number!"); 
        } 
        this.quantittyy= quantittyy; 
    } 
 
    @Override 
    public boolean borrowItem(int amount) { 
        if (amount>quantittyy) { 
            return false; 
        } 
        quantittyy -= amount; 
        return true; 
    } 
 
    @Override 
    public void showDetails() { 
        System.out.println("Title: " + title + ", ID: " + identifier + ", Author: " + writer + ", Available: " + quantittyy); 
    } 
 
    public int getQuantity() { 
        return quantittyy; 
    } 
 
    public String getTitle() { 
        return title; 
    } 
}
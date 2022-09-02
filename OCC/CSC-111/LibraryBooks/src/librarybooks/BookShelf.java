/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarybooks;

/**
 *
 * @author Trev
 */
public class BookShelf 
{
    private final int SHELF_SIZE = 10;
    private Book shelf[];
    private int numBooks;
    
    public BookShelf()
    {
        numBooks = 0;
        shelf = new Book[SHELF_SIZE];
    }
    
    public void addBook(String title, String author, String type, String isbn)
    {
        if(numBooks == shelf.length)
        {
            increaseSize();
        }
        
        Book temp = new Book(title, author, type, isbn);
        shelf[numBooks] = temp;
        numBooks++;
    }
    
    public void addBook(Book temp)
    {
        if(numBooks == shelf.length)
        {
            increaseSize();
        }
                
        shelf[numBooks] = temp;
        numBooks++;
    }
    
    public String toString()
    {
        String msg = "";
        
        msg += "----- Books on Shelf -----\n";
        for(int index = 0; index < numBooks; index++)
        {
            msg += shelf[index].toString();
            msg += "\n";
        }
        
        msg += "Number of Books on Shelf: " + numBooks + "\n";
        
        return msg;
    }
    
    private void increaseSize()
    {
        Book temp [] = new Book[shelf.length * 2];
        
        for(int index = 0; index < shelf.length; index++)
        {
            temp[index] = shelf[index];
        }
        
        shelf = temp;
    }
}

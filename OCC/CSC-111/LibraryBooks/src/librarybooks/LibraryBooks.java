package librarybooks;

/**
 *
 * @author Trev
 */
public class LibraryBooks
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Book book1 = new Book();
        Book book2 = new Book("Starting Out With Java", "Trevor Butler", "Science",
            "0123654789");
        
//        System.out.println(book1);
//        System.out.println(book2);
        
        BookShelf myShelf = new BookShelf();
        myShelf.addBook("Intro To C#", "Kyle Elliot", "Science", "9874563210");
        myShelf.addBook("Intro To C++", "Tim Scheemaker", "Science", "4569874123");
        myShelf.addBook(book1);
        myShelf.addBook(book2);
        
        System.out.print(myShelf);
        

    }
    
}

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
public class Book 
{
    private String title;
    private String author;
    private String type;
    private String isbn;

    public Book()
    {
        title = author = type = isbn = "N/A";
    }

    public Book(String t, String a, String ty, String num)
    {
        title = t;
        author = a;
        type = ty;
        isbn = num;
    }
    
    public String toString()
    {
        String msg = "";
        
        msg += "Book Title: " + title + "\n";
        msg += "Book Author: " + author + "\n";
        msg += "Type of Book: " + type + "\n";
        msg += "ISBN of Book: " + isbn + "\n";
        
        return msg;
    }
}




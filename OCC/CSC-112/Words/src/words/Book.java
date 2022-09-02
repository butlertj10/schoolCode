/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

/**
 *
 * @author speciosr
 */
public class Book 
{
    protected int pages = 1500;

    public Book() {
        System.out.println("Book Default Constructor");
    }
    
    public Book(int pages) {
        System.out.println("Book Constructor");
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }  

    @Override
    public String toString() {
        return "Book{" + "pages=" + pages + '}';
    }
    
    
}

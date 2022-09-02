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
public class Dictionary extends Book
{
    private int definitions = 52500;

    public Dictionary() {
        System.out.println("Dictionary Default Constructor");
    }

    public Dictionary(int definitions, int pages) 
    {
        //super(pages);
        this.pages = pages;
        this.definitions = definitions;
        System.out.println("Dictionary Constructor");
    }
    
    public double computeRatio()
    {
        return (double)definitions / pages;
    }
    
    public int getDefinitions() 
    {
        return definitions;
    }

    public void setDefinitions(int definitions) 
    {
        this.definitions = definitions;
    }

    @Override
    public String toString() {
        return "Definitions:" + definitions + 
                super.toString() + getPages() + '}';
    }
}

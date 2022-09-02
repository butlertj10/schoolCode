/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

/**
 *
 * @author t.j.butler2
 */
public class TreeNode<T>
{
    private T element;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode()
    {
        element = null;
        left = right = null;
    }
    
    public TreeNode(T element)
    {
        this.element = element;
        left = right = null;
    }
    
    public TreeNode(T element, TreeNode<T> left, TreeNode<T> right)
    {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public T getElement() 
    {
        return element;
    }

    public void setElement(T element) 
    {
        this.element = element;
    }

    public TreeNode<T> getLeft() 
    {
        return left;
    }

    public void setLeft(TreeNode<T> left) 
    {
        this.left = left;
    }

    public TreeNode<T> getRight() 
    {
        return right;
    }

    public void setRight(TreeNode<T> right) 
    {
        this.right = right;
    }
    
    public int numChildren()
    {
        int children = 0;
        
        if (left != null)
            children = 1 + left.numChildren();
        
        if(right != null)
            children = children + 1 + right.numChildren();
        
        return children;
    }
}

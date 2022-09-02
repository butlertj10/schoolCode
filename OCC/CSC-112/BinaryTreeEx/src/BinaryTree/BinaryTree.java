/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author t.j.butler2
 */
public class BinaryTree <T extends Comparable> implements BinaryTreeADT<T>
{

    TreeNode<T> root;
    
    public BinaryTree()
    {
        root = null;
    }
    
    public BinaryTree(T element)
    {
        root = new TreeNode(element);
    }
    
    public void addElement(T element)
    {
        root = addElement(root, element);
    }
    
    private TreeNode<T> addElement(TreeNode<T> node, T element)
    {
        if (node == null)
            node = new TreeNode<T>(element);
        else if(element.compareTo(node.getElement()) < 0 )
            node.setLeft(addElement(node.getLeft(), element));
        else
            node.setRight(addElement(node.getRight(), element));
           
        return node;
    }
    
    @Override
    public T getRootElement() 
    {
        T temp = null;
        
        if (root != null)
            temp = root.getElement();
        
        return temp;
    }

    @Override
    public boolean isEmpty() 
    {
        return (root == null);
    }

    @Override
    public int size() 
    {
        int count = 0;
        
        if (root == null)
            count = 0;
        else
            count = root.numChildren() + 1;
        
        return count;
    }

    @Override
    public boolean contains(T target) 
    {
        boolean found = false;
        T temp;
        
        temp = find(target);
        if(temp != null)
            found = true;
        
        return found;
    }

    @Override
    public T find(T target) 
    {
        TreeNode<T> current = FindNode(target, root);
        T temp = null;
        
        if(current != null)
            temp = current.getElement();
        
        return temp;
    }

    @Override
    public Iterator<T> iterator()
    {
        return iteratorInOrder();
    }

    
    @Override
    public Iterator<T> iteratorInOrder() 
    {
        ArrayList<T> tempList = new ArrayList<T>();
        
        inOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }
    
    
    
    private void inOrder(TreeNode<T> node, ArrayList<T> tempList)
    {
        if(node != null)
        {
            inOrder(node.getLeft(), tempList);
            tempList.add(node.getElement());
            inOrder(node.getRight(), tempList);
        }
    }
    
    
    
    private void preOrder(TreeNode<T> node, ArrayList<T> tempList)
    {
        if(node != null)
        {
            
            tempList.add(node.getElement());
            preOrder(node.getLeft(), tempList);
            preOrder(node.getRight(), tempList);
        }
    }

    
    
    @Override
    public Iterator<T> iteratorPreOrder() 
    {
        ArrayList<T> tempList = new ArrayList<T>();
        
        preOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    
    
    @Override
    public Iterator<T> iteratorPostOrder() 
    {
        ArrayList<T> tempList = new ArrayList<T>();
        
        inOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());    
    }
    
    
    
    private void postOrder(TreeNode<T> node, ArrayList<T> tempList)
    {
        if(node != null)
        {
            postOrder(node.getLeft(), tempList);
            postOrder(node.getRight(), tempList);
            tempList.add(node.getElement());
        }
    }
    
    
    
    private class TreeIterator implements Iterator<T>
    {
        private Iterator<T> iter;
        
        public TreeIterator(Iterator<T> iter)
        {
            this.iter = iter;
        }
        
        @Override
        public boolean hasNext() 
        {
            return (iter.hasNext());
        }

        @Override
        public T next() 
        {
            T temp = null;
            
            if(hasNext())
                temp = iter.next();
            else
                throw new NoSuchElementException();
            
            return temp;
        }
    }
    
    private TreeNode<T> FindNode(T target, TreeNode<T> next)
    {
        TreeNode<T> temp = null;
        
        if(next != null)
        {
            if(next.getElement().equals(target))
                temp = next;
            else
            {
                temp = FindNode(target, next.getLeft());
                
                if(temp == null)
                    temp = FindNode(target, next.getRight());
            }
        }
        
        return temp;
    }
}

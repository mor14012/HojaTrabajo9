import java.util.Iterator;
import java.util.Comparator;
// This is a implementation of splay trees, in Java.
// (c) 1996, 1997, 1998, 2001 duane a. bailey
// (c) 1998, 2001 duane a. bailey

/**
 * An implementation of binary search trees, based on a splay operation
 * by Tarjan et al.  An extension of the binary search tree class that decreases
 * the likelyhood of a binary tree becomming degenerate.
 * @version $Id: SplayTree.java 35 2007-08-09 20:38:38Z bailey $
 * @author, 2001 duane a. bailey
 */
public class SplayTree<E extends Comparable<E>>
    extends BinarySearchTree<E> 
{
    /**
     * Construct an empty search tree
     * @post construct a new splay tree
     */
    public SplayTree()
    {
    this(new NaturalComparator<E>());
    
    }

    public SplayTree(Comparator<E> alternateOrder)
    {
        super(alternateOrder);
    }
   
    /**
     * Add a value to the splay tree.
     * @post adds a value to the binary search tree
     * @param val The value to be xadded.
     */
    public void add(E val)
    {
	
        BinaryTree<E> newNode = new BinaryTree<E>(val,EMPTY,EMPTY);

        // add value to binary search tree 
        // if there's no root, create value at root.
        if (root.isEmpty())
        {
            root = newNode;
        }
        else
        {
            BinaryTree<E> insertLocation = locate(root,val);
            E nodeValue = insertLocation.value();

            // The location returned is the successor or predecessor
            // of the to-be-inserted value.

            if (ordering.compare(nodeValue,val) < 0) {
                insertLocation.setRight(newNode);
            } else {
                if (!insertLocation.left().isEmpty()) {
                    // if value is in tree, we insert just before
                    predecessor(insertLocation).setRight(newNode);
                } else {
                    insertLocation.setLeft(newNode);
                }
            }
            splay(root = newNode);
        }
        count++;
    }
	
	
    /**
     * Determine if a particular value is within the search tree.
     * @post returns true iff val is a value found within the tree
     * @param val The comparable value to be found.
     * @return True iff the comparable value is within the tree.
     */
    public boolean contains(E val)
    {
        if (root.isEmpty()) return false;

        BinaryTree<E> possibleLocation = locate(root,val);
        if (val.equals(possibleLocation.value())) {
            splay(root = possibleLocation);
            return true;
        } else {
            return false;
        }
    }

	
	
    /**
     * Fetch a reference to the comparable value in the tree.
     * Resulting value may be inspected, but should not be modified in
     * a way that might change its position within tree.
     * @post returns object found in tree, or null
     * @param val The value to be sought in tree.
     * @return A reference to the value within the tree.
     */
    public E get(E val)
    {
        if (root.isEmpty()) return null;

        BinaryTree<E> possibleLocation = locate(root,val);
        splay(root = possibleLocation);
        if (val.equals(possibleLocation.value()))
            return possibleLocation.value();
        else
            return null;
    }

    /**
     * Remove a comparable value from the tree.
     * @post removes one instance of val, if found
     * @param val The value to be removed.
     * @return The actual value removed.
     */
    public E remove(E val) 
    {
        if (isEmpty()) return null;
      
        if (val.equals(root.value())) // delete root value
        {
            BinaryTree<E> newroot = removeTop(root);
            count--;
            E result = root.value();
            root = newroot;
            return result;
        }
        else
        {
            BinaryTree<E> location = locate(root,val);

            if (val.equals(location.value())) {
                count--;
                BinaryTree<E> parent = location.parent();
                if (parent.right() == location) {
                    parent.setRight(removeTop(location));
                } else {
                    parent.setLeft(removeTop(location));
                }
                splay(root = parent);
                return location.value();
            }
        }
        return null;
    }

	
	
    protected void splay(BinaryTree<E> splayedNode)
    {
        BinaryTree<E> parent,grandParent;

        while ((parent = splayedNode.parent()) != null)
        {
            if ((grandParent = parent.parent()) == null)
            {
                if (splayedNode.isLeftChild()) parent.rotateRight();
                else parent.rotateLeft();
            }
            else
            {
                if (parent.isLeftChild())
                {
                    if (splayedNode.isLeftChild())
                    {
                      
                        grandParent.rotateRight();
                        parent.rotateRight();
                    }
                    else
                    {
                        parent.rotateLeft();
                        grandParent.rotateRight();
                    }
                }
                else
                {
                    if (splayedNode.isRightChild()) {
                        grandParent.rotateLeft();
                        parent.rotateLeft();
                    }
                    else
                    {
                        parent.rotateRight();
                        grandParent.rotateLeft();
                    }
                }
            }
        }
    }

     /**
     * Construct a string that represents the splay tree.
     * @post returns string representation
     * @return A string representing the tree.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<SplayTree: size="+count+" root="+root+">");
        return s.toString();
    }
}


package bst;

public class binarySearchTree<E extends Comparable<E>> {
    bstNode<E> root;






    E findMaxInTree(bstNode root) {
        if (root.getRight() == null)
            return (E) root.getData();
        else
            return findMaxInTree(root.getRight());
    }

    E findMinInTree(bstNode root) {
        if (root.getLeft() == null)
            return (E) root.getData();
        else
            return findMinInTree(root.getLeft());
    }





    void printHelper(bstNode<E> node)
    {
        if(node==null)
            return;
        System.out.print(node.getData());

        if(node.getRight()==null && node.getLeft()==null)
            return;
        System.out.print("(");
        printHelper(node.getLeft());
        System.out.print(")");

        System.out.print("(");
        printHelper(node.getRight());
        System.out.print(")");

    }
    public void print()
    {
        if(root==null)
            return;

        printHelper(root);
        System.out.println();
    }









    bstNode<E> insertHelper(bstNode node,E x)
    {
        if(node==null) {
            node = new bstNode(x, null, null);
            return node;
        }
        if(node.getData().compareTo(x)<0)
            node.setRight(insertHelper(node.getRight(),x));
        else
            node.setLeft(insertHelper(node.getLeft(),x));
        return node;

    }
    public void insert(E x)
    {
        root=insertHelper(root,x);

    }




    boolean findHelper(bstNode root,E x)
    {
        if(root==null)
            return false;
        if(root.getData().equals(x))
            return true;
        else if(root.getData().compareTo(x)<0)
            return findHelper(root.getRight(),x);
        else
            return findHelper(root.getLeft(),x);

    }
    public boolean find(E x)
    {

        return findHelper(root,x);


    }



    bstNode<E> deleteHelper(bstNode<E> node,E x)
    {
        if(node==null)
        {
            //System.out.println("invalid operation");
            return null;
        }



        if(node.getData().compareTo(x)<0)
        {
            node.setRight(deleteHelper(node.getRight(),x));
            return node;
        }
        else if(node.getData().compareTo(x)>0)
        {
            node.setLeft(deleteHelper(node.getLeft(),x));
            return node;
        }
        else
        {
            if(node.getLeft()==null && node.getRight()==null)
                return null;
            else if(node.getRight()==null)
                return node.getLeft();
            else if(node.getLeft()==null)
                return node.getRight();
            else
            {
                E temp= findMaxInTree(node.getLeft()); // or we can use findMinInTree to search minimum in right subtree
                delete(temp);

                node.setData(temp);
                return node;
            }

        }




    }
    public void delete(E x) //delete will return true if delete is successful...we need it  because of the difference in output for two cases
    {

        root=deleteHelper(root,x);


    }














    void inOrderTraverseHelper(bstNode node) {
        if(node==null)
            return;
        inOrderTraverseHelper(node.getLeft());
        System.out.print(node.getData()+" ");
        inOrderTraverseHelper(node.getRight());
    }
    public void inOrderTraverse()
    {
        inOrderTraverseHelper(root);
        System.out.println();
    }


    void preOrderTraverseHelper(bstNode node) {
        if(node==null)
            return;

        System.out.print(node.getData()+" ");
        preOrderTraverseHelper(node.getLeft());
        preOrderTraverseHelper(node.getRight());
    }
    public void preOrderTraverse()
    {
        preOrderTraverseHelper(root);
        System.out.println();
    }



    void postOrderTraverseHelper(bstNode node) {
        if(node==null)
            return;

        postOrderTraverseHelper(node.getLeft());
        postOrderTraverseHelper(node.getRight());
        System.out.print(node.getData()+" ");
    }
    public void postOrderTraverse()
    {
        postOrderTraverseHelper(root);
        System.out.println();
    }





}
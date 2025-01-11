package bst;

class bstNode<E extends Comparable<E>> {

    private E data;
    private bstNode<E> left,right;

    public bstNode(E data, bstNode left, bstNode right)
    {
        this.data=data;
        this.left=left;
        this.right=right;
    }

    public bstNode<E> getLeft() {
        return left;
    }

    public bstNode<E> getRight() {
        return right;
    }

    public E getData() {
        return data;
    }


    public void setData(E data) {
        this.data = data;
    }

    public void setRight(bstNode<E> right) {
        this.right = right;
    }

    public void setLeft(bstNode<E> left) {
        this.left = left;
    }
}


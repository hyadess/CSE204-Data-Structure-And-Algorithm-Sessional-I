package List_Interface;

public interface LIst<E> {


    public void insert(E x);
    public void append(E x);
    public E remove();
    public void moveToStart();
    public void moveToEnd();
    public void prev();
    public void next();
    public void moveToPos(int x);
    public int currPos();
    public int length();
    public E getValue();
    public int search(E x);
    public void clear();




}

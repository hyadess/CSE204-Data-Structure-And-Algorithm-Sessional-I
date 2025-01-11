package Interfaces;

public interface stack<E> {

    void clear();
    void push(E x);
    E pop();
    int length();
    E topValue();
    void setDirection(int x);
    void print();

    void insert(E item,int offset);
    void remove(int offset);

}

package Linked_list_based_implementation;

import Interfaces.queue;

public class listQueue<E> implements queue<E> {

    Node head;
    Node tail;
    int size;


    public listQueue()
    {
        head=new Node(null,null);
        tail=head;
        size=0;
    }

    boolean emptyCheck()
    {
        if(length()==0)
        {
            System.out.println("queue is empty!!");
            return true;
        }
        return false;
    }


    @Override
    public void clear() {
        head=new Node(null,null);
        tail=head;
        size=0;
    }

    @Override
    public void enqueue(E item) {
        if(item==null)
            return;
        Node cur=new Node(item,null);

        if(length()==0)
            head.setNext(cur);
        tail.setNext(cur);

        tail=cur;
        size++;
    }

    @Override
    public E dequeue() {
        if(emptyCheck())
            return null;

        Node cur=head.getNext();
        head.setNext(cur.getNext());
        size--;
        return (E)cur.getData();
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public E frontValue() {
        if(emptyCheck())
            return null;
        return (E)head.getNext().getData();
    }

    @Override
    public E rearValue() {
        if(emptyCheck())
            return null;
        return (E)tail.getData();
    }

    @Override
    public E leaveQueue() {
        if(emptyCheck())
            return null;

        Node cur=head;
        while(cur.getNext()!=tail)
            cur=cur.getNext();
        tail=cur;
        cur=cur.getNext();
        tail.setNext(null);
        size--;
        if(length()==0)
            head.setNext(null);
        return (E)cur.getData();


    }
}

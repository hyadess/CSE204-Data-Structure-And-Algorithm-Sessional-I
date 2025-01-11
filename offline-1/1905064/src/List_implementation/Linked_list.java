package List_implementation;

import List_Interface.LIst;

import java.util.List;

public class Linked_list<E> implements LIst<E> {
    private node head;
    private node cur;
    private node tail;
    private int size;

    public Linked_list()
    {
        head=new node(0,null);
        cur=head;
        tail=head;
        size=0;

    }
    public Linked_list(E[] arr,int n)
    {
        head=new node(0,null);
        cur=head;
        tail=head;
        size=0;
        node flag=head;
        for(int i=0;i<n;i++)
        {
            node o=new node(arr[i],null);
            flag.setNext(o);
            flag=o;
            size++;
            if(i==n-1)
            {
                tail=o;
            }
        }
    }



    public void insert(E x)
    {
        node p=new node(x,cur.getNext());
        if(size==0){
            head.setNext(p);
            tail=p;
        }

        cur.setNext(p);
        size++;


    }
    public void append(E x)
    {
        node p=new node(x,null);
        if (size==0){
            head.setNext(p);
        }
        else {
           tail.setNext(p);
        }
        tail=p;
        size++;

    }
    public E remove()
    {
        node p=cur.getNext();
        if(size==0)
        {
            System.out.println("there is nothing to remove");
            return null;
        }
        if(cur==head)
        {
            head.setNext(p.getNext());
        }
        if(cur.getNext()==tail)
        {
            cur.setNext(null);
            tail=cur;
            prev();

        }
        else
            cur.setNext(p.getNext());
        size--;

        return (E)p.getData();
    }


    public void moveToStart()
    {
        cur=head;

    }
    public void moveToEnd()
    {
        moveToPos(size-1);

    }
    public void prev()
    {
        if(cur==head) {
            System.out.println("there is no previous position");
            return;
        }
        else
        {
            node p=head;
            while(p.getNext()!=cur)
                p=p.getNext();
            cur=p;
        }

    }
    public void next()
    {
        if(cur.getNext()==tail)
        {
            System.out.println("there is no next position");
            return;
        }
        else
            cur=cur.getNext();

    }
    public void moveToPos(int x)
    {
        node p=head;
        while(x>0)
        {
            p=p.getNext();
            x--;
        }
        cur=p;

    }
    public int currPos()
    {
        int flag=0;

        node o=head;
        while(o!=cur)
        {
            o=o.getNext();
            flag++;

        }
        return flag;

    }




    public int length()
    {
        return size;
    }
    public E getValue()
    {
        if(size==0)
        {
            System.out.println("there is no element");
            return null;
        }
        return (E)cur.getNext().getData();
    }
    public int search(E x)
    {
        int flag=-1;
        node p=head;
        while(true)
        {

            if(p.getData().equals(x)) {
                flag = 1;
                break;
            }
            if(p.getNext()==null)
                break;
            p=p.getNext();

        }


        return flag;

    }


    public void clear()
    {
        head=cur=tail=new node(0,null);
        size=0;

    }

}

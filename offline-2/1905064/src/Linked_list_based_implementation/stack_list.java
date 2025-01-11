package Linked_list_based_implementation;

import Array_based_implementation.stack_array;
import Interfaces.stack;

public class stack_list<E> implements stack<E> {
    int size;
    Node top;




    public stack_list()
    {
        top=new Node(null,null);
        size=0;
    }


    @Override
    public void print() {

        System.out.print("< ");
        Node cur=top;
        while(true)
        {
            if(cur.getData()==null)
                break;
            System.out.print(cur.getData()+" ");
            if(cur.getNext()==null)
                break;
            cur=cur.getNext();
        }
        System.out.println(">");
    }



    @Override
    public void clear() {
        size=0;
        top=new Node(null,null);


    }

    @Override
    public void push(E x) {
        if(size==0)
        {
            top.setData(x);

        }
        else
        {
            Node cur=new Node(x,top);
            top=cur;
        }
        size++;
    }

    @Override
    public E pop() {
        if(size==0)
        {
            System.out.println("there is nothing to pop");
            return null;
        }
        else
        {
            Node p=top;
            top=top.getNext();
            if(top==null)
                top=new Node(null,null);
            size--;
            return (E)p.getData();
        }
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public E topValue() {

        return (E)top.getData();
    }

    @Override
    public void setDirection(int x) {

    }

    @Override
    public void insert(E item, int offset) {

        stack_list<E> temp=new stack_list<>();

        int cur=offset;
        while(this.length()>0)
        {
            if(cur<0)
            {
                temp.push(item);
                cur=10000000;
            }
            temp.push(this.pop());
            cur--;
        }
        while(temp.length()>0)
            this.push(temp.pop());
    }

    @Override
    public void remove(int offset) {
        stack_list<E> temp=new stack_list<>();

        int cur=offset;
        E r;
        while(this.length()>0)
        {
            if(cur!=0)
            {
                temp.push(this.pop());
            }
            else
               r= this.pop();

            cur--;
        }
        while(temp.length()>0)
            this.push(temp.pop());

    }






}

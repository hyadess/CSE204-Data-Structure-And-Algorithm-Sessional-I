package Array_based_implementation;

import Interfaces.stack;

public class stack_array<E> implements stack<E> {

    E[] arr;
    private int size;
    private int max_size;
    private int direction;
    private int top;



    public stack_array(int max_size)
    {
        this.size=0;
        this.max_size=max_size;
        arr=(E[])new Object[max_size];
        direction=1;
        top=-1;
    }
    public stack_array(E[] arr,int direction)
    {
        this.arr=arr;
        max_size=arr.length;
        size=0;
        this.direction=direction;
        if(this.direction==-1)
            top=max_size;
        else
            top=-1;

    }


    public void print()
    {
        System.out.print("< ");
        if(direction==1)
        {
            for(int i=0;i<size;i++)
            {
                System.out.print(arr[i]+" ");
            }
        }
        else
        {
            for(int i=max_size-size;i<max_size;i++)
            {
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println(">");

    }



    void increase_size()
    {
        E[] arr=(E[])new Object[max_size*2];

        if(direction==1)
        {
            for(int i=0;i<size;i++)
            {
                arr[i]=this.arr[i];

            }
            this.arr=arr;
            max_size*=2;

        }
        else
        {
            for(int i=1;i<=size;i++)
            {
                arr[2*max_size-i]=this.arr[max_size-1];
            }
            this.arr=arr;
            max_size*=2;
            top=max_size-size;

        }
    }




    @Override
    public void clear() {
        arr=(E[])new Object[max_size];
        size=0;
        if(direction==-1)
            top=max_size;
        else
            top=-1;

    }

    @Override
    public void push(E x) {
        if(size==max_size)
            increase_size();
        if(direction==1)
            top++;
        else
            top--;
        arr[top]=x;
        size++;


    }

    @Override
    public E pop() {
        if(size==0)
        {
            System.out.println("there is nothing to pop");
            return null;
        }
        E p=arr[top];
        if(direction==1)
            top--;
        else
            top++;
        size--;
        return p;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public E topValue() {
        if(top==-1 || top==max_size)
            return null;
        return arr[top];
    }

    @Override
    public void setDirection(int x) {
        if(size!=0)
            System.out.println("stack is not empty");
        direction=x;
        if(x==1)
            top=-1;
        else
            top=max_size;
    }

    @Override
    public void insert(E item, int offset) {

        stack_array<E> temp=new stack_array<>(max_size);
        temp.setDirection(this.direction);
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
        stack_array<E> temp=new stack_array<>(max_size);
        temp.setDirection(this.direction);
        int cur=offset;
        E r;
        while(this.length()>0)
        {
            if(cur!=0)
            {
                temp.push(this.pop());
            }
            else
                r=this.pop();

            cur--;
        }
        while(temp.length()>0)
            this.push(temp.pop());

    }


}

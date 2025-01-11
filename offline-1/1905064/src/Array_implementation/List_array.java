package Array_implementation;


import List_Interface.LIst;

public class List_array<E> implements LIst<E> {

    private E[] p;
    private int cur;
    private int size;
    private int max_size;
    private int increase_amount;


    public List_array(int x)
    {
        p=(E[])new Object[x];
        max_size=x;
        size=0;
        cur=0;
        increase_amount=x;
    }
    public List_array(E[] arr,int n,int x)
    {
        p=(E[])new Object[x];
        for(int i=0;i<n;i++)
            p[i]=arr[i];
        size=n;
        max_size=x;
        cur=0;
        increase_amount=x;
    }

    private void increase_size()
    {
        E[] n=(E[])new Object[max_size+increase_amount];
        max_size+=increase_amount;
        for(int i=0;i<size;i++)
        {
            n[i]=p[i];

        }
        p=n;
    }




    public void append(E x)
    {
        if(size==max_size)
            increase_size();
        p[size]=x;
        size++;


    }
    public void insert(E x)
    {
        if(size==max_size)
        {
            increase_size();
        }
        for(int i=size;i>cur;i--)
        {
            p[i]=p[i-1];
        }
        size++;
        p[cur]=x;

    }
    public E remove()
    {
        if(size==0)
        {
            System.out.println("there is nothing to remove");
            return null;
        }
        E r=p[cur];
        for(int i=cur;i<size-1;i++)
        {
            p[i]=p[i+1];
        }
        size--;
        return r;

    }




    public void moveToStart()
    {
        cur=0;

    }
    public void moveToEnd()
    {
        cur=size-1;

    }
    public void prev()
    {
        if(cur==0)
            System.out.println("there is no previous position");
        else
            cur--;

    }
    public void next()
    {
        if(cur==size-1)
        {
            System.out.println("there is no next position");
        }
        else
            cur++;

    }


    public int length()
    {

       return size;
    }
    public int currPos()
    {
       return cur;
    }
    public void moveToPos(int x)
    {
        if(size==0)
        {
            cur=0;
            return;
        }
        if(x+1>size || x<0)
        {
            System.out.println("there is no such position");
        }
        else
            cur=x;

    }

    public E getValue()
    {

        return p[cur];
    }

    public int search(E x)

    {
        int flag=-1;
        for(int i=0;i<size;i++)
        {
            if(p[i].equals(x))
            {
                flag=1;
                break;
            }
        }
        return flag;

    }


    public void clear()
    {
        cur=size=max_size=0;
        p=null;


    }





}

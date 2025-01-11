package Array_based_implementation;

import Interfaces.queue;

public class arrayQueue<E> implements queue<E> {

    E[] arr;
    int front;
    int rear;
    int maxSize;


    public arrayQueue(int maxSize)
    {
        this.maxSize=maxSize+1;
        rear=0;
        front=1;
        arr= (E[]) new Object[this.maxSize];
    }

    void increaseSize()
    {
        E[] temp=(E[])new Object[maxSize*2];
        if(length()!=0)
        {
            for(int i=0;i<length();i++)
                temp[(i+front)%maxSize]=arr[(i+front)%maxSize];
        }
        arr=temp;
        maxSize*=2;

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
        rear=0;
        front=1;

    }

    @Override
    public void enqueue(E item) {
        if((rear+2)%maxSize==front)
        {
            increaseSize();
        }
        rear=(rear+1)%maxSize;
        arr[rear]=item;

    }

    @Override
    public E dequeue() {
        if(emptyCheck())
            return null;

        E r=arr[front];
        front=(front+1)%maxSize;
        return r;
    }

    @Override
    public int length() {
        return (rear-front+1+maxSize)%maxSize;
    }

    @Override
    public E frontValue() {
        if(emptyCheck())
            return null;

        return arr[front];
    }

    @Override
    public E rearValue() {
        if(emptyCheck())
            return null;

        return arr[rear];
    }

    @Override
    public E leaveQueue() {
        if(emptyCheck())
            return null;

        E r=arr[rear];
        rear=(rear-1+maxSize)%maxSize;
        return r;
    }
}

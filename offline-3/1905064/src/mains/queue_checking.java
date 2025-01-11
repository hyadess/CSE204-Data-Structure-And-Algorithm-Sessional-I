package mains;

import Array_based_implementation.arrayQueue;
import Interfaces.queue;
import Linked_list_based_implementation.listQueue;

import java.util.Scanner;

public class queue_checking {


    static void print(queue<Integer> s)
    {
        queue<Integer> p;

        //p=new listQueue<>();
        p=new arrayQueue<>(s.length());

        while(s.length()!=0)
        {
            Integer temp=s.dequeue();
            if(temp==null)
                break;
            p.enqueue(temp);
        }
        System.out.print("<");

        while(p.length()!=0)
        {
            Integer temp=p.dequeue();
            if(temp==null)
                break;
            System.out.print(temp+" ");
            s.enqueue(temp);
        }
        System.out.println(">");


    }

    static void process(queue<Integer> s,int q,int v)
    {
        if(q==1)
        {
            s.clear();
            print(s);
            System.out.println("-1");
        }
        if(q==2)
        {
            s.enqueue(v);
            print(s);
            System.out.println("-1");
        }
        if(q==3)
        {
            int u;
            if(s.length()==0)
                u=-1;
            else
                u=(int)s.dequeue();

            print(s);
            System.out.println(u);

        }
        if(q==4)
        {
            print(s);
            System.out.println(s.length());
        }
        if(q==5)
        {

            print(s);
            System.out.println(s.frontValue());

        }
        if(q==6)
        {

            print(s);
            System.out.println(s.rearValue());

        }
        if(q==7)
        {
            Integer p= (Integer) s.leaveQueue();
            print(s);
            System.out.println(p);

        }

    }





    public static void main(String args[])
    {

        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int max_size=scn.nextInt();

        queue<Integer> s;
        s=new arrayQueue<>(max_size);
        //s=new listQueue<>();

        for(int i=0;i<n;i++)
        {
            int p=scn.nextInt();
            s.enqueue(p);
        }

        while(true)
        {
            int q=scn.nextInt();

            if(q==0)
                break;

            int v=scn.nextInt();
            process(s,q,v);

        }




    }

}

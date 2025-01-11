package main_and_TNL;

import Array_implementation.List_array;
import List_Interface.LIst;
import List_implementation.Linked_list;

import java.util.Scanner;


public class list_checking {



    static void print(LIst l)
    {

        int flag=l.currPos();

        l.moveToStart();
        System.out.print("<");
        
        while(l.length()!=0)
        {
            if(l.currPos()==flag)
                System.out.print("| ");
            System.out.print(l.getValue()+" ");
            if(l.currPos()+1==l.length())
                break;
            else
                l.next();

        }
        System.out.println(">");
        l.moveToPos(flag);


    }

    public static  <E>void process(LIst l,int q,E p)
    {
        if(q==1)
        {
            l.clear();
            print(l);
            System.out.println("-1");
        }
        else if(q==2)
        {
            l.insert(p);
            print(l);
            System.out.println("-1");
        }
        else if(q==3)
        {
            l.append(p);
            print(l);
            System.out.println("-1");
        }
        else if(q==4)
        {
            E r=(E)l.remove();

            print(l);
            if(r==null)
            {
                System.out.println("-1");
            }
            else
                System.out.println(r);

        }
        else if(q==5)
        {
            l.moveToStart();
            print(l);
            System.out.println("-1");
        }
        else if(q==6)
        {
            l.moveToEnd();
            print(l);
            System.out.println("-1");
        }
        else if(q==7)
        {
            l.prev();
            print(l);
            System.out.println("-1");

        }
        else if(q==8)
        {
            l.next();
            print(l);
            System.out.println("-1");
        }
        else if(q==9)
        {
            print(l);
            System.out.println(l.length());
        }
        else if(q==10)
        {
            print(l);
            System.out.println(l.currPos());
        }
        else if(q==11)
        {
            l.moveToPos((int)p);
            print(l);
            System.out.println("-1");
        }
        else if(q==12)
        {
            E r=(E)l.getValue();
            print(l);
            System.out.println(r);

        }
        else if(q==13)
        {
            print(l);
            System.out.println(l.search(p));
        }
        else
            System.out.println("such command doesn't exist");



    }

    public static void main(String Args[])
    {

        Scanner scn=new Scanner(System.in);

        int n,x;
        System.out.println("enter the input size");
        n=scn.nextInt();
        System.out.println("enter the chunk size");
        x=scn.nextInt();
        Integer[] arr=new Integer[x];
        for(int i=0;i<n;i++)
        {
            arr[i]= scn.nextInt();
        }
        LIst<Integer>l;
        //l=new Linked_list<>(arr,n);
        l=new List_array<>(arr,n,x);

        while(true)
        {
            int q=scn.nextInt();
            Integer p=scn.nextInt();
            if(q==0)
                break;
            process(l,q,p);

        }








    }



}

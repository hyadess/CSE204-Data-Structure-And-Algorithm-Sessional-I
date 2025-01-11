package mains;

import Array_based_implementation.stack_array;
import Interfaces.stack;
import Linked_list_based_implementation.stack_list;

import java.util.Scanner;

public class stack_testing {


    static void print(stack<Integer> s)
    {
        stack<Integer> p;

        //p=new stack_list<>();
        p=new stack_array<>(s.length());
        while(s.length()!=0)
        {
            p.push(s.pop());
        }
        System.out.print("<");

        while(p.length()!=0)
        {
            Integer temp=p.pop();
            System.out.print(temp+" ");
            s.push(temp);
        }
        System.out.println(">");


    }

    static void process(stack s,int q,int v)
    {
        if(q==1)
        {
            s.clear();
            print(s);
            System.out.println("-1");
        }
        if(q==2)
        {
            s.push(v);
            print(s);
            System.out.println("-1");
        }
        if(q==3)
        {
            int u;
            if(s.length()==0)
                u=-1;
            else
                u=(int)s.pop();

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
            System.out.println(s.topValue());

        }
        if(q==6)
        {
            s.setDirection(v);
            print(s);
            System.out.println("-1");

        }

    }





    public static void main(String args[])
    {

        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int max_size=scn.nextInt();

        stack<Integer> s;
        s=new stack_array<>(max_size);
        //s=new stack_list<>();

        for(int i=0;i<n;i++)
        {
            int p=scn.nextInt();
            s.push(p);
        }

        while(true)
        {
            int q=scn.nextInt();

            if(q==0)
                break;
            if(q==7)
            {
                Integer v= scn.nextInt();
                int i=scn.nextInt();
                s.insert(v,i);
                print(s);
                continue;
            }

            if(q==8)
            {
                int i=scn.nextInt();
                s.remove(i);
                print(s);
                continue;
            }
            int v=scn.nextInt();
            process(s,q,v);

        }




    }

}

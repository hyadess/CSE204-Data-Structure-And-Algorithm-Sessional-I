package main_and_TNL;

import Array_implementation.List_array;
import List_Interface.LIst;
import List_implementation.Linked_list;
import TNL_implementation.TNL;

import java.util.Scanner;


public class TNL_checking {

    static int stops = 0,bus_no=0,train_no=0;
    static Integer[] b,t;



    static void input_taking()
    {
        Scanner scn=new Scanner(System.in);

        System.out.println("enter the number of stops");
        stops=scn.nextInt();




        System.out.println("enter the number of bus stations");
        bus_no=scn.nextInt();
        System.out.println("enter the bus stations");
        b=new Integer[bus_no];
        for(int i=0;i<bus_no;i++)
        {
            b[i]=scn.nextInt();
        }




        System.out.println("enter the number of train stations");
        train_no=scn.nextInt();
        System.out.println("enter the train stations");
        t=new Integer[train_no];
        for(int i=0;i<train_no;i++)
        {
            t[i]=scn.nextInt();
        }

    }

    static void process(TNL tnl,int q)
    {
        if(q==1)
            tnl.print();
    }


    public static void main(String args[])
    {

        Scanner scn=new Scanner(System.in);

        input_taking();

        LIst<Integer> bus=new Linked_list<>(b,bus_no);
       LIst<Integer> train=new Linked_list<>(t,train_no);

//        LIst<Integer> bus=new List_array<>(b,bus_no,bus_no);
//        LIst<Integer> train=new List_array<>(t,train_no,train_no);


        TNL tnl=new TNL(bus,train,stops);
        while(true)
        {
            int q=scn.nextInt();
            process(tnl,q);
            if(q==0)
                break;
        }





    }
}

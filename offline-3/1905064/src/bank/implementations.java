package bank;

import Array_based_implementation.arrayQueue;
import Interfaces.queue;
import Linked_list_based_implementation.listQueue;
import bank.customerInfo;

import java.util.Scanner;



public class implementations {

    static int booth_1_freeTime=0;
    static int booth_2_freeTime=0;

    static boolean booth_1_atWork=false;
    static boolean booth_2_atWork=false;
    static boolean newCustomerEntered=false;



    static queue<customerInfo> booth_1;
    static queue<customerInfo> booth_2;

    static int customer;





    static void enterBooth(customerInfo cur)
    {
        int one=booth_1.length();


        int two=booth_2.length();

        if(one<=two)
        {
            booth_1.enqueue(cur);
        }
        else
        {
            booth_2.enqueue(cur);
        }
    }



    static void offeringServiceAtBooth1()
    {
        if(booth_1.length()!=0 && !booth_1_atWork)
        {
            customerInfo cur=booth_1.frontValue();
            if(booth_1_freeTime<cur.getEntryTime())
                booth_1_freeTime=cur.getEntryTime()+cur.getServiceTime();
            else
                booth_1_freeTime+=cur.getServiceTime();
            booth_1_atWork=true;
        }

    }

    static void offeringServiceAtBooth2()
    {
        if(booth_2.length()!=0 && !booth_2_atWork)
        {
            customerInfo cur=booth_2.frontValue();
            if(booth_2_freeTime<cur.getEntryTime())
                booth_2_freeTime=cur.getEntryTime()+cur.getServiceTime();
            else
                booth_2_freeTime+=cur.getServiceTime();
            booth_2_atWork=true;

        }
    }




    static void switchBooth()
    {

        if(booth_1.length()+1<booth_2.length())
        {

            booth_1.enqueue(booth_2.leaveQueue());

        }


        else if(booth_2.length()+1<booth_1.length())
        {

            booth_2.enqueue(booth_1.leaveQueue());
        }





    }




    public static void main(String args[])
    {
        Scanner scn= new Scanner(System.in);
        System.out.println("enter the number of customers");
        customer=scn.nextInt();

//        booth_1=new arrayQueue<>(customer);
//        booth_2=new arrayQueue<>(customer);

        booth_1=new listQueue<>();
        booth_2=new listQueue<>();




        int t= scn.nextInt(), s=scn.nextInt();
        newCustomerEntered=true;

        int remain=customer-1;

        int currTime=t;


        while(true)
        {



            if(currTime==booth_1_freeTime && booth_1_atWork)  //first step:- doing dequeue...................
            {
                customerInfo trash=booth_1.dequeue();

                booth_1_atWork=false;

            }
            if(currTime==booth_2_freeTime && booth_2_atWork)
            {
                customerInfo trash=booth_2.dequeue();
                booth_2_atWork=false;

            }






            if(currTime==t && newCustomerEntered)     // 2nd step:- doing enqueue...............................
            {

                customerInfo newCustomer=new customerInfo(t,s);
                enterBooth(newCustomer);
                newCustomerEntered=false;

            }
            if(newCustomerEntered==false && remain>0)
            {
                t=scn.nextInt();
                s=scn.nextInt();
                remain--;
                while(t==currTime){                      // multiple customer entered ..........................

                    customerInfo newCustomer=new customerInfo(t,s);
                    enterBooth(newCustomer);

                    if(remain==0)
                    {
                        t=s=0;
                        break;
                    }
                    t=scn.nextInt();
                    s=scn.nextInt();
                    remain--;
                }

                if(s!=0)
                    newCustomerEntered=true;
            }






            switchBooth();               // 3rd step:- switching queue....................




            offeringServiceAtBooth1();   // now..let's serve......................
            offeringServiceAtBooth2();

            currTime=10000000;


            if(newCustomerEntered)      // jumping to the next enqueue or dequeue time.......................
                currTime=Math.min(currTime,t);
            if(booth_2_atWork)
                currTime=Math.min(currTime,booth_2_freeTime);
            if(booth_1_atWork)
                currTime=Math.min(currTime,booth_1_freeTime);



            if(!booth_1_atWork && !booth_2_atWork && !newCustomerEntered) // noting to enqueue or dequeue.....................
                break;


//            System.out.println(currTime+ " "+ " "+t+" "+booth_1_freeTime+ " "+booth_2_freeTime);
//            try {
//                Thread.sleep(500);
//            }catch (Exception e)
//            {
//                System.out.println();
//            }

        }


        System.out.println("Booth 1 finishes service at:  " +booth_1_freeTime);
        System.out.println("Booth 2 finishes service at:  " +booth_2_freeTime);



    }
}

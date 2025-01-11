package dishwasher;

import Array_based_implementation.stack_array;
import Interfaces.stack;
import Linked_list_based_implementation.stack_list;

import java.util.Scanner;

public class implementations {

    static int freeTime=-1;


    static stack<dishInfo> dirty;
    static stack<dishInfo> clean;


    static int friend;
    static int dishNo;
    static int dishTime[];

    static stack<Integer> fullMealFriend;
    static stack<Integer> finishing_times;







    static void cleanNow(dishInfo cur)
    {
        if(freeTime==cur.getPushing_time())
            freeTime+=dishTime[cur.getDish_no()-1];
        else
            freeTime= cur.getPushing_time()+dishTime[cur.getDish_no()-1]-1;
        cur.setCleaning_time(freeTime);
        clean.push(cur);
    }

    static void cleanTheStack(dishInfo cur)
    {
        while((cur==null || freeTime<cur.getPushing_time() ) && dirty.length()!=0)
        {
            dishInfo p=dirty.pop();
            freeTime+=dishTime[p.getDish_no()-1];
            p.setCleaning_time(freeTime);
            clean.push(p);
        }
    }




    static void analyzeCleaning()
    {


//        fullMealFriend=new stack_list<>();
//        finishing_times=new stack_list<>();


        fullMealFriend=new stack_array<>(friend);
        int u=friend*dishNo;
        finishing_times=new stack_array<>(u);

        extractTheInfo(clean);


    }

    static void extractTheInfo(stack<dishInfo> s)
    {
        dishInfo p=s.pop();

        if(p.getDish_no()==dishNo)
            fullMealFriend.push(p.getFriend_info());

        finishing_times.push(p.getCleaning_time());

        if(s.length()>=1)
             extractTheInfo(s);

        s.push(p);


    }


    static void printTheTimes(stack s)
    {
        int[] temp=new int[s.length()];

        int p=0;
        while(s.length()!=0)
        {
            temp[p]= (int) s.topValue();
            s.pop();
            p++;

        }


        System.out.println(temp[temp.length-1]);

        for(int i=0;i< temp.length;i++)
        {
            System.out.print(temp[i]);
            if(i< temp.length-1)
                System.out.print(",");
        }
        System.out.println();




    }

    static void printTheFriends(stack s)
    {
        int[] temp=new int[s.length()];


        int p=0;
        while(s.length()!=0)
        {
            temp[p]= (int) s.topValue();
            s.pop();
            p++;

        }

        if(temp.length==friend)
            System.out.println("Y");
        else
            System.out.println("N");


        for(int i= temp.length-1;i>=0;i--)
        {
            System.out.print(temp[i]);
            if(i>0)
                System.out.print(",");
        }
        System.out.println();


    }

    static void print()
    {
        printTheTimes(finishing_times);
        printTheFriends(fullMealFriend);
    }




    public static void main(String args[])
    {
        Scanner scn= new Scanner(System.in);
        System.out.println("enter the number of friends");
        friend=scn.nextInt();
        System.out.println("enter the total number of dishes");
        dishNo=scn.nextInt();


        dishTime= new int[dishNo];          // to store the cleaning times of different dishes



//        dirty=new stack_list<>();   // linked_list implementation..................................
//        clean=new stack_list<>();

//        int u=friend*dishNo;        // array based implementation........................................
//        clean=new stack_array<>(u);
//        dirty=new stack_array<>(u);

        int u=friend*dishNo;        // 1 array 2 stack implementation..........................................
        dishInfo[] arr=new dishInfo[u];
        clean=new stack_array<>(arr,-1);
        dirty=new stack_array<>(arr,1);



        System.out.println("enter the cleaning time for dishes");
        for(int i=0;i<dishNo;i++)
        {
            dishTime[i]=scn.nextInt();
        }

        while(true)
        {
            int f=scn.nextInt();
            int t=scn.nextInt();
            int d=scn.nextInt();

            if(f==0 && t==0 && d==0)
            {
                cleanTheStack(null);
                analyzeCleaning();
                print();
                break;
            }


            dishInfo cur=new dishInfo(f,t,d);
            if(freeTime>cur.getPushing_time())
                dirty.push(cur);
            else if(t==0 || freeTime==cur.getPushing_time())
                cleanNow(cur);
            else
            {
                cleanTheStack(cur);
                if(freeTime>cur.getPushing_time())
                    dirty.push(cur);
                else if(freeTime<=cur.getPushing_time())
                    cleanNow(cur);
            }



        }




    }
}

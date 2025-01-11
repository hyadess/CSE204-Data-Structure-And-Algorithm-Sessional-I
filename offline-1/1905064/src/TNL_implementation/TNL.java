package TNL_implementation;

import List_Interface.LIst;

public class TNL {
    private LIst<Integer> bus,train;
    private int stops;

    public TNL(LIst bus,LIst train,int stops)
    {
        this.bus=bus;
        this.train=train;
        this.stops=stops;
    }


    private Integer[] LIst_to_array(LIst l)
    {
        Integer[] arr;
        arr=new Integer[l.length()];

        int flag=l.currPos();

        l.moveToStart();
        int i=0;

        while(true)
        {

            arr[i]=(Integer) l.getValue();
            if(l.currPos()+1==l.length())
                break;
            else
                l.next();
            i++;

        }

        l.moveToPos(flag);

        return arr;
    }

    public void print()
    {
        for(int i=0;i<stops;i++)
        {
            System.out.print(i);
            if(i<stops-1)
                System.out.print(",");
        }
        System.out.println();
        Integer[] bus_array,train_array;
        bus_array=LIst_to_array(bus);
        train_array=LIst_to_array(train);





        for(int i=0;i<bus_array[0];i++)
            System.out.print(",");
        for(int i=0;i<bus_array.length;i++)
        {
            if(i>0)
            {
                for(int j=bus_array[i-1];j<bus_array[i];j++)
                    System.out.print(",");
            }
            System.out.print(bus_array[i]);

        }
        for(int i=stops-1;i>bus_array[bus_array.length-1];i--)
            System.out.print(",");
        System.out.println();





        for(int i=0;i<train_array[0];i++)
            System.out.print(",");
        for(int i=0;i<train_array.length;i++)
        {
            if(i>0)
            {
                for(int j=train_array[i-1];j<train_array[i];j++)
                    System.out.print(",");
            }
            System.out.print(train_array[i]);

        }
        for(int i=stops-1;i>train_array[train_array.length-1];i--)
            System.out.print(",");
        System.out.println();



    }










}

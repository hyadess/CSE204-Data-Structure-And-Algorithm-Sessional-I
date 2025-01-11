
#include<bits/stdc++.h>
#include<chrono>
using namespace std;
using namespace std::chrono;

void mergeTwo(int* arr, int startIndex, int midIndex, int endIndex)
{
    int length1=midIndex-startIndex+1;
    int length2=endIndex-midIndex;

    int leftArray[length1],rightArray[length2];
    for( int i=0;i<length1;i++)
        leftArray[i]=arr[startIndex+i];
    for( int i=0;i<length2;i++)
        rightArray[i]=arr[midIndex+1+i];
    int left=0,right=0;
    for(int i=startIndex;i<=endIndex;i++)
    {
        if(leftArray[left]<=rightArray[right])
        {
            arr[i]=leftArray[left];
            left++;
        }
        else
        {
            arr[i]=rightArray[right];
            right++;
        }
    }
}
void mergeSort(int* arr, int startIndex, int endIndex)
{
    if(startIndex<endIndex)
    {
        int midIndex=(startIndex+endIndex)/2;
        mergeSort(arr,startIndex,midIndex);
        mergeSort(arr,midIndex+1,endIndex);
        mergeTwo(arr,startIndex,midIndex,endIndex);
    }
}




int divide(int* arr, int startIndex,int endIndex, bool random)
{
    if(random==true)
    {
        srand(time(0));
        int randomIndex=startIndex+rand()%(endIndex-startIndex+1);

        int temp=arr[randomIndex];
        arr[randomIndex]=arr[endIndex];
        arr[endIndex]=temp;
    }
    int pivotValue=arr[endIndex];
    int pivotIndex=startIndex;
    for( int i=startIndex;i<=endIndex-1;i++)
    {
        if(arr[i]<=pivotValue)
        {
            int temp=arr[i];
            arr[i]=arr[pivotIndex];
            arr[pivotIndex]=temp;
            pivotIndex++;
        }
    }
    int temp=arr[endIndex];
    arr[endIndex]=arr[pivotIndex];
    arr[pivotIndex]=temp;
    return pivotIndex;
}

void quickSort(int* arr, int startIndex, int endIndex)
{
    if(startIndex<endIndex)
    {
        int pivotPoint= divide(arr,startIndex,endIndex,false);
        quickSort(arr, startIndex,pivotPoint-1);
        quickSort(arr, pivotPoint+1,endIndex);


    }
}
void randomizedQuickSort(int* arr, int startIndex, int endIndex)
{
    if(startIndex<endIndex)
    {
        int pivotPoint= divide(arr,startIndex,endIndex,true);
        randomizedQuickSort(arr, startIndex,pivotPoint-1);
        randomizedQuickSort(arr, pivotPoint+1,endIndex);


    }
}



// choose a number a_i, insert the number somwhere between a_0 and a_i such that a_0....a_i is sorted...............
void insertionSort(int* arr, int n)
{

    for (int i=1;i<n;i++)
    {
        int currValue = arr[i];
        int j=i-1;


        while (j>=0 && arr[j]>currValue)
        {
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=currValue;
    }
}



int main()
{
    freopen("output.csv","w",stdout);

    cout<<"n,merge sort,quick sort, randomized quick sort,insertion sort,quick sort in sorted array, randomized quick sort in sorted array,stl sort,"<<endl;
    int nArray[6]={5,10,100,1000,10000,100000};
    for(int i=0;i<6;i++)
    {
        cout<<nArray[i]<<",";
        double merge_Sort_Times[20]={0};
        double quick_Sort_Times[20]={0};
        double random_Quick_Sort_Times[20]={0};
        double insertion_Sort_Times[20]={0};
        double stl_Sort_Times[20]={0};
        double sorted_Quick_Sort_Times[20]={0};
        double sorted_random_quick_sort_times[20]={0};
        //cout<<"sort-----------------"<<endl;
        for(int j=0;j<20;j++)
        {
            int array_for_mergeSort[nArray[i]];
            int array_for_quickSort[nArray[i]];
            int array_for_randomQuickSort[nArray[i]];
            int array_for_insertionSort[nArray[i]];
            int array_for_stlSort[nArray[i]];


            srand(time(0));
            for(int k=0;k<nArray[i];k++)
            {
                array_for_mergeSort[k]=rand();
                array_for_quickSort[k]=array_for_mergeSort[k];
                array_for_randomQuickSort[k]=array_for_mergeSort[k];
                array_for_insertionSort[k]=array_for_mergeSort[k];
                array_for_stlSort[k]=array_for_mergeSort[k];
            }

            double d;

            /// merge sort....................
            auto start = high_resolution_clock::now();
            mergeSort(array_for_mergeSort,0,nArray[i]-1);
            auto stop = high_resolution_clock::now();
            auto duration = duration_cast<nanoseconds>(stop - start);
            d=duration.count();
            d=d*0.000001;
            merge_Sort_Times[j]=d;
            //cout << d<<"     ";


            ///quick sort.....................
            start = high_resolution_clock::now();
            quickSort(array_for_quickSort,0,nArray[i]-1);
            stop = high_resolution_clock::now();
            duration = duration_cast<nanoseconds>(stop - start);
            d=duration.count();
            d=d*0.000001;
            quick_Sort_Times[j]=d;
            //cout << d<<"     ";


            ///randomized quick sort.............
            start = high_resolution_clock::now();
            randomizedQuickSort(array_for_randomQuickSort,0,nArray[i]-1);
            stop = high_resolution_clock::now();
            duration = duration_cast<nanoseconds>(stop - start);
            d=duration.count();
            d=d*0.000001;
            random_Quick_Sort_Times[j]=d;
            //cout << d<<"     ";


            ///insertion sort..........
            start = high_resolution_clock::now();
            insertionSort(array_for_insertionSort,nArray[i]);
            stop = high_resolution_clock::now();
            duration = duration_cast<nanoseconds>(stop - start);
            d=duration.count();
            d=d*0.000001;
            insertion_Sort_Times[j]=d;
            //cout << d<<"     ";


            ///stl sort.................
            start = high_resolution_clock::now();
            sort(array_for_stlSort,array_for_stlSort+nArray[i]);
            stop = high_resolution_clock::now();
            duration = duration_cast<nanoseconds>(stop - start);
            d=duration.count();
            d=d*0.000001;
            stl_Sort_Times[j]=d;
            //cout << d<<"     ";

            ///quick sort with sorted input........
            start = high_resolution_clock::now();
            quickSort(array_for_quickSort,0,nArray[i]-1);
            stop = high_resolution_clock::now();
            duration = duration_cast<nanoseconds>(stop - start);
            d=duration.count();
            d=d*0.000001;
            sorted_Quick_Sort_Times[j]=d;
            //cout << d<<"     ";

            ///randomized quick sort for sorted input....
            start = high_resolution_clock::now();
            randomizedQuickSort(array_for_randomQuickSort,0,nArray[i]-1);
            stop = high_resolution_clock::now();
            duration = duration_cast<nanoseconds>(stop - start);
            d=duration.count();
            d=d*0.000001;
            sorted_random_quick_sort_times[j]=d;
            //cout << d<<endl;
        }



        double average_time=0;

        ///for merge sort.......
        for(int l=0;l<20;l++)
            average_time+=merge_Sort_Times[l];
        cout<<average_time/20.0<<",";

        ///for quick sort.......
        average_time=0;
        for(int l=0;l<20;l++)
            average_time+=quick_Sort_Times[l];
        cout<<average_time/20.0<<",";

        ///for random quick sort..........
        average_time=0;
        for(int l=0;l<20;l++)
            average_time+=random_Quick_Sort_Times[l];
        cout<<average_time/20.0<<",";

        ///for insertion sort...........
        average_time=0;
        for(int l=0;l<20;l++)
            average_time+=insertion_Sort_Times[l];
        cout<<average_time/20.0<<",";

        ///for sorted quick sort............
        average_time=0;
        for(int l=0;l<20;l++)
            average_time+=sorted_Quick_Sort_Times[l];
        cout<<average_time/20.0<<",";

        ///for sorted randomized quick sort...........
        average_time=0;
        for(int l=0;l<20;l++)
            average_time+=sorted_random_quick_sort_times[l];
        cout<<average_time/20.0<<",";

        /// for stl sort
        average_time=0;
        for(int l=0;l<20;l++)
            average_time+=stl_Sort_Times[l];
        cout<<average_time/20.0<<","<<endl;


    }

    fclose(stdout);
    return 0;
}


#include<bits/stdc++.h>
using namespace std;

class Heap
{
    int *arr;
    int totalNode;
    int currSize;

    int leftNode(int i)
    {
        if(2*i>currSize)
            return -1;

        return 2*i;
    }
    int rightNode(int i)
    {
        if(2*i+1>currSize)
            return -1;

        return 2*i+1;
    }


    void maxHeapify(int i)
    {
        int leftIndex=leftNode(i);
        int rightIndex=rightNode(i);

        int largestIndex=i;
        if(leftIndex!=-1 && arr[largestIndex]<arr[leftIndex])
            largestIndex=leftIndex;
        if(rightIndex!=-1 && arr[largestIndex]<arr[rightIndex])
            largestIndex=rightIndex;

        if(largestIndex!=i)
        {
            swap(arr[i],arr[largestIndex]);
            maxHeapify(largestIndex);
        }


    }

    void buildheap()
    {
        for(int i=currSize/2;i>=0;i--)
            maxHeapify(i);


    }




public:


    Heap(int totalNode)
    {
        this->totalNode=totalNode;
        arr=new int[totalNode];
        currSize=0;
    }
    Heap(vector<int> &v)
    {
        this->totalNode=v.size();
        arr=new int[totalNode];
        currSize=0;
        for(int i=0;i<totalNode;i++)
        {
            arr[i]=v[i];
            currSize++;
        }
        buildheap();
    }



    void insert(int data)
    {
        if(currSize==totalNode)
        {
            cout<<"heap is already full"<<endl;
            return;
        }
        arr[currSize]=data;
        currSize++;

        int currIndex=currSize-1;
        while(currIndex>0)
        {
            if(arr[currIndex]>arr[currIndex/2]){
                swap(arr[currIndex],arr[currIndex/2]);
                currIndex=currIndex/2;
            }
            else
                break;
        }
    }
    void deleteKey()
    {
        if(currSize==0)
        {
            cout<<"heap is empty"<<endl;
            return;
        }
        arr[0]=arr[currSize-1];
        currSize--;
        int currIndex=0;
        while(currIndex<currSize)
        {
            int leftIndex=leftNode(currIndex);
            int rightIndex=rightNode(currIndex);

            int largestIndex=currIndex;
            if(leftIndex!=-1 && arr[largestIndex]<arr[leftIndex])
                largestIndex=leftIndex;
            if(rightIndex!=-1 && arr[largestIndex]<arr[rightIndex])
                largestIndex=rightIndex;

            if(largestIndex!=currIndex)
            {
                swap(arr[currIndex],arr[largestIndex]);
                if(largestIndex==leftIndex)
                    currIndex=leftIndex;
                else
                    currIndex=rightIndex;
            }
            else
                break;
        }
    }


    int size()
    {
        return currSize;
    }
    int getMax()
    {
        if(currSize==0)
        {
            cout<<"there is no element in the heap"<<endl;
            return -1;
        }
        return arr[0];
    }

    ~Heap()
    {
        delete[] arr;
    }
};

void heapsort(vector<int> &v)
{
    Heap h(v);
    v.clear();
    while(h.size()>0)
    {
        v.push_back(h.getMax());
        h.deleteKey();

    }


}

int main()
{
    /*
    vector<int>v;
    int n;
    cin>>n;
    for(int i=0;i<n;i++)
    {
        int temp;
        cin>>temp;
        v.push_back(temp);
    }
    for(int i=0;i<v.size();i++)
        cout<<v[i]<<" ";


    heapsort(v);
    for(int i=0;i<v.size();i++)
        cout<<v[i]<<" ";
*/
    Heap h(10000);


    int n;
    cin>>n;

    for(int i=0;i<n;i++)
    {
        int temp;
        cin>>temp;
        h.insert(temp);
    }

    h.deleteKey();
    h.insert(4566);
    cout<<h.getMax();
    /*cout<<h.getMax()<<endl;
    h.deleteKey();
    cout<<h.getMax()<<endl;
    for(int i=0;i<6;i++)
    {
        h.deleteKey();
        cout<<h.size()<<endl;
       cout<<h.getMax()<<endl;
    }*/


}



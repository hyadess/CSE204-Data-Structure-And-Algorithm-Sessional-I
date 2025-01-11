#include<bits/stdc++.h>
using namespace std;
#define inf 1e9
void TraverseTheGraph(int x,int n,int* parent,int* snakeEnd,int* ladderEnd,bool* reachability,int* level)
{
    queue<int>q;
    q.push(1);
    reachability[1]=true;
    level[1]=0;

    while(!q.empty())
    {
        int currNode=q.front();
        q.pop();

        if(snakeEnd[currNode]!=currNode)
        {
            if(reachability[snakeEnd[currNode]]!=true || (level[snakeEnd[currNode]]>level[currNode]))
            {
                reachability[snakeEnd[currNode]]=true;
                parent[snakeEnd[currNode]]=currNode;
                level[snakeEnd[currNode]]=level[currNode];
                q.push(snakeEnd[currNode]);
            }
        }

        else if(ladderEnd[currNode]!=currNode)
        {
            if(reachability[ladderEnd[currNode]]!=true || (level[ladderEnd[currNode]]>level[currNode]))
            {
                reachability[ladderEnd[currNode]]=true;
                parent[ladderEnd[currNode]]=currNode;
                level[ladderEnd[currNode]]=level[currNode];
                q.push(ladderEnd[currNode]);
            }
        }

        else
        {
            for(int i=currNode;i<=currNode+n;i++)
            {
                if(i>x)
                    break;
                if(reachability[i]!=true || level[i]>level[currNode]+1)
                {
                    reachability[i]=true;
                    parent[i]=currNode;
                    level[i]=level[currNode]+1;
                    q.push(i);
                }
            }
        }

    }
}

void pathPrint(int x,int* parent,int* snakeEnd,int* ladderEnd,int* level)
{
    vector<int>v;
    int currNode=x;
    v.push_back(x);

    while(currNode!=1)
    {
        if(parent[currNode]==currNode)
            break;
        currNode=parent[currNode];
        v.push_back(currNode);
    }
    if(currNode!=1)
    {
        cout<<-1<<endl;
        cout<<"No solution"<<endl;
        return;
    }
    cout<<level[x]<<endl;
    for(int i=v.size()-1;i>=0;i--)
    {
        cout<<v[i];
        if(i>0)
            cout<<" -> ";
    }

    cout<<endl;

}

int main()
{
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    int t;
    cin>>t;
    while(t--)
    {
        int x; //number of cells
        int n; //number of faces in dice
        cin>>n>>x;


        int parent[x+5];  //data arrays to store data about the cells
        int snakeEnd[x+5];
        int ladderEnd[x+5];
        bool reachability[x+5];
        int level[x+5];

        for(int i=0;i<x+5;i++)
        {
            parent[i]=i;
            snakeEnd[i]=i;
            ladderEnd[i]=i;
            level[i]=inf;
            reachability[i]=false;
        }

        int l;
        cin>>l;
        for(int i=0;i<l;i++)
        {
            int p,q;
            cin>>p>>q;
            ladderEnd[p]=q;
        }
        int s;
        cin>>s;
        for(int i=0;i<s;i++)
        {
            int p,q;
            cin>>p>>q;
            snakeEnd[p]=q;
        }


        TraverseTheGraph(x,n,parent,snakeEnd,ladderEnd,reachability,level);
        pathPrint(x,parent,snakeEnd,ladderEnd,level);

        vector<int>v;
        for(int i=1;i<=x;i++)
        {
            if(!reachability[i])
            {
                v.push_back(i);
            }
        }
        if(v.size()==0)
        {
            cout<<"all reachable"<<endl;
        }
        else
        {
            for(int i=0;i<v.size();i++)
                cout<<v[i]<<" ";
            cout<<endl;
        }
        cout<<endl<<endl;


    }

    fclose(stdout);
    fclose(stdin);
    return 0;

}
/*
2
3 20
1
2 8
2
10 7
15 3
*/

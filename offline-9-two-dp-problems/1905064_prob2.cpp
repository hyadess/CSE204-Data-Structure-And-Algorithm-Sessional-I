#include<bits/stdc++.h>
using namespace std;
#define ll long long
ll mod=1e9+7;

ll power(int x,int n,int mod=0)
{
    if(n==1)
        return x;
    ll d=power(x,n/2,mod);

    if(n%2)
    {
        if(mod==0)
            return d*d*x;
        else
            return (((d*d)%mod)*x)%mod;
    }
    else
    {
        if(mod==0)
            return d*d;
        else
            return (d*d)%mod;
    }

}


//bitmasking......
ll removeBit(ll num,ll pos)
{

    ll temp=num^(1<<(pos-1));
    num=num>>(pos-1);
    if(num%2!=1)
        return -1;
    return temp;
}
ll addBit(ll num,ll pos)
{

    ll temp=num^(1<<(pos-1));
    num=num>>(pos-1);
    if(num%2==1)
        return -1;
    return temp;
}


ll process(ll** c,ll** dp,int n,int i,int remain)
{
    if(remain==0)
        return 0;
    if(i>=n)
        return 0;
    if(dp[i][remain]!=-1e18)
        return dp[i][remain];



    dp[i][remain]=1e18;
    ll prev=0;
    int u=remain;
    int j=0;


    for(j=0;j<n;j++)      //calculating price for previous cities.............
    {
        if((u>>j)%2==0)
            prev+=c[i][j];


    }

    int now=removeBit(remain,i+1);


    for(j=0;j<n;j++)  //choose a city to go next...............
    {
        if(i==j)
            continue;

        if(removeBit(remain,j+1)==-1)
            continue;

        dp[i][remain]=min(dp[i][remain],c[i][i]+prev+process(c,dp,n,j,now));

    }

    if(dp[i][remain]==1e18) // if all cities are done..then nowhere to go..........
        dp[i][remain]=c[i][i]+prev;


    return dp[i][remain];
}


void findTheTravelCost(ll** c,int n)
{

    ll** dp;

    ll start;
    start=power(2,n)-1; //initially all cities are unvisited........

    dp=new ll*[n+5];
    for(int i=0;i<=n;i++)
    {
        dp[i]=new ll[start+5];
        for(int j=0;j<=start;j++)
        {
            dp[i][j]=-1e18;
        }
    }



    ll mn=1e18;
    for(int i=0;i<n;i++)
    {
        mn=min(mn,process(c,dp,n,i,start));
    }

    cout<<mn<<endl;

}

int main()
{

    int n;
    ll** c;

    cin>>n;

    c=new ll*[n+5];
    for(int i=0;i<n;i++)
    {
        c[i]=new ll[n+5];
        for(int j=0;j<n;j++)
        {
            cin>>c[i][j];
        }
    }

    findTheTravelCost(c,n);



}


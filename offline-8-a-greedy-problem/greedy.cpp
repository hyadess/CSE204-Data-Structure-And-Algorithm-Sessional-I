#include<bits/stdc++.h>

using namespace std;

#define ll long long

ll find_cost(ll* arr, ll n, ll k)
{
    ll* prices=arr;
    sort(prices,prices+n);
    reverse(prices,prices+n);
    ll round=1,remaining_friend=k;
    ll cost=0;
    for(int i=0;i<n;i++)
    {
        cost+=round*prices[i];
        remaining_friend--;
        if(remaining_friend==0)
        {
            remaining_friend=k;
            round++;
        }
    }
    return cost;
}
int main()
{
    ll n,k;
    cin>>n>>k;
    ll prices[n];
    for(int i=0;i<n;i++)
        cin>>prices[i];

    cout<<find_cost(prices,n,k)<<endl;
}

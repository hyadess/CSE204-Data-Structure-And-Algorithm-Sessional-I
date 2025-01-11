#include<bits/stdc++.h>
using namespace std;
#define ll long long
ll mod=1e9+7;


int process(int i,int j,int** dp,string a,string b,int lenA,int lenB)
{

    if(i==0 || j==0)
        return 0;
    if(dp[i][j]!=-1)
        return dp[i][j];



    if(a[i-1]==b[j-1])
        dp[i][j]=process(i-1,j-1,dp,a,b,lenA,lenB)+1;
    else
        dp[i][j]=max(process(i,j-1,dp,a,b,lenA,lenB),process(i-1,j,dp,a,b,lenA,lenB));

    return dp[i][j];

}


vector<char> printTheLcs(string a,string b,int** dp,int lenA,int lenB)
{
    vector<char>v;
    int i=lenA,j=lenB;
    while(i>0 && j>0)
    {
        if(a[i-1]==b[j-1])
        {
            v.push_back(a[i-1]);
            i--;
            j--;
        }
        else
        {
            if(dp[i-1][j]>dp[i][j-1])
                i--;
            else
                j--;
        }
    }
    reverse(v.begin(),v.end());
    return v;
}


void findAndPrintLCS(string a,string b)
{
    int lenA=a.length();
    int lenB=b.length();

    int** dp=new int*[lenA+5];
    for(int i=0;i<lenA+5;i++)
        dp[i]=new int[lenB+5];

    for(int i=0;i<lenA+5;i++)
    {
        for(int j=0;j<lenB+5;j++)
        {
            dp[i][j]=-1;
        }
    }


    cout<<process(lenA,lenB,dp,a,b,lenA,lenB)<<endl;


    vector<char>v=printTheLcs(a,b,dp,lenA,lenB);

    int len=v.size();
    for(int i=0;i<len;i++)
        cout<<v[i];
    cout<<endl;

}


int main()
{
    string a,b;
    cin>>a>>b;

    findAndPrintLCS(a,b);







}


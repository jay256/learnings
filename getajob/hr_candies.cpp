#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void resolve(int ratings[], int N){
    int candies[N];
    for(int i=0; i<N; i++){
        candies[i] = 1;
    }
    for(int i=1; i<N; i++){
        if(ratings[i] > ratings[i-1])
            candies[i] = candies[i-1]+1;
    }
    for(int i=N-2; i>=0; i--){
        if(ratings[i] > ratings[i+1])
            candies[i] = max(candies[i], candies[i+1]+1);
    }
    long sum=0;
    for(int i=0;i<N;i++){
        sum+=candies[i];
    }
    cout << sum << endl;
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int N;
    cin >> N;
    int ratings[N];
    for(int i = 0; i<N; i++){
        cin >> ratings[i];
    }
    resolve(ratings, N);
    return 0;
}
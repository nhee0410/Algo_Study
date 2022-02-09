#include <iostream>

using namespace std;

int prime(int num)
{
    if (num == 1) 
        return 0;
    
    for (int i = 2; i < num; i++)
    {
        if (num % i == 0)
            return 0;
    }
    return 1;
}

int main()
{
    int n;
    cin >> n;
    
    int result = 0;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        result += prime(x); 
    }
    cout << result << endl;
}

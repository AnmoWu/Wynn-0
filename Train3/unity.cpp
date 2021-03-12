#include<iostream>
#include<math.h>
#include<string.h>
#include<ctype.h>
//#include<vector>
//#include<time.h>
#define LAST 1000
const double pi = 4.0 * atan(1.0);

//char buf[LAST];
//int p[LAST];

//ÀýÌâ4-2 ÂÏÉúËØÊý
bool pr(int n);
int main()
{
    int m;
    scanf("%d", &m);
    for(int i=m-2;i>=3;i--)
        if (pr(i) && pr(i + 2))
        {
            printf("%d %d\n", i, i + 2);
            break;
        }
    return 0;
}
bool pr(int n)
{
    for (int i = 2; i < sqrt(n); i++)
        if (n % i == 0)
            return 0;
    return 1;
}

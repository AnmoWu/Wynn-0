#include<iostream>
#include<math.h>
//#include<string.h>
//#include<ctype.h>
#include<assert.h>
//#include<vector>
//#include<time.h>
#define LAST 1000
const double pi = 4.0 * atan(1.0);

//char buf[LAST];
//int p[LAST];

//例题4-2 孪生素数升级版
bool pr(int n);
int main()
{
    int m;
    scanf("%d", &m);
    for (int i = m - 2; i >= 3; i--)
        if (pr(i) && pr(i + 2))
        {
            printf("%d %d\n", i, i + 2);
            break;
        }
    return 0;
}
bool pr(int n)//判断是否为素数
{
    assert(n >= 0);//多余步骤，可用if (n <= 1)return 0;代替
    if (n == 1)return 0;//防止将1误判为素数
    int a = floor(sqrt(n) + 0.5);//不知道这一步与原版的差别在哪
    for (int i = 2; i < a; i++)
        if (n % i == 0)
            return 0;
    return 1;
}


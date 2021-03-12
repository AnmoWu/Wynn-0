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

//ÀıÌâ4-1
int fl(int n);
int main()
{
    int res, n, m;
    scanf("%d%d", &n, &m);
    res = fl(n) / (fl(m) * fl(n - m));
    printf("%d\n", res);
    return 0;
}

int fl(int n)
{
    int r = 1;
    for (int i = 1; i <= n; i++)
        r *= i;
    return r;
}
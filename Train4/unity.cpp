#include<iostream>
#include<math.h>
#include<string.h>
#include<ctype.h>
#include<assert.h>
//#include<vector>
//#include<time.h>
#define LAST 1000
const double pi = 4.0 * atan(1.0);

//char buf[LAST];
//int p[LAST];

//����4-3 �׳�������
int fl(int n);
int main()
{
    int n, m, res;
    scanf("%d%d", &n, &m);
    res = fl(n) / (fl(m) * fl(n - m));
    printf("%d", res);
    return 0;
}

int fl(int n)
{
    assert(n >= 0);
    return n == 0 ? 1 : fl(n - 1) * n;//���õݹ�ʵ�ֽ׳�
}
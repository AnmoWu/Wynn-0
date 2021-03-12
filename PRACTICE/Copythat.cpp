//#define LOCAL
#include<iostream>
#include<math.h>
#include<vector>
//#include<time.h>
#define last 1000+10
const double pi = 4.0 * atan(1.0);
//bool judge(int a, int b, int c);
int main()
{
	int n, k;
	scanf("%d%d", &n, &k);
	bool b[last] = { 0 };
	int i = -1;
	/*while (++i < n)
	{
		b[i] = 1;
	}*/
	memset(b, 1, n);
	for (int j = 1; j <= k; j++)
	{
		for (int t = 1; t < n; t++)
		{
			if (j % t == 0)
				b[t] = !b[t];
		}
	}
	for (int j = 0; j < n; j++)
	{
		if (b[j] == 1)
			printf("%d ", j + 1);
	}
	return 0;
}

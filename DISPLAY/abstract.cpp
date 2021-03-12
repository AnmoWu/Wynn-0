#include<stdio.h>
#include<string>
class Time
{
public:
	void setime();
	void showtime();
private:
	int hour;
	int minute;
	int second;
};
void Time::setime()
{
	scanf("%d,%d,%d", &hour, &minute, &second);
}
void Time::showtime()
{
	printf("%d:%d:%d", hour, minute, second);
}
int  main()
{
	Time first;
	first.setime();
	first.showtime();
	return 0;
}
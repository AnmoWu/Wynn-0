#include<stdio.h>
class Cuboid
{
public:
	Cuboid();
	Cuboid(int, int,int);
	int volume();
private:
	int height;
	int width;
	int length;
};
Cuboid::Cuboid()
{
	height = width = length = 0;
}
Cuboid::Cuboid(int h, int w, int len)
{
	height = h;
	width = w;
	length = len;
}
int Cuboid::volume()
{
	return height * width * length;
}
int main()
{
	Cuboid first;
	printf("cuboid 1 �����Ϊ:%d\n", first.volume());
	Cuboid second(10,20,30);
	printf("cuboid 2 �����Ϊ:%d", second.volume());
	return 0;
}
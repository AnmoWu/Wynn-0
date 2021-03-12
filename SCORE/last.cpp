#include<iostream>
#include<string>
using namespace std;
class CStudent
{
private:
	string Name;
	float Phi, Math ,Ave;
public:
	void Set(string name, float phi, float math)
	{
	  Name = name;
	  Phi = phi;
	  Math = math;
    }
	void Display()
	{
		printf("%s\t%s\t%s\t%s\n", Name, Phi, Math, Ave);
	}
	void Average() 
	{
		Ave = (Phi + Math) / 2;
	}
};
int main()
{
	CStudent first;
	first.Set("LiSi", 88, 66);
	first.Average();
	first.Display();
	return 0;
}
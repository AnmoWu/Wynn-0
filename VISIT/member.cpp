#include<iostream>
#include<string>
using namespace std;
#define MAXLINE 100
class CStudent
{
  public:
	  CStudent(string name, float sc);
	  static float average();
	  void Print();
	  ~CStudent();
  private:
	  string SName;
	  float Score;
	  static int studentTotal;
	  static float SumScore;
};
int CStudent::studentTotal = 0;
float CStudent::SumScore = 0;
CStudent::CStudent(string name, float sc)
{
	SName = name;
	Score = sc;
	studentTotal++;
	SumScore += sc;
	printf("%s Consructor called.",SName);
}
void CStudent::Print()
{
	printf("%s : %e", SName, Score);
}
float CStudent::average()
{
	return(SumScore / studentTotal);
}
CStudent::~CStudent()
{
	studentTotal--;
	SumScore -= Score;
	printf("%s Destructor called.", SName);
}
int main()
{ 
	CStudent first("LiSi", 90);
	CStudent second("ZhangSan", 80);
	first.Print();
	second.average();
	printf("平均分成：%e", CStudent::average());
	return 0;
}
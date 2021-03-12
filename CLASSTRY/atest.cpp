#include<stdio.h>
struct Node
{
    int num;
	struct Node* next;
};
int main()
{
	Node s[3] = {
		{1,NULL},{2,NULL},{3,NULL}
	};
	Node* p, * q, * r;

	s[0].next = s + 1;
	s[1].next = s + 2;
	s[2].next = s;

	p = s;
	q = p->next;
	r = q->next;

	int sum = 0;

	sum += q->next->num;
	sum += r->next->next->num;
	printf("%d", sum);

	return 0;
}
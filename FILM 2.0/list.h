#pragma once
#ifndef LIST_H_
#define LIST_H_
#include<stdbool.h>

#define SIZE 45
struct film
{
	char title[SIZE];
	int rating;
};

typedef struct film Item;

typedef struct node
{
	Item item;
	struct node* next;
}Node;

typedef Node* List;

void InitializeList(List* plist);

bool ListIsEmpty(const List* plist);

bool ListIsFull(const List* plist);

unsigned int ListItemCount(const List* plist);

bool AddItem(Item item, List* plist);

void Traverse(const List* plist, void(*pun)(Item item));

void EmptyTheList(List* plist);

#endif

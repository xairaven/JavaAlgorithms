#include <iostream>
#include <string>
using namespace std;

//Struct
struct Node {
    int value;
    Node* pointerToNextElem;
};

//prototypes
Node* createList();
void deleteList(Node* first);
void printList(Node* first);
void printList(Node* first, int startIndex, int endIndex);
void pushBack(Node* &first, int value);
int listLength(Node* first);
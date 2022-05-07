#include <iostream>
#include <string>
using namespace std;

//Struct
struct Node {
    int value;
    Node* pointerToNextElem;
};

//prototypes
Node* createList ();
Node* copyList   (Node* first);
int   listLength (Node* first);
void  deleteList (Node* first);
void  deleteElem (Node* &first, int index);
void  insertElem (Node* &first, int index, int value);
void  printList  (Node* first);
void  printList  (Node* first, int startIndex, int endIndex);
void  pushBack   (Node* &first, int value);
void  popBack    (Node* &first);
void  sortList   (Node* first);

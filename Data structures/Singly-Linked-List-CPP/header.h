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
int list_length(Node* first);
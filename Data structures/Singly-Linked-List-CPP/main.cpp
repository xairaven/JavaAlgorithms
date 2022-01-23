#include "header.h"

int main() {
    Node* list = createList();
    pushBack(list, 5);
    cout << list << endl;
    cout << "Length of the list: " << listLength(list) << endl;
    printList(list);
    deleteList(list);
    return 0;
}

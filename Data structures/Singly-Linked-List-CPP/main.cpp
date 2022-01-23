#include "header.h"

int main() {
    Node* list = createList();
    cout << "Length of the list: " << listLength(list) << endl;
    printList(list);
    deleteList(list);
    return 0;
}

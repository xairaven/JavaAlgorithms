#include "header.h"

int main() {
    Node* list = createList();
    cout << "Length of the list: " << list_length(list) << endl;
    deleteList(list);
    return 0;
}

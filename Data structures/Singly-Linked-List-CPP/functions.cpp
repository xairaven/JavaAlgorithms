#include "header.h"

Node* createList() {
    Node* first = new Node;
    Node* previous;
    Node* current = first;
    previous = current;
    cout << "Creating list.\nEnter numbers or STOP:\n";
    while (true) {
        string value;
        cin >> value;
        if (value == "STOP"){
            previous -> next = nullptr;
            delete current;
            break;
        }
        current -> value = stoi(value); //stoi() == string to int function
        current -> next = new Node;
        previous = current;
        current = current -> next;
    }
    return first;
}
#include "header.h"

//creating list
Node* createList() {
    Node* first = new Node;
    Node* current = first;
    Node* previous = current;
    bool firstValueException = true;
    cout << "Creating list.\nEnter numbers or STOP:\n";
    while (true) {
        string value;
        cin >> value;
        if (firstValueException && value == "STOP") {
            return nullptr;
        } else {
            firstValueException = false;
        }
        if (value == "STOP"){
            previous -> pointerToNextElem = nullptr;
            delete current;
            break;
        }
        current -> value = stoi(value); //stoi() == string to int function
        current -> pointerToNextElem = new Node;
        previous = current;
        current = current -> pointerToNextElem;
    }
    return first;
}

//deleting list
void deleteList(Node* first){
    if (first == nullptr) return; //empty list can not be cleared
    Node* current = first;
    while (current)
    {
        first = first -> pointerToNextElem;
        delete current;
        current = first;
    }
}

//getting length of the list
int list_length(Node* first) {
    if(first == nullptr) return 0;
    int length = 1;
    Node* current = first;
    while(current -> pointerToNextElem != nullptr) {
        length++;
        current = current -> pointerToNextElem;
    }
    return length;
}
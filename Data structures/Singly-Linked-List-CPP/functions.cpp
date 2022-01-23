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
int listLength(Node* first) {
    if (first == nullptr) return 0;
    int length = 1;
    Node* current = first;
    while(current -> pointerToNextElem != nullptr) {
        length++;
        current = current -> pointerToNextElem;
    }
    return length;
}

//print list
void printList(Node* first) {
    if (first == nullptr) return;
    Node* current = first;
    while (current) {
        cout << current -> value << endl;
        current = current -> pointerToNextElem;
    }
}

//print list starting with index startIndex and ending with index endIndex
void printList(Node* first, int startIndex, int endIndex) {
    if (first == nullptr) return;
    Node* current = first;
    int counter = 0;
    while (current) {
        if (counter >= startIndex && counter < endIndex) cout << current -> value << endl;
        current = current -> pointerToNextElem;
        counter++;
    }
}

//push element into back of the list
void pushBack(Node* &first, int value) {
    Node* current = first;
    Node* previous = current;
    int length = 0; //for 0st index
    while (current) {
        previous = current;
        current = current->pointerToNextElem;
        length++;
    }
    current = new Node;
    current -> value = value;
    current -> pointerToNextElem = nullptr;
    if (length != 0) {
        previous -> pointerToNextElem = current;
    } else {
        first = current;
    }
}

void popBack(Node* &first) {
    if (first == nullptr) return;
    Node* current = first;
    Node* previous = current;
    int length = 0; //for 0st index
    while (current -> pointerToNextElem) {
        previous = current;
        current = current->pointerToNextElem;
        length++;
    }
    if (length > 1) {
        delete current;
        previous -> pointerToNextElem = nullptr;
    } else {
        first = nullptr;
    }
}
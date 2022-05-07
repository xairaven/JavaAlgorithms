# Documentation ![](https://img.shields.io/badge/Code-C++-informational?style=flat-square&logo=C%2B%2B&logoColor=white&color=5194f0)
### Author: xairaven
### How to start?
- Create list (int values)
```cpp
Node* list = createList();
```

### Functions (prototypes)
- Delete list
```cpp
void deleteList (Node* list);
```
- Delete node (element)
```cpp
void deleteElem (Node* &list, int index);
```
- (Get) List length
```cpp
int listLength (Node* list);
```
- (Get) List copy
```cpp
Node* copyList (Node* list);
```
- (Get) Print list
```cpp
void printList (Node* list);
```
- (Get) Print list interval
```cpp
void printList (Node* list, int startIndex, int endIndex);
```
- (Set) Insert element
```cpp
void insertElem (Node* &list, int index, int value);
```
- (Set) Push back element
```cpp
void pushBack (Node* &list, int value);
```
- (Set) Pop back element
```cpp
void popBack (Node* &list);
```
- (Set) Sort list (bubble-sort)
```cpp
void sortList (Node* first);
```

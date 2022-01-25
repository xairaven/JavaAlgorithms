# Documentation ![](https://img.shields.io/badge/Code-Java-informational?style=flat-square&logo=Java&logoColor=white&color=5194f0)
### Author: xairaven
### How to start?
- Enter any number from [largeWSorted.txt](https://github.com/xairaven/Algorithms-Data-Structures/tree/main/Algorithms/resources/txt_files)
```Java
int key = 688426; //random number from largeWSorted.txt
```
- Profit!
```console
Index of number 688426 is 687500
```
### Prototype of the metod "Binary search"
```Java
public static int binarySearch(int key, int[] arr, int lo, int hi)
```
- **key** - number from [largeWSorted.txt](https://github.com/xairaven/Algorithms-Data-Structures/tree/main/Algorithms/resources/txt_files)
- **arr** - int array, all numbers from [largeWSorted.txt](https://github.com/xairaven/Algorithms-Data-Structures/tree/main/Algorithms/resources/txt_files)
- **lo** = 0 (low index)
- **high** = array.length - 1 (high index)
### Resources
- I used library "stdlib.jar", licensed by GNU (GPL) v.3.<br>
- Authors: *Robert Sedgwick* and *Kevin Wayne*<br>
- Link: http://introcs.cs.princeton.edu/java/stdlib/stdlib-package.jar
- An archive that contains data files (largeW and e.t.c.) can be found at: http://algs4.cs.princeton.edu/code/algs4-data.zip

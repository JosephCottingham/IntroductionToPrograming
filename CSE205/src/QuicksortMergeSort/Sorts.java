// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Five Quicksort & Merge Sort
// Author: Joseph H Cottingham | 1216723703
// Description: Implimention of quicksort and merge sort


public class Sorts {

    // Quicksort ------------------------------------------------------------------------------------

    public static void quicksort(MyList<Integer> aList) {
        // calls meathod built for recurserion
        recursiveQuicksort(aList, 0);
    }

    private static void recursiveQuicksort(MyList<Integer> aList, int pivote) {
        // if pivote values is the out of bounds it returns as sort is complete
        if (pivote >= aList.size()) return;
        // swap index represents the temp storage location where values smaller than the piviote will be moved
        int swapIndex = pivote + 1;
        // loops though moving smaller vlaues to swapIndex
        for (int x = pivote + 1; x < aList.size(); x++) {
            if (aList.get(x) < aList.get(pivote)) {
                swap(aList, x, swapIndex);
                swapIndex++;
            }
        }
        // Moves one value before the pivot if their was a lower value, else it swaps with itself
        swap(aList, pivote, swapIndex - 1);

        if (swapIndex > pivote + 1)
            recursiveQuicksort(aList, pivote);
        else
            recursiveQuicksort(aList, pivote + 1);
    }

    // Mergesort ------------------------------------------------------------------------------------

    public static void mergesort(MyList<Integer> aList) {
        // retrieves a sorted list
        MyList<Integer> temp = recursiveMergesort(aList, aList.size() / 2);
        // Populates memory adress of the given list
        for (int x = 0; x < aList.size(); x++) {
            aList.set(x, temp.get(x));
        }
    }

    private static MyList<Integer> recursiveMergesort(MyList<Integer> alist, int pivote) {
        // list consists on one element and therefore is already sorted
        if (alist.size() < 2) return alist;
        // list is large enough that it needs to be broke up again to eventualy form chuncks of two
        else if (alist.size() > 2) {
            // creating and populateing two temp lists that will each have one half of the list
            MyArrayList<Integer> tempA = new MyArrayList<Integer>();
            MyArrayList<Integer> tempB = new MyArrayList<Integer>();
            for (int x = 0; x < pivote; x++) {
                tempA.add(alist.get(x));
            }
            for (int x = pivote; x < alist.size(); x++) {
                tempB.add(alist.get(x));
            }
            // this will merge the returned lists for order after breaking them down into small section that where switched for order
            return mergeOrderedLists(recursiveMergesort(tempA, tempA.size() / 2), recursiveMergesort(tempB, tempB.size() / 2));
        } else {
            // if the list has only two values stored then it checks which is larger and returns a list that reflects that
            if (alist.get(0) > alist.get(1)) swap(alist, 0, 1);
            return alist;
        }
    }

    private static MyList<Integer> mergeOrderedLists(MyList<Integer> listA, MyList<Integer> listB) {
        // starting index values
        int indexA = 0;
        int indexB = 0;
        MyList<Integer> temp = new MyArrayList<Integer>();
        // Sort though lists comparing then untill on is empty
        while (indexA < listA.size() && indexB < listB.size()) {
            if (listA.get(indexA) > listB.get(indexB)) {
                temp.add(listB.get(indexB));
                indexB++;
            } else {
                temp.add(listA.get(indexA));
                indexA++;
            }
        }
        // once one is empty these loops will check and add any values not added to the temp list from both lists
        while (indexA < listA.size()) {
            temp.add(listA.get(indexA));
            indexA++;
        }
        while (indexB < listB.size()) {
            temp.add(listB.get(indexB));
            indexB++;
        }
        return temp;
    }

    // Used by both quick and merge sort ----------------------------------------------------------------------------

    private static void swap(MyList<Integer> aList, int a, int b) {
        // Swaps values of indexs of a given MyList object
        Integer tempVal = aList.get(a);
        aList.set(a, aList.get(b));
        aList.set(b, tempVal);
    }
}

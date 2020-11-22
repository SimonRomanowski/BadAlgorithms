package de.lasagevo.badalgs.algorithms;

import de.lasagevo.badalgs.UiPrinter;

import static de.lasagevo.badalgs.algorithms.ArrayUtils.printArrayWithPointer;
import static de.lasagevo.badalgs.algorithms.ArrayUtils.swap;
import static de.lasagevo.badalgs.algorithms.ArrayUtils.swapVerbose;
import static de.lasagevo.badalgs.algorithms.SortingAlgorithm.printSortingMessage;

/**
 * This class implements the quicksort algorithm.
 * <p>Quicksort needs Θ(n²) comparisons and Θ(n) permutations but it has a
 * very common best-case of O(n*log((n)), making it one of the most effective
 * sorting algorithms.</p>
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public final class QuickSort implements SortingAlgorithm {

    @Override
    public void sort(final int... arr) {
        recSort(arr, 0, arr.length - 1);
    }

    private void recSort(final int[] arr, final int left, final int right) {
        if (left < right) {
            // Choosing the last element as the pivot element
            final int pivot = right;
            int leftPointer = left;
            int rightPointer = right - 1;
            do {
                // Run through the array from the left until you encounter an
                // entry that is larger than the pivot element.
                while (leftPointer <= rightPointer
                       && arr[leftPointer] <= arr[pivot]) {
                    leftPointer++;
                }
                // Run through the array from the right until you encounter an
                // entry that is smaller than the pivot element.
                while (leftPointer <= rightPointer
                       && arr[rightPointer] >= arr[pivot]) {
                    rightPointer--;
                }
                // If we found two different elements that each are on the wrong
                // side of the array, we swap them and go on.
                if (leftPointer < rightPointer) {
                    swap(arr, rightPointer, leftPointer);
                    rightPointer--;
                    leftPointer++;
                }
            } while (leftPointer < rightPointer);
            // Pivot element goes to the middle
            swap(arr, leftPointer, pivot);
            // Sort both halves recursively
            recSort(arr, left, leftPointer - 1);
            recSort(arr, leftPointer + 1, right);
        }
    }

    @Override
    public void sortVerbose(final UiPrinter printer, final int... arr) {
        recSortVerbose(arr, 0, arr.length - 1, printer);
    }

    private void recSortVerbose(final int[] arr, final int left,
                                final int right, final UiPrinter printer) {
        printSortingMessage("recursive quicksort", printer);
        printArrayWithPointer(arr, left, 'l', printer);
        printArrayWithPointer(arr, right, 'r', printer);
        if (left < right) {
            // Choosing the last element as the pivot element
            final int pivot = right;
            printArrayWithPointer(arr, pivot, 'p', printer);
            int leftPointer = left;
            printArrayWithPointer(arr, leftPointer, 'i', printer);
            int rightPointer = right - 1;
            printArrayWithPointer(arr, rightPointer, 'j', printer);
            do {
                // Run through the array from the left until you encounter an
                // entry that is larger than the pivot element.
                while (leftPointer <= rightPointer
                        && arr[leftPointer] <= arr[pivot]) {
                    leftPointer++;
                }
                // Run through the array from the right until you encounter an
                // entry that is smaller than the pivot element.
                while (leftPointer <= rightPointer
                        && arr[rightPointer] >= arr[pivot]) {
                    rightPointer--;
                }
                // If we found two different elements that each are on the wrong
                // side of the array, we swap them and go on.
                if (leftPointer < rightPointer) {
                    swapVerbose(arr, rightPointer, leftPointer, printer);
                    rightPointer--;
                    leftPointer++;
                }
            } while (leftPointer < rightPointer);
            // Pivot element goes to the middle
            swapVerbose(arr, leftPointer, pivot, printer);
            // Sort both halves recursively
            recSortVerbose(arr, left, leftPointer - 1, printer);
            recSortVerbose(arr, leftPointer + 1, right, printer);
        }
    }
}

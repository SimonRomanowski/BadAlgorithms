package de.lasagevo.badalgs.algorithms;

import de.lasagevo.badalgs.UiPrinter;

import static de.lasagevo.badalgs.algorithms.ArrayUtils.printArrayWithPointer;
import static de.lasagevo.badalgs.algorithms.ArrayUtils.swap;
import static de.lasagevo.badalgs.algorithms.ArrayUtils.swapVerbose;
import static de.lasagevo.badalgs.algorithms.SortingAlgorithm.printSortingMessage;

/**
 * This class implements the heapsort algorithm.
 * <p>Heapsort needs O(n*log(n)) comparisons and permutations in its
 * worst-case.</p>
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public final class HeapSort implements SortingAlgorithm {

    @Override
    public void sort(final int... arr) {
        // Construct max heap
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, arr.length - 1);
        }
        // Sort heap
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            siftDown(arr, 0, i - 1);
        }
    }

    private void siftDown(final int[] arr, final int siftIndex,
                          final int maxIndex) {
        int toSift = siftIndex;
        while (2 * toSift + 1 <= maxIndex) {
            int successor = 2 * toSift + 1;
            // Choose the larger of two successors
            if (successor + 1 <= maxIndex
                && arr[successor] < arr[successor + 1]) {
                successor++;
            }
            if (arr[toSift] < arr[successor]) {
                swap(arr, toSift, successor);
                toSift = successor;
            } else {
                break;
            }
        }
    }

    @Override
    public void sortVerbose(final UiPrinter printer, final int... arr) {
        printSortingMessage("heapsort", printer);
        // Construct max heap
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            printArrayWithPointer(arr, i, 'i', printer);
            siftDownVerbose(arr, i, arr.length - 1, printer);
        }
        printer.print("\tHeap constructed!");
        // Sort heap
        for (int i = arr.length - 1; i > 0; i--) {
            swapVerbose(arr, i, 0, printer);
            siftDown(arr, 0, i - 1);
        }
    }

    private void siftDownVerbose(final int[] arr, final int siftIndex,
                                 final int maxIndex, final UiPrinter printer) {
        int toSift = siftIndex;
        while (2 * toSift + 1 <= maxIndex) {
            int successor = 2 * toSift + 1;
            // Choose the larger of two successors
            if (successor + 1 <= maxIndex
                    && arr[successor] < arr[successor + 1]) {
                successor++;
            }
            if (arr[toSift] < arr[successor]) {
                swapVerbose(arr, toSift, successor, printer);
                toSift = successor;
            } else {
                break;
            }
        }
    }
}

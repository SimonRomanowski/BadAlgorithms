package de.lasagevo.badalgs.algorithms;

import de.lasagevo.badalgs.UiPrinter;

import static de.lasagevo.badalgs.algorithms.ArrayUtils.printArrayWithPointer;
import static de.lasagevo.badalgs.algorithms.ArrayUtils.swap;
import static de.lasagevo.badalgs.algorithms.ArrayUtils.swapVerbose;
import static de.lasagevo.badalgs.algorithms.SortingAlgorithm.printSortingMessage;

/**
 * This class implements the insertion sort algorithm.
 * <p>Insertion sort needs Θ(n²) comparisons and Θ(n²) permutations
 * in its worst-case.</p>
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public final class InsertionSort implements SortingAlgorithm {

    @Override
    public void sort(final int... arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = i;
            while (current > 0 && arr[current] < arr[current - 1]) {
                swap(arr, current, current - 1);
                current--;
            }
        }
    }

    @Override
    public void sortVerbose(final UiPrinter printer, final int... arr) {
        printSortingMessage("insertion sort", printer);
        for (int i = 1; i < arr.length; i++) {
            printArrayWithPointer(arr, i, 'i', printer);
            int current = i;
            while (current > 0 && arr[current] < arr[current - 1]) {
                swapVerbose(arr, current, current - 1, printer);
                current--;
                printArrayWithPointer(arr, current,
                        'j', printer);
            }
        }
    }
}

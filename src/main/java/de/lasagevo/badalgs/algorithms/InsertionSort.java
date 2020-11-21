package de.lasagevo.badalgs.algorithms;

import de.lasagevo.badalgs.UiPrinter;

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
                ArrayUtils.swap(arr, current, current - 1);
                current--;
            }
        }
    }

    @Override
    public void sortVerbose(final UiPrinter printer, final int... arr) {
        SortingAlgorithm.printSortingMessage("insertion sort", printer);
        for (int i = 1; i < arr.length; i++) {
            ArrayUtils.printArrayWithPointer(arr, i, 'i', printer);
            int current = i;
            while (current > 0 && arr[current] < arr[current - 1]) {
                ArrayUtils.swapVerbose(arr, current, current - 1, printer);
                current--;
                ArrayUtils.printArrayWithPointer(arr, current,
                        'j', printer);
            }
        }
    }
}

package de.lasagevo.badalgs.algorithms;

import de.lasagevo.badalgs.UiPrinter;

/**
 * This class implements the selection sort algorithm.
 * <p>Selection sort needs Θ(n²) comparisons and Θ(n) permutations.</p>
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public final class SelectionSort implements SortingAlgorithm {

    @Override
    public void sort(final int... arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minimum = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minimum]) {
                    minimum = j;
                }
            }
            ArrayUtils.swap(arr, i, minimum);
        }
    }

    @Override
    public void sortVerbose(final UiPrinter printer, final int... arr) {
        SortingAlgorithm.printSortingMessage("selection sort", printer);
        for (int i = 0; i < arr.length - 1; i++) {
            ArrayUtils.printArrayWithPointer(arr, i, 'i', printer);
            int minimum = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minimum]) {
                    minimum = j;
                }
            }
            ArrayUtils.printArrayWithPointer(arr, minimum,
                    'm', printer);
            ArrayUtils.swapVerbose(arr, i, minimum, printer);
        }
    }

}

package de.lasagevo.badalgs.algorithms;

import de.lasagevo.badalgs.UiPrinter;

import static de.lasagevo.badalgs.algorithms.ArrayUtils.printArrayWithPointer;
import static de.lasagevo.badalgs.algorithms.ArrayUtils.swap;
import static de.lasagevo.badalgs.algorithms.ArrayUtils.swapVerbose;
import static de.lasagevo.badalgs.algorithms.SortingAlgorithm.printSortingMessage;

/**
 * This class implements the bubble sort algorithm.
 * <p>Bubble sort needs Θ(n²) comparisons and Θ(n²) permutations
 * in its worst-case.</p>
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public final class BubbleSort implements SortingAlgorithm {

    @Override
    @SuppressWarnings("PMD.DataflowAnomalyAnalysis")
    public void sort(final int... arr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    @Override
    @SuppressWarnings("PMD.DataflowAnomalyAnalysis")
    public void sortVerbose(final UiPrinter printer, final int... arr) {
        printSortingMessage("bubble sort", printer);
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                printArrayWithPointer(arr, i, 'i', printer);
                if (arr[i] > arr[i + 1]) {
                    swapVerbose(arr, i, i + 1, printer);
                    swapped = true;
                }
            }
        }
    }
}

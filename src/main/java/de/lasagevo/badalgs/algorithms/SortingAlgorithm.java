package de.lasagevo.badalgs.algorithms;

import de.lasagevo.badalgs.UiPrinter;

/**
 * These classes implement methods to sort an int array.
 */
public interface SortingAlgorithm {

    /**
     * Prints a message indicating the sort to the {@link UiPrinter}.
     * @param algName The name that is printed
     * @param printer The {@link UiPrinter} to print to
     */
    static void printSortingMessage(final String algName,
                                    final UiPrinter printer) {
        printer.print("\tSorting with " + algName + "...");
    }

    /**
     * Sort the array with the specified algorithm.
     * @param arr The array to sort
     */
    void sort(int... arr);

    /**
     * Sort the array with the specified algorithm and print additional
     * information to the {@link UiPrinter}.
     * @param printer The {@link UiPrinter} to print to
     * @param arr The array to sort
     */
    void sortVerbose(UiPrinter printer, int... arr);

}

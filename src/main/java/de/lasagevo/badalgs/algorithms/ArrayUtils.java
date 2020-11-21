package de.lasagevo.badalgs.algorithms;

import de.lasagevo.badalgs.UiPrinter;

/**
 * Naive utilities for arrays.
 */
@SuppressWarnings("PMD")
public final class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * Swap the entries i and j in the array arr.
     * @param arr The array to swap in
     * @param first The index of the first entry
     * @param second The index of the second entry
     */
    public static void swap(final int[] arr, final int first,
                            final int second) {
        final int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    /**
     * Prints the array to the {@link UiPrinter} with a pointer to the
     * given position.
     * <p>If the pointerPos is < 0 or >= arr.length nothing will happen.<br>
     * Otherwise the array will be printed, lead by a tab and inserted into
     * [ ]s, each element seperated by a comma.<br>
     * Below the array, the pointerName will be printed at the specified
     * location.</p>
     * @param arr The array to be printed
     * @param pointerPos Index of the pointer
     * @param pointerName Name of the pointer
     * @param printer {@link UiPrinter} that should be printed to
     */
    public static void printArrayWithPointer(final int[] arr,
                                             final int pointerPos,
                                             final char pointerName,
                                             final UiPrinter printer) {
        if (pointerPos < arr.length && pointerPos >= 0) {
            // Assign element lengths
            int[] lengths = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                final int current = arr[i];
                if (current > 0) {
                    lengths[i] = (int) Math.log10(current) + 1;
                } else if (current < 0) {
                    lengths[i] = (int) Math.log10(-1 * current) + 2;
                } else {
                    lengths[i] = 1;
                }
            }
            // Print array
            String arrayString = "\t[";
            for (int i = 0; i < arr.length; i++) {
                arrayString += " " + arr[i];
                if (i != arr.length - 1) {
                    arrayString += ",";
                }
            }
            arrayString += "]";
            // Print pointer
            printer.print(arrayString);
            // Calculate amount of whitespace
            int whitespaceCount = 0;
            for (int i = 0; i < pointerPos; i++) {
                // Number length + ',' + ' '
                whitespaceCount += lengths[i] + 2;
            }
            // Ignore last digit for the last entry
            whitespaceCount += lengths[pointerPos] - 1;
            // Build whitespace string
            final StringBuilder builder =
                    new StringBuilder(whitespaceCount + 3);
            builder.append("\t ");
            builder.append(" ".repeat(Math.max(0, whitespaceCount + 1)));
            builder.append(pointerName);
            // Print whitespace and counter
            printer.print(builder.toString());
        }
    }

    /**
     * Swap the entries i and j in the array arr.
     * <p>Additionally, a message indicating what is swapped is printed
     * to the {@link UiPrinter}</p>
     * @param arr The array to swap in
     * @param first The index of the first entry
     * @param second The index of the second entry
     * @param printer The {@link UiPrinter} to print to
     */
    public static void swapVerbose(final int[] arr, final int first,
                                   final int second, final UiPrinter printer) {
        printer.print("\tSwapping " + first + " with " + second);
        swap(arr, first, second);
    }
}

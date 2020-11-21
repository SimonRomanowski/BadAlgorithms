package de.lasagevo.badalgs;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Reads the user's input.
 */
public final class UiReader {

    /**
     * The Scanner that reads the user's input.
     */
    private final transient Scanner scanner;

    /**
     * Creates an instance of a reader that reads input from the given source.
     * @param input
     */
    @SuppressFBWarnings("DM_DEFAULT_ENCODING")
    public UiReader(final InputStream input) {
        scanner = new Scanner(input);
    }

    /**
     * Returns the next line that the user enters as 1 String.
     * @return
     *      The next input
     */
    public String readInput() {
        String input;
        if (scanner.hasNext()) {
            input = scanner.nextLine();
        } else {
            input = "";
        }
        return input;
    }

    /**
     * Closes the reader.
     */
    public void closeReader() {
        scanner.close();
    }

    /**
     * Reads an array of integers from the user input.
     * <p>Returns null if the input was invalid.</p>
     * @return The input as an int array
     */
    @SuppressWarnings("PMD.NullAssignment")
    public int[] readArray() {
        // Read input
        String input;
        if (scanner.hasNext()) {
            input = scanner.nextLine();
        } else {
            input = null;
        }
        // Create int array
        int[] array;
        if (input == null) {
            array = null;
        } else {
            final String[] splitInput = input.split(" ");
            try {
                array = new int[splitInput.length];
                for (int i = 0; i < array.length; i++) {
                    array[i] = Integer.parseInt(splitInput[i]);
                }
            } catch (NumberFormatException e) {
                array = null;
            }
        }
        return array;
    }
}

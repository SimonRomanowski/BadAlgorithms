package de.lasagevo.badalgs;

import java.io.PrintStream;

/**
 * Prints the applications output.
 */
public class UiPrinter {

    /**
     * The PrintStream that this class prints its output to.
     */
    private final transient PrintStream output;

    /**
     * Creates an instance that prints to the given PrintStream.
     *
     * @param out
     *      The PrintStream that should be printed to
     */
    public UiPrinter(final PrintStream out) {
        output = out;
    }

    /**
     * Prints the greeting of the Bad Algorithms application.
     */
    public void printGreeting() {
        // Print title
        output.println("\n\nB A D   A L G O R I T H M S");
        // Print greeting with an additional newline
        output.println("\tWelcome to BadAlgorithms!\n");
    }

    /**
     * Prints the String to the output.
     * @param input
     *      The String that should be printed
     */
    public void print(final String input) {
        output.println(input);
    }

    /**
     * Print the farewell of the application.
     */
    public void printFarewell() {
        // Print farewell
        output.println("\tGoodbye!\n");
    }
}

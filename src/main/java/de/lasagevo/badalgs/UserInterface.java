package de.lasagevo.badalgs;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * The main class of the UI, communicating with the given input and output.
 */
public class UserInterface {

    /**
     * The {@link UiPrinter} instance that prints the applications output.
     */
    private final transient UiPrinter printer;

    /**
     * The {@link UiReader} instance that reads the users input.
     */
    private final transient UiReader reader;

    /**
     * The {@link CommandProcessor} instance that interprets the input.
     */
    private final transient CommandProcessor processor;

    /**
     * Creates a user interface for Bad Algorithms, that prints to the
     * given PrintStream instance.
     * @param output
     *      The PrintStream that should display the application
     * @param input
     *      The InputStream that the application should read from
     */
    public UserInterface(final PrintStream output, final InputStream input) {
        printer = new UiPrinter(output);
        reader = new UiReader(input);
        processor = new CommandProcessor(printer, reader);
    }

    /**
     * Start the application, printing a greeting message and then expecting
     * user input.
     */
    public void start() {
        // Print the greeting to the output
        printer.printGreeting();
        while (processor.shouldKeepRunning()) {
            // Read input with a newline afterwards
            final String input = reader.readInput();
            printer.print("");
            // Parse command
            final Command command = CommandHelper.parse(input);
            // Execute command
            processor.execute(command);
        }
        // Print farewell
        printer.printFarewell();
    }
}

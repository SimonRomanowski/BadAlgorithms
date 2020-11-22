package de.lasagevo.badalgs;

import de.lasagevo.badalgs.algorithms.SortingAlgorithm;

import java.util.Arrays;

/**
 * This class executes {@link Command}s.
 */
public final class CommandProcessor {

    /**
     * The message that should be displayed, when a command ist not found.
     */
    private static final String COMMAND_NOT_FOUND =
              "\tCommand was not found...\n"
            + "\tType 'help' for a list of commands.";

    /**
     * The {@link UiPrinter} instance, that is used to print command outputs.
     */
    private final transient UiPrinter printer;

    /**
     * The {@link UiReader} instance, that is used to read user input.
     */
    private final transient UiReader reader;

    /**
     * Decides, if the application should keep running.
     */
    private transient boolean keepRunning = true;

    /**
     * If true, all algorithms will print additional information.
     * <p>Turned off by default.</p>
     */
    private transient boolean verbose;

    /**
     * The list of integers to sort, defined by user input.
     */
    private transient int[] array;

    /**
     * Creates a {@link CommandProcessor} that prints to the given
     * {@link UiPrinter}.
     * @param uiPrinter The {@link UiPrinter} to print to
     * @param uiReader The {@link UiReader} to read from
     */
    public CommandProcessor(final UiPrinter uiPrinter,
                            final UiReader uiReader) {
        printer = uiPrinter;
        reader = uiReader;
    }

    /**
     * Returns true if the application should keep running.
     * @return
     *      True, if and only if the application should keep running.
     */
    public boolean shouldKeepRunning() {
        return keepRunning;
    }

    /**
     * Executes the given command.
     * <p>Shoulf the {@link Command} be {@code null}, an error
     * message will be printed.</p>
     * @param command
     *      The command to be executed.
     */
    public void execute(final Command command) {
        if (command == null) {
            printer.print(COMMAND_NOT_FOUND);
        } else if (CommandHelper.isSortingCommand(command)) {
            sort(CommandHelper.asSorting(command));
        } else {
            switch (command) {
                case HELP:
                    printHelp();
                    break;

                case END:
                    keepRunning = false;
                    break;

                case LIST:
                    readList();
                    break;

                case SHOW:
                    showInputs();
                    break;

                case VERBOSE:
                    switchVerbose();
                    break;

                default:
                    printer.print("\tCommand not yet implemented...");
                    break;
            }
        }
        // End command execution with a newline
        printer.print("");
    }

    private void readList() {
        printer.print("\tEnter a list of integers seperated by whitespace:");
        array = reader.readArray();
        if (array == null) {
            printer.print("\tThere has been an error reading the list...");
        } else {
            printer.print("\tList read succesfully!");
        }
    }

    private void switchVerbose() {
        verbose = !verbose;
        String verboseMessage = "\tVerbose is ";
        if (!verbose) {
            verboseMessage += "not ";
        }
        printer.print(verboseMessage + "activated.");
    }

    /**
     * Sort the entered array with the specified sorting algorithm.
     * @param algorithm The algorithm to sort with
     */
    private void sort(final SortingAlgorithm algorithm) {
        if (array == null) {
            printer.print("\tDefine a list using 'list' first!");
        } else {
            if (verbose) {
                algorithm.sortVerbose(printer, array);
                printer.print("\tDone!");
            } else {
                algorithm.sort(array);
            }
        }
    }

    /**
     * Show the entered list of integers or note if there is none.
     */
    private void showInputs() {
        if (array == null) {
            printer.print("\tNo integer list defined yet.");
            printer.print("\tUse 'list' to define one.");
        } else {
            printer.print("\t" + Arrays.toString(array));
        }
    }

    /**
     * Print a list of all commands with their descriptions.
     */
    private void printHelp() {
        final Command[] commands = Command.values();
        for (final Command c: commands) {
            printer.print("\t" + c.toString());
        }
    }

}

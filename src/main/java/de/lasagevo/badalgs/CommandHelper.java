package de.lasagevo.badalgs;

import de.lasagevo.badalgs.algorithms.BubbleSort;
import de.lasagevo.badalgs.algorithms.HeapSort;
import de.lasagevo.badalgs.algorithms.InsertionSort;
import de.lasagevo.badalgs.algorithms.QuickSort;
import de.lasagevo.badalgs.algorithms.SelectionSort;
import de.lasagevo.badalgs.algorithms.SortingAlgorithm;

import java.util.Locale;

/**
 * This class allows parsing of Strings to {@link Command}s.
 */
public final class CommandHelper {

    private CommandHelper() {
    }

    /**
     * Interprets a String to a {@link Command} Object.
     * <p>If the command can not be found, {@code null} is returned instead.
     * @param command
     *      The command as a String
     * @return
     *      The command as {@link Command}
     */
    @SuppressWarnings({"PMD.EmptyCatchBlock", "PMD.DataflowAnomalyAnalysis"})
    public static Command parse(final String command) {
        Command parsed = null;
        try {
            parsed = Command.valueOf(command.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException e) {
            // Just return null
        }
        return parsed;
    }



    /**
     * Returns true if and only if the command is a sorting command.
     * @param command The command to check
     * @return True if it is a sorting command
     */
    public static boolean isSortingCommand(final Command command) {
        boolean isSorting;
        switch (command) {
            case BUB_SORT: // Falls through
            case INS_SORT: // Falls through
            case QUI_SORT: // Falls through
            case HEA_SORT: // Falls through
            case SEL_SORT:
                isSorting = true;
                break;

            default:
                isSorting = false;
                break;
        }
        return isSorting;
    }

    /**
     * Returns the {@link SortingAlgorithm} corresponding to the command.
     * <p>If it is no sorting command, null is returned.</p>
     * @param command The command to check
     * @return The corresponding {@link SortingAlgorithm}, or null
     */
    @SuppressWarnings("PMD.NullAssignment")
    public static SortingAlgorithm asSorting(final Command command) {
        SortingAlgorithm sorting;
        switch (command) {
            case BUB_SORT:
                sorting = new BubbleSort();
                break;

            case INS_SORT:
                sorting = new InsertionSort();
                break;

            case SEL_SORT:
                sorting = new SelectionSort();
                break;

            case QUI_SORT:
                sorting = new QuickSort();
                break;

            case HEA_SORT:
                sorting = new HeapSort();
                break;

            default:
                sorting = null;
                break;
        }
        return sorting;
    }

}

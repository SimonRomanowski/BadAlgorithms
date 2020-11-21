package de.lasagevo.badalgs;

import de.lasagevo.badalgs.algorithms.BubbleSort;
import de.lasagevo.badalgs.algorithms.InsertionSort;
import de.lasagevo.badalgs.algorithms.SelectionSort;
import de.lasagevo.badalgs.algorithms.SortingAlgorithm;

/**
 * Commands are certain inputs that can be interpreted by the application.
 */
public enum Command {

    /**
     * The 'help' command.
     */
    HELP {
        @Override
        public String toString() {
            return "help - show a list of all commands";
        }
    },

    /**
     * The 'end' command.
     */
    END {
        @Override
        public String toString() {
            return "end - end the application";
        }
    },

    /**
     * The 'list' command.
     */
    LIST {
        @Override
        public String toString() {
            return "list - enter a list of integers for the algorithms to\n"
               + "\t       interact with";
        }
    },

    /**
     * The 'show' command.
     */
    SHOW {
        @Override
        public String toString() {
            return "show - show the currently defined integer list or text";
        }
    },

    /**
     * The 'verbose' command.
     */
    VERBOSE {
        @Override
        public String toString() {
            return "verbose - turn on/off the verbose setting,\n"
                    + "\t          printing additional information while\n"
                    + "\t          executing algorithms";
        }
    },

    /**
     * The 'sel_sort' command.
     */
    SEL_SORT {
        @Override
        public String toString() {
            return "sel_sort - sort your list with selection sort";
        }
    },

    /**
     * The 'ins_sort' command.
     */
    INS_SORT {
        @Override
        public String toString() {
            return "ins_sort - sort your list with insertion sort";
        }
    },

    /**
     * The 'bub_sort' command.
     */
    BUB_SORT {
        @Override
        public String toString() {
            return "bub_sort - sort your list with bubble sort";
        }
    };

    /**
     * Returns true if and only if this is a sorting command.
     * @return True if this is a sorting command
     */
    public boolean isSortingCommand() {
        boolean isSorting;
        switch (this) {
            case BUB_SORT: // Falls through
            case INS_SORT: // Falls through
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
     * Returns the {@link SortingAlgorithm} corresponding to this command.
     * <p>If this is no sorting command, null is returned.</p>
     * @return The corresponding {@link SortingAlgorithm}, or null
     */
    @SuppressWarnings("PMD.NullAssignment")
    public SortingAlgorithm asSorting() {
        SortingAlgorithm sorting;
        switch (this) {
            case BUB_SORT:
                sorting = new BubbleSort();
                break;

            case INS_SORT:
                sorting = new InsertionSort();
                break;

            case SEL_SORT:
                sorting = new SelectionSort();
                break;

            default:
                sorting = null;
                break;
        }
        return sorting;
    }
}

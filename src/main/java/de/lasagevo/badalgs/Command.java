package de.lasagevo.badalgs;

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
            return "show - show the currently defined integer list";
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
     * The 'DONT_sort' command.
     */
    DONT_SORT {
        @Override
        public String toString() {
            return "dont_sort - leaves the entered list untouched by the\n"
               + "\t            sorting algorithm.\n"
               + "\t            Activates verbose setting automatically.";
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
    },

    /**
     * The 'qui_sort' command.
     */
    QUI_SORT {
        @Override
        public String toString() {
            return "qui_sort - sort your list with quicksort";
        }
    },

    /**
     * The 'hea_sort' command.
     */
    HEA_SORT {
        @Override
        public String toString() {
            return "hea_sort - sort your list with heapsort";
        }
    }

}

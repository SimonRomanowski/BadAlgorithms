package de.lasagevo.badalgs;

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

}

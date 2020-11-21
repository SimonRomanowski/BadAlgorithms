package de.lasagevo.badalgs;

/**
 * Represents the entry point to the Bad Algorithms App.
 */
public final class AppEntryPoint {

    private AppEntryPoint() {
    }

    /**
     * Starts the Bad Algorithms App, using standard in/out.
     *
     * @param args Arguments (unused)
     */
    public static void main(final String[] args) {
        final UserInterface userInterface =
                new UserInterface(System.out, System.in);
        userInterface.start();
    }
}

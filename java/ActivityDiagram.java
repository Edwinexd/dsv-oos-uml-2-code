public class ActivityDiagram {
    private static void hireDevelopers() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static void createGame() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static void assignDevelopers(String... developers) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static void releaseGame() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static void reviewGame() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static boolean deservesAward() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static void createAward() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    public static void main(String[] args) {
        // Start
        hireDevelopers();
        createGame();
        assignDevelopers("Henrik", "Olle", "Jozef");
        releaseGame();
        reviewGame();
        // Award?
        if (deservesAward()) {
            // Yes
            createAward();
        }
        // No

        // End
    }
}

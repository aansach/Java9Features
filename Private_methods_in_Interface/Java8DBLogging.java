interface Java8DBLogging {

    default void logInfo(String message) {
        System.out.println("Step1: Connect to DataBase");
        System.out.println("Step2: Log Info Message: " + message);
        System.out.println("Step3: Close the DataBase connection");
    }

    default void logWarn(String message) {
        System.out.println("Step1: Connect to DataBase");
        System.out.println("Step2: Log Warn Message: " + message);
        System.out.println("Step3: Close the DataBase connection");
    }

    default void logError(String message) {
        System.out.println("Step1: Connect to DataBase");
        System.out.println("Step2: Log Error Message: " + message);
        System.out.println("Step3: Close the DataBase connection");
    }

    default void logFatal(String message) {
        System.out.println("Step1: Connect to DataBase");
        System.out.println("Step2: Log Fatal Message: " + message);
        System.out.println("Step3: Close the DataBase connection");
    }
}
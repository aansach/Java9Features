interface Java9DBLogging {
    
    default void logInfo(String message) {
        log(message, "INFO");
    }
    
    default void logWarn(String message) {
        log(message, "WARN");
    }
    
    default void logError(String message) {
        log(message, "ERROR");
    }
    
    default void logFatal(String message) {
        log(message, "FATAL");
    }
    
    private void log(String msg, String logLevel) {
        System.out.println("Step1: Connect to DataBase");
        System.out.println("Step2: Log Message with the Provided logLevel: " + logLevel + " - " + msg);
        System.out.println("Step3: Close the DataBase Connection");
    }
}
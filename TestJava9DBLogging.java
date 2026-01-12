class TestJava9DBLogging implements Java9DBLogging {
    public static void main(String[] args) {
        TestJava9DBLogging obj = new TestJava9DBLogging();
        obj.logInfo("Application started");
        System.out.println();
        obj.logWarn("Low memory warning");
        System.out.println();
        obj.logError("File not found");
        System.out.println();
        obj.logFatal("System crash");
    }
}
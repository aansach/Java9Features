
class TestJava8DBLogging implements Java8DBLogging {
    public static void main(String[] args) {
        TestJava8DBLogging obj = new TestJava8DBLogging();
        obj.logInfo("Application started");
        System.out.println();
        obj.logWarn("Low memory warning");
        System.out.println();
        obj.logError("File not found");
        System.out.println();
        obj.logFatal("System crash");
    }
}
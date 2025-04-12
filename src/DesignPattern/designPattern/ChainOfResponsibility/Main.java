package ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLog(new DebugLog(new ErrorLog(null)));

        logProcessor.log(LogProcessor.INFO, "info message");
        logProcessor.log(LogProcessor.DEBUG, "debug message");
        logProcessor.log(LogProcessor.ERROR, "error message");
//        logProcessor.log(4, "Invalid log method called");
    }
}

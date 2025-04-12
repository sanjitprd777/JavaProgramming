package ChainOfResponsibility;

public class ErrorLog extends LogProcessor {

    ErrorLog(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == ERROR) {
            System.out.println("ERROR: " + message);
        }
        else {
            super.log(logLevel, message);
        }
    }

}

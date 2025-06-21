import java.util.Date;

/**
 * Logger class implementing the Singleton design pattern
 * Ensures only one instance of the logger exists throughout the application
 */
public class Logger {
    // Private static instance of the Logger class (eager initialization)
    private static final Logger instance = new Logger();
    
    // Private constructor to prevent external instantiation
    private Logger() {
        System.out.println("Logger instance created at: " + new Date());
    }
    
    /**
     * Public static method to get the single instance of Logger
     * @return the singleton Logger instance
     */
    public static Logger getInstance() {
        return instance;
    }
    
    /**
     * Log an info message
     * @param message the message to log
     */
    public void logInfo(String message) {
        System.out.println("[INFO] " + new Date() + " - " + message);
    }
    
    /**
     * Log an error message
     * @param message the error message to log
     */
    public void logError(String message) {
        System.err.println("[ERROR] " + new Date() + " - " + message);
    }
    
    /**
     * Log a warning message
     * @param message the warning message to log
     */
    public void logWarning(String message) {
        System.out.println("[WARNING] " + new Date() + " - " + message);
    }
    
    /**
     * Log a debug message
     * @param message the debug message to log
     */
    public void logDebug(String message) {
        System.out.println("[DEBUG] " + new Date() + " - " + message);
    }
}

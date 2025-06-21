public class LoggerTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Logger Pattern ===\n");
        
        // Test 1: Get multiple instances and verify they are the same
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();
        
        // Test that all instances are the same object
        System.out.println("Instance 1 hash code: " + logger1.hashCode());
        System.out.println("Instance 2 hash code: " + logger2.hashCode());
        System.out.println("Instance 3 hash code: " + logger3.hashCode());
        
        System.out.println("\nAre logger1 and logger2 the same instance? " + (logger1 == logger2));
        System.out.println("Are logger2 and logger3 the same instance? " + (logger2 == logger3));
        System.out.println("Are logger1 and logger3 the same instance? " + (logger1 == logger3));
        
        // Test 2: Use the logger for different types of messages
        System.out.println("\n=== Testing Logger Functionality ===");
        logger1.logInfo("Application started successfully");
        logger2.logWarning("This is a warning message");
        logger3.logError("An error occurred during processing");
        logger1.logDebug("Debug information for troubleshooting");
        
        // Test 3: Demonstrate usage across different methods
        System.out.println("\n=== Testing Logger Usage Across Methods ===");
        simulateApplicationFlow();
        
        System.out.println("\n=== Singleton Pattern Test Complete ===");
    }
    
    /**
     * Simulate application flow using the logger in different methods
     */
    private static void simulateApplicationFlow() {
        Logger logger = Logger.getInstance();
        
        logger.logInfo("Starting application flow simulation");
        
        // Simulate some business logic
        processUserData();
        handleFileOperations();
        performDatabaseOperations();
        
        logger.logInfo("Application flow simulation completed");
    }
    
    private static void processUserData() {
        Logger logger = Logger.getInstance();
        logger.logInfo("Processing user data...");
        logger.logDebug("User data validation completed");
    }
    
    private static void handleFileOperations() {
        Logger logger = Logger.getInstance();
        logger.logInfo("Handling file operations...");
        logger.logWarning("File size is larger than recommended");
    }
    
    private static void performDatabaseOperations() {
        Logger logger = Logger.getInstance();
        logger.logInfo("Performing database operations...");
        logger.logError("Database connection timeout - retrying...");
        logger.logInfo("Database operations completed successfully");
    }
}
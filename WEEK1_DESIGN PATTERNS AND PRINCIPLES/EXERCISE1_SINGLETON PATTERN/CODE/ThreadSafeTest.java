class ThreadSafeTest {
    public static void testThreadSafety() {
        System.out.println("\n=== Testing Thread Safety ===");
        
        // Create multiple threads that try to get Logger instances
        Runnable task = () -> {
            Logger logger = Logger.getInstance();
            String threadName = Thread.currentThread().getName();
            logger.logInfo("Logger accessed from thread: " + threadName + 
                          " (Hash: " + logger.hashCode() + ")");
        };
        
        // Start multiple threads
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for all threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Logger.getInstance().logError("Thread interrupted: " + e.getMessage());
        }
    }
}
class LazyLogger {
    // Volatile keyword ensures visibility across threads
    private static volatile LazyLogger instance;
    
    // Private constructor
    private LazyLogger() {
        System.out.println("LazyLogger instance created");
    }
    
    /**
     * Thread-safe lazy initialization using double-checked locking
     * @return the singleton LazyLogger instance
     */
    public static LazyLogger getInstance() {
        if (instance == null) {
            synchronized (LazyLogger.class) {
                if (instance == null) {
                    instance = new LazyLogger();
                }
            }
        }
        return instance;
    }
    
    public void log(String message) {
        System.out.println("[LAZY-LOG] " + message);
    }
}

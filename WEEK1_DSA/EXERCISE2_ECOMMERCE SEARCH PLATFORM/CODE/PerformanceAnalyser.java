import java.util.Arrays;
class PerformanceAnalyzer {
    
    public static void analyzeSearchPerformance(Product[] products, int searchId) {
        System.out.println("=== Performance Analysis ===");
        System.out.println("Searching for Product ID: " + searchId);
        System.out.println("Total products: " + products.length);
        System.out.println();
        
        // Linear Search Performance
        long startTime = System.nanoTime();
        Product linearResult = SearchAlgorithms.linearSearch(products, searchId);
        long endTime = System.nanoTime();
        long linearTime = endTime - startTime;
        
        System.out.println("Linear Search:");
        System.out.println("Result: " + (linearResult != null ? "Found" : "Not Found"));
        System.out.println("Time taken: " + linearTime + " nanoseconds");
        System.out.println();
        
        // Sort for binary search
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        SearchAlgorithms.sortProductsById(sortedProducts);
        
        // Binary Search Performance
        startTime = System.nanoTime();
        Product binaryResult = SearchAlgorithms.binarySearch(sortedProducts, searchId);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;
        
        System.out.println("Binary Search:");
        System.out.println("Result: " + (binaryResult != null ? "Found" : "Not Found"));
        System.out.println("Time taken: " + binaryTime + " nanoseconds");
        System.out.println();
        
        // Performance comparison
        if (linearTime > binaryTime) {
            System.out.println("Binary search was " + (linearTime / binaryTime) + "x faster");
        } else {
            System.out.println("Linear search was faster for this case");
        }
    }
}

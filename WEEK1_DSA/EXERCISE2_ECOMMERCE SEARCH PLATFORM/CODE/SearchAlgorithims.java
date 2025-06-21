import java.util.Arrays;
import java.util.Comparator;


class SearchAlgorithms {
    
    // Linear Search - O(n) time complexity
    public static Product linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return products[i];
            }
        }
        return null; // Product not found
    }
    
    // Binary Search - O(log n) time complexity
    // Requires sorted array by productId
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products[mid].getProductId();
            
            if (midId == targetId) {
                return products[mid];
            }
            
            if (midId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Product not found
    }
    
    // Sort products by ID for binary search
    public static void sortProductsById(Product[] products) {
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
    }
}
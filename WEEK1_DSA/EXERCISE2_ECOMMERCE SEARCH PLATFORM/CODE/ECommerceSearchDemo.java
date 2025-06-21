public class ECommerceSearchDemo {
    
    public static void main(String[] args) {
        System.out.println("=== E-commerce Search Demo ===\n");
        
        // Create sample products
        Product[] products = createSampleProducts();
        
        // Test linear search
        System.out.println("Linear Search:");
        Product result1 = SearchAlgorithms.linearSearch(products, 105);
        System.out.println("Found: " + result1);
        System.out.println();
        
        // Sort products for binary search
        Product[] sortedProducts = new Product[products.length];
        for (int i = 0; i < products.length; i++) {
            sortedProducts[i] = products[i];
        }
        SearchAlgorithms.sortProductsById(sortedProducts);
        
        // Test binary search
        System.out.println("Binary Search:");
        Product result2 = SearchAlgorithms.binarySearch(sortedProducts, 105);
        System.out.println("Found: " + result2);
    }
    
    private static Product[] createSampleProducts() {
        return new Product[] {
            new Product(101, "Laptop", "Electronics", 999.99),
            new Product(102, "Phone", "Electronics", 699.99),
            new Product(103, "Book", "Education", 29.99),
            new Product(104, "Shirt", "Clothing", 39.99),
            new Product(105, "Headphones", "Electronics", 199.99),
            new Product(106, "Shoes", "Clothing", 79.99),
            new Product(107, "Watch", "Accessories", 299.99),
            new Product(108, "Tablet", "Electronics", 499.99),
            new Product(109, "Backpack", "Accessories", 59.99),
            new Product(110, "Camera", "Electronics", 1299.99)
        };
    }
}
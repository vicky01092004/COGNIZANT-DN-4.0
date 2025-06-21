
public class FinancialForecasting {
    
    
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        
        if (years == 0) {
            return presentValue;
        }
        
        
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }
    
    
    public static double calculateFutureValueOptimized(double presentValue, double growthRate, int years) {
        double[] memo = new double[years + 1];
        return calculateFutureValueMemo(presentValue, growthRate, years, memo);
    }
    
    private static double calculateFutureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
       
        if (years == 0) {
            return presentValue;
        }
        
     
        if (memo[years] != 0) {
            return memo[years];
        }
        
        
        memo[years] = calculateFutureValueMemo(presentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }
    
    
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        double result = presentValue;
        for (int i = 0; i < years; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }
    
    
    public static double compoundInterest(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return compoundInterest(principal * (1 + rate), rate, years - 1);
    }
    
   
    public static void main(String[] args) {
        double initialInvestment = 10000.0;
        double annualGrowthRate = 0.08; 
        int forecastYears = 10;
        
        System.out.println("=== Financial Forecasting Demo ===");
        System.out.println("Initial Investment: $" + initialInvestment);
        System.out.println("Annual Growth Rate: " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecast Period: " + forecastYears + " years");
        System.out.println();
        
        
        double futureValue1 = calculateFutureValue(initialInvestment, annualGrowthRate, forecastYears);
        System.out.println("Future Value (Recursive): $" + String.format("%.2f", futureValue1));
        
        
        double futureValue2 = calculateFutureValueOptimized(initialInvestment, annualGrowthRate, forecastYears);
        System.out.println("Future Value (Optimized): $" + String.format("%.2f", futureValue2));
        
        
        double futureValue3 = calculateFutureValueIterative(initialInvestment, annualGrowthRate, forecastYears);
        System.out.println("Future Value (Iterative): $" + String.format("%.2f", futureValue3));
        
        System.out.println();
        
     
        double compoundValue = compoundInterest(initialInvestment, annualGrowthRate, forecastYears);
        System.out.println("Compound Interest Value: $" + String.format("%.2f", compoundValue));
        
       
        performanceTest();
    }
    
    private static void performanceTest() {
        System.out.println("\n=== Performance Test ===");
        double principal = 1000.0;
        double rate = 0.05;
        int years = 20;
        
        
        long startTime = System.nanoTime();
        double result1 = calculateFutureValue(principal, rate, years);
        long endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;
        
        
        startTime = System.nanoTime();
        double result2 = calculateFutureValueIterative(principal, rate, years);
        endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;
        
        System.out.println("Recursive time: " + recursiveTime + " nanoseconds");
        System.out.println("Iterative time: " + iterativeTime + " nanoseconds");
        System.out.println("Results match: " + (Math.abs(result1 - result2) < 0.01));
    }
}
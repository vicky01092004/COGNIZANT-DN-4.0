public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===\n");
        
        // Create different document factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        // Test Word document creation and processing
        System.out.println("1. Processing Word Document:");
        wordFactory.processDocument();
        System.out.println();
        
        // Test PDF document creation and processing
        System.out.println("2. Processing PDF Document:");
        pdfFactory.processDocument();
        System.out.println();
        
        // Test Excel document creation and processing
        System.out.println("3. Processing Excel Document:");
        excelFactory.processDocument();
        System.out.println();
        
        // Alternative way - creating documents directly
        System.out.println("4. Creating documents directly:");
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();
        
        System.out.println("Word document type: " + wordDoc.getClass().getSimpleName());
        System.out.println("PDF document type: " + pdfDoc.getClass().getSimpleName());
        System.out.println("Excel document type: " + excelDoc.getClass().getSimpleName());
    }
}
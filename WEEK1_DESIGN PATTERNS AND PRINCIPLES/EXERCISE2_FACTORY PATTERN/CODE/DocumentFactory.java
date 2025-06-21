abstract class DocumentFactory {
    // Factory method - to be implemented by concrete factories
    public abstract Document createDocument();
    
    // Template method that uses the factory method
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}

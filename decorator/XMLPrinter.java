package decorator;

public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer decoratedPrinter) {
        super(decoratedPrinter);
    }

    @Override
    public void print(String text) {
        super.print("<message>" + text + "</message>");
    }
    
}

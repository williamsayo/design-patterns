package decorator;

public class PrinterDecorator implements Printer {
    private Printer printer;

    public PrinterDecorator(Printer decoratedPrinter) {
        this.printer = decoratedPrinter;
    }

    @Override
    public void print(String text) {
        printer.print(text);
    }
    
}

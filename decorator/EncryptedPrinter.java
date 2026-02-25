package decorator;

public class EncryptedPrinter extends PrinterDecorator {
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String text) {
        String encryptedText = encrypt(text);
        super.print(encryptedText);
    }

    private String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            encrypted.append((char) (c + 3));
        }
        return encrypted.toString();
    }
    
}

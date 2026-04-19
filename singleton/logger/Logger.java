package singleton.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger logger;
    private String fileName;
    private FileWriter writer;

    private Logger(){
        this.setFileName("default.txt");
    }

    public synchronized static Logger getInstance(){
        if (logger == null){
            logger = new Logger();
        }
        return logger;
    }

    public void write(String message){
        try {
            this.writer.write(message + System.lineSeparator());
            this.writer.flush();
        } catch (IOException e) {
            this.printError(e,"Failed to write to log file");
        }
    }

    public synchronized void setFileName(String fileName){
        try {
            if (this.writer != null) this.writer.close();
            this.fileName = fileName;
            this.writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            this.printError(e,"Failed to close file");
        }
    }

    public void close(){
        try {
            if (this.writer != null) this.writer.close();
        } catch (IOException e) {
            this.printError(e,"Failed to close file");
        }
    }

    private void printError(IOException error, String message){
        System.err.println("[" + this.fileName +"]" + message+ ": " + error.getMessage());
    }
}

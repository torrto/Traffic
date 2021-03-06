package com.daniel.model;

import java.io.*;

/**
 * Created by danielmelton on 10/9/16.
 */
public class FileService {

    private final String file = "/var/log/squid3/access.log";
    private File output = new File("/home/pi/output.txt");
    private PrintWriter writer;

    public File getOutput() {
        return output;
    }

    public void setOutput(File output) {
        this.output = output;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public String getFile() {
        return file;
    }

    public void readWrite() {
        try {
            String b;
            writer = new PrintWriter(new FileWriter("/home/pi/output.txt"));
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((b = reader.readLine()) != null) {
                writer.println(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.close();
    }


}

package com.zzz.tutorial.java8;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class shows how to implement the execute around pattern with java 8 and lambdas
 */
public class FileWriterEAM {

    public static class FileWrite implements AutoCloseable {
        final private FileWriter fileWriter;

        private FileWrite(String filename) throws IOException {
            fileWriter = new FileWriter(filename);
        }

        public void writeStuff(String input) throws IOException {
            this.fileWriter.write(input);
        }

        @Override
        public void close() throws Exception {
            System.out.println("Closing the FileWriter..");
            fileWriter.close();
        }

        public static void use(String fileName, UseInstance<FileWrite, IOException> block) throws IOException {
            // Create the class instance
            try (final FileWrite fileWrite = new FileWrite(fileName)) {
                block.accept(fileWrite);
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) throws IOException {
        FileWrite.use("abc.txt", writer -> writer.writeStuff("Hello there!"));
    }
}

/**
 * Declare user defined interface as lambdas can only throw checked exceptions
 * defined in the method being synthesized
 */
@FunctionalInterface
interface UseInstance<T, X extends Throwable> {
    void accept(T instance) throws X;
}

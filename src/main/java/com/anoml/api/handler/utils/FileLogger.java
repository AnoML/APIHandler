package com.anoml.api.handler.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * Created by ashenwgt on 6/13/18.
 */
public class FileLogger {
    private static final Logger logger = LoggerFactory.getLogger(FileLogger.class);

    public static void createFile(String content) throws IOException {
        BufferedWriter bw = null;
        try {
            File file = new File("/home/anoml/API-Handler-Log.log");
            if (!file.exists()) {
                if(!file.createNewFile()){
                    logger.error("File not created");
                }
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(content);

        } catch(IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception e){
                logger.error(e.getMessage(), e);
            }
        }
    }

    public static void writeFile(String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/anoml/API-Handler-Log.log", true));
        writer.newLine();
        writer.append(content);
        writer.close();
    }

}

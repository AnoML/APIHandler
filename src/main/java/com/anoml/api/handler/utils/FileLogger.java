package com.anoml.api.handler.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileLogger {
    private static final Logger logger = LoggerFactory.getLogger(FileLogger.class);

    public static void createFile(String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/anoml/API-Handler-Log.log"))) {
            bw.write(content);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void writeFile(String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/anoml/API-Handler-Log.log"))) {
            bw.write(content);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}

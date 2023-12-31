package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoggingService {

    private static final String LOG_FILE_PATH = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "test.txt";
    public void addLog(String fileName, String effectName, String optionValues){//overloaded function
        /*This method adds a log entry with info about the image filter operation and runs the file
         I/O operation in a separate thread.*/
        new Thread(()-> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
                String timeStamp = currentDateTime.format(formatter);
                String logEntry = String.format("%s, %s, %s, %s%n", timeStamp, fileName, effectName, optionValues);
                writer.write(logEntry);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void addLog(String fileName, String effectName) {//overloaded function
        /*This method adds a log entry with info about the image filter operation and runs the file
         I/O operation in a separate thread.*/
        new Thread(()-> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
                String timeStamp = currentDateTime.format(formatter);
                String logEntry = String.format("%s, %s, %s%n", timeStamp, fileName, effectName);
                writer.write(logEntry);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public List<LogModel> getAllLogs() {
        /*This method retrieves all logs and
        runs the file I/O operation in a separate thread.*/
        List<LogModel> logs = new ArrayList<>();
        new Thread(()-> {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String fileName = parts[1].trim();
                String timeStamp = parts[0].trim();
                String effectName = parts[2].trim();
                String optionValues = "";
                if (parts.length == 4) {
                    optionValues = parts[3].trim();
                }
                logs.add(new LogModel(timeStamp, fileName, effectName, optionValues));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }).start();
        return logs;
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        /*This method retrieves logs filtered by a specific image processing effect and
        runs the file I/O operation in a separate thread.*/
        List<LogModel> logs = new ArrayList<>();
        new Thread(()->{
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Filtering logs by effect name and creating LogModel objects
                String[] parts = line.split(", ");
                String effectNAME = parts[2];
                if (effectNAME.equalsIgnoreCase(effectName)) {
                    String fileName = parts[1];
                    String timeStamp = parts[0];
                    String optionValues = "";
                    if (parts.length == 4) {
                        optionValues = parts[3];
                    }
                    logs.add(new LogModel(timeStamp, fileName, effectNAME, optionValues));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }).start();
        return logs;
    }

    public void clearLogs() {
        //This method clears all logs and runs the file I/O operation in a separate thread.
        new Thread(()-> {
            try (PrintWriter writer = new PrintWriter(LOG_FILE_PATH)) {
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        /* This method retrieves logs with timestamps within a specified range and
        runs the file I/O operation in a separate thread.*/
        List<LogModel> logs = new ArrayList<>();
        new Thread(()-> {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //Filtering logs by timestamp range and creating LogModel objects
                String[] parts = line.split(", ");
                String timeStampString = parts[0];
                LocalDateTime timeStamp = LocalDateTime.parse(timeStampString, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss"));
                if (timeStamp.isAfter(startTime) && timeStamp.isBefore(endTime)) {
                    String fileName = parts[1];
                    String effectName = parts[2];
                    String optionValues = "";
                    if (parts.length == 4) {
                        optionValues = parts[3];
                    }
                    logs.add(new LogModel(timeStampString, fileName, effectName, optionValues));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }).start();
        return logs;
    }

}
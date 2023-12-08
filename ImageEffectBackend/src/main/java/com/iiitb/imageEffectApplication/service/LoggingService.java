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

    private static final String LOG_FILE_PATH = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "test.txt";;

    public void addLog(String fileName, String effectName, String optionValues) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Format the date and time using a specific pattern
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
            String timeStamp = currentDateTime.format(formatter);
            String logEntry = String.format("%s, %s, %s, %s%n",timeStamp,fileName, effectName, optionValues);
            writer.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
    }

    public void addLog(String fileName, String effectName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Format the date and time using a specific pattern
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
            String timeStamp = currentDateTime.format(formatter);
            String logEntry = String.format("%s, %s, %s%n",timeStamp,fileName, effectName);
            writer.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
    }

    public List<LogModel> getAllLogs() {
//        System.out.println("HI");
        List<LogModel> logs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each line follows the format: "File: %s, Effect: %s, Options: %s"
                String[] parts = line.split(", ");
//                for(int i = 0;i<parts.length;i++){
//                    System.out.println(parts[i]);
//                }
                String fileName = parts[1].trim();
                String timeStamp = parts[0].trim();
                String effectName = parts[2].trim();
                String optionValues = "";
                if(parts.length == 4) {
                    optionValues = parts[3].trim();
                }
                logs.add(new LogModel(timeStamp,fileName,effectName,optionValues));
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
        return logs;
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        List<LogModel> logs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String effectNAME = parts[2];
                if (effectNAME.equalsIgnoreCase(effectName)) {
                    String fileName = parts[1];
                    String timeStamp = parts[0];
                    String optionValues = "";
                    if(parts.length == 4){
                        optionValues = parts[3];
                    }
                    logs.add(new LogModel(timeStamp,fileName, effectNAME, optionValues));
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
        return logs;
    }

    public void clearLogs() {
        try (PrintWriter writer = new PrintWriter(LOG_FILE_PATH)) {
            // Clears the content of the log file
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
    }

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        List<LogModel> logs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String timeStampString = parts[0];
                LocalDateTime timeStamp = LocalDateTime.parse(timeStampString, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss"));

                // Check if the log entry timestamp is within the specified range
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
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
        return logs;
    }

}
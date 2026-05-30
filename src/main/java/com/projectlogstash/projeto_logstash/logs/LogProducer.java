package com.projectlogstash.projeto_logstash.logs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class LogProducer {

    private final ObjectMapper mapper =
            new ObjectMapper();

    public void logUserCreated(
            Long userId,
            String name,
            String email
    ) {

        try {

            File directory = new File("logs");

            if (!directory.exists()) {
                directory.mkdirs();
            }

            Map<String, Object> event =
                    new HashMap<>();

            event.put(
                    "eventType",
                    "USER_REGISTERED"
            );

            event.put("userId", userId);
            event.put("name", name);
            event.put("email", email);

            event.put(
                    "timestamp",
                    LocalDateTime.now().toString()
            );

            String json =
                    mapper.writeValueAsString(event);

            FileWriter writer =
                    new FileWriter(
                            "logs/user-events.log",
                            true
                    );

            writer.write(json + "\n");

            writer.close();

            System.out.println(
                    "LOG CRIADO: " + json
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
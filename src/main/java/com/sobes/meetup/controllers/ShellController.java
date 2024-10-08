package com.sobes.meetup.controllers;

import org.springframework.web.bind.annotation.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShellController {

    @PostMapping("/execute")
    public List<String> executeCommand(@RequestBody String command) {
        List<String> output = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.add(line);
            }
            process.waitFor();
        } catch (Exception e) {
            output.add("Error: " + e.getMessage());
        }
        return output;
    }

    @PostMapping("/message")
    public String accMessage(@RequestBody String message) {
        System.out.println(message);
        String response =  "получено сообщение " + message;
        return response;
    }
}
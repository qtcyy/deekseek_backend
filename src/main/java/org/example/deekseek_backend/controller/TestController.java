package org.example.deekseek_backend.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.nio.charset.StandardCharsets;

/**
 * @author chengyiyang
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/stream")
    public StreamingResponseBody streamText(HttpServletResponse response) {
        return outputStream -> {
            String[] sentences={"Hello, world!", "Hello, world!", "Hello, world!", "Hello, world!", "Hello, world!"};
            for (String sentence: sentences) {
                outputStream.write(sentence.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
    }
}

package ru.sberbank.jd.webinar07.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ResourceProcessor {

    private AuthorRepository authorRepository = new AuthorRepository();
    private ObjectMapper objectMapper = new ObjectMapper();
    public void process(Socket socket, String method, String resource, String body) {
        String response = "";
        switch (method) {
            case "GET":
                response = doGet(resource);
                break;
            case "POST":
                response = doPost(resource, body);
                break;
            default:
                throw new UnsupportedOperationException();
        }

        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String doPost(String resource, String body) {
        String response = "";
        if ("/author".equals(resource)) {
            try {
                Author author = objectMapper.readValue(body, Author.class);
                Author savedAuthor = authorRepository.create(author);
                String responseBody = objectMapper.writeValueAsString(savedAuthor);

                response = new StringBuilder()
                        .append("HTTP/1.1 200 OK").append("\n")
                        .append("Content-Type: application/json").append("\n")
                        .append("Content-Lenght: ").append(responseBody.length()).append("\n")
                        .append("\n")
                        .append(responseBody)
                        .toString();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            response = notFoundResponse();
        }
        return response;
    }

    private String doGet(String resource) {
        String response = "";
        if ("/". equals(resource)) {
            String responseBody = "<html><body><h1>Hello World</h1></body></html>";
            response = new StringBuilder()
                    .append("HTTP/1.1 200 OK").append("\n")
                    .append("Content-Type: text/html").append("\n")
                    .append("Content-Lenght: ").append(responseBody.length()).append("\n")
                    .append("\n")
                    .append(responseBody)
                    .toString();
        } else {
            response = notFoundResponse();
        }

        return response;
    }

    private String notFoundResponse() {
        return new StringBuilder()
                .append("HTTP/1.1 400 NOT FOUND")
                .append("\n")
                .append("\n")
                .toString();
    }
}

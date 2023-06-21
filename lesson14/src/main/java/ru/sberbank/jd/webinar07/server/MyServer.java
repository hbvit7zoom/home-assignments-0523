package ru.sberbank.jd.webinar07.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    private ResourceProcessor resouceProcessor = new ResourceProcessor();

    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {

            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                String startLine = dataInputStream.readLine();
                System.out.println(startLine);

                String[] s = startLine.split(" ");
                String method = s[0];
                String resource = s[1];

                String line = null;
                while (!(line = dataInputStream.readLine()).isEmpty()) {
                    System.out.println(line);
                }

                System.out.println("===" + line + "===");

                String body = "";
                while (true) {

                    int available = dataInputStream.available();

                    if (available == 0) {
                        break;
                    }
//                    System.out.println(available);

                    line = dataInputStream.readLine();
                    body += line;
                    System.out.println(line);
                }
                System.out.println("=== END REQUEST ===");

                resouceProcessor.process(socket, method, resource, body);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}

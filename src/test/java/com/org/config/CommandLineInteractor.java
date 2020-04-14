package com.org.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CommandLineInteractor {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    private String convertStreamToString(InputStream is) throws IOException {
        return new String(FileCopyUtils.copyToByteArray(is), StandardCharsets.UTF_8);
    }

    public String execute(String command, boolean waitForResponse) {

        String response = "";

        ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
        pb.redirectErrorStream(true);

        logger.info("Linux command: " + command);

        try {
            Process shell = pb.start();
            if (waitForResponse) {
                InputStream shellIn = shell.getInputStream();
                int shellExitStatus = shell.waitFor();
                System.out.println("Exit status: " + shellExitStatus);
                response = convertStreamToString(shellIn);
                shellIn.close();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error occurred while executing Linux command. Error Description: "
                    + e.getMessage());
        }
        return response;
    }

    public void openBash() {

    }

    public void closeBase() {

    }

}

package com.org.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

@Component
public class CommandLineProcess {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    private String convertStreamToString(InputStream is) throws IOException {
        return new String(FileCopyUtils.copyToByteArray(is), StandardCharsets.UTF_8);
    }

    public String execute(String command) {

        String response = "";

        ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
        pb.redirectErrorStream(true);

        logger.info("Executing command: " + pb.command());

        try {
            Process bash = pb.start();
            InputStream shellIn = bash.getInputStream();
            int shellExitStatus = bash.waitFor();
            assertEquals(0, shellExitStatus);
            response = convertStreamToString(shellIn);
            shellIn.close();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error occurred while executing command: "
                    + e.getMessage());
        }
        return response;
    }

}

package com.org.config;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class SSHClientConfig {

    private String convertStreamToString(InputStream is) throws IOException {
        return new String(FileCopyUtils.copyToByteArray(is), StandardCharsets.UTF_8);
    }

    @Test
    public void test() throws IOException {
        SSHClient client = new SSHClient();
        client.loadKnownHosts();
        client.addHostKeyVerifier("cb:b5:f1:b9:81:60:18:4f:11:7c:60:66:23:41:3a:01");
        client.connect("localhost");
        try {
            client.authPassword("ubuntu", "thisisnottheactualpassword");
            Session session = client.startSession();
            try {
                Command cmd = session.exec("ls");
                System.out.println(convertStreamToString(cmd.getInputStream()));
                cmd.join(1, TimeUnit.SECONDS);
            } finally {
                session.close();
            }
        } finally {
            client.disconnect();
        }
    }

}

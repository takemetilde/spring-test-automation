package com.org.cli;

import com.org.config.CommandLineInteractor;
import org.junit.Test;

public class CLITest {

    @Test
    public void cliTest() {
        System.out.println(new CommandLineInteractor().execute("ls", true));
        System.out.println(new CommandLineInteractor().execute("cd ..", true));
        System.out.println(new CommandLineInteractor().execute("ls", true));
    }

}

package com.org.cli;

import com.org.config.CommandLineProcess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@Import(CommandLineProcess.class)
public class CLITest {

    @Autowired
    CommandLineProcess cli;

//    @Test
    public void cliTest() {
        System.out.println(cli.execute("ls"));
        System.out.println(cli.execute("cd .."));
        System.out.println(cli.execute("ls"));
    }

}

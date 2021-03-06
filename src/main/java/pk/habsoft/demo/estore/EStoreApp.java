package pk.habsoft.demo.estore;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class EStoreApp.
 */
@SpringBootApplication
public class EStoreApp {

    private static final Logger LOG = Logger.getLogger(EStoreApp.class);

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        LOG.info("Welcome to EStore App console");
        SpringApplication.run(EStoreApp.class, args);
    }
}

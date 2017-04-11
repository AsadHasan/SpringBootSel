package utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Asad.Hasan on 11/04/2017.
 */
public class Log {
    private static final Logger LOGGER= LoggerFactory.getLogger(Log.class);

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void warn(String message) {
        LOGGER.warn(message);
    }

    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void debug(String message) {
        LOGGER.debug(message);
    }

    public static void trace(String message) {
        LOGGER.trace(message);
    }
}

package nl.newnexus.skills.exception;

/**
 * User: xanderarling
 * Date: 9/15/13
 * Time: 20:19
 */
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException() {

    }

    public DataNotFoundException(String msg) {
        super(msg);
    }

    public DataNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}

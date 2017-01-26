package pl.mnowicka.autobus;

/**
 * Created by magda on 2017-01-24.
 */
public class EmailExistsException extends Throwable {

    public EmailExistsException(final String message) {
        super(message);
    }

}

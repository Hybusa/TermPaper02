package pro.sky.termpaper02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ListIsEmptyException extends RuntimeException {
    public ListIsEmptyException(String s) {
        super(s);
    }
}

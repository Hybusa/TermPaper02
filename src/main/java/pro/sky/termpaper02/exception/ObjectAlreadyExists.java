package pro.sky.termpaper02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ObjectAlreadyExists extends RuntimeException {
    public ObjectAlreadyExists(String s) {
        super(s);
    }
}

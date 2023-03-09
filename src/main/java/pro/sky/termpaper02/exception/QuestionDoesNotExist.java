package pro.sky.termpaper02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class QuestionDoesNotExist extends RuntimeException {
    public QuestionDoesNotExist(String s) {
        super(s);
    }
}

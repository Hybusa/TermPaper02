package pro.sky.termpaper02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAmountExceeded extends RuntimeException {
    public QuestionAmountExceeded(String s) {
        super(s);
    }
}

package pro.sky.termpaper02.service;

import org.springframework.stereotype.Service;
import pro.sky.termpaper02.domain.Question;

import java.util.Collection;
@Service
public interface ExaminerService {
    Collection<Question> getQuestions (int amount);
}

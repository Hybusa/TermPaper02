package pro.sky.termpaper02.service;

import org.springframework.stereotype.Component;
import pro.sky.termpaper02.domain.Question;
import pro.sky.termpaper02.exception.QuestionAmountExceeded;

import java.util.*;

@Component
public class ExaminerServiceImpl implements ExaminerService {

    QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService){
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount < 1)
            throw new IllegalArgumentException("Amount can't be negative");
        if (amount > questionService.getAll().size())
            throw new QuestionAmountExceeded("There are less questions then requested in the List");
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}

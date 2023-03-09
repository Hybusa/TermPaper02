package pro.sky.termpaper02.service;

import org.springframework.stereotype.Component;
import pro.sky.termpaper02.domain.Question;
import pro.sky.termpaper02.exception.ListIsEmptyException;
import pro.sky.termpaper02.exception.NullValueException;
import pro.sky.termpaper02.exception.ObjectAlreadyExists;
import pro.sky.termpaper02.exception.QuestionDoesNotExist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
@Component
public class JavaQuestionService implements QuestionService{

    List<Question> questionList = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        return checkedAdd(new Question(question,answer));
    }

    @Override
    public Question add(Question question) {
        return checkedAdd(question);
    }

    @Override
    public Question remove(Question question) {
        if(question == null)
            throw new NullValueException("Value is null");
        if(!questionList.contains(question))
            throw new QuestionDoesNotExist("There is no such question in the List");
        if(!questionList.remove(question))
            throw new RuntimeException("Something went wrong");
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        if(questionList.size() == 0)
            throw new ListIsEmptyException("List is empty");
        return questionList;
    }

    @Override
    public Question getRandomQuestion() {

        if(questionList.size() == 0)
            throw new ListIsEmptyException("List is empty");
        Random rn = new Random();

        return questionList.get(rn.nextInt(questionList.size()));
    }


    private Question checkedAdd(Question question){
        if(!checkIfInListAndNotNullAndAdd(question))
            throw new RuntimeException("Something went wrong");
        System.out.println("Question added");
        return question;
    }

    private boolean checkIfInListAndNotNullAndAdd (Question question)
    {
        if(question == null)
            throw new NullValueException("Value is null");
        if(questionList.contains(question))
            throw new ObjectAlreadyExists("There is already such question in the List");

        return this.questionList.add(question);
    }
}

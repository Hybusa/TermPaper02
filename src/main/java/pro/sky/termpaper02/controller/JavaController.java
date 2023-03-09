package pro.sky.termpaper02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.termpaper02.domain.Question;
import pro.sky.termpaper02.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService questionService;


    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Collection<Question> getAllQuestions()
    {
        return questionService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("add")
    public Question add(@RequestParam String question, @RequestParam String answer){
        return questionService.add(question,answer);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("remove")
    public Question remove(@RequestParam String question, @RequestParam String answer){
        Question tmpQuestion = new Question(question,answer);
        return questionService.remove(tmpQuestion);
    }

}

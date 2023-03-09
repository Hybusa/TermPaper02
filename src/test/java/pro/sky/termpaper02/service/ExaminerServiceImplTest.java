package pro.sky.termpaper02.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sky.termpaper02.domain.Question;
import pro.sky.termpaper02.exception.QuestionAmountExceeded;

@ContextConfiguration(classes = {ExaminerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ExaminerServiceImplTest {
    @Autowired
    private ExaminerServiceImpl examinerServiceImpl;

    @MockBean
    private QuestionService questionService;

    /**
     * Method under test: {@link ExaminerServiceImpl#getQuestions(int)}
     */
    @Test
    void testGetQuestions() {
        when(questionService.getAll()).thenReturn(new ArrayList<>());
        assertThrows(QuestionAmountExceeded.class, () -> examinerServiceImpl.getQuestions(10));
        verify(questionService).getAll();
    }

    /**
     * Method under test: {@link ExaminerServiceImpl#getQuestions(int)}
     */
    @Test
    void testGetQuestions2() {
        when(questionService.getAll()).thenReturn(new ArrayList<>());
        assertThrows(IllegalArgumentException.class, () -> examinerServiceImpl.getQuestions(0));
    }

    /**
     * Method under test: {@link ExaminerServiceImpl#getQuestions(int)}
     */
    @Test
    void testGetQuestions3() {
        when(questionService.getAll()).thenThrow(new IllegalArgumentException());
        assertThrows(IllegalArgumentException.class, () -> examinerServiceImpl.getQuestions(10));
        verify(questionService).getAll();
    }

    /**
     * Method under test: {@link ExaminerServiceImpl#getQuestions(int)}
     */
    @Test
    void testGetQuestions4() {
        ArrayList<Question> questionList = new ArrayList<>();
        questionList.add(new Question("There are less questions then requested in the List",
                "There are less questions then requested in the List"));
        when(questionService.getRandomQuestion()).thenReturn(new Question("Question", "Answer"));
        when(questionService.getAll()).thenReturn(questionList);
        assertEquals(1, examinerServiceImpl.getQuestions(1).size());
        verify(questionService).getAll();
        verify(questionService).getRandomQuestion();
    }

    /**
     * Method under test: {@link ExaminerServiceImpl#getQuestions(int)}
     */
    @Test
    void testGetQuestions5() {
        ArrayList<Question> questionList = new ArrayList<>();
        questionList.add(new Question("There are less questions then requested in the List",
                "There are less questions then requested in the List"));
        when(questionService.getRandomQuestion()).thenThrow(new IllegalArgumentException());
        when(questionService.getAll()).thenReturn(questionList);
        assertThrows(IllegalArgumentException.class, () -> examinerServiceImpl.getQuestions(1));
        verify(questionService).getAll();
        verify(questionService).getRandomQuestion();
    }
}


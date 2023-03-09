package pro.sky.termpaper02.service;

import org.junit.jupiter.api.Test;
import pro.sky.termpaper02.domain.Question;
import pro.sky.termpaper02.exception.ListIsEmptyException;
import pro.sky.termpaper02.exception.NullValueException;
import pro.sky.termpaper02.exception.ObjectAlreadyExists;
import pro.sky.termpaper02.exception.QuestionDoesNotExist;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class JavaQuestionServiceTest {

    Question mockQuestion = mock(Question.class);
    Question mockQuestion1 = mock(Question.class);

    /**
     * Method under test: {@link JavaQuestionService#add(String, String)}
     */
    @Test
    void testAdd() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        javaQuestionService.add("Question", "Answer");
        assertEquals(1, javaQuestionService.getAll().size());
    }

    /**
     * Method under test: {@link JavaQuestionService#add(String, String)}
     */
    @Test
    void testAdd2() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        javaQuestionService.add(new Question("Question", "Answer"));
        javaQuestionService.add("Question added", "Question added");
        assertThrows(ObjectAlreadyExists.class, () -> javaQuestionService.add("Question", "Answer"));
    }

    /**
     * Method under test: {@link JavaQuestionService#add(Question)}
     */
    @Test
    void testAdd4() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();

        assertSame(mockQuestion, javaQuestionService.add(mockQuestion));
        assertEquals(1, javaQuestionService.getAll().size());
    }

    /**
     * Method under test: {@link JavaQuestionService#add(Question)}
     */
    @Test
    void testAdd5() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        javaQuestionService.add(mockQuestion);
        javaQuestionService.add(mockQuestion1);
        assertThrows(ObjectAlreadyExists.class, () -> javaQuestionService.add(mockQuestion));
    }

    /**
     * Method under test: {@link JavaQuestionService#add(Question)}
     */
    @Test
    void testAdd6() {

        JavaQuestionService javaQuestionService = new JavaQuestionService();
        assertThrows(NullValueException.class, () -> javaQuestionService.add(null));
    }

    /**
     * Method under test: {@link JavaQuestionService#remove(Question)}
     */
    @Test
    void testRemove() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        assertThrows(QuestionDoesNotExist.class, () -> javaQuestionService.remove(mockQuestion));
    }

    /**
     * Method under test: {@link JavaQuestionService#remove(Question)}
     */
    @Test
    void testRemove2() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        javaQuestionService.add(mockQuestion);
        javaQuestionService.add(mockQuestion1);

        assertSame(mockQuestion, javaQuestionService.remove(mockQuestion));
        assertEquals(1, javaQuestionService.getAll().size());
    }

    /**
     * Method under test: {@link JavaQuestionService#remove(Question)}
     */
    @Test
    void testRemove3() {

        JavaQuestionService javaQuestionService = new JavaQuestionService();
        assertThrows(NullValueException.class, () -> javaQuestionService.add(null));
        assertThrows(QuestionDoesNotExist.class, () -> javaQuestionService.remove(mockQuestion));
    }

    /**
     * Method under test: {@link JavaQuestionService#getAll()}
     */
    @Test
    void testGetAll() {
        assertThrows(ListIsEmptyException.class, () -> (new JavaQuestionService()).getAll());
    }

    /**
     * Method under test: {@link JavaQuestionService#getAll()}
     */
    @Test
    void testGetAll2() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        javaQuestionService.add(mockQuestion);
        Collection<Question> actualAll = javaQuestionService.getAll();
        assertSame(javaQuestionService.questionList, actualAll);
        assertEquals(1, actualAll.size());
    }

    /**
     * Method under test: {@link JavaQuestionService#getRandomQuestion()}
     */
    @Test
    void testGetRandomQuestion() {
        assertThrows(ListIsEmptyException.class, () -> (new JavaQuestionService()).getRandomQuestion());
    }

    /**
     * Method under test: {@link JavaQuestionService#getRandomQuestion()}
     */
    @Test
    void testGetRandomQuestion2() {

        JavaQuestionService javaQuestionService = new JavaQuestionService();
        javaQuestionService.add(mockQuestion);
        javaQuestionService.add(mockQuestion1);

       assertThat(javaQuestionService.getRandomQuestion(), isOneOf(mockQuestion, mockQuestion1));
    }

    /**
     * Method under test: {@link JavaQuestionService#getRandomQuestion()}
     */
    @Test
    void testGetRandomQuestion3() {
        assertThrows(ListIsEmptyException.class, () -> (new JavaQuestionService()).getRandomQuestion());
    }

    /**
     * Method under test: {@link JavaQuestionService#getRandomQuestion()}
     */
    @Test
    void testGetRandomQuestion4() {

        JavaQuestionService javaQuestionService = new JavaQuestionService();
        javaQuestionService.add(mockQuestion);
        assertSame(mockQuestion, javaQuestionService.getRandomQuestion());
    }
}


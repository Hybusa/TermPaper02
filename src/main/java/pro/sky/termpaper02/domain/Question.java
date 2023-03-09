package pro.sky.termpaper02.domain;

import java.util.Objects;

public class Question {
    private final String question;
    private final String answer;

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public int hashCode() {

        return Objects.hash(question,answer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;

        return this.question.equals(((Question) obj).question) &&
                this.answer.equals(((Question) obj).answer);
    }

    @Override
    public String toString() {
        return String.format("%s\n\n%s", question,answer);
    }
}

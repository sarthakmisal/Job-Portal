package com.job.portal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Question {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long q_id;
@Column(length = 5000)
private String question;
private String image;
private String answer;
private String option1;
private String option2;
private String option3;
private String option4;
Question(){}
@ManyToOne(fetch = FetchType.EAGER)
private Quiz quiz;

public Long getQ_id() {
    return q_id;
}

public void setQ_id(Long q_id) {
    this.q_id = q_id;
}

public String getQuestion() {
    return question;
}

public void setQuestion(String question) {
    this.question = question;
}

public String getImage() {
    return image;
}

public void setImage(String image) {
    this.image = image;
}

public String getAnswer() {
    return answer;
}

public void setAnswer(String answer) {
    this.answer = answer;
}

public String getOption1() {
    return option1;
}

public void setOption1(String option1) {
    this.option1 = option1;
}

public String getOption2() {
    return option2;
}

public void setOption2(String option2) {
    this.option2 = option2;
}

public String getOption3() {
    return option3;
}

public void setOption3(String option3) {
    this.option3 = option3;
}

public String getOption4() {
    return option4;
}

public void setOption4(String option4) {
    this.option4 = option4;
}

public Quiz getQuiz() {
    return quiz;
}

public void setQuiz(Quiz quiz) {
    this.quiz = quiz;
}


}


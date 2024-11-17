package com.job.portal.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long qz_id;
    private String title;
    private String description;
    private Long no_Of_Que;
    private String status = "active";
    private Long marksPer;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Question> questions = new HashSet<>();

    public Quiz(String title, String desc, Long no_of_Que,Long marksPer) {
        this.title = title;
        this.description = desc;
        this.no_Of_Que = no_of_Que;
        this.marksPer=marksPer;
    }

    public Quiz() {
    }

    public long getQz_id() {
        return qz_id;
    }

    public void setQz_id(long qz_id) {
        this.qz_id = qz_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNo_Of_Que() {
        return no_Of_Que;
    }

    public void setNo_Of_Que(Long no_Of_Que) {
        this.no_Of_Que = no_Of_Que;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Long getMarksPer() {
        return marksPer;
    }

    public void setMarksPer(Long marksPer) {
        this.marksPer = marksPer;
    }
}

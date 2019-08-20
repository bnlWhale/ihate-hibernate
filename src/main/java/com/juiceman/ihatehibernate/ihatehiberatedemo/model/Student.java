package com.juiceman.ihatehibernate.ihatehiberatedemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "Student")
public class Student {


    @Id
    @NotNull
    @Size(max = 20)
    private String  s_id;

    private String s_name;

    @Size(max = 20)
    private String s_birth;

    @Size(max = 20)
    private String s_sex;


    @OneToMany(cascade=CascadeType.ALL, mappedBy="student")
    private Set<Score> studentScore;

    public void addScore(int numScore, Course course) {
        if (studentScore == null) {
            studentScore = new LinkedHashSet<>();
        }
        Score score = new Score();
        score.setS_score(numScore);
        score.setStudent(this);
        score.setCourse(course);
        ScoreIDdentity scoreIDdentity = new ScoreIDdentity(this.s_id, course.getC_id());
        score.setScoreIDdentity(scoreIDdentity);
        studentScore.add(score);
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_birth() {
        return s_birth;
    }

    public void setS_birth(String s_birth) {
        this.s_birth = s_birth;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }


    public Set<Score> getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(Set<Score> studentScore) {
        this.studentScore = studentScore;
    }
}

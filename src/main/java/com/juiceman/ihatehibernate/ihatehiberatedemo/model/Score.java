package com.juiceman.ihatehibernate.ihatehiberatedemo.model;




import com.juiceman.ihatehibernate.ihatehiberatedemo.config.SqlStringQuery;
import com.juiceman.ihatehibernate.ihatehiberatedemo.model.dto.ScoreAvgDTO;

import javax.persistence.*;


@Entity(name = "Score")
@Table(name = "Score")
@NamedNativeQuery(
   name = "ScoreAvgDTOQuery",
        query = SqlStringQuery.AvgSumSql,
        resultSetMapping = "ScoreAvgDTOQuery"
)
@SqlResultSetMapping(
        name = "ScoreAvgDTOQuery",
        classes = @ConstructorResult(
                targetClass = ScoreAvgDTO.class,
                columns = {
                        @ColumnResult(name = "studentId"),
                        @ColumnResult(name = "studentName"),
                        @ColumnResult(name = "avgScore")
                }
        )
)

public class Score {

   @EmbeddedId
   private ScoreIDdentity scoreIDdentity;

    private int s_score;


    public Score(){

    }


    @MapsId("studentID")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name="s_id", insertable=false, updatable=false, nullable=false)
    private Student student;

    @MapsId("courseID")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="c_id", insertable=false, updatable=false, nullable=false)
    private Course course;



    public Score(ScoreIDdentity scoreIDdentity, int score){
        this.setScoreIDdentity(scoreIDdentity);
        this.setS_score(score);
    }

    public ScoreIDdentity getScoreIDdentity() {
        return scoreIDdentity;
    }

    public void setScoreIDdentity(ScoreIDdentity scoreIDdentity) {
        this.scoreIDdentity = scoreIDdentity;
    }

    public int getS_score() {
        return s_score;
    }

    public void setS_score(int s_score) {
        this.s_score = s_score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

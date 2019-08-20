package com.juiceman.ihatehibernate.ihatehiberatedemo.model.dto;

public class ScoreAvgDTO {

    private String studentId;
    private String studentName;
    private Number avgScore;
    private String courseName;

    public ScoreAvgDTO()
    {

    }
    public ScoreAvgDTO(String studentId,  String studentName, Number avgScore, String courseName){
        setStudentId(studentId);
        setStudentName(studentName);
        setAvgScore(avgScore);
        setCourseName(courseName);
    }



    public void showInfo(){
        System.out.println("id "+this.studentId+" name:"+this.studentName+" course:"+this.courseName+"  avg:"+this.avgScore);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Number getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Number avgScore) {
        this.avgScore = avgScore;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

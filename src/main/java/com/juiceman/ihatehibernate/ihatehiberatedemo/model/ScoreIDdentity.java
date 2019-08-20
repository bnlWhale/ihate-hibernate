package com.juiceman.ihatehibernate.ihatehiberatedemo.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Embeddable
public class ScoreIDdentity implements Serializable {


        @NotNull
        @Size(max=20)
        @Column(name = "s_id")
        private String studentID;

        @NotNull
        @Size(max=20)
        @Column(name = "c_id")
        private String courseID;


        public ScoreIDdentity(){
                super();
        }

        public ScoreIDdentity(String studentID, String courseID){
                this.setStudentID(studentID);
                this.setCourseID(courseID);
        }

        public String getStudentID() {
                return studentID;
        }

        public void setStudentID(String studentID) {
                this.studentID = studentID;
        }

        public String getCourseID() {
                return courseID;
        }

        public void setCourseID(String courseID) {
                this.courseID = courseID;
        }

        @Override
        public boolean equals(Object o){

                if(this == o){
                        return true;
                }
                if(o == null || getClass() != o.getClass()){
                        return false;
                }
                ScoreIDdentity so = (ScoreIDdentity)o;
                if(!studentID.equals(so.getStudentID())){
                        return false;
                }
                return this.courseID.equals(so.getCourseID());
        }

        @Override
        public int hashCode(){
                int result = studentID.hashCode();
                result = 31 * result + courseID.hashCode();
                return result;
        }
}



package com.juiceman.ihatehibernate.ihatehiberatedemo.config;

public class SqlStringQuery {

    public static final String AvgSumSql = "select sc3.s_id as studentId, sc2.student_name as studentName, sc2.avgNum as avgScore, (select c_name from Course where sc3.c_id = c_id) as courseName from Score sc3 " +
            "left join  (select sc1.s_id, avg(sc1.s_score) as avgNum, st.s_name as student_name from Score sc1 , Student st " +
            "where sc1.s_id = st.s_id group by sc1.s_id) as sc2 on sc3.s_id = sc2.s_id order by sc2.avgNum desc";
}

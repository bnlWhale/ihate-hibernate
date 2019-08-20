package com.juiceman.ihatehibernate.ihatehiberatedemo.repository.impl;

import com.juiceman.ihatehibernate.ihatehiberatedemo.config.SqlStringQuery;
import com.juiceman.ihatehibernate.ihatehiberatedemo.model.dto.ScoreAvgDTO;
import com.juiceman.ihatehibernate.ihatehiberatedemo.repository.ScoreRepository;
import com.juiceman.ihatehibernate.ihatehiberatedemo.repository.StudentAvgScore;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ScoreRepositoryImpl implements StudentAvgScore {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public List<ScoreAvgDTO> findAllAvgScore(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);

        String avgSumSql = SqlStringQuery.AvgSumSql;
        List<ScoreAvgDTO> avgList = session.createNativeQuery(avgSumSql).setResultTransformer(Transformers.aliasToBean(ScoreAvgDTO.class)).list();

        session.close();
        entityManager.close();
        return avgList;
    }
}

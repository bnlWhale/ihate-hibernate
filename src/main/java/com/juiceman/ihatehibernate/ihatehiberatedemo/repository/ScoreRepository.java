package com.juiceman.ihatehibernate.ihatehiberatedemo.repository;

import com.juiceman.ihatehibernate.ihatehiberatedemo.config.SqlStringQuery;
import com.juiceman.ihatehibernate.ihatehiberatedemo.model.Score;
import com.juiceman.ihatehibernate.ihatehiberatedemo.model.ScoreIDdentity;
import com.juiceman.ihatehibernate.ihatehiberatedemo.model.dto.ScoreAvgDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public interface ScoreRepository extends JpaRepository<Score, ScoreIDdentity>, StudentAvgScore {



}

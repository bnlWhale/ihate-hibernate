package com.juiceman.ihatehibernate.ihatehiberatedemo.repository;

import com.juiceman.ihatehibernate.ihatehiberatedemo.config.SqlStringQuery;
import com.juiceman.ihatehibernate.ihatehiberatedemo.model.dto.ScoreAvgDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentAvgScore {


    List<ScoreAvgDTO> findAllAvgScore();
}

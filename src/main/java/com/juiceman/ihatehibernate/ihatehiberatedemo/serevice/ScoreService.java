package com.juiceman.ihatehibernate.ihatehiberatedemo.serevice;


import com.juiceman.ihatehibernate.ihatehiberatedemo.model.dto.ScoreAvgDTO;
import com.juiceman.ihatehibernate.ihatehiberatedemo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<ScoreAvgDTO> getAllAvgScore(){
        return scoreRepository.findAllAvgScore();
    }


}

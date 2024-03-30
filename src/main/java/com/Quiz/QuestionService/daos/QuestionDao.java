package com.Quiz.QuestionService.daos;


import com.Quiz.QuestionService.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

  //  @Query(value ="SELECT q.id from question q where q.category=:category ORDER BY RANDOM() LIMIT:numQues",nativeQuery = true)
    //List<Question> findRandomQuestionsByCategory(String category, int numQues);

  @Query(value = "SELECT q.id FROM Question q Where q.category=:category  LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}

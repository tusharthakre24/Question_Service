package com.tushar.questionservice.service;

import com.tushar.questionservice.model.Answer;
import com.tushar.questionservice.model.Question;
import com.tushar.questionservice.repo.QuestionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {

        logger.info("getAllQuestions started");

        List<Question> list = questionRepo.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    public ResponseEntity<Question> getQuestionById(Integer id) {

        logger.info("Started getQuestionById Id: {}", id);
        Question question= questionRepo.findById(id).get();

        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(Question question) {

        logger.info("Started addQuestion");
        questionRepo.save(question);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {

        logger.info("Started getQuestionByCategory Category: {}", category);
        List<Question> questions = questionRepo.findByCategory(category);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<String> addMultipleQuestions(List<Question> questions) {

        logger.info("Started addMultipleQuestions ");
        questionRepo.saveAll(questions);
        return new ResponseEntity<>("success",HttpStatus.OK);

    }

    public ResponseEntity<Integer> getScore(List<Answer> answers) {

        logger.info("Started getScore ");
        int score = 0;
        List<Question> list = questionRepo.findAll();
        for (Answer ans : answers){
            for (Question q : list){
                if (ans.getQuestion().equalsIgnoreCase(q.getQuestion()) && ans.getSubmittedAnswer().equalsIgnoreCase(q.getAnswer())){
                    score = score + 1;
                }
            }
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}

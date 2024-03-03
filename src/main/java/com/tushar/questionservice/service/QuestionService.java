package com.tushar.questionservice.service;

import com.tushar.questionservice.model.Question;
import com.tushar.questionservice.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> list = questionRepo.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<Question> getQuestionById(Integer id) {
        Question question= questionRepo.findById(id).get();
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionRepo.save(question);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        List<Question> questions = questionRepo.findByCategory(category);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}

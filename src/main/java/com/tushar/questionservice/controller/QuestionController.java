package com.tushar.questionservice.controller;

import com.tushar.questionservice.model.Answer;
import com.tushar.questionservice.model.Question;
import com.tushar.questionservice.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    QuestionService questionService;

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        logger.info("Started controller getAllQuestion");
        return questionService.getAllQuestions();
    }

    @GetMapping("/getQuestionById/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id){
        logger.info("Started controller getQuestionById Id: {}", id);
        return questionService.getQuestionById(id);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        logger.info("Started controller addQuestion");
        return questionService.addQuestion(question);
    }

    @PostMapping("/addMultipleQuestions")
    public ResponseEntity<String> addMultipleQuestions(@RequestBody List<Question> questions){
        logger.info("Started controller addMultipleQuestions");
        return questionService.addMultipleQuestions(questions);
    }

    @GetMapping("/getQuestionByCategory/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        logger.info("Started controller getQuestionByCategory");
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Answer> answers){
        logger.info("Started controller getScore");
        return questionService.getScore(answers);
    }
}

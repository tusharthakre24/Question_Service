package com.tushar.questionservice.controller;

import com.tushar.questionservice.model.Answer;
import com.tushar.questionservice.model.Question;
import com.tushar.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/getQuestionById/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id){
        return questionService.getQuestionById(id);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PostMapping("/addMultipleQuestions")
    public ResponseEntity<String> addMultipleQuestions(@RequestBody List<Question> questions){
        return questionService.addMultipleQuestions(questions);
    }

    @GetMapping("/getQuestionByCategory/{category}")
    public ResponseEntity<List<Question>> getQuestionById(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Answer> answers){
        return questionService.getScore(answers);
    }
}

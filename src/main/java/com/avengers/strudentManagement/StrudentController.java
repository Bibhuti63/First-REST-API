package com.avengers.strudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    /*
    User Iteracts with this layer
    All the API end points are defined/written only in this layer

    it main task is to  pass the information to Service Layer
    */

@RestController //to tell compileer that this class have REST API
public class StrudentController {

    @Autowired
    StudentService studentService;

    /*
    It's important that with every response we have to send the status code also, ex : (404- page not found error)
    so we will use ResponseEnity as return type
    ResposeEntity is a class consists of Response+Status Code
    */

    @PostMapping("/add_student") //to define end point of post API
    //access : localhost:8080/add_student

    public ResponseEntity addStudent(@RequestBody Student student){
        String response= studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/get_student") //to define end point of GET API
    //access : localhost:8080/get_student?q=1

    public ResponseEntity getStudent(@RequestParam("q") int admNo){
        //what value we will get from  'q' value will passed to 'admNo'
         Student student= studentService.getStudent(admNo);
         if(student==null){
             return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<>(student,HttpStatus.FOUND);
    }


    @DeleteMapping("/delete_student/{id}")
    //access : localhost:8080/delete_student/1

    public ResponseEntity deleteStudent(@PathVariable("id") int id){
        String response= studentService.deleteStudent(id);
        if(response.equals("Invalid id")){
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }


    @PutMapping("/update_student")
    //access : localhost:8080/update_student?id=1&age=100

    public ResponseEntity updateStudent(@RequestParam("id") int id,@RequestParam("age") int age){
        String response= studentService.updateStudent(id,age);
        if(response==null){
            return new ResponseEntity<>("Invalid Request",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }


}

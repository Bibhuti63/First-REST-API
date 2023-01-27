package com.avengers.strudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
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

    //adding the information
    @PostMapping("/add_student") //to define end point of post API
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
        //access : localhost:8080/add_student

    //get the information
    @GetMapping("/get_student")  //to define end point of GET API
    public Student getStudent(@RequestParam("q") int admNo){ //what value we will get from  'q' value will passed to 'admNo'
        return studentService.getStudent(admNo);
    }
        //access : localhost:8080/get_student?q=1

    //Delete the information
    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        return studentService.deleteStudent(id);
    }
        //access : localhost:8080/delete_student/1

    //Update Information
    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int id,@RequestParam("age") int age){
        return studentService.updateStudent(id,age);
    }
        //access : localhost:8080/update_student?id=1&age=100

}

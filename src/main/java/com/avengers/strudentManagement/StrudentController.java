package com.avengers.strudentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController //to tell compileer that this class have REST API
public class StrudentController {

    Map<Integer,Student> db=new HashMap<>();

    //adding the information
    @PostMapping("/add_student") //to define end point of post API
    public String addStudent(@RequestBody Student student){
        //if(student==null)return "invalid student";
        int admNo=student.getAdmNo();
        db.put(admNo,student);
        return "Student added successfully";
        //access : localhost:8080/add_student
    }

//    or

//   /*
   @PostMapping("/add_students") //to define end point of post API
    public String addStudent(@RequestParam("name") String name,@RequestParam("age") int age,@RequestParam("admNo") int admNo,@RequestParam("state") String state){
        Student s=new Student(name,age,admNo,state);
        db.put(admNo,s);
        return "Student added successfully";
        //access : localhost:8080/add_students?name="bibhutibiswal"&age=18&admNo=9&state="Orissa"
    }

//    */


    //get the information
    @GetMapping("/get_student")  //to define end point of GET API
    public Student getStudent(@RequestParam("q") int admNo){ //what value we will get from  'q' value will passed to 'admNo'

        return db.get(admNo);
        //access : localhost:8080/get_student?q=1
    }

    @GetMapping("get_students")
    public Student getStudent(@RequestParam("name") String name){
        for(int key : db.keySet()){
            String str=db.get(key).getName();
            if(name.equals(str)){
                return db.get(key);
            }
        }
        return null;
        //access : localhost:8080/get_student?name=Bibhuti
    }

    //Delete the information
    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        if(!db.containsKey(id)){
            return "invalid id";
        }
        db.remove(id);
        return "Student removed successfully";
    }


    //Update Information
    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int id,@RequestParam("age") int age){
        if(!db.containsKey(id)){
            return "Invalid id";
        }
        db.get(id).setAge(age);
        return "Age updated successfully";
    }








    // Different ways of getting information from user


    /*

    1
    RequestParam - Parameter taking as request
    @RequestParam

    2
    PathVariable - Parameter is part of path of url
    @PathVariable

    3
    BodyParam - Parameter is passed in body of HTTP request inform of JSON or XML
    @RequestBody

    */

}

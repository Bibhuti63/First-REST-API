package com.avengers.strudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    Main Business logic is written in this layer. So it is the main part
    this logic will also do the processing , ex: (getting list of numbers from Database and sorting here)
    this logic is most useful when writing large complex API.

    It further passes info to Repository layer
    */

@Service
public class StudentService {

    //We can not create multiple object of class here, as it will create multiple HashMap also.
    //So we will use concept of singleton class (class wich can have only one object at most)


    /*
    @Autowired // annotation through which we can use object of StudentRepository class
    StudentRepository studentRepository;

    Note : We can not use @Autowired for any other object except(controller,service,repository)
    */
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        //any preprocessing to done (if required)
        //calling or passing info to repository layer
        return studentRepository.addStudent(student);
    }

    public Student getStudent(int admNo){
        return studentRepository.getStudent(admNo);
    }

    public String deleteStudent(int admNo){
        return studentRepository.deleteStudent(admNo);
    }

    public String updateStudent(int id, int age){
        return studentRepository.updateStudent(id,age);
    }



}

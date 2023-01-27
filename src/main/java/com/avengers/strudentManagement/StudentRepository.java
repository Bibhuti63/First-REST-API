package com.avengers.strudentManagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    //Logic related to Database is written here,
    //this layer interacts with the database



    Map<Integer,Student> db=new HashMap<>();

    public String addStudent(Student student){
        int admNo=student.getAdmNo();
        db.put(admNo,student);
        return "Student added successfully";
    }

    public Student getStudent( int admNo){
        return db.get(admNo);
    }

    public String deleteStudent( int id){
        if(!db.containsKey(id)){
            return "Student not availabe on database";
        }
        db.remove(id);
        return "Student removed successfully";
    }

    public String updateStudent(int id, int age){
        if(!db.containsKey(id)){
            return "Student not availabe of database";
        }
        db.get(id).setAge(age);
        return "Age updated successfully";
    }

}

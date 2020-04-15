package org.springmvc.class04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmvc.class04.jdbc.Studentjdbc;
import org.springmvc.class04.model.student;

@Controller
public class addStudentController {
    @RequestMapping(path = "addStudent",method = RequestMethod.POST)
private String addStudent(@RequestParam(value = "student_Id") String student_Id,@RequestParam(value = "student_Name") String student_Name){
        student s = new student();
        /**
         * 赋值
         */

        s.setStudentId(Long.parseLong(student_Id));
        s.setStudentName(student_Name );
//        Studentjdbc.addStudent(s);
        Boolean result = Studentjdbc.addStudent(s);
    return"index";
}
}

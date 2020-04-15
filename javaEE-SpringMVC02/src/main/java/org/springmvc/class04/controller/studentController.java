package org.springmvc.class04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmvc.class04.jdbc.Studentjdbc;
import org.springmvc.class04.model.student;

import java.util.List;

@Controller
public class studentController {

@RequestMapping(value = "/showStudents")
    private String showStudent(Model model){
        List<student> list = Studentjdbc.selectAll();
        model.addAttribute("list",list);
        return "student";
    }

}

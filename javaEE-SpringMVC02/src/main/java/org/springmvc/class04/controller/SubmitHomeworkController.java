package org.springmvc.class04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmvc.class04.jdbc.StudentHomeworkjdbc;
import org.springmvc.class04.model.StudentHomework;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SubmitHomeworkController {
    @RequestMapping(path = "/SubmitHomework",method = RequestMethod.POST)
    private String  submitHomework (@RequestParam(value = "Id") String Id,
                                          @RequestParam(value = "studentId") String studentId,
                                          @RequestParam(value = "homeworkId") String homeworkId,
                                          @RequestParam(value = "homeworkTitle") String homeworkTitle,
                                          @RequestParam(value = "homeworkContent") String homeworkContent

    ){
        StudentHomework sh = new StudentHomework();
        /**
         * 赋值
         */
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sh.setId(Long.getLong( Id));
        sh.setStudentId(Long.getLong(studentId));
        sh.setHomeworkId(Long.getLong( homeworkId));
        sh.setHomeworkContent(homeworkContent);
        sh.setCreateTime(new Date());
        sh.setHomeworkTitle(homeworkTitle);
        StudentHomeworkjdbc.addStudentHomework(sh);
        return"index";
    }
}

package org.springmvc.class04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmvc.class04.jdbc.Homeworkjdbc;
import org.springmvc.class04.model.homework;

@Controller

public class addHomeworkController {
    @RequestMapping(value = "addHomework",method = RequestMethod.POST)
    private String  addHomeworkController(@RequestParam(value = "homework_Id") String homework_Id,
                                          @RequestParam(value = "homework_Title") String homework_Title,
                                          @RequestParam(value = "homework_Content") String homework_Content
    ){
        homework h= new homework();
        /**
         * 赋值
         */

        h.setHomeworkId(Long.parseLong(homework_Id));
        h.setHomeworkName( homework_Title );
        h.setHomeworkContent(homework_Content);
        Boolean result = Homeworkjdbc.addHomework(h);
        return "index";
    }
}

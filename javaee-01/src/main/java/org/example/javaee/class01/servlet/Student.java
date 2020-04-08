package org.example.javaee.class01.servlet;
import java.util.List;
import org.example.javaee.class01.jdbc.StudentHomeworkjdbc;
import org.example.javaee.class01.jdbc.Studentjdbc;
import org.example.javaee.class01.model.StudentHomework;
import org.example.javaee.class01.model.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentlist")
public class Student   extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<student> list = Studentjdbc.selectAll();


        req.setAttribute("list", list);

        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }
}

package org.example.javaee.class01.servlet;

import java.util.List;

import org.example.javaee.class01.jdbc.StudentHomeworkjdbc;
import org.example.javaee.class01.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/list")
public class StudentHomeworkServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> list = StudentHomeworkjdbc.selectAll();


        req.setAttribute("list", list);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

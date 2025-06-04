package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectListAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        School school = (School) request.getSession().getAttribute("school");

        if (school == null) {
            System.out.println("school がセッションにありません");
            return "/login.jsp";
        }

        System.out.println("school = " + school.getCd());

        SubjectDAO dao = new SubjectDAO();
        List<Subject> subjectList = dao.findAll(school);

        System.out.println("取得件数: " + subjectList.size());

        request.setAttribute("subjectList", subjectList);
        return "/main/subject_list.jsp";
    }
}

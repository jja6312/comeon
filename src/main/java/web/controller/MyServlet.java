package web.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import web.entity.Member;
import web.exception.MyException;
import web.model.MemberService;

import java.io.IOException;

@WebServlet("/main")
public class MyServlet extends HttpServlet {
    MemberService memberService;


    @Override
    public void init() throws ServletException {
        memberService = new MemberService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        process(request, response);

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sign = request.getParameter("sign");
        if (sign != null && sign.equals("login")) {
            login(request, response);
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        Member loginMember = null;
        try {
            loginMember = memberService.login(id, pw);
            if (loginMember != null) {// login ok
                HttpSession session = request.getSession();
                session.setAttribute("loginMember", loginMember);
            }
        } catch (MyException e) {
        }


        RequestDispatcher disp = request.getRequestDispatcher("loginSuccess.jsp");
        disp.forward(request, response);

//
////        Cookie cookie = new Cookie("id", loginMember.getId());
////        Cookie cookie2 = new Cookie("name", loginMember.getName());
////        cookie.setPath("/");
////        cookie.setMaxAge(3000);
////        cookie2.setMaxAge(3000);
////        response.addCookie(cookie);
////        response.addCookie(cookie2);
//
//        HttpSession session = request.getSession();
//        session.setAttribute("id", loginMember.getId());
//        session.setAttribute("name", loginMember.getName());
//
//
//        System.out.println(loginMember);
//
////        request.setAttribute("id", loginMember.getId());
////        request.setAttribute("pw", loginMember.getPw());
////        request.setAttribute("name", loginMember.getName());
//        RequestDispatcher disp = request.getRequestDispatcher("loginSuccess.jsp");
//        disp.forward(request, response);

    }
}

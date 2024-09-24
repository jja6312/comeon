package web.model;

import web.entity.Member;
import web.exception.MyException;

import java.sql.*;

public class MemberDAO {
    Connection con;

    public MemberDAO() {
        // JDBC

        // 1. 드라이버 등록
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. 연결
            String url = "jdbc:mysql://localhost/jesdb";  // "jdbc:mysql:" -> "jdbc:mysql://"
            String user = "ssafy";
            String pw = "ssafy";

            System.out.println("connect");

            con = DriverManager.getConnection(url, user, pw);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public Member login(String id, String pw) throws MyException {

        try {
            // 3. Statement 정보
            Statement stmt = con.createStatement();

            String sql = "select * from member where id='" + id + "' and pw='" + pw + "'";

            //4. sql 전송
            ResultSet rs = stmt.executeQuery(sql);

            // 5. 결과 얻기
            if (rs.next()) {
                String name = rs.getString("name");
//                int no = rs.getInt("no");
                Member member = new Member(id, name, pw);
                System.out.println(member);
                return member;
            }
            rs.close();
            stmt.close();
            return null;
        }catch(Exception e){
            throw new MyException("로그인 실패");
        }



//        Member member = db.get(id);
//        if (member == null) throw new IllegalArgumentException("멤버가 없습니다.");
//        if (!member.getPw().equals(pw)) new IllegalArgumentException("패스워드가 잘못되었습니다");
//
//        return member;
    }

    public Member login(Member member) throws MyException {


        return login(member.getId(), member.getPw());
    }


    public static void main(String[] args) throws MyException {
        MemberDAO memberDAO = new MemberDAO();
        Member m = memberDAO.login("a", "a");

        System.out.println(m.getName()+"님 환영합니다.");
    }

}

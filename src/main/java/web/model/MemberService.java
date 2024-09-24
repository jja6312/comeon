package web.model;

import web.entity.Member;
import web.exception.MyException;

import java.util.HashMap;
import java.util.Map;

public class MemberService {
//    Map<String, Member> db  = new HashMap<>();
    MemberDAO memberDAO;

    public MemberService() {
//        db.put("test1", new Member("test1","123","피카츄","text@xx.xx"));
//        db.put("test2", new Member("test2","123","라이츄","text@xx.xx"));
//        db.put("test3", new Member("test3","123","파이리","text@xx.xx"));
        memberDAO = new MemberDAO();
    }

    public Member login(String id, String pw) throws MyException {
        return memberDAO.login(id, pw);
    }

    public Member login(Member member) throws MyException {
        return memberDAO.login(member);
    }




}

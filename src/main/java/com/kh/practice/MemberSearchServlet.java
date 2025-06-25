package com.kh.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.practice.model.vo.Member;

@WebServlet("/search")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Member> mockList = new ArrayList<>();

	public MemberSearchServlet() {
		super();
	}

	@Override
	public void init() {
		// MOCK 회원 데이터
		mockList.add(new Member("홍은동", 25, "남자"));
        mockList.add(new Member("김영심", 19, "여자"));
        mockList.add(new Member("이은수", 30, "남자"));
        mockList.add(new Member("심하늘", 22, "여자"));
        mockList.add(new Member("정심훈", 45, "남자"));
        mockList.add(new Member("심은성", 4, "남자"));
        mockList.add(new Member("나수지", 33, "여자"));
        mockList.add(new Member("유상성", 21, "남자"));
        mockList.add(new Member("한지은", 28, "여자"));
        mockList.add(new Member("고심현", 40, "남자"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. doPost의 인코딩 타입 설정
		request.setCharacterEncoding("utf-8");
		
		// 1. 클라이언트로부터 요청값 받아오기 getParameter
		String name = request.getParameter("name");
		
		// 2. 새로운 리스트 생성하기
		ArrayList<Member> list = new ArrayList<>();
		
		// 3. 반복문으로 값 조회해서 리스트에 담기
		for(Member m : mockList) {
			if(m.getName().contains(name)) {
				list.add(m);
			}
		}
		
		// 4. 리스트를 응답값으로 넣기 setAttribute
		request.setAttribute("list", list);
		
		// 5. 요청을 위임할 jsp로 경로 찾아서 jsp에 데이터 전달 dispatcher, forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);
	}
}
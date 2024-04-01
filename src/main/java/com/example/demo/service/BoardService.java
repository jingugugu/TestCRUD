package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import com.example.demo.dto.BoardDto;
import com.example.demo.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardMapper boardMapper;

	public void create(BoardDto boardDto) {
		System.out.println("================CreateService===========");
		boardMapper.create(boardDto);
		System.out.println("===========tet==============");
	}

//	public List<BoardDto> list() {
//		System.out.println("===========service 게시글 목록==============");
//		List<BoardDto> boardList = new ArrayList<>();
//		boardList = boardMapper.list();
//		return boardList;
//	}
	
//	public List<BoardDto> list() {
//		List<BoardDto> boardList = boardMapper.list();
//		System.out.println("===========list==============");
//		return boardList;
//	}
	
	public List<BoardDto> list() {
		System.out.println("===========service 게시글 목록==============");
		return boardMapper.list();
	}
	
	public BoardDto detail(int bno) {
		System.out.println("===========service 게시글 상세==============");
		return boardMapper.detail(bno);
	}

	public void update(BoardDto boardDto) {
		System.out.println("===========service 게시글 수정==============");
		boardMapper.update(boardDto);
	}

	public void delete(int bno) {
		System.out.println("===========service 게시글 삭제==============");
		boardMapper.delete(bno);
	}
	
}

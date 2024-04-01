package com.example.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.dto.BoardDto;

@Mapper
public interface BoardMapper {

	void create(BoardDto boardDto);

	List<BoardDto> list();

	BoardDto detail(int bno);

	void update(BoardDto boardDto);

	void delete(int bno);
	
}

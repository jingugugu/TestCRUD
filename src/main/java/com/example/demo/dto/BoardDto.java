package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class BoardDto {
	private int bno; //게시판 번호
	private String title; //제목
	private String content; //내용
	private String writer; //작성자
	private LocalDateTime insert_time; //작성날짜
}
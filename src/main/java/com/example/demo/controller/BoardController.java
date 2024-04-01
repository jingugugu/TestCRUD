package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/create")
	public void create() {
	}
	
	@PostMapping("/create")
	public String create(BoardDto boardDto) {
		System.out.println("===================controller 게시글 등록=====================");
		System.out.println("boardDTO" + boardDto);
		boardService.create(boardDto);
		return "home";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("====================controller 게시글 목록====================");
		model.addAttribute("boardList", boardService.list());
		return "list";
	}
	 
	 @GetMapping("/{bno}")
	 public String detail(@PathVariable("bno") int bno, Model model) {
		 // 상세내용 가져옴
		 BoardDto boardDto = boardService.detail(bno);
		 model.addAttribute("boardDto", boardDto);
		 System.out.println("boardDto = " + boardDto);
		 return "detail";
	 }
	 
	  @GetMapping("/update/{bno}")
	  public String update(@PathVariable("bno") int bno, Model model) {
		  BoardDto boardDto = boardService.detail(bno);
		  model.addAttribute("boardDto", boardDto);
		  System.out.println("boardDto = " + boardDto);
		  return "update";
	  }
	  
	  @PostMapping("/update/{bno}")
	  public String update(BoardDto boardDto, Model model) {
		  boardService.update(boardDto);
		  BoardDto dto = boardService.detail(boardDto.getBno());
		  model.addAttribute("boardDto", dto);
		  return "detail";
	    }
	  
	  @GetMapping("/delete/{bno}")
	  public String delete(@PathVariable("bno") int bno) {
		  boardService.delete(bno);
		  return "redirect:/list";
	  }
	    
}
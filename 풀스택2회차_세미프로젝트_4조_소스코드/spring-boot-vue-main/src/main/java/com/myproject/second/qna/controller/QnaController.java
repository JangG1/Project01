package com.myproject.second.qna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.second.qna.service.QnaService;
import com.myproject.second.qna.vo.QnaVO;
import com.myproject.second.review.vo.ReviewVO;

@RestController
@RequestMapping(value = "api/qna/*")
public class QnaController {
	@Autowired
	private QnaService qnaService;

	@GetMapping("/count/{productno}")
	public int reviewCount(@PathVariable("productno") int productno) throws Exception {
		return qnaService.qnaCount(productno);
	}

	@GetMapping("/getQna")
	public List<QnaVO> getQnaList(@RequestParam("productno") int productno, @RequestParam("page") int page,
			@RequestParam("content") int content) throws Exception {
		return qnaService.getQnaList(productno, page, content);
	}

	@PostMapping("/{productno}")
	public void inserQna(@PathVariable("productno") int productno, @RequestParam String title, @RequestParam String id)
			throws Exception {
		qnaService.addQna(productno, title, id);
	}
}
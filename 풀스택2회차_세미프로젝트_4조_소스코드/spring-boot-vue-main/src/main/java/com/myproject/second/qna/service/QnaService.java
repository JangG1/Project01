package com.myproject.second.qna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.second.qna.mapper.QnaMapper;
import com.myproject.second.qna.vo.QnaVO;
import com.myproject.second.review.vo.ReviewVO;

@Service
public class QnaService {
	private QnaMapper qnaMapper;

	public QnaService(QnaMapper qnaMapper) {
		this.qnaMapper = qnaMapper;
	}

	public int qnaCount(int productno) {
		return qnaMapper.qnaCount(productno);
	}

	public List<QnaVO> getQnaList(int productno, int page, int content) {
		List<QnaVO> result = qnaMapper.findAllQna(productno);
		if (result.size() > content * page) {
			return result.subList(content * (page - 1), content * page);
		} else {
			return result.subList(content * (page - 1), result.size());
		}
	}

	public void addQna(int productno, String title, String id) {
		// TODO Auto-generated method stub
		qnaMapper.addQna(productno, title, id);
	}
}
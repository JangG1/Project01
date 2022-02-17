package com.myproject.second.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.second.product.vo.ProdVO;
import com.myproject.second.review.mapper.ReviewMapper;
import com.myproject.second.review.vo.ReviewVO;

@Service
public class ReviewService {
	private ReviewMapper reviewMapper;

	public ReviewService(ReviewMapper reviewMapper) {
		this.reviewMapper = reviewMapper;
	}

	public int reviewCount(int productno) {
		return reviewMapper.reviewCount(productno);
	}

	public List<ReviewVO> getReviewList(int productno, int page, int content) {
		List<ReviewVO> result = reviewMapper.findAllReview(productno);
		if (result.size() > content * page) {
			return result.subList(content * (page - 1), content * page);
		} else {
			return result.subList(content * (page - 1), result.size());
		}
	}

}

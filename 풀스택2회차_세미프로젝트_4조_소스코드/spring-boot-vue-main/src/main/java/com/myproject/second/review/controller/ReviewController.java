package com.myproject.second.review.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.second.review.service.ReviewService;
import com.myproject.second.review.vo.ReviewVO;

@RestController
@RequestMapping(value = "api/review/*")
public class ReviewController {
   @Autowired
   private ReviewService reviewService;

   @GetMapping("/count/{productno}")
   public int reviewCount(@PathVariable("productno") int productno) throws Exception {
      return reviewService.reviewCount(productno);
   }

   @GetMapping("/getReview")
   public List<ReviewVO> getReviewList(@RequestParam("productno") int productno, @RequestParam("page") int page,
         @RequestParam("content") int content) throws Exception {
      return reviewService.getReviewList(productno, page, content);
   }

   @GetMapping("/reviewImage/{productno}/{reviewno}/{image}")
   public ResponseEntity<?> productimage(@PathVariable("productno") int productno,
         @PathVariable("reviewno") int reviewno, @PathVariable("image") String image) throws IOException {

      System.out.println(productno);
      System.out.println(reviewno);
      System.out.println(image);
      InputStream imageStream;
      try {
         imageStream = new FileInputStream(
               "./src/main/resources/images/product/" + productno + "/review/" + reviewno + "/" + image);
      } catch (FileNotFoundException e) {
    	  imageStream = new FileInputStream("./src/main/resources/images/error.png");
      }
      byte[] imageByteArray = IOUtils.toByteArray(imageStream);
      imageStream.close();
      return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
   }
}
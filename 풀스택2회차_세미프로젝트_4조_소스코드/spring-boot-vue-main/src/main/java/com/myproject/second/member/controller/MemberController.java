package com.myproject.second.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.second.member.service.MemberService;
import com.myproject.second.member.vo.MemberVO;

@RestController
@RequestMapping(value = "api/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping("/all")
	public List<MemberVO> getAllMembers() {
		return memberService.getAllMembers();
	}

	@GetMapping("/{id}")
	public MemberVO getMemberInfo(@PathVariable("id") String id) throws Exception {
		return memberService.getMemberInfo(id);
	}

	@GetMapping("/idCheck/{id}")
	public int idCheck(@PathVariable("id") String id) throws Exception {
		return memberService.idCheck(id);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestParam("id") String id, @RequestParam("password") String pwd) {
		return memberService.getMember(id, pwd);
	}

	@GetMapping("/productDetail/{productno}")
	public String getMember(@PathVariable("productno") int productno) throws Exception {
		return memberService.getNickname(productno);
	}

	@PostMapping("/insertMember")
	public ResponseEntity<?> insertMember(@RequestBody MemberVO in) throws Exception {
		return memberService.insertMember(in);
	}

	@PutMapping("/point")
	public void updatePoint(@RequestParam("id") String id, @RequestParam("point") int point) throws Exception {
		memberService.updatePoint(id, point);
	}

	@PutMapping("/nickname")
	public void updateNickname(@RequestParam("id") String id, @RequestParam("nickname") String nickname)
			throws Exception {
		memberService.updateNickname(id, nickname);
	}

	@PutMapping("/password")
	public void updatePassword(@RequestParam("id") String id, @RequestParam("password") String password)
			throws Exception {
		memberService.updatePassword(id, password);
	}

	@PutMapping("/tel")
	public void updateTel(@RequestParam("id") String id, @RequestParam("tel") String tel) throws Exception {
		memberService.updateTel(id, tel);
	}

	@PutMapping("/address")
	public void updateAddress(@RequestParam("id") String id, @RequestParam("zipcode") String zipcode,
			@RequestParam("address") String address, @RequestParam("detailaddr") String detailaddr) throws Exception {
		memberService.updateAddress(id, zipcode, address, detailaddr);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteMember(@RequestParam("id") String id,
			@RequestParam(value = "password", required = false) String password) throws Exception {
		return memberService.deleteMember(id, password);
	}
}

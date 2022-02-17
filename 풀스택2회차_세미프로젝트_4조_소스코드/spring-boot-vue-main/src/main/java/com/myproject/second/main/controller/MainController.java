package com.myproject.second.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.second.main.service.MainService;
import com.myproject.second.main.vo.MainVO;
import com.myproject.second.product.vo.ProdVO;

@RestController
@RequestMapping(value="api/main/*")
public class MainController {
	@Autowired
	private MainService mainService;

	@GetMapping("/test11")
	public List<MainVO> testBuild() {
		List<MainVO> list = mainService.getMainList();
//		list.stream().forEach((i)->{System.out.println(i.getImage());});
		
//		System.out.println(mainService.getMainList());
		return mainService.getMainList();
//		temp temp1 = new temp("1","2","3");
//		List<temp> tempList = new ArrayList<>();
//		tempList.add(temp1);
//		return tempList;
	}
//	@RequestMapping("/test11")
//	public String ddd() {
//		return "Dfdf";
//	}
	@GetMapping("/productDetail/{num}")
	public MainVO getMainList(@PathVariable("num") int num) throws Exception {
		List<MainVO> list = mainService.getMainList();
		
		return list.get(num-1);
	}
	
	@GetMapping("/temp/{num}")
	public MainVO nosstice(@PathVariable("num") int num) throws Exception {
		List<MainVO> list = mainService.getMainList();
		
		return list.get(num-1);
	}
	
}

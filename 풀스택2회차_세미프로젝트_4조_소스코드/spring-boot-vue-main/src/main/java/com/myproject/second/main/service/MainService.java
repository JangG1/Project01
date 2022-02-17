package com.myproject.second.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.second.main.mapper.MainMapper;
import com.myproject.second.main.vo.MainVO;

@Service
public class MainService {
	private MainMapper mainMapper;

	public MainService(MainMapper mainMapper) {
		this.mainMapper = mainMapper;
	}
	
	public List<MainVO> getMainList(){
		return mainMapper.findAll();
	}
}


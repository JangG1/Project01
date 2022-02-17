package com.myproject.second.order.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myproject.second.order.mapper.OrderMapper;
import com.myproject.second.order.vo.OrderVO;
import com.myproject.second.product.vo.ProdVO;

@Service
public class OrderService {
	private OrderMapper orderMapper;

	public OrderService(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	public List<OrderVO> getAllOrderList(String id) {
		return orderMapper.getAllOrderList(id);
	}

	public List<OrderVO> getOrderList(String id, String startdate, String enddate, String productname) {
		String temp = "%" + productname + "%";
		return orderMapper.getOrderList(id, startdate, enddate, temp);
	}

	public List<OrderVO> getCancelList(String id, String startdate, String enddate, String productname) {
		String temp = "%" + productname + "%";
		return orderMapper.getCancelList(id, startdate, enddate, temp);
	}

	public ResponseEntity<?> insertOrder(OrderVO orderVO) {
		try {
			orderMapper.insertOrder(orderVO);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<OrderVO> getSellList(String sellerid) {
		return orderMapper.getSellList(sellerid);
	}

	public ResponseEntity<?> updateOrder(long orderidx, String state) {
		try {
			orderMapper.updateOrder(orderidx, state);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public int haveOrder(String id) {
		return orderMapper.haveOrder(id);
	}
	
	public ResponseEntity<?> findByName(String name, String id) {
		List<OrderVO> res = orderMapper.findByName(name, id);
		if (res == null)
			return new ResponseEntity<>("Product Not Found", HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> findByNo(int productno, String id) {
		List<OrderVO> res = orderMapper.findByNo(productno, id);
		if (res == null)
	
			return new ResponseEntity<>("Product Not Found", HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity<>(res, HttpStatus.OK);
	}
}

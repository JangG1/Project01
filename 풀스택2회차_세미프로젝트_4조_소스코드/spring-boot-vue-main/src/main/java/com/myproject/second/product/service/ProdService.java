package com.myproject.second.product.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.second.product.mapper.ProdMapper;
import com.myproject.second.product.vo.ProdVO;

@Service
public class ProdService {
	private ProdMapper prodMapper;

	public ProdService(ProdMapper prodMapper) {
		this.prodMapper = prodMapper;
	}

	public List<ProdVO> getProductList() {
		return prodMapper.findAllProduct();
	}

	public List<ProdVO> getSalesList(String sellerid) {
		return prodMapper.findSalesList(sellerid);
	}

	public ProdVO getfindProduct(int productno) {
		return prodMapper.findProduct(productno);
	}

	public int getCount(String productname, int min, int max) {
		String temp = "%" + productname + "%";
		return prodMapper.getCount(temp, min, max);
	}

	public List<ProdVO> searchMinMaxProduct(String productname, int page, int content, int min, int max) {
		String temp = "%" + productname + "%";
		List<ProdVO> result = prodMapper.searchMinMaxProduct(temp, min, max);
		if (result.size() > content * page) {
			return result.subList(content * (page - 1), content * page);
		} else {
			return result.subList(content * (page - 1), result.size());
		}
	}

	public List<ProdVO> searchPopular(String productname) {
		String temp = "%" + productname + "%";
		List<ProdVO> result = prodMapper.searchProduct(temp);
		if (result.size() > 4) {
			return result.subList(0, 4);
		} else {
			return result.subList(0, result.size());
		}
	}

	public List<ProdVO> searchProduct(String productname, int page, int content) {
		String temp = "%" + productname + "%";
		List<ProdVO> result = prodMapper.searchProduct(temp);
		if (result.size() > content * page) {
			return result.subList(content * (page - 1), content * page);
		} else {
			return result.subList(content * (page - 1), result.size());
		}
	}

	public String getOption1(int productno) {
		return prodMapper.findOption1(productno);
	}

	public List<ProdVO> getProductImageList(int productno) {
		List<ProdVO> list = prodMapper.findAllProductImage(productno).subList(0, 6);
		return list;
	}

//	public int insertProduct(ProdVO target) {
////		ProdVO result = new ProdVO();
////		prodMapper.insertProduct(target, result);
////		return result.getProductno();
//	
//	}

	public int haveProduct(String sellerid) {
		return prodMapper.haveProduct(sellerid);
	}

	public ResponseEntity<?> onSaleProduct(String onsale, int productno) {
//		System.out.println(prodMapper.onSaleProduct(onsale, productno));
//		prodMapper.onSaleProduct(onsale, productno);
//		return null;
		int res = prodMapper.onSaleProduct(onsale, productno);
		System.out.println(res);
		if (res == 1) {
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> insertProduct(ProdVO requestData, List<MultipartFile> fileList) {
		ProdVO result = new ProdVO();
		ResponseEntity<?> entity = null;

		try {
			if (requestData.getOption2().equals(";")) {
				requestData.setOption2("옵션2;선택");
			}
			prodMapper.insertProduct(requestData, result);
			int productno = result.getProductno();
			File file = new File("./src/main/resources/images/product/" + productno + "/");
			file.mkdir();
			String[] path = { "/product/", "/detail/" };
			file = new File("./src/main/resources/images/product/" + productno + path[0]);
			file.mkdir();
			file = new File("./src/main/resources/images/product/" + productno + path[1]);
			file.mkdir();

			for (int i = 0; i < fileList.size(); i++) {
				MultipartFile multipartFile = fileList.get(i);
				FileOutputStream writer = new FileOutputStream("./src/main/resources/images/product/" + productno
						+ path[i] + multipartFile.getOriginalFilename());
				System.out.println(multipartFile.getOriginalFilename());
				writer.write(multipartFile.getBytes());
				writer.close();
			}
			entity = new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}

	public ResponseEntity<?> updateProduct(ProdVO requestData, List<MultipartFile> file1, List<MultipartFile> file2) {
		ProdVO result = new ProdVO();
		ResponseEntity<?> entity = null;

		try {
			if (requestData.getOption2().equals(";")) {
				requestData.setOption2("옵션2;선택");
			}
			
			prodMapper.updateProduct(requestData, result);
//			int productno = result.getProductno();
			File file;
			File[] underDir;
			FileOutputStream writer;
			String[] path = { "/product/", "/detail/" };

			if (file1 != null) {
				file = new File("./src/main/resources/images/product/" + requestData.getProductno() + path[0]);
				underDir = file.listFiles();
				for (int i = 0; i < underDir.length; i++) {
					underDir[i].delete();
				}
				writer = new FileOutputStream("./src/main/resources/images/product/" + requestData.getProductno()
						+ path[0] + file1.get(0).getOriginalFilename());
				writer.write(file1.get(0).getBytes());
				writer.close();
			}
			if (file2 != null) {
				file = new File("./src/main/resources/images/product/" + requestData.getProductno() + path[1]);
				underDir = file.listFiles();
				for (int i = 0; i < underDir.length; i++) {
					underDir[i].delete();
				}
				writer = new FileOutputStream("./src/main/resources/images/product/" + requestData.getProductno()
						+ path[1] + file2.get(0).getOriginalFilename());
				writer.write(file2.get(0).getBytes());
				writer.close();
			}

			entity = new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}

	public ResponseEntity<?> findByName(String name) {
		List<ProdVO> res = prodMapper.findByName(name);
		if (res == null)
			return new ResponseEntity<>("Product Not Found", HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> findByNo(int productno) {
		List<ProdVO> res = prodMapper.findByNo(productno);
		if (res == null)
			return new ResponseEntity<>("Product Not Found", HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> updateAmount(int productno, int amount) {
		try {
			prodMapper.updateAmount(productno, amount);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

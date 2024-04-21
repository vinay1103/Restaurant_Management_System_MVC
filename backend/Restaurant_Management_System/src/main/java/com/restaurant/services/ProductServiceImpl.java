package com.restaurant.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.daos.ProductDao;
import com.restaurant.dtos.ProductDTO;
import com.restaurant.dtos.ProductDTOSend;
import com.restaurant.entities.Product;
import com.restaurant.utils.DtoEntityConverter;

@Service
@Transactional
public class ProductServiceImpl {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private DtoEntityConverter converter;

	public Map<String, Object> addProduct(ProductDTO productDTO) {
		Product product=converter.toProductEntity(productDTO);
		
		product = productDao.save(product);
		return Collections.singletonMap("insertedId", product.getProductId());
	}
	
	
	
	public Map<String, Object> updateProduct(ProductDTO productDTO,int id) {
		Product product=productDao.findByProductId(id);		
		product.setProductName(productDTO.getProductName());
		product.setProductPrice(productDTO.getProductPrice());
//		product.setCategory(new Category(productDTO.getProductcategoryId()));
		product = productDao.save(product);
		return Collections.singletonMap("Updated", product.getProductId());
	}
	
	public Map<String, Object> updateProductStatus(ProductDTO productDTO,int id) {
		Product product=productDao.findByProductId(id);
		product.setProductStatus(productDTO.getProductStatus());
		product = productDao.save(product);
		return Collections.singletonMap("Updated", product.getProductId());
	}
	
	public List<ProductDTOSend> getAllProduct() {
		
	List<ProductDTOSend> sendList= new ArrayList<ProductDTOSend>();	
	List<Product> list = productDao.findAll();
	for (Product product : list) {
		sendList.add(converter.toProductDTO(product));
	}
	
	
	return sendList;
	}
	
	public List<ProductDTOSend> getAllProductByStatus() {
		
		List<ProductDTOSend> sendList= new ArrayList<ProductDTOSend>();	
		List<Product> list = productDao.findByProductStatus("Enabled");
		for (Product product : list) {
			sendList.add(converter.toProductDTO(product));
		}
		
		
		return sendList;
		}
	
	public List<ProductDTOSend> getProductByCat(int id) {
		
	List<ProductDTOSend> sendList= new ArrayList<ProductDTOSend>();	
	List<Product> list = productDao.findByCategory_CategoryIdAndProductStatus(id,"Enabled");
	for (Product product : list) {
		sendList.add(converter.toProductDTO(product));
	}
	
	return sendList;
	}
	public ProductDTOSend getByProductId(int id) {

		ProductDTOSend dtoSend = converter.toProductDTO(productDao.findByProductId(id));
		
	return dtoSend;
	}
	
	public int deleteByProductId(int id) {

		if(productDao.existsById(id))
		{
			Product product = productDao.findByProductId(id);
			productDao.deleteById(id);
			return 1;
		}
		
	return 0;
	}
}

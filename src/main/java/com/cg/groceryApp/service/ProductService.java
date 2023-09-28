package com.cg.groceryApp.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cg.groceryApp.entities.Category;
import com.cg.groceryApp.entities.Product;
import com.cg.groceryApp.entities.ProductPaging;
import com.cg.groceryApp.exception.ResourceNotFound;
import com.cg.groceryApp.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product)
	{
		System.out.println("Product Added Succesfully "+product);
		product.setProductname(product.getProductname());
		product.setQuantity(product.getQuantity());
		product.setMrpPrice(product.getMrpPrice());
		product.setImage(product.getImage());
		product.setDescription(product.getDescription());
		product.setMeasurement(product.getMeasurement());
		return productRepository.save(product);
		
	}

	
	public List<Product> getAllProducts() 
	{
		
		return productRepository.findAll();
	}


	public Product getProductByProductId(long productId) 
	{
		
		return productRepository.findByproductId(productId).orElseThrow(()->new ResourceNotFound("Product","Id" , productId));
	}


	public Product updateProduct(Product product,long productId) 
	{
		Product existingProduct = productRepository.findById(productId).orElseThrow(()->new ResourceNotFound("product","productId",productId));
		existingProduct.setProductname(product.getProductname());
		existingProduct.setMrpPrice(product.getMrpPrice());
		existingProduct.setImage(product.getImage());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setMeasurement(product.getMeasurement());
		
		productRepository.save(existingProduct);
		
		return existingProduct;
	}


	public void deleteProduct(long productId) 
	{
		productRepository.findById(productId).orElseThrow(()->new ResourceNotFound("product","Id",productId));
		productRepository.deleteById(productId);	
	
		
	}


	public List<Product> findByCategory(Category category) 
	{
		
		return productRepository.findByCategory(category);
	}


	public ProductPaging findByCategory(Category category, Integer pageNo, Integer pageSize) 
	{
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pageResult = productRepository.findByCategory(category, paging);
		ProductPaging pr = new ProductPaging();
		pr.setTotalProduct(pageResult.getTotalElements());
		if(pageResult.hasContent()) {
            pr.setProduct(pageResult.getContent());
        } else {
        	 pr.setProduct(new ArrayList<Product>());
        }
		return pr;
	}


	public ProductPaging getAllProducts(Integer pageNo, Integer pageSize) 
	{
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pageResult = productRepository.findAll(paging);
		ProductPaging pr = new ProductPaging();
		pr.setTotalProduct(pageResult.getTotalElements());
		System.out.println(">>>>>"+ pageResult.getTotalPages());
		if(pageResult.hasContent()) {
            pr.setProduct(pageResult.getContent());
        } else {
        	 pr.setProduct(new ArrayList<Product>());
        }
		return pr;
	}

	

}
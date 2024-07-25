package com.ecommerce.servicess;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.dto.Login;
import com.ecommerce.entity.CartIteam;
import com.ecommerce.entity.Payment;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;



public interface UserService {
	
	public String userSave(User user) ;
	public String productSave(Product product,MultipartFile imageFile,List<String> flavors);
	public String addCart(int quant,Long userId,Long productId);
	public List<Product> getAllIteam();
	public List<CartIteam> getAllCartIteams(Long userId);
	
	public String deleteCart(Long cartId);

	public User login(Login login);
	public Product getPuductById(Long Id);
	
	public String addPaymentMethod(Long userId, Payment payment);
	public String checkout(Long userId);
	public User findbyid(Long id);
	public Payment findbypayId(Long id);
	
	
}

package com.ecommerce.servicess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.dto.ImageUtil;
import com.ecommerce.dto.Login;
import com.ecommerce.entity.CakeOption;
import com.ecommerce.entity.CartIteam;
import com.ecommerce.entity.Payment;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;

import com.ecommerce.repository.CakeRep;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.PaymentInterface;
import com.ecommerce.repository.Productrepository;
import com.ecommerce.repository.UserRep;

@Service
public class ServiceImp implements UserService {
	
	private CartRepository cartRepository;
	private Productrepository productrepository;
	private UserRep users;
	@Autowired
	private PaymentInterface paymentInterface;
	@Autowired
	private CakeRep cakeRep;
 	public ServiceImp(CartRepository cartRepository, Productrepository productrepository, UserRep user) {
		super();
		this.cartRepository = cartRepository;
		this.productrepository = productrepository;
		this.users = user;
	}

	@Override
	public String userSave(User user) {
		User save = users.save(user);
		if(save.getId()!=null) {
			return "User ifo stored";
		}
		return "user details not stored";
	}

	@Override
	public String productSave(Product product,MultipartFile imageFile,List<String> flavors) {
		  try {
	            // Set product details
	            product.setImageData(imageFile.getBytes());

	            // Create CakeFlavor entities and associate them with the product
	            List<CakeOption> cakeFlavors = new ArrayList<>();
	            for (String flavorName : flavors) {
	            	CakeOption flavor = new CakeOption();
	                flavor.setOptionName(flavorName);
	                flavor.setProduct(product); // Associate with the product
	                cakeFlavors.add(flavor);
	            }
	            product.setOptions(cakeFlavors);

	            // Save the product with flavors
	            Product savedProduct = productrepository.save(product);

	            if (savedProduct.getId() != null) {
	                return "Product saved successfully";
	            } else {
	                return "Failed to save product";
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Error: Failed to process image";
	        }
	    }
	    

	@Override
	public String addCart(int quantity, Long userId,Long productId) {
		  // Step 1: Fetch user and product entities
        Optional<User> userOptional = users.findById(userId);
        Optional<Product> productOptional = productrepository.findById(productId);

        if (userOptional.isPresent() && productOptional.isPresent()) {
            User user = userOptional.get();
            Product product = productOptional.get();

            // Step 2: Check if the product quantity is sufficient
            if (product.getQuantityAvailable() < quantity) {
                return "Insufficient quantity available for " + product.getProductName();
            }

            // Step 3: Check if the item is already in the user's cart
            Optional<CartIteam> existingCartItemOptional = cartRepository.findByUserAndProduct(user, product);

            if (existingCartItemOptional.isPresent()) {
                // Update quantity if item already exists in cart
                CartIteam existingCartItem = existingCartItemOptional.get();
                existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
                cartRepository.save(existingCartItem);
            } else {
                // Create a new cart item
                CartIteam newCartItem = new CartIteam();
                newCartItem.setUser(user);
                newCartItem.setProduct(product);
                newCartItem.setQuantity(quantity);
                cartRepository.save(newCartItem);
            }

            return "Item(s) added to cart successfully";
        } else {
            return "User or product not found";
        }
		
		
	}

	@Override
	public List<Product> getAllIteam() {
		List<Product> findAll = productrepository.findAll();
		return findAll;
	}

	@Override
	public List<CartIteam> getAllCartIteams(Long userId) {
		// TODO Auto-generated method stub
		List<CartIteam> findByUserId = cartRepository.findByUserId(userId);
		return findByUserId;
	}

	@Override
	public String deleteCart(Long cartId) {
		// TODO Auto-generated method stub
		 Optional<CartIteam> cartItemOptional = cartRepository.findById(cartId);

	        if (cartItemOptional.isPresent()) {
	            // Step 2: Delete the cart item
	            cartRepository.deleteById(cartId);
	            return "Cart item deleted successfully";
	        } else {
	            return "Cart item not found";
	        }
	}

	@Override
	public User login(Login login) {
		 User entity = new User();
		    entity.setEmailId(login.getEmail());
		    entity.setPassword(login.getPassword());
		    
		    Example<User> example = Example.of(entity);
		    List<User> findAll = users.findAll(example);
		    
		    if (findAll.isEmpty()) {
		        return null; // User not found or invalid credentials
		    } else {
		        User userMaster = findAll.get(0);
		        if (userMaster.getAccountStatus().equals("Active")) {
		            return userMaster; // Return the user object if login successful and account active
		        } else {
		            return null; // Account not activated
		        }
		    }}

	@Override
	public Product getPuductById(Long Id) {
		Product findById = productrepository.findById(Id).get();
		return findById;
	}

	@Override
	public String addPaymentMethod(Long userId, Payment payment) {
		  Optional<User> userOptional = users.findById(userId);
	        
	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            
	            // Associate payment with the user
	            payment.setUser(user);
	            user.setPayment(payment);
	            
	            // Save the user with payment details
	            paymentInterface.save(payment); // Assuming PaymentRepository is correctly injected and manages Payment entity
	            return "Payment method added successfully";
	        } else {
	            return "User not found";
	        }
	    
	    }
	

	@Override
	public String checkout(Long userId) {
		 Optional<User> userOptional = users.findById(userId);
	        
	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            
	            // Retrieve associated payment (if any)
	            Payment payment = user.getPayment();
	            
	            if (payment != null ||user.getId()!=null) {
	                // Example: Implement your checkout logic here
	                return "Checkout successful for user with ID " + userId;
	            } else {
	                return "No payment method associated. Please add a payment method first.";
	            }
	        } else {
	            return "User not found";
	        }
	}
	@Override
	public User findbyid(Long id) {
		return users.findById(id).get();
		
	}
//	@Override
//	public String productChocolate(Product product, MultipartFile imageFile, List<String> flavors) {
//		// TODO Auto-generated method stub
//		try {
//            // Set product details
//            product.setImageData(imageFile.getBytes());
//
//            // Create CakeFlavor entities and associate them with the product
//            List<Chocolate> cakeFlavors = new ArrayList<>();
//            for (String flavorName : flavors) {
//            	Chocolate flavor = new Chocolate();
//                flavor.setDryname(flavorName);
//                flavor.setProduct(product); // Associate with the product
//                cakeFlavors.add(flavor);
//            }
//            product.setChocolates(cakeFlavors);
//
//            // Save the product with flavors
//            Product savedProduct = productrepository.save(product);
//
//            if (savedProduct.getId() != null) {
//                return "Product saved successfully";
//            } else {
//                return "Failed to save product";
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "Error: Failed to process image";
//        }
//	
//		
//	}

	@Override
	public Payment findbypayId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Product> findByChock(Long Id) {
//		List<Product> findByproduct_id = cChocRep.findByproduct_id(Id);
//		return findByproduct_id;
//	}
//
//	@Override
//	public List<Product> findByCacke(String name) {
//		// TODO Auto-generated method stub
//		List<Product> findByproduct_id = productrepository.findByName(name);
//		return findByproduct_id;
//	}
}

package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.dto.Login;
import com.ecommerce.entity.AllChartDetails;
import com.ecommerce.entity.CartIteam;
import com.ecommerce.entity.Chockolate;
import com.ecommerce.entity.DiwaliGifts;
import com.ecommerce.entity.Dryfruites;
import com.ecommerce.entity.Flowers;
import com.ecommerce.entity.Gift;
import com.ecommerce.entity.Others;
import com.ecommerce.entity.Payment;
import com.ecommerce.entity.Plants;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.servicess.AddCartService;
import com.ecommerce.servicess.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private AddCartService service2;
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		String userSave = service.userSave(user);
		return new ResponseEntity<>(userSave,HttpStatus.CREATED);
		
	}
//	@PostMapping("/productSave/image")
//	public ResponseEntity<String> productSave(@RequestBody Product product,@RequestParam("image") MultipartFile file){
//		String productSave = service.productSave(product,file);
//		return new ResponseEntity<> (productSave,HttpStatus.CREATED);
//		
//	}
	  @PostMapping(value = "/productSave/image", consumes = "multipart/form-data")
	    public ResponseEntity<String> productSave(@RequestParam("productName") String productName,
	                                              @RequestParam("productDescription") String productDescription,
	                                              @RequestParam("productPrice") double productPrice,
	                                              @RequestParam("quantityAvailable") int quantityAvailable,
	                                              @RequestParam("image") MultipartFile imageFile, @RequestParam("flavors")List<String> flavors) {
	        Product product = new Product();
	        product.setProductName(productName);
	        product.setProductDescription(productDescription);
	        product.setProductPrice(productPrice);
	        product.setQuantityAvailable(quantityAvailable);

	        
	        String productSave = service.productSave(product, imageFile, flavors);
	        if (productSave.startsWith("Error")) {
	            return ResponseEntity.badRequest().body(productSave);
	        } else {
	            return ResponseEntity.ok(productSave);
	        }
	    }
	@PostMapping("/saveCart/{id}/{quantity}/{pdId}")
	public ResponseEntity<String> cartSave(@PathVariable Long id,@PathVariable  int quantity,@PathVariable Long pdId){
	
		String addCart = service.addCart(quantity, id,pdId);
		return new ResponseEntity<>(addCart,HttpStatus.CREATED);
	}
	@GetMapping("/allProduct")
	public ResponseEntity<List<Product>> getAllproduct(){
		List<Product> allIteam = service.getAllIteam();
		return new ResponseEntity<>(allIteam,HttpStatus.OK);
		
	}
	@GetMapping("/getAllCart/{id}")
	public ResponseEntity<List<CartIteam>> getAllcart(@PathVariable Long id){
		List<CartIteam> allCartIteams = service.getAllCartIteams(id);
		return new ResponseEntity<> (allCartIteams,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCart(@PathVariable Long id){
		String deleteCart = service.deleteCart(id);
		return new ResponseEntity<> (deleteCart,HttpStatus.OK);
		
	}
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody Login login){
		User loginStatus = service.login(login);
		
		return new ResponseEntity<>(loginStatus, HttpStatus.OK);
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id){
		Product puductById = service.getPuductById(id);
		return new ResponseEntity<>(puductById,HttpStatus.OK);
		
	}
//	 @PostMapping(value = "/productSavecho/image", consumes = "multipart/form-data")
//	    public ResponseEntity<String> productSaveCho(@RequestParam("productName") String productName,
//	                                              @RequestParam("productDescription") String productDescription,
//	                                              @RequestParam("productPrice") double productPrice,
//	                                              @RequestParam("quantityAvailable") int quantityAvailable,
//	                                              @RequestParam("image") MultipartFile imageFile, @RequestParam("flavors")List<String> flavors) {
//	        Product product = new Product();
//	        product.setProductName(productName);
//	        product.setProductDescription(productDescription);
//	        product.setProductPrice(productPrice);
//	        product.setQuantityAvailable(quantityAvailable);
//
//	        
//	        String productSave = service.productChocolate(product, imageFile, flavors);
//	        if (productSave.startsWith("Error")) {
//	            return ResponseEntity.badRequest().body(productSave);
//	        } else {
//	            return ResponseEntity.ok(productSave);
//	        }
//	    }
//	 @GetMapping("/getChock/{id}")
//	 public ResponseEntity<List<Product>> getAllChock(@PathVariable Long id){
//		 List<Product> findByChock = service.findByChock(id);
//		return new ResponseEntity<>(findByChock,HttpStatus.OK);
//		 
//	 }
//	 @GetMapping("/getCake/{name}")
//	 public ResponseEntity<List<Product>> getAllCacke(@PathVariable String name){
//		 List<Product> findByCake = service.findByCacke(name);
//		return new ResponseEntity<>(findByCake,HttpStatus.OK);
//		 
//	 }
	 @PostMapping(value = "/choSave/image", consumes = "multipart/form-data")
	    public ResponseEntity<String> ChoSave(@RequestParam("productName") String productName,
	                                              @RequestParam("productDescription") String productDescription,
	                                              @RequestParam("productPrice") double productPrice,
	                                              @RequestParam("quantityAvailable") int quantityAvailable,
	                                              @RequestParam("image") MultipartFile imageFile, @RequestParam("flavors")List<String> flavors) {
	        Chockolate product = new Chockolate();
	        product.setProductName(productName);
	        product.setProductDescription(productDescription);
	        product.setProductPrice(productPrice);
	        product.setQuantityAvailable(quantityAvailable);

	        
	        String productSave = service2.choSave(product, imageFile);
	        if (productSave.startsWith("Error")) {
	            return ResponseEntity.badRequest().body(productSave);
	        } else {
	            return ResponseEntity.ok(productSave);
	        }
	    }
	 @PostMapping(value = "/giftSave/image", consumes = "multipart/form-data")
	    public ResponseEntity<String> giftSave(@RequestParam("productName") String productName,
	                                              @RequestParam("productDescription") String productDescription,
	                                              @RequestParam("productPrice") double productPrice,
	                                              @RequestParam("quantityAvailable") int quantityAvailable,
	                                              @RequestParam("image") MultipartFile imageFile, @RequestParam("flavors")List<String> flavors) {
	        Gift product = new Gift();
	        product.setProductName(productName);
	        product.setProductDescription(productDescription);
	        product.setProductPrice(productPrice);
	        product.setQuantityAvailable(quantityAvailable);

	        
	        String productSave = service2.giftSave(product, imageFile);
	        if (productSave.startsWith("Error")) {
	            return ResponseEntity.badRequest().body(productSave);
	        } else {
	            return ResponseEntity.ok(productSave);
	        }
	    }
	 @GetMapping("/allcho")
		public ResponseEntity<List<Chockolate>> getAllCho(){
			List<Chockolate> allIteam = service2.getAllCho();
			return new ResponseEntity<>(allIteam,HttpStatus.OK);
}  
	 @GetMapping("/allgift")
		public ResponseEntity<List<Gift>> getAllGif(){
			List<Gift> allIteam = service2.getAllGift();
			return new ResponseEntity<>(allIteam,HttpStatus.OK);
			
}  
	 @PostMapping("/Cartsave/{id}/{quantity}/{coId}")
		public ResponseEntity<String> saveCart(@PathVariable Long id,@PathVariable  int quantity,@PathVariable Long coId){
		
			String addCart = service2.addCart(quantity, id,coId);
			return new ResponseEntity<>(addCart,HttpStatus.CREATED);
		}
	 
	 
	 @PostMapping(value = "/drySave/image", consumes = "multipart/form-data")
	    public ResponseEntity<String> DryfruSave(@RequestParam("productName") String productName,
	                                              @RequestParam("productDescription") String productDescription,
	                                              @RequestParam("productPrice") double productPrice,
	                                              @RequestParam("quantityAvailable") int quantityAvailable,
	                                              @RequestParam("image") MultipartFile imageFile, @RequestParam("flavors")List<String> flavors) {
	        Dryfruites product = new Dryfruites();
	        product.setProductName(productName);
	        product.setProductDescription(productDescription);
	        product.setProductPrice(productPrice);
	        product.setQuantityAvailable(quantityAvailable);

	        
	        String productSave = service2.DrySave(product, imageFile);
	        if (productSave.startsWith("Error")) {
	            return ResponseEntity.badRequest().body(productSave);
	        } else {
	            return ResponseEntity.ok(productSave);
	        }
	    }
	 @PostMapping(value = "/plantSave/image", consumes = "multipart/form-data")
	    public ResponseEntity<String> plantSave(@RequestParam("productName") String productName,
	                                              @RequestParam("productDescription") String productDescription,
	                                              @RequestParam("productPrice") double productPrice,
	                                              @RequestParam("quantityAvailable") int quantityAvailable,
	                                              @RequestParam("image") MultipartFile imageFile, @RequestParam("flavors")List<String> flavors) {
	        Plants product = new Plants();
	        product.setProductName(productName);
	        product.setProductDescription(productDescription);
	        product.setProductPrice(productPrice);
	        product.setQuantityAvailable(quantityAvailable);

	        
	        String productSave = service2.plantSave(product, imageFile);
	        if (productSave.startsWith("Error")) {
	            return ResponseEntity.badRequest().body(productSave);
	        } else {
	            return ResponseEntity.ok(productSave);
	        }
	    }
	 @GetMapping("/allplant")
		public ResponseEntity<List<Plants>> getAllplant(){
			List<Plants> allIteam = service2.getAllplant();
			return new ResponseEntity<>(allIteam,HttpStatus.OK);
}  
	 @GetMapping("/alldry")
		public ResponseEntity<List<Dryfruites>> getAllDry(){
			List<Dryfruites> allIteam = service2.getAllDry();
			return new ResponseEntity<>(allIteam,HttpStatus.OK);
			
} 
	 
	 @PostMapping(value = "/diwaliSave/image", consumes = "multipart/form-data")
	    public ResponseEntity<String> DiwaliSave(@RequestParam("productName") String productName,
	                                              @RequestParam("productDescription") String productDescription,
	                                              @RequestParam("productPrice") double productPrice,
	                                              @RequestParam("quantityAvailable") int quantityAvailable,
	                                              @RequestParam("image") MultipartFile imageFile, @RequestParam("flavors")List<String> flavors) {
	        DiwaliGifts product = new DiwaliGifts();
	        product.setProductName(productName);
	        product.setProductDescription(productDescription);
	        product.setProductPrice(productPrice);
	        product.setQuantityAvailable(quantityAvailable);

	        
	        String productSave = service2.DivSave(product, imageFile);
	        if (productSave.startsWith("Error")) {
	            return ResponseEntity.badRequest().body(productSave);
	        } else {
	            return ResponseEntity.ok(productSave);
	        }
	    }
	 @PostMapping(value = "/otherSave/image", consumes = "multipart/form-data")
	    public ResponseEntity<String> otherSave(@RequestParam("productName") String productName,
	                                              @RequestParam("productDescription") String productDescription,
	                                              @RequestParam("productPrice") double productPrice,
	                                              @RequestParam("quantityAvailable") int quantityAvailable,
	                                              @RequestParam("image") MultipartFile imageFile, @RequestParam("flavors")List<String> flavors) {
	        Others product = new Others();
	        product.setProductName(productName);
	        product.setProductDescription(productDescription);
	        product.setProductPrice(productPrice);
	        product.setQuantityAvailable(quantityAvailable);

	        
	        String productSave = service2.OtherSave(product, imageFile);
	        if (productSave.startsWith("Error")) {
	            return ResponseEntity.badRequest().body(productSave);
	        } else {
	            return ResponseEntity.ok(productSave);
	        }
	    }
	 @GetMapping("/alldivt")
		public ResponseEntity<List<DiwaliGifts>> getAllDiwali(){
			List<DiwaliGifts> allIteam = service2.getAllDiwali();
			return new ResponseEntity<>(allIteam,HttpStatus.OK);
}  
	 @GetMapping("/allother")
		public ResponseEntity<List<Others>> getAllOthers(){
			List<Others> allIteam = service2.getAllOthers();
			return new ResponseEntity<>(allIteam,HttpStatus.OK);
	 }
	 @PostMapping(value = "/flowerSave/image", consumes = "multipart/form-data")
	    public ResponseEntity<String> flowerSave(@RequestParam("productName") String productName,
	                                              @RequestParam("productDescription") String productDescription,
	                                              @RequestParam("productPrice") double productPrice,
	                                              @RequestParam("quantityAvailable") int quantityAvailable,
	                                              @RequestParam("image") MultipartFile imageFile, @RequestParam("flavors")List<String> flavors) {
	        Flowers product = new Flowers();
	        product.setProductName(productName);
	        product.setProductDescription(productDescription);
	        product.setProductPrice(productPrice);
	        product.setQuantityAvailable(quantityAvailable);

	        
	        String productSave = service2.flowerSave(product, imageFile);
	        if (productSave.startsWith("Error")) {
	            return ResponseEntity.badRequest().body(productSave);
	        } else {
	            return ResponseEntity.ok(productSave);
	        }
	    }
	 @GetMapping("/allflowe")
		public ResponseEntity<List<Flowers>> getAllflower(){
			List<Flowers> allIteam = service2.getAllFlowers();
			return new ResponseEntity<>(allIteam,HttpStatus.OK);
}  
	 @PostMapping("/addPaymentMethod/{userId}")

	    public ResponseEntity<String> addPaymentMethod(@PathVariable Long userId, @RequestBody Payment payment) {
	        String userOptional = service.addPaymentMethod(userId, payment);

			return new ResponseEntity<>(userOptional,HttpStatus.OK);
	            
	        }
	  

	    @GetMapping("/checkout/{userId}")
	    
	    public ResponseEntity<String> checkout(@PathVariable Long userId) {
	    	String checkout = service.checkout(userId);
	    	return new ResponseEntity<>(checkout,HttpStatus.OK);
	        
	    }
	 
	    
 @GetMapping("/userbyid/{userId}")
	    
	    public ResponseEntity<User> userById(@PathVariable Long userId) {
	    	User findbyid = service.findbyid(userId);
	            return new ResponseEntity<>(findbyid,HttpStatus.OK);
	            
	        
	            
	    }
 
 @GetMapping("/gift/{id}")
	public ResponseEntity<Gift> getByFloId(@PathVariable Long id){
	 Gift puductById = service2.findByGiftid(id);
		return new ResponseEntity<>(puductById,HttpStatus.OK);
		
	}
 @GetMapping("/cho/{id}")
	public ResponseEntity<Chockolate> getByChoId(@PathVariable Long id){
	 Chockolate puductById = service2.findBychooid(id);
		return new ResponseEntity<>(puductById,HttpStatus.OK);
		
	}
 @GetMapping("/dry/{id}")
	public ResponseEntity<Dryfruites> getByDrId(@PathVariable Long id){
	 Dryfruites puductById = service2.findByDryid(id);
		return new ResponseEntity<>(puductById,HttpStatus.OK);
		
	}
 @GetMapping("/plant/{id}")
	public ResponseEntity<Plants> getByPlantId(@PathVariable Long id){
	 Plants puductById = service2.findPlantid(id);
		return new ResponseEntity<>(puductById,HttpStatus.OK);
		
	}
 @GetMapping("/other/{id}")
	public ResponseEntity<Others> getByOthersId(@PathVariable Long id){
	 Others puductById = service2.findByotherid(id);
		return new ResponseEntity<>(puductById,HttpStatus.OK);
		
	}
 @GetMapping("/flow/{id}")
	public ResponseEntity<Flowers> getByOthId(@PathVariable Long id){
	 Flowers puductById = service2.findByFlowersid(id);
		return new ResponseEntity<>(puductById,HttpStatus.OK);
		
	}
 @GetMapping("/div/{id}")
	public ResponseEntity<DiwaliGifts> getByDiv(@PathVariable Long id){
	 DiwaliGifts puductById = service2.findDiwaliGifts(id);
		return new ResponseEntity<>(puductById,HttpStatus.OK);
		
	}
 @PostMapping("/AllsaveCart/{id}/{quantity}/{pdId}")
	public ResponseEntity<String> cartSaveAll(@PathVariable Long id,@PathVariable  int quantity,@PathVariable Long pdId){
	
		String addCart = service2.addCart(quantity, id,pdId);
		return new ResponseEntity<>(addCart,HttpStatus.CREATED);
	}
 
 @GetMapping("/allchart/{id}")
	public ResponseEntity<List<AllChartDetails>> getAlld(@PathVariable Long id){
	 List<AllChartDetails> puductById = service2.getAllCartsA(id);
		return new ResponseEntity<>(puductById,HttpStatus.OK);}
}
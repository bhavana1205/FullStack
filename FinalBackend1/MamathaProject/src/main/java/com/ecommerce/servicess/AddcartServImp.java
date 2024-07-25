package com.ecommerce.servicess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entity.AllChartDetails;
import com.ecommerce.entity.CakeOption;
import com.ecommerce.entity.CartIteam;
import com.ecommerce.entity.Chockolate;
import com.ecommerce.entity.DiwaliGifts;
import com.ecommerce.entity.Dryfruites;
import com.ecommerce.entity.Flowers;
import com.ecommerce.entity.Gift;
import com.ecommerce.entity.Others;
import com.ecommerce.entity.Plants;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.repository.AllCartRep;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ChockRpo;
import com.ecommerce.repository.DiwaliRep;
import com.ecommerce.repository.DryfruitRep;
import com.ecommerce.repository.FlowersRep;
import com.ecommerce.repository.GiftRepo;
import com.ecommerce.repository.OthersRep;
import com.ecommerce.repository.PlantsRep;
import com.ecommerce.repository.Productrepository;
import com.ecommerce.repository.UserRep;
@Service
public class AddcartServImp implements AddCartService {
	@Autowired
	private GiftRepo giftRepo;
	@Autowired
	private ChockRpo chockolate;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private Productrepository productrepository;
	@Autowired
	private UserRep users;
	@Autowired
	private AllCartRep allCartRep;
	@Autowired
	private DryfruitRep dryfruitRep;
	@Autowired
	private PlantsRep plants;
	@Autowired
	private DiwaliRep diwaliGifts;
	@Autowired
	private OthersRep othersRep;
	
	@Autowired
	private FlowersRep flowersRep;
	@Override
	public String choSave(Chockolate product, MultipartFile imageFile) {
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Chockolate savedProduct = chockolate.save(product);

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
	public String giftSave(Gift product, MultipartFile imageFile) {
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Gift savedProduct = giftRepo.save(product);

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
	public String addCart(int quant, Long userId, Long choId) {
		return null;
//		 Optional<User> userOptional = users.findById(userId);
//	       
//	        Optional<Chockolate> choOptional = chockolate.findById(choId);
//	  
//	        
//	        if (userOptional.isPresent() &&choOptional.isPresent()) {
//	            User user = userOptional.get();
//	           Gift g= new Gift();
//	            Chockolate chockolate2 = choOptional.get();
//	          
//
//	            // Step 2: Check if the product quantity is sufficient
//	            if (chockolate2.getQuantityAvailable() < quant) {
//	                return "Insufficient quantity available for " + chockolate2.getProductName();
//	            }
//
//	            // Step 3: Check if the item is already in the user's cart
//	           
//	            Optional<CartIteam> findByChockolateAndGift = cartRepository.findByUserAndChockolate(user, chockolate2);
//
//	            if (findByChockolateAndGift.isPresent()) {
//	                // Update quantity if item already exists in cart
//	               
//	             
//	                CartIteam cartIteam = findByChockolateAndGift.get();
//	                cartIteam.setQuantity(cartIteam.getQuantity());
//	            } else {
//	                // Create a new cart item
//	                CartIteam newCartItem = new CartIteam();
//	                newCartItem.setUser(user);
//	                newCartItem.setQuantity(quant);
//	               
//	                cartRepository.save(newCartItem);
//	            }
//
//	            return "Item(s) added to cart successfully";
//	        } else {
//	            return "User or product not found";
//	        }
	}

	@Override
	public List<Chockolate> getAllCho() {
		List<Chockolate> findAll = chockolate.findAll();
		return findAll;
	}

	@Override
	public List<Gift> getAllGift() {
		// TODO Auto-generated method stub
		List<Gift> findAll = giftRepo.findAll();
		return findAll;
	}

	@Override
	public String DrySave(Dryfruites product, MultipartFile imageFile) {
		// TODO Auto-generated method stub
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Dryfruites savedProduct = dryfruitRep.save(product);

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
	public String plantSave(Plants product, MultipartFile imageFile) {
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Plants savedProduct = plants.save(product);

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
	public List<Plants> getAllplant() {
		List<Plants> findAll = plants.findAll();
		return findAll;
	}

	@Override
	public List<Dryfruites> getAllDry() {
		// TODO Auto-generated method stub
		List<Dryfruites> findAll = dryfruitRep.findAll();
		return findAll;
	}

	@Override
	public String DivSave(DiwaliGifts product, MultipartFile imageFile) {
		// TODO Auto-generated method stub
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            DiwaliGifts savedProduct = diwaliGifts.save(product);

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
	public String OtherSave(Others product, MultipartFile imageFile) {
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Others savedProduct = othersRep.save(product);

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
	public List<DiwaliGifts> getAllDiwali() {
		
		return diwaliGifts.findAll();
	}

	@Override
	public List<Others> getAllOthers() {
		// TODO Auto-generated method stub
		return othersRep.findAll();
	}

	@Override
	public String flowerSave(Flowers product, MultipartFile imageFile) {
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Flowers savedProduct = flowersRep.save(product);

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
	public List<Flowers> getAllFlowers() {
		// TODO Auto-generated method stub
		return flowersRep.findAll();
	}

	@Override
	public Chockolate findBychooid(Long id) {
		// TODO Auto-generated method stub
		return chockolate.findById(id).get();
	}

	@Override
	public Others findByotherid(Long id) {
		// TODO Auto-generated method stub
		return othersRep.findById(id).get();
	}

	@Override
	public Dryfruites findByDryid(Long id) {
		// TODO Auto-generated method stub
		return dryfruitRep.findById(id).get();
	}

	@Override
	public Gift findByGiftid(Long id) {
		// TODO Auto-generated method stub
		return giftRepo.findById(id).get();
	}

	@Override
	public Plants findPlantid(Long id) {
		// TODO Auto-generated method stub
		return plants.findById(id).get();
	}

	@Override
	public Flowers findByFlowersid(Long id) {
		// TODO Auto-generated method stub
		return flowersRep.findById(id).get();
	}
	@Override
	public String allproductToCart(int quantity,Long userId,Long productId){
		 Optional<User> userOptional = users.findById(userId);
	        Optional<Chockolate> productOptional = chockolate.findById(productId);
Optional<Gift> findById = giftRepo.findById(productId);
Optional<Plants> findById2 = plants.findById(productId);
Optional<Others> findById3 = othersRep.findById(productId);
Optional<Dryfruites> findById4 = dryfruitRep.findById(productId);

	        if (userOptional.isPresent() || productOptional.isPresent()||findById.isPresent()||findById2.isPresent()||findById3.isPresent()||findById4.isPresent()) {
	            User user = userOptional.get();
	            Chockolate product = productOptional.get();
	            Gift gift = findById.get();
	            Plants plants2 = findById2.get();
	            Others others = findById3.get();
	            Dryfruites dryfruites = findById4.get();
	            // Step 2: Check if the product quantity is sufficient
	            if (product.getQuantityAvailable() < quantity||gift.getQuantityAvailable()<quantity||others.getQuantityAvailable()<quantity||plants2.getQuantityAvailable()<quantity||dryfruites.getQuantityAvailable()<quantity) {
	                return "Insufficient quantity available for " + product.getProductName();
	            }

	            // Step 3: Check if the item is already in the user's cart
	            Optional<AllChartDetails> existingCartItemOptional = allCartRep.findByUserAndChockolate(user, product);
	            Optional<AllChartDetails> findByUserAndGift = allCartRep.findByUserAndGift(user, gift);
	            Optional<AllChartDetails> dryfruites2 = allCartRep.findByUserAndDryfruites(user, dryfruites);
	            Optional<AllChartDetails> otherss = allCartRep.findByUserAndChockolate(user, others);
	           Optional<AllChartDetails> findByUserAndPlants = allCartRep.findByUserAndPlants(user, plants2);
	            
	            
	            
	            if (existingCartItemOptional.isPresent()||findByUserAndGift.isPresent()||findByUserAndPlants.isPresent()||dryfruites2.isPresent()||otherss.isPresent()) {
	                // Update quantity if item already exists in cart
	            	AllChartDetails existingCartItem = existingCartItemOptional.get();
	                existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
	                
	                allCartRep.save(existingCartItem);
	                AllChartDetails allChartDetails = findByUserAndGift.get();
	                allChartDetails.setQuantity(allChartDetails.getQuantity()+quantity);
	                allCartRep.save(allChartDetails);
	                AllChartDetails allChartDetails2 = dryfruites2.get();
	                allChartDetails.setQuantity(allChartDetails2.getQuantity()+quantity);
	                allCartRep.save(allChartDetails2);
	                AllChartDetails allChartDetails4 = otherss.get();
	                
	                allChartDetails.setQuantity(allChartDetails4.getQuantity()+quantity);
	                allCartRep.save(allChartDetails4);
	                AllChartDetails allChartDetails3 = findByUserAndPlants.get();
	                allChartDetails.setQuantity(allChartDetails3.getQuantity()+quantity);
	                allCartRep.save(allChartDetails3);
	            } else {
	                // Create a new cart item
	                AllChartDetails newCartItem = new AllChartDetails();
	                newCartItem.setUser(user);
	                newCartItem.setChockolate(product);
	                newCartItem.setGift(gift);
	              
	                newCartItem.setDryfruites(dryfruites);
	                newCartItem.setOthers(others);
	                newCartItem.setPlants(plants2);
	                newCartItem.setQuantity(quantity);
	                allCartRep.save(newCartItem);
	                
	            }

	            return "Item(s) added to cart successfully";
	        } else {
	            return "User or product not found";
	        }}

	@Override
	public List<AllChartDetails> getAllCartsA(Long id) {
		
		return allCartRep.findByUserId(id);
	}

	@Override
	public DiwaliGifts findDiwaliGifts(Long id) {
		// TODO Auto-generated method stub
		return diwaliGifts.findById(id).get();
	}
	}


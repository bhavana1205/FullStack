package com.ecommerce.servicess;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entity.AllChartDetails;
import com.ecommerce.entity.Chockolate;
import com.ecommerce.entity.DiwaliGifts;
import com.ecommerce.entity.Dryfruites;
import com.ecommerce.entity.Flowers;
import com.ecommerce.entity.Gift;
import com.ecommerce.entity.Others;
import com.ecommerce.entity.Plants;


public interface AddCartService {
	
	public String choSave(Chockolate product,MultipartFile imageFile);
	public String giftSave(Gift product,MultipartFile imageFile);
	
	public List<Chockolate> getAllCho();
	public List<Gift> getAllGift();
	public String addCart(int quant,Long userId,Long choId);
	
	
	public String DrySave(Dryfruites product,MultipartFile imageFile);
	public String plantSave(Plants product,MultipartFile imageFile);
	
	public List<Plants> getAllplant();
	public List<Dryfruites> getAllDry();
	
	public String DivSave(DiwaliGifts product,MultipartFile imageFile);
	public String OtherSave(Others product,MultipartFile imageFile);
	
	public List<DiwaliGifts> getAllDiwali();
	public List<Others> getAllOthers();
public String flowerSave(Flowers product,MultipartFile imageFile);
	
	public List<Flowers> getAllFlowers();
	
	public Chockolate findBychooid(Long id);
	public Others findByotherid(Long id);
	public Dryfruites findByDryid(Long id);
	public Gift findByGiftid(Long id);
	public Plants findPlantid(Long id);
	public Flowers findByFlowersid(Long id);
public DiwaliGifts findDiwaliGifts(Long id);
	public String allproductToCart(int quant,Long userId,Long productId);
	public List<AllChartDetails> getAllCartsA(Long id);
}

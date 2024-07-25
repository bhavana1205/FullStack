package com.ecommerce.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.entity.CartIteam;
import com.ecommerce.entity.Product;

public interface Productrepository  extends JpaRepository<Product, Long>{
//	List<Product> findByOptionName(String optionName);
//	   

}

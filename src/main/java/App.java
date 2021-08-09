import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ecw.model.Address;
import com.ecw.model.Category;
import com.ecw.model.OrderDetail;
import com.ecw.model.Product;
import com.ecw.model.User;
import com.ecw.model.UserTyppe;
import com.ecw.services.AddressService;
import com.ecw.services.CategoryService;
import com.ecw.services.OrderDetailsService;
import com.ecw.services.ProductService;
import com.ecw.services.UserService;
import com.ecw.services.UserTypeService;
import com.ecw.services.impl.AddressServiceImpl;
import com.ecw.services.impl.CategoryServiceImp;
import com.ecw.services.impl.OrderDetailServiceImpl;
import com.ecw.services.impl.ProductServiceImpl;
import com.ecw.services.impl.UserServiceImpl;
import com.ecw.services.impl.UserTypeServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		OrderDetailsService orderService = new OrderDetailServiceImpl();
//		OrderDetail order = orderService.getOrderDetailById(19);
//		System.out.println(order);

		
		//Create order		
		
//		OrderDetail order = new OrderDetail();
//		AddressService addressService = new AddressServiceImpl();
//	    order.setAdress(addressService.getAddressById(4));
//		
//		 ProductService productservice = new ProductServiceImpl();
//
//		order.setQuantity(10);
//		UserService userService = new UserServiceImpl();
//		order.setUser(userService.getUserById(7));
//		
//		OrderDetailsService orderDetailService = new OrderDetailServiceImpl();
//		
//		order.setAmount(orderDetailService.getAmmount(productservice.getProductById(10) , order.getQuantity()));
//		
//		order.setProduct(productservice.getProductById(10));
//
//		orderDetailService.createOrderDetail(order);
		
		//Login
		
//		UserService userService = new UserServiceImpl();
//		userService.getUserByEmailAndPassword("ks@gmail.com", "123");

//		creating Address

		
//		  Address address = new Address(); address.setArea("thaltej");
//		  address.setCity("Ahemdabad-1"); address.setName("Sonia Singh");
//		  address.setPhoneNumber("7004747698"); address.setPincode(380006);
//		  address.setState("Gujrat");
//		  
//		  AddressService addressService = new AddressServiceImpl();
//		  addressService.createAddress(address);
//		 
//
//		// Creating User type..
//		
//		  UserTyppe userType = new UserTyppe();
//		  
//		  userType.setUserType("customer");
//		  
//		  UserTypeService userTypeService = new UserTypeServiceImpl();
//		  userTypeService.createUserType(userType);
		 

//		creating User 

//		AddressService addressService = new AddressServiceImpl();
		
//		System.out.println(address);
//		
	
//	UserTyppe userType = userTypeService.getUserTypeById(1);
//		System.out.println(userType);

//	    UserTyppe userType = new UserTyppe();
//		  
//		  userType.setUserType("admin");
//
//		User user = new User();
//		user.getAddress().add(addressService.getAddressById(2));
//		user.setUserEmail("aks@gmail.com");
//		user.setUserName("Sonia Singh");
//		user.setUserPassword("1234");
//		user.setUserPhone("7004747697");
//		UserTypeService userTypeService = new UserTypeServiceImpl();
//		user.setUserType(userTypeService.getUserTypeById(5));
//
//		UserService userService = new UserServiceImpl();
//		userService.createUser(user);

//		  creating product

//		  CategoryService categoryService = new CategoryServiceImp();
//		  
//		  Product product = new Product(); 
//		  product.setProductName("DELL Inspiron 3505 Ryzen ");
//		  product.setDescription("DELL Inspiron 3505 Ryzen 3 Dual Core 3250U - (8 GB/256 GB SSD/Windows 10 Home) Inspiron 3505 Laptop  (15.6 inch, Black, 1.83 kg, With MS Office)");
//		  product.setPrice(35090);
//		  product.setQuantity(100);
//		  product.setProductCategory(categoryService.getCategoryById(9));
//		  
//		  ProductService productservice = new ProductServiceImpl();
//		  productservice.createProduct(product);

//		  deleting a product

//		
//		  ProductService productservice = new ProductServiceImpl();
//		  productservice.deleteProduct(10);

//		  deleting all product

//		
//		  ProductService productservice = new ProductServiceImpl();
//		  productservice.deleteAllRecords();

//		  getting detail of a product
		
//		ProductService productservice = new ProductServiceImpl();
//		Product product = productservice.getProductById(10);
//		System.out.println(product);
//		Category category = product.getProductCategory();
//		System.out.println(category);

//		  getting detail of all products

		/*
		 * ProductService productservice = new ProductServiceImpl(); List<Product> list
		 * = productservice.getProductsDetail(); Iterator<Product> itr =
		 * list.iterator(); while (itr.hasNext()) { Product product = itr.next();
		 * System.out.println(product); Category category =
		 * product.getProductCategory(); System.out.println(category); }
		 */
		
		
//		creating category
		
//		Category category = new Category();
//		category.setName("Laptops");
//		category.setDescription("Contains Laptops");
//		
//		CategoryService categoryService = new CategoryServiceImp();
//		categoryService.createCategory(category);
	}
}
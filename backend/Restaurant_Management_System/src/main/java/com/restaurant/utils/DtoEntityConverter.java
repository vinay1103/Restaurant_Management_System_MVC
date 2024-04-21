package com.restaurant.utils;

import org.springframework.stereotype.Component;

import com.restaurant.dtos.BillDTO;
import com.restaurant.dtos.BillDTOSend;
import com.restaurant.dtos.CategoryDTO;
import com.restaurant.dtos.OrderItemDTO;
import com.restaurant.dtos.OrdersDTO;
import com.restaurant.dtos.ProductDTO;
import com.restaurant.dtos.ProductDTOSend;
import com.restaurant.dtos.TablesDTO;
import com.restaurant.dtos.UserDTO;
import com.restaurant.dtos.UserDTOSend;
import com.restaurant.entities.Bill;
import com.restaurant.entities.Category;
import com.restaurant.entities.OrderItem;
import com.restaurant.entities.Orders;
import com.restaurant.entities.Product;
import com.restaurant.entities.Tables;
import com.restaurant.entities.Users;
@Component
public class DtoEntityConverter {

	public  CategoryDTO toCategoryDTO (Category category)
	{
		if(category==null)
			return null;
		return new CategoryDTO(category.getCategoryId(), category.getCategoryName(), category.getCategoryStatus());
	}
	
	public  Category toCategoryEntity (CategoryDTO categoryDto)
	{
		if(categoryDto==null)
			return null;
		return new Category(categoryDto.getCategoryId(), categoryDto.getCategoryName(), categoryDto.getCategoryStatus());
	}
	
	
	public Product toProductEntity(ProductDTO productDTO)
	{
		if(productDTO==null)
			return null;
		Product product = new Product();
		product.setProductId(productDTO.getProductId());
		product.setProductName(productDTO.getProductName());
		product.setProductPrice(productDTO.getProductPrice());
		product.setProductStatus(productDTO.getProductStatus());
		product.setCategory(new Category(productDTO.getProductcategoryId()));
		
	
		
		return product;
	}
	
	public ProductDTOSend toProductDTO(Product product) {
		if(product == null)
			return null;
		ProductDTOSend productDTOSend = new ProductDTOSend();
		productDTOSend.setProductId(product.getProductId());
		productDTOSend.setProductName(product.getProductName());
		productDTOSend.setProductPrice(product.getProductPrice());
		productDTOSend.setProductStatus(product.getProductStatus());
		productDTOSend.setProductcategoryId(product.getCategory().getCategoryId());
		productDTOSend.setProductcategoryName(product.getCategory().getCategoryName());
		return productDTOSend;
	}
	
	
	public TablesDTO toTablesDTO(Tables tables) {
		if(tables==null)
			return null;
		TablesDTO tablesDTO = new TablesDTO();
		tablesDTO.setTableId(tables.getTableId());
		tablesDTO.setTableName(tables.getTableName());
		tablesDTO.setTableStatus(tables.getTableStatus());
		tablesDTO.setTableCapacity(tables.getTableCapacity());
		if(tables.getWaiter()!=null)
		tablesDTO.setWaiterId(tables.getWaiter().getUserId());
		if(tables.getWaiter()!=null)
			tablesDTO.setWaiterName(tables.getWaiter().getName());
		
		return tablesDTO;
		
	}
	
	public Tables toTablesEntity(TablesDTO tablesDTO) {
		if(tablesDTO==null)
			return null;
		Tables tables = new Tables();
		tables.setTableId(tablesDTO.getTableId());
		tables.setTableName(tablesDTO.getTableName());
		tables.setTableStatus(tablesDTO.getTableStatus());
		tables.setTableCapacity(tablesDTO.getTableCapacity());
		if(tablesDTO.getWaiterId()!=0)
		tables.setWaiter(new Users(tablesDTO.getWaiterId()));
		
		return tables;
		
	}
	
	public Users toUserEntity(UserDTO userDTO)
	{
		if(userDTO==null)
			return null;
		Users users = new Users();
		users.setUserId(userDTO.getUserId());
		users.setName(userDTO.getName());
		users.setEmail(userDTO.getEmail());
		users.setPhone(userDTO.getPhone());
		users.setPassword(userDTO.getPassword());
		users.setRole(userDTO.getRole());
		users.setCurrentStatus(userDTO.getCurrentStatus());
		
//		if(userDTO.getProfileImage()!=null)
//		{
//			
//			users.setProfileImage(userDTO.getProfileImage().getOriginalFilename());
//		
//		}
		
		return users;
		
		
	}
	
	
	
	public UserDTOSend toUserDTO(Users user)
	{
		if(user==null)
			return null;
		UserDTOSend userDTO = new UserDTOSend();
		userDTO.setUserId(user.getUserId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPhone(user.getPhone());
		userDTO.setRole(user.getRole());
		userDTO.setCurrentStatus(user.getCurrentStatus());
//		userDTO.setProfileImage(user.getProfileImage());
		userDTO.setCreatedDate(user.getDate());
	
		
		return userDTO;
		
		
	}
	
	public OrdersDTO toOrderDTO(Orders orders)
	{
		if(orders==null)
			return new OrdersDTO(0);
		
		OrdersDTO ordersDTO = new OrdersDTO();
		
		ordersDTO.setOrderId(orders.getOrderId());
		ordersDTO.setOrderStatus(orders.getOrderStatus());
		ordersDTO.setOrderServicePersonId(orders.getOrderServicePerson().getUserId());
		ordersDTO.setOrderTableId(orders.getOrderTable().getTableId());
		ordersDTO.setOrderTableName(orders.getOrderTable().getTableName());
		return ordersDTO;
		
	}
	
	
	public Orders toOrderEntity(OrdersDTO ordersDTO)
	{
		if(ordersDTO==null)
			return null;
		
		Orders orders = new Orders();
		
		
		orders.setOrderId(ordersDTO.getOrderId());
		orders.setOrderStatus(ordersDTO.getOrderStatus());
		orders.setOrderServicePerson(new Users(ordersDTO.getOrderServicePersonId()));
		orders.setOrderTable(new Tables(ordersDTO.getOrderTableId()));
		
		
		return orders;
		
	}
	
	public OrderItem toOrderItemEntity(OrderItemDTO orderItemDTO)
	{
		if(orderItemDTO==null)
			return null;
		
		OrderItem orderItem = new OrderItem();
		
		orderItem.setOrderItemQuantity(orderItemDTO.getOrderItemQuantity());
		orderItem.setOrderItemOrder(new Orders(orderItemDTO.getOrderItemOrderId()));
		orderItem.setOrderItemProduct(new Product(orderItemDTO.getOrderItemProductId()));
		
		
		return orderItem;
		
	}
	
	public OrderItemDTO toOrderItemDTO(OrderItem orderItem)
	{
		if(orderItem==null)
			return null;
		
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		
		orderItemDTO.setOrderItemQuantity(orderItem.getOrderItemQuantity());
		orderItemDTO.setOrderItemId(orderItem.getOrderItemId());
		orderItemDTO.setOrderItemAmount(orderItem.getOrderItemAmount());
		orderItemDTO.setOrderItemOrderId(orderItem.getOrderItemOrder().getOrderId());
		orderItemDTO.setOrderItemProductId(orderItem.getOrderItemProduct().getProductId());
		orderItemDTO.setOrderItemRate(orderItem.getOrderItemProduct().getProductPrice());
		orderItemDTO.setOrderItemName(orderItem.getOrderItemProduct().getProductName());
		return orderItemDTO;
		
	}
	
	public Bill toBillEntity(BillDTO billDTO) {
		if(billDTO==null)
			return null;
		
		Bill bill = new  Bill();
		bill.setTaxAndCharge(billDTO.getTaxAndCharge());
		bill.setDiscount(billDTO.getDiscount());
		bill.setBillAmount(billDTO.getBillAmount());
		bill.setBillTotal(billDTO.getBillTotal());
		bill.setBillDate(billDTO.getBillDate());
		bill.setBillPaymentMethod(billDTO.getBillPaymentMethod());
		bill.setBillStatus(billDTO.getBillStatus());
		if(billDTO.getBillCashierId()!=0)
		bill.setBillCashier(new Users(billDTO.getBillCashierId()));
		if(billDTO.getBillOrderId()!=0)
		bill.setBillOrder(new Orders(billDTO.getBillOrderId()));
		return bill;
	}
	
	public BillDTOSend toBillDTO(Bill bill) {
		if(bill==null)
			return null;
		
		BillDTOSend billDTO = new  BillDTOSend();
		billDTO.setTaxAndCharge(bill.getTaxAndCharge());
		billDTO.setDiscount(bill.getDiscount());
		billDTO.setBillAmount(bill.getBillAmount());
		billDTO.setBillTotal(bill.getBillTotal());
		billDTO.setBillDate(bill.getBillDate());
		billDTO.setBillPaymentMethod(bill.getBillPaymentMethod());
		billDTO.setBillStatus(bill.getBillStatus());
		billDTO.setBillId(bill.getBillId());
		billDTO.setBillOrderId(bill.getBillOrder().getOrderId());
		if(bill.getBillCashier()!=null)
		billDTO.setBillCashierName(bill.getBillCashier().getName());
		billDTO.setWaiterName(bill.getBillOrder().getOrderServicePerson().getName());
		billDTO.setTableName(bill.getBillOrder().getOrderTable().getTableName());
		billDTO.setTableId(bill.getBillOrder().getOrderTable().getTableId());
		return billDTO;
	}

}

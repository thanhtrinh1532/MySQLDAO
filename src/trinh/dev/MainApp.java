package trinh.dev;
import java.util.List;

import trinh.dev.data.dao.CategoryDao;
import trinh.dev.data.dao.Database;
import trinh.dev.data.dao.DatabaseDao;
import trinh.dev.data.dao.OrderDao;
import trinh.dev.data.dao.OrderItemDao;
import trinh.dev.data.dao.ProductDao;
import trinh.dev.data.dao.UserDao;
import trinh.dev.data.model.Category;
import trinh.dev.data.model.Order;
import trinh.dev.data.model.OrderItem;
import trinh.dev.data.model.Product;
import trinh.dev.data.model.User;
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseDao.init(new Database());

        // Get the UserDao instance via DatabaseDao
		CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        OrderItemDao orderItemDao = DatabaseDao.getInstance().getOrderItemDao();
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
//		
		List<Category> allCats = categoryDao.findAll();
		for (Category category : allCats) {
            System.out.println("Id: "+category.getId()+"; Ten: "+ category.getName()+"; Mo ta: "+ category.getDescription());
        }
//		
		List<User> allUsers = userDao.findAll();
        for (User user : allUsers) {
            System.out.println("Id: "+user.getId()+"; Email: "+ user.getEmail()+"; Mat khau: "+ user.getPassword()+"; Quyen: "+ user.getRole());
        }
//        
        List<Order> allOrders = orderDao.findAll();
        for (Order order : allOrders) {
            System.out.println("Id: "+order.getId()+"; User: "+ order.getUserId()+"; Code: "+ order.getCode()+"; Ngay tao: "+ order.getCreatedAt()+"; Tinh trang: "+ order.getStatus());
        }
        
        //find all order items
        List<OrderItem> allOrderItems = orderItemDao.findAll();
        for (OrderItem orderItem : allOrderItems) {
            System.out.println("Id: "+orderItem.getId()+"; ID Order: "+ orderItem.getOrderId()+"; ID san pham: "+ orderItem.getProductId()+"; So luong: "+ orderItem.getQuantity()+"; Don gia: "+ orderItem.getPrice());
        }
     
        // Find all products
        List<Product> allProducts = productDao.findAll();
        for (Product product : allProducts) {
            System.out.println("Id: " + product.getId() + "; Ten sp: " + product.getName() + "; Gia ban: " + product.getPrice());
        }
	}
	
}

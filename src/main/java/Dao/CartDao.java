package Dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Context.DBContext;
import Dao.DAO;
import Models.Account;
import Models.Cart;
import Models.Category;
import Models.Invoice;
import Models.Product;
import Models.Review;
import Models.SoLuongDaBan;
import Models.Supplier;
import Models.TongChiTieuBanHang;
import Repository.ServletRepository;
import Interface.*;

public class CartDao implements IDataRepository<Cart> {
	private static CartDao instance = null;

	private CartDao() {}
	
	public static CartDao getInstance() {
		if (instance == null) {
			instance = new CartDao();
		}
		return instance;
	}

	@Override
	public void insertData(Cart modelInsert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(Cart modelUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Cart modelDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Cart> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getData(Cart model) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Cart> getCartByAccountID(int accountID) {
    	var rs = DBContext.Query("select * from Cart where accountID = '"+ accountID +"'");
    	ArrayList<Cart> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
	
	public Cart checkCartExist(int accountID,int productID) {
    	var rs = DBContext.Query("select * from Cart\r\n"
           		+ "where [accountID] = '"+ accountID +"' and [productID] = '"+ productID +"'");
       try {
           while (rs.next()) {
               return new Cart(rs.getInt(1),
                       rs.getInt(2),
                       rs.getInt(3),
                       rs.getInt(4),
                       rs.getString(5));
           }
       } catch (Exception e) {
       }
      return null;
   }
	
	
	public void deleteCartByAccountID(int accountID) {
	       DBContext.Delete("delete from Cart \r\n"
	        		+ "where [accountID]='"+ accountID +"'");
	        
	    }
	    
	public void deleteCartByProductID(String productID) {
	        DBContext.Delete("delete from Cart where [productID]='"+ productID +"'");
	        
	    }
	    
	public void deleteCart(int productID) {
	        DBContext.Delete("delete from Cart where productID = '"+ productID +"'");
	        
	    }
	public void insertCart(int accountID, int productID, int amount, String size) {
        DBContext.Create("insert Cart(accountID, productID, amount,size)\r\n"
        		+ "values('"+ accountID +"','"+ productID +"','"+ amount +"','"+ size +"')");
        
    }
	
	public void editAmountAndSizeCart(int accountID, int productID, int amount, String size) {
        DBContext.Edit("update Cart set [amount]='"+ amount +"',\r\n"
        		+ "[size]='"+ size +"'\r\n"
        		+ "where [accountID]='"+ accountID +"' and [productID]='"+productID+"'");
        
    }
    
    public void editAmountCart(int accountID, int productID, int amount) {
        DBContext.Edit("update Cart set [amount]='"+ amount +"'\r\n"
        		+ "where [accountID]='"+ accountID +"' and [productID]='"+ productID +"'");
        
    }
}

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


public class ReviewDao implements IDataRepository<Review> {
	private static ReviewDao instance = null;

	private ReviewDao() {}
	
	public static ReviewDao getInstance() {
		if (instance == null) {
			instance = new ReviewDao();
		}
		return instance;
	}

	@Override
	public void insertData(Review modelInsert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(Review modelUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Review modelDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Review> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review getData(Review model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int countAllReview() {
        var rs = DBContext.Query("select count(*) from Review");
        try {
            while (rs.next()) {
               return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
	
	
	public ArrayList<Review> getAllReviewByProductID(String productId) {
    	var rs = DBContext.Query("select * from Review"
    			+ "        		+ \"where [productID] ='"+ productId +"'");
        ArrayList<Review> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Review(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4)
                       ));
            }
        } catch (Exception e) {
        }
        return list;
    }
	
	public Review getNewReview(int accountID, int productID) {
    	var rs = DBContext.Query("select top 1 * from Review\r\n"
        		+ "where accountID = '"+ accountID +"' and productID = '"+ productID +"'\r\n"
        		+ "order by maReview desc");
        try {
            while (rs.next()) {
                return new Review(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
	
	public void deleteReviewByProductID(String productID) {
        DBContext.Delete("delete from Review where [productID] = '"+ productID +"'");
        
    }
    
    public void deleteReviewByAccountID(String id) {
    	DBContext.Delete("delete from Review where [accountID] = '"+ id +"'");
        
    }
    
    
    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
  
    public void insertReview(int accountID, int productID, String contentReview) {
        DBContext.Create("insert Review(accountID, productID, contentReview, dateReview)\r\n"
        		+ "values('"+ accountID +"','"+ productID +"','"+ contentReview +"','"+ getCurrentDate() +"')");

        
    }
	
}

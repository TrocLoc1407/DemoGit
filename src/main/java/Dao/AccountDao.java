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


public class AccountDao implements IDataRepository<Account> {
	private static AccountDao instance = null;

	private AccountDao() {}
	
	public static AccountDao getInstance() {
		if (instance == null) {
			instance = new AccountDao();
		}
		return instance;
	}

	@Override
	public void insertData(Account modelInsert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(Account modelUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Account modelDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Account> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getData(Account model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ArrayList<Account> getAllAccount() {
    	var rs = DBContext.Query("select * from Account");
        ArrayList<Account> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                		rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
	
	public int checkAccountAdmin(int userID) {
    	var rs = DBContext.Query("select isAdmin from Account where [uID]='"+ userID +"'");
        try { 
            while (rs.next()) {
            	 return rs.getInt(1);
             }
        } catch (Exception e) {
        	
        }
        return 0;
    }
	
	
	public Account login(String user, String pass) {
    	var rs = DBContext.Query("select * from Account\n"
                + "where [user] = '"+ user +"'\n"
                + "and pass = '"+ pass +"'");
        
        try {
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                		rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkAccountExist(String user) {
    	var rs = DBContext.Query("select * from Account\n"
                + "where [user] = '"+ user +"'\n");
        try {
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                		rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Account checkAccountExistByUsernameAndEmail(String username, String email) {
    	var rs = DBContext.Query("select * from Account where [user]='"+ username +"' and [email]='"+ email +"'");
        try {
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                		rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
    public void singup(String user, String pass, String email) {
        DBContext.Create("insert into Account\n"
                + "values('"+ user +"','"+ pass +"',0,0,'"+ email +"')");
        
    }
    
    public void deleteAccount(String id) {
        DBContext.Delete("delete from Account where uID= '"+ id +"'");
        
    }
    
    public void insertAccount(String user, String pass, String isSell,
    		String isAdmin, String email) {
        DBContext.Create("insert Account([user], pass, isSell, isAdmin, email)\r\n"
        		+ "values('"+ user +"','"+ pass +"','"+ isSell +"','"+ isAdmin +"','"+ email +"')");
        
    }
    
    public void editProfile(String username, String password, String email, int uID) {
        DBContext.Edit("update Account set [user]='"+ username +"',\r\n"
        		+ "[pass]='"+ password +"',\r\n"
        		+ "[email]='"+ email +"'\r\n"
        		+ "where [uID] = '"+ uID +"'");
       
    }
	
	
	
}

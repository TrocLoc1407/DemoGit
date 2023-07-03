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

public class InvoiceDao implements IDataRepository<Invoice> {
	private static InvoiceDao instance = null;

	private InvoiceDao() {}
	
	public static InvoiceDao getInstance() {
		if (instance == null) {
			instance = new InvoiceDao();
		}
		return instance;
	}

	@Override
	public void insertData(Invoice modelInsert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(Invoice modelUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Invoice modelDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Invoice> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice getData(Invoice model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Invoice> getAllInvoice() {
    	var rs =  DBContext.Query("select * from Invoice");
        ArrayList<Invoice> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Invoice(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4)
                       ));
            }
        } catch (Exception e) {
        }
        return list;
    }
	
	public double totalMoneyDay(int day) {
        var rs = DBContext.Query("select \r\n"
        		+ "	SUM(tongGia) \r\n"
        		+ "from Invoice\r\n"
        		+ "where DATEPART(dw,[ngayXuat]) = '"+ day +"'\r\n"
        		+ "Group by ngayXuat ");
        try {
            while (rs.next()) {
               return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public double totalMoneyMonth(int month) {
        var rs = DBContext.Query("select SUM(tongGia) from Invoice\r\n"
        		+ "where MONTH(ngayXuat)='"+ month +"'\r\n"
        		+ "Group by MONTH(ngayXuat)");
        try {
            while (rs.next()) {
               return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    
    
    public double sumAllInvoice() {
        var rs = DBContext.Query("select SUM(tongGia) from Invoice");
        try {
            while (rs.next()) {
               return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public ArrayList<Invoice> searchByNgayXuat(String ngayXuat) {
    	var rs = DBContext.Query("select * from Invoice\r\n"
        		+ "where [ngayXuat] ='"+ngayXuat+"'");
        ArrayList<Invoice> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Invoice(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4)
                       ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void deleteInvoiceByAccountId(String id) {
        DBContext.Delete("delete from Invoice\n"
                + "where [accountID] = '"+ id +"'");
        
    }
    
    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
    
    public void insertInvoice(int accountID, double tongGia) {
        DBContext.Create("insert Invoice(accountID,tongGia,ngayXuat)\r\n"
        		+ "values('"+ accountID +"','"+ tongGia +"','"+ getCurrentDate() +"')");

        
    }
	
	
}

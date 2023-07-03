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


public class SupplierDao implements IDataRepository<SupplierDao> {
	private static SupplierDao instance = null;

	private SupplierDao() {}
	
	public static SupplierDao getInstance() {
		if (instance == null) {
			instance = new SupplierDao();
		}
		return instance;
	}

	@Override
	public void insertData(SupplierDao modelInsert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(SupplierDao modelUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(SupplierDao modelDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<SupplierDao> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierDao getData(SupplierDao model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Supplier> getAllSupplier() {
    	var  rs = DBContext.Query("select * from Supplier");
        ArrayList<Supplier> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Supplier(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                		rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
	
	public void deleteSupplier(String idSupplier) {
        DBContext.Delete("delete from Supplier\r\n"
        		+ "where idSupplier='"+ idSupplier +"'");
        
    }
	
	public void insertSupplier(String nameSupplier, String phoneSupplier, String emailSupplier, String addressSupplier, String cateID) {
        DBContext.Create("insert Supplier(nameSupplier, phoneSupplier, emailSupplier, addressSupplier, cateID) \r\n"
        		+ "values('"+ nameSupplier +"','"+ phoneSupplier +"','"+ emailSupplier +"','"+ addressSupplier +"','"+ cateID +"')");
        
    }
	
}

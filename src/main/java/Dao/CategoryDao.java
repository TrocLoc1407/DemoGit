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


public class CategoryDao implements IDataRepository<Category> {
	private static CategoryDao instance = null;

	private CategoryDao() {}
	
	public static CategoryDao getInstance() {
		if (instance == null) {
			instance = new CategoryDao();
		}
		return instance;
	}

	@Override
	public void insertData(Category modelInsert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(Category modelUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Category modelDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Category> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getData(Category model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Category> getAllCategory() {
    	var rs = DBContext.Query("select * from Category");
        ArrayList<Category> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
	
	
}

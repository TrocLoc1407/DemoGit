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

public class SoLuongDaBanDao implements IDataRepository<SoLuongDaBan> {
	private static SoLuongDaBanDao instance = null;

	private SoLuongDaBanDao() {}
	
	public static SoLuongDaBanDao getInstance() {
		if (instance == null) {
			instance = new SoLuongDaBanDao();
		}
		return instance;
	}

	@Override
	public void insertData(SoLuongDaBan modelInsert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(SoLuongDaBan modelUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(SoLuongDaBan modelDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<SoLuongDaBan> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SoLuongDaBan getData(SoLuongDaBan model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ArrayList<SoLuongDaBan> getTop10SanPhamBanChay() {
    	var rs = DBContext.Query("select top(10) *\r\n"
        		+ "from SoLuongDaBan\r\n"
        		+ "order by soLuongDaBan desc");
        ArrayList<SoLuongDaBan> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new SoLuongDaBan(rs.getInt(1),
                        rs.getInt(2)
                  ));
            }
        } catch (Exception e) {
        }
        return list;
    }
	
	public SoLuongDaBan checkSoLuongDaBanExist(int productID) {
    	var rs = DBContext.Query("select * from SoLuongDaBan where productID = '"+ productID +"'");
        try {
            while (rs.next()) {
                return new SoLuongDaBan(rs.getInt(1),
                        rs.getInt(2)
                       );
            }
        } catch (Exception e) {
        }
       return null;
    }
	
	public void insertSoLuongDaBan(int productID, int soLuongDaBan) {
        DBContext.Create("insert SoLuongDaBan(productID,soLuongDaBan)\r\n"
        		+ "values('"+ productID +"','"+ soLuongDaBan +"')");
        
    }
	
	public void editSoLuongDaBan(int productID, int soLuongBanThem) {
        DBContext.Edit("exec dbo.proc_CapNhatSoLuongDaBan '"+ productID +"','"+ soLuongBanThem +"'");
        
    }
}

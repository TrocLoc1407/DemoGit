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


public class TongChiTieuBanHangDao implements IDataRepository<TongChiTieuBanHang> {
	private static TongChiTieuBanHangDao instance = null;

	private TongChiTieuBanHangDao() {}
	
	public static TongChiTieuBanHangDao getInstance() {
		if (instance == null) {
			instance = new TongChiTieuBanHangDao();
		}
		return instance;
	}

	@Override
	public void insertData(TongChiTieuBanHang modelInsert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(TongChiTieuBanHang modelUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(TongChiTieuBanHang modelDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TongChiTieuBanHang> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TongChiTieuBanHang getData(TongChiTieuBanHang model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<TongChiTieuBanHang> getTop5KhachHang() {
    	var rs = DBContext.Query("select top(5) *\r\n"
        		+ "from TongChiTieuBanHang\r\n"
        		+ "order by TongChiTieu desc");
        ArrayList<TongChiTieuBanHang> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new TongChiTieuBanHang(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3)
                       ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<TongChiTieuBanHang> getTop5NhanVien() {
    	var rs = DBContext.Query("select top(5) *\r\n"
        		+ "from TongChiTieuBanHang\r\n"
        		+ "order by TongBanHang desc");
        ArrayList<TongChiTieuBanHang> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new TongChiTieuBanHang(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3)
                       ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    public TongChiTieuBanHang checkTongChiTieuBanHangExist(int userID) {
    	var rs = DBContext.Query("select * from TongChiTieuBanHang where [userID]='"+ userID +"'");
        try {
            while (rs.next()) {
                return new TongChiTieuBanHang(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3)
                        );
            }
        } catch (Exception e) {
        }
       return null;
    }
    
    public void deleteTongChiTieuBanHangByUserID(String id) {
        DBContext.Delete("delete from TongChiTieuBanHang\n"
                + "where [userID] = '"+ id +"'");
        
    }
    

    public void insertTongChiTieuBanHang(int userID, double tongChiTieu, double tongBanHang) {
        DBContext.Create("insert TongChiTieuBanHang(userID,TongChiTieu,TongBanHang)\r\n"
        		+ "values('"+ userID +"','"+ tongChiTieu +"','"+ tongBanHang +"')");
        
    }
    
    public void editTongChiTieu(int accountID, double totalMoneyVAT) {
        DBContext.Edit("exec dbo.proc_CapNhatTongChiTieu '"+ accountID +"','"+ totalMoneyVAT +"'");
        
    }
    
    
    
    public void editTongBanHang(int sell_ID, double tongTienBanHangThem) {
        DBContext.Edit("exec dbo.proc_CapNhatTongBanHang '"+ sell_ID +"','"+ tongTienBanHangThem +"'");
        
    }
	
}

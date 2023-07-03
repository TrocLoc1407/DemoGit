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

public class ProductDao implements IDataRepository<Product> {
	
	private static ProductDao instance = null;

	private ProductDao() {}
	
	public static ProductDao getInstance() {
		if (instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}

	@Override
	public void insertData(Product modelInsert) {
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public void updateData(Product modelUpdate) {
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public void deleteData(Product modelDelete) {
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public ArrayList<Product> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getData(Product model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Product> getAllProduct(){
		var rs=DBContext.Query("select * from Product");
	    ArrayList<Product> list = new ArrayList<Product>();
		try { 
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setImage(rs.getString("image"));
				p.setPrice(rs.getDouble("price"));
				p.setTitle(rs.getString("title"));
				p.setDescription(rs.getString("description"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}
	
	
	public int countAllProduct() {
        var rs = DBContext.Query("select count(*) from Product");
        try {
            while (rs.next()) {
               return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
	
	
	public int getCateIDByProductID(String id) {
        var rs = DBContext.Query("select [cateID] from Product\r\n"
        		+ "where [id] ='"+ id +"'");
        try {
            while (rs.next()) {
               return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
	
	public ArrayList<Product> getTop3() {
    	var rs = DBContext.Query("select top 3 * from Product");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> getNext3Product(int amount) {
    	var rs = DBContext.Query("SELECT *\n"
                + "  FROM Product\n"
                + " ORDER BY id\n"
                + "OFFSET "+ amount +" ROWS\n"
                + " FETCH NEXT 3 ROWS ONLY");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> getNext4NikeProduct(int amount) {
    	var rs = DBContext.Query("select * from Product\r\n"
        		+ "where cateID=2\r\n"
        		+ "order by id desc\r\n"
        		+ "offset "+ amount +" rows\r\n"
        		+ "fetch next 4 rows only");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> getNext4AdidasProduct(int amount) {
    	var rs = DBContext.Query("select * from Product\r\n"
        		+ "where cateID=1\r\n"
        		+ "order by id desc\r\n"
        		+ "offset "+ amount +" rows\r\n"
        		+ "fetch next 4 rows only");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> getProductByCID(String cid) {
    	var rs = DBContext.Query("select * from Product\n"
                + "where cateID = '"+ cid +"'");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> getProductBySellIDAndIndex(int id, int indexPage) {
    	int a = (indexPage-1)*5;
    	var rs = DBContext.Query("select * from Product \r\n"
        		+ "where sell_ID = '"+ id +"'\r\n"
        		+ "order by [id]\r\n"
        		+ "offset "+ a +" rows\r\n"
        		+ "fetch next 5 rows only");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> getProductByIndex(int indexPage) {
    	int a = (indexPage-1)*9;
    	var rs = DBContext.Query("select * from Product \r\n"
        		+ "order by [id]\r\n"
        		+ "offset "+ a +" rows\r\n"
        		+ "fetch next 9 rows only");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> searchByName(String txtSearch) {
    	var rs = DBContext.Query("select * from Product\n"
                + "where [name] like '%"+txtSearch+"%'");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    public ArrayList<Product> searchPriceUnder100() {
    	var rs = DBContext.Query("select * from Product\r\n"
        		+ "where [price] < 100");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> searchPrice100To200() {
    	var rs = DBContext.Query("select * from Product\r\n"
        		+ "where [price] >= 100 and [price]<=200");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> searchColorWhite() {
    	var rs = DBContext.Query("select * from Product\r\n"
        		+ "where color = 'White'");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> searchColorGray() {
    	var rs = DBContext.Query("select * from Product\r\n"
        		+ "where color = 'Gray'");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> searchColorBlack() {
    	var rs = DBContext.Query("select * from Product\r\n"
        		+ "where color = 'Black'");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> searchColorYellow() {
    	var rs = DBContext.Query("select * from Product\r\n"
        		+ "where color = 'Yellow'");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Product> searchByPriceMinToMax(String priceMin,String priceMax) {
    	var rs = DBContext.Query("select * from Product\r\n"
        		+ "where [price] >= "+priceMin+" and [price]<="+priceMax+"");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> searchPriceAbove200() {
    	var rs = DBContext.Query("select * from Product\r\n"
        		+ "where [price] > 200");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> getRelatedProduct(int cateIDProductDetail) {
    	var rs = DBContext.Query("select top 4 * from product\r\n"
        		+ "where [cateID] ='"+ cateIDProductDetail +"'\r\n"
        		+ "order by id desc");
        ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Product getProductByID(String id) {
    	var rs = DBContext.Query("select * from Product\n"
                + "where id = '"+ id +"'");
        try {
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Product getLast() {
        var rs = DBContext.Query("select top 1 * from Product\n"
                + "order by id desc");
        try {
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<Product> get8Last() {
    	var rs = DBContext.Query("select top 8 * from Product order by id desc");
    	ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
            	list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> get4NikeLast() {
    	var rs = DBContext.Query("select top 4 * from Product\r\n"
        		+ "where cateID = 2\r\n"
        		+ "order by id desc");
    	ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
            	list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Product> get4AdidasLast() {
    	var rs = DBContext.Query("select top 4 * from Product\r\n"
        		+ "where cateID = 1\r\n"
        		+ "order by id desc");
    	ArrayList<Product> list = new ArrayList<>();
        try {
            while (rs.next()) {
            	list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void deleteProduct(String pid) {
        DBContext.Delete("delete from Product\n"
                 + "where [id] = '"+ pid +"'");
         
     }
     
     public void deleteProductBySellID(String id) {
         DBContext.Delete("delete from Product\n"
                 + "where [sell_ID] = '"+ id +"'");
         
     }
     
     
     public void insertProduct(String name, String image, String price,
             String title, String description, String category, int sid, String model, String color, String delivery, String image2, String image3, String image4) {
         DBContext.Create("insert Product([name],[image],[price],[title],\r\n"
         		+ "[description],[cateID],[sell_ID],[model],\r\n"
         		+ "[color],[delivery],[image2],[image3],[image4])\r\n"
         		+ "values(N'"+name+"','"+image+"','"+price+"',N'"+title+"',N'"+description+"','"+category+"','"+sid+"',N'"+model+"',N'"+color+"',N'"+delivery+"','"+image2+"','"+image3+"','"+image4+"')");
         
     }
     
     public void editProduct(String pname, String pimage, String pprice, String ptitle, String pdescription, String pcategory, 
     		String pmodel, String pcolor, 
     		String pdelivery, String pimage2, String pimage3, String pimage4, String pid) {
         DBContext.Edit("update Product\r\n"
         		+ "set [name] = '"+ pname +"',\r\n"
         		+ "[image] = '"+ pimage +"',\r\n"
         		+ "price = '"+ pprice +"',\r\n"
         		+ "title = '"+ ptitle +"',\r\n"
         		+ "[description] = '"+ pdescription +"',\r\n"
         		+ "cateID = '"+ pcategory +"',\r\n"
         		+ "model= '"+ pmodel +"',\r\n"
         		+ "color= '"+ pcolor +"',\r\n"
         		+ "delivery='"+ pdelivery +"',\r\n"
         		+ "image2='"+ pimage2 +"',\r\n"
         		+ "image3='"+ pimage3 +"',\r\n"
         		+ "image4='"+ pimage4 +"'\r\n"
         		+ "where [id] = '"+ pid +"'");
         
     }
     
     public int countAllProductBySellID(int sell_ID) {
         var rs = DBContext.Query("select count(*) from Product where sell_ID= '"+sell_ID+"'");
          try {
              while (rs.next()) {
                 return rs.getInt(1);
              }
          } catch (Exception e) {
          }
          return 0;
      }
      
      public int getSellIDByProductID(int productID) {
          var rs=DBContext.Query("select sell_ID\r\n"
          		+ "from Product\r\n"
          		+ "where [id]='"+ productID +"'");
          try {
              while (rs.next()) {
                 return rs.getInt(1);
              }
          } catch (Exception e) {
          }
          return 0;
      }
	
	
}

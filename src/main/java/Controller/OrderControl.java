package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import Repository.*;
import Models.*;
/**
 * Servlet implementation class OrderControl
 */
@WebServlet("/order")
public class OrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        int accountID = a.getId();
        //DAO dao = new DAO();
        var list = ServletRepository.getInstance().getCartByAccountID(accountID);
        var list2 = ServletRepository.getInstance().getAllProduct();
        //List<Cart> list = dao.getCartByAccountID(accountID);
        //List<Product> list2 = dao.getAllProduct();
        double totalMoney=0;
        for(Cart c : list) {
			for(Product p : list2) {
				if(c.getProductID()==p.getId()) {
					totalMoney=totalMoney+(p.getPrice()*c.getAmount());
				}
			}
		}
        double totalMoneyVAT=totalMoney+totalMoney*0.1;
        
        double tongTienBanHangThem=0;
        int sell_ID;
        for (Cart c : list) {
            for (Product p : list2) {
                if (c.getProductID() == p.getId()) {
                    tongTienBanHangThem = 0;
                    sell_ID = ServletRepository.getInstance().getSellIDByProductID(p.getId());
                    tongTienBanHangThem = tongTienBanHangThem + (p.getPrice() * c.getAmount());
                    TongChiTieuBanHang t2 = ServletRepository.getInstance().checkTongChiTieuBanHangExist(sell_ID);
                    if (t2 == null) {
                        ServletRepository.getInstance().insertTongChiTieuBanHang(sell_ID, 0, tongTienBanHangThem);
                    } else {
                        ServletRepository.getInstance().editTongBanHang(sell_ID, tongTienBanHangThem);
                    }
                }
            }
        }
        
        
        for(Cart c : list) {
			for(Product p : list2) {
				if(c.getProductID()==p.getId()) {
					SoLuongDaBan s = ServletRepository.getInstance().checkSoLuongDaBanExist(p.getId());
					if(s == null) {
						ServletRepository.getInstance().insertSoLuongDaBan(p.getId(), c.getAmount());
					}
					else {
						ServletRepository.getInstance().editSoLuongDaBan(p.getId(), c.getAmount());
					}	
				}
			}
		}
        
        ServletRepository.getInstance().insertInvoice(accountID, totalMoneyVAT);
        TongChiTieuBanHang t = ServletRepository.getInstance().checkTongChiTieuBanHangExist(accountID);
        if(t==null) {
        	ServletRepository.getInstance().insertTongChiTieuBanHang(accountID,totalMoneyVAT,0);
        }
        else {
        	ServletRepository.getInstance().editTongChiTieu(accountID, totalMoneyVAT);
        }
        
        
	request.getRequestDispatcher("DatHang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");
			String name = request.getParameter("name");
			String phoneNumber = request.getParameter("phoneNumber");
			String deliveryAddress = request.getParameter("deliveryAddress");
			
			 HttpSession session = request.getSession();
		        Account a = (Account) session.getAttribute("acc");
		        if(a == null) {
		        	response.sendRedirect("login");
		        	return;
		        }
		        int accountID = a.getId();
		        //DAO dao = new DAO();
		        var list = ServletRepository.getInstance().getCartByAccountID(accountID);
		        var list2 = ServletRepository.getInstance().getAllProduct();
		        //List<Cart> list = dao.getCartByAccountID(accountID);
		        //List<Product> list2 = dao.getAllProduct();
					
		        double totalMoney=0;
		        for(Cart c : list) {
					for(Product p : list2) {
						if(c.getProductID()==p.getId()) {
							totalMoney=totalMoney+(p.getPrice()*c.getAmount());
						}
					}
				}
		        double totalMoneyVAT=totalMoney+totalMoney*0.1;
		        
		        
		        //old code
				Email email =new Email();
				email.setFrom("dinhkha14072003@gmail.com"); //email quan tri 
				email.setFromPassword("dreqnintbzrsmzte"); //mat khau email tren
				email.setTo(emailAddress);
				email.setSubject("Dat hang thanh cong tu Troc Right Hand");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(name).append("<br>");
				sb.append("Ban vua dat dang tu Troc Right Hand. <br> ");
				sb.append("Dia chi nhan hang cua ban la: <b>").append(deliveryAddress).append(" </b> <br>");
				sb.append("So dien thoai khi nhan hang cua ban la: <b>").append(phoneNumber).append(" </b> <br>");
				sb.append("Cac san pham ban dat la: <br>");
				for(Cart c : list) {
					for(Product p : list2) {
						if(c.getProductID()==p.getId()) {
							sb.append(p.getName()).append(" | ").append("Price:").append(p.getPrice()).append("$").append(" | ").append("Amount:").append(c.getAmount()).append(" | ").append("Size:").append(c.getSize()).append("<br>");
						}
					}
				}
				sb.append("Tong Tien: ").append(String.format("%.02f",totalMoneyVAT)).append("$").append("<br>");
				sb.append("Cam on ban da dat hang tai Troc Right Hand<br>");
				sb.append("Chu cua hang");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				request.setAttribute("mess", "Dat hang thanh cong!");
				
				ServletRepository.getInstance().deleteCartByAccountID(accountID);
				
				
				//new code
//				request.setAttribute("email", emailAddress);
//				request.getRequestDispatcher("ThongTinDatHang.jsp").forward(request, response);
				
			
		} catch (Exception e) {
			request.setAttribute("error", "Dat hang that bai!");
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("DatHang.jsp").forward(request, response);
	}

}

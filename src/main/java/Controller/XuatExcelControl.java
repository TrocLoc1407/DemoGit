package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Models.*;
import Repository.*;
import Dao.*;


import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
/**
 * Servlet implementation class XuatExcelControl
 */
@WebServlet("/xuatExcelControl")
public class XuatExcelControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuatExcelControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String ngayXuat = request.getParameter("dateHoaDon");  
	       
	        //DAO dao = new DAO();
	        
		 	var list = ServletRepository.getInstance().searchByNgayXuat(ngayXuat);
		 	var listAllAccount = ServletRepository.getInstance().getAllAccount();
		 
	        //List<Invoice> list = dao.searchByNgayXuat(ngayXuat);
	        //List<Account> listAllAccount = dao.getAllAccount();
	        
	        FileOutputStream file=new FileOutputStream("D:\\ExcelControl\\"+ngayXuat+"hoaDon.xlsx");
	        XSSFWorkbook workbook=new XSSFWorkbook();
	        XSSFSheet workSheet=workbook.createSheet("1");
	        XSSFRow row;
	        XSSFCell cell0;
	        XSSFCell cell1;
	        XSSFCell cell2;
	        XSSFCell cell3;
	        
	        row=workSheet.createRow(0);
	        cell0=row.createCell(0);
	        cell0.setCellValue("Mã Hóa Đơn");
	        cell1=row.createCell(1);
	        cell1.setCellValue("Account");
	        cell2=row.createCell(2);
	        cell2.setCellValue("Tổng Giá($)");
	        cell3=row.createCell(3);
	        cell3.setCellValue("Ngày Xuất");
	        
	        double tongGia;
	        int i=0;
	        
	        for (Invoice o : list) {
	        	i=i+1;
	        	for (Account a : listAllAccount) {
	        		if(o.getAccountID()==a.getId()) {
	        			tongGia=Math.round((o.getTongGia()) * 100.0) / 100.0;
	        			 row=workSheet.createRow(i);
	        			 cell0=row.createCell(0);
	        		     cell0.setCellValue(o.getMaHD());
	        		     cell1=row.createCell(1);
	        		     cell1.setCellValue(a.getUser());
	        		     cell2=row.createCell(2);
	        		     cell2.setCellValue(tongGia);
	        		     cell3=row.createCell(3);
	        		     cell3.setCellValue(ngayXuat);	
	        		}
	        		}
	        }
	        workbook.write(file);
	        workbook.close();
	        file.close();
	        
	        request.setAttribute("mess", "Đã xuất file Excel thành công!");
	        request.getRequestDispatcher("hoaDon").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

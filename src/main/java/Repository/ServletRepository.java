package Repository;

import java.util.ArrayList;

import Dao.*;
import Models.*;

public class ServletRepository {
	
	private static ServletRepository instance = null;

	private ServletRepository() {
	}
	public static ServletRepository getInstance() {
		if (instance == null) {
			instance = new ServletRepository();
		}
		return instance;
	}
	
	//product
	
	public ArrayList<Product> getAllProduct(){
		return ProductDao.getInstance().getAllProduct();
	}
	
	public ArrayList<Product> getTop3(){
		return ProductDao.getInstance().getTop3();
	}
	
	public ArrayList<Product> getNext3Product(int amount){
		return ProductDao.getInstance().getNext3Product(amount);
	} 
	
	public ArrayList<Product> getNext4NikeProduct(int amount){
		return ProductDao.getInstance().getNext4NikeProduct(amount);
	}
	
	public ArrayList<Product> getNext4AdidasProduct(int amount){
		return ProductDao.getInstance().getNext4AdidasProduct(amount);
	}
	
	public ArrayList<Product> getProductByCID(String cid){
		return ProductDao.getInstance().getProductByCID(cid);
	}
	
	public ArrayList<Product> getProductBySellIDAndIndex(int id, int indexPage){
		return ProductDao.getInstance().getProductBySellIDAndIndex(id, indexPage);
	}
	
	public ArrayList<Product> getProductByIndex(int indexPage){
		return ProductDao.getInstance().getProductByIndex(indexPage);
	}
	
	public ArrayList<Product> searchByName(String txtSearch){
		return  ProductDao.getInstance().searchByName(txtSearch);
	}
	
	public ArrayList<Product> searchPriceUnder100(){
		return ProductDao.getInstance().searchPriceUnder100();
	}
	
	public ArrayList<Product> searchPrice100To200(){
		return ProductDao.getInstance().searchPrice100To200();
	}
	
	public ArrayList<Product> searchColorWhite(){
		return ProductDao.getInstance().searchColorWhite();
	}
	
	public ArrayList<Product> searchColorGray(){
		return ProductDao.getInstance().searchColorGray();
	}
	
	public ArrayList<Product> searchColorBlack(){
		return ProductDao.getInstance().searchColorBlack();
	}
	
	public ArrayList<Product> searchColorYellow(){
		return ProductDao.getInstance().searchColorYellow();
	}
	public ArrayList<Product> searchByPriceMinToMax(String priceMin,String priceMax){
		return ProductDao.getInstance().searchByPriceMinToMax(priceMin, priceMax);
	}
	
	public ArrayList<Product> searchPriceAbove200(){
		return ProductDao.getInstance().searchPriceAbove200();
	}
	
	public ArrayList<Product> getRelatedProduct(int cateIDProductDetail){
		return ProductDao.getInstance().getRelatedProduct(cateIDProductDetail);
	}
	
	public ArrayList<Product> get8Last(){
		return ProductDao.getInstance().get8Last();
	}
	
	public ArrayList<Product> get4NikeLast(){
		return ProductDao.getInstance().get4NikeLast();
		
	}
	
	public ArrayList<Product> get4AdidasLast(){
		return ProductDao.getInstance().get4AdidasLast();
	}
	
	public int countAllProduct() {
		return ProductDao.getInstance().countAllProduct();
	
	}
	
	public int getCateIDByProductID(String id) {
		return ProductDao.getInstance().getCateIDByProductID(id);
	}
	
	public Product getProductByID(String id) {
		return ProductDao.getInstance().getProductByID(id);
	}
	
	public Product getLast() {
		return ProductDao.getInstance().getLast();
	}
	
	public void deleteProduct(String pid) {
		ProductDao.getInstance().deleteProduct(pid);
	}
	
	public void deleteProductBySellID(String id) {
		ProductDao.getInstance().deleteProductBySellID(id);
	}
	
	public void insertProduct(String name, String image, String price,
            String title, String description, String category, int sid, String model, String color, String delivery, String image2, String image3, String image4) {
		ProductDao.getInstance().insertProduct(name, image, price, title, description, category, sid, model, color, delivery, image2, image3, image4);
	}
	
	public void editProduct(String pname, String pimage, String pprice, String ptitle, String pdescription, String pcategory, 
     		String pmodel, String pcolor, 
     		String pdelivery, String pimage2, String pimage3, String pimage4, String pid) {
		ProductDao.getInstance().editProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, pmodel, pcolor, pdelivery, pimage2, pimage3, pimage4, pid);
	}
	
	public int countAllProductBySellID(int sell_ID) {
		return ProductDao.getInstance().countAllProductBySellID(sell_ID);
	}
	
	public int getSellIDByProductID(int productID) {
		return ProductDao.getInstance().getSellIDByProductID(productID);
	}
	
	
	//Cart
	
	public ArrayList<Cart> getCartByAccountID(int accountID){
		return CartDao.getInstance().getCartByAccountID(accountID);
	}
	
	public Cart checkCartExist(int accountID,int productID) {
		return CartDao.getInstance().checkCartExist(accountID, productID);
	}
	
	public void deleteCartByAccountID(int accountID) {
		CartDao.getInstance().deleteCartByAccountID(accountID);
	}
	
	public void deleteCartByProductID(String productID) {
		CartDao.getInstance().deleteCartByProductID(productID);
	}
	
	public void deleteCart(int productID) {
		CartDao.getInstance().deleteCart(productID);
	}
	
	public void insertCart(int accountID, int productID, int amount, String size) {
		CartDao.getInstance().insertCart(accountID, productID, amount, size);
	}
	
	public void editAmountAndSizeCart(int accountID, int productID, int amount, String size) {
		CartDao.getInstance().editAmountAndSizeCart(accountID, productID, amount, size);
	}
	
	public void editAmountCart(int accountID, int productID, int amount) {
		CartDao.getInstance().editAmountCart(accountID, productID, amount);
	}
	
	
	//Category
	
	public ArrayList<Category> getAllCategory(){
		return CategoryDao.getInstance().getAllCategory();
	}
	
	//Account
	
	public ArrayList<Account> getAllAccount(){
		return AccountDao.getInstance().getAllAccount();
	}
	
	public int checkAccountAdmin(int userID) {
		return AccountDao.getInstance().checkAccountAdmin(userID);
	}
	
	public Account login(String user, String pass) {
		return AccountDao.getInstance().login(user, pass);
	}
	
	public Account checkAccountExist(String user) {
		return AccountDao.getInstance().checkAccountExist(user);
	}
	
	public Account checkAccountExistByUsernameAndEmail(String username, String email) {
		return AccountDao.getInstance().checkAccountExistByUsernameAndEmail(username, email);
	}
	
	public void singup(String user, String pass, String email) {
		AccountDao.getInstance().singup(user, pass, email);
	}
	
	public void deleteAccount(String id) {
		AccountDao.getInstance().deleteAccount(id);
	}
	
	public void insertAccount(String user, String pass, String isSell,
    		String isAdmin, String email) {
		AccountDao.getInstance().insertAccount(user, pass, isSell, isAdmin, email);
	}
	
	public void editProfile(String username, String password, String email, int uID) {
		AccountDao.getInstance().editProfile(username, password, email, uID);
	}
	
	//Invoice
	
	public ArrayList<Invoice> getAllInvoice(){
		return InvoiceDao.getInstance().getAllInvoice();
	}
	
	public double totalMoneyDay(int day) {
		return InvoiceDao.getInstance().totalMoneyDay(day);
	}
	
	public double totalMoneyMonth(int month) {
		return InvoiceDao.getInstance().totalMoneyMonth(month);
	}
	
	public double sumAllInvoice() {
		return InvoiceDao.getInstance().sumAllInvoice();
	}
	
	public ArrayList<Invoice> searchByNgayXuat(String ngayXuat){
		return InvoiceDao.getInstance().searchByNgayXuat(ngayXuat);
	}
	
	public void deleteInvoiceByAccountId(String id) {
		InvoiceDao.getInstance().deleteInvoiceByAccountId(id);
	}
	
	
	public void insertInvoice(int accountID, double tongGia) {
		InvoiceDao.getInstance().insertInvoice(accountID, tongGia);
	}
	
	//Review
	
	public int countAllReview() {
		return ReviewDao.getInstance().countAllReview();
	}
	
	public ArrayList<Review> getAllReviewByProductID(String productId){
		return ReviewDao.getInstance().getAllReviewByProductID(productId);
	}
	
	public Review getNewReview(int accountID, int productID) {
		return ReviewDao.getInstance().getNewReview(accountID, productID);
	}
	
	public void deleteReviewByProductID(String productID) {
		ReviewDao.getInstance().deleteReviewByProductID(productID);
	}
	
	public void deleteReviewByAccountID(String id) {
		ReviewDao.getInstance().deleteReviewByAccountID(id);
	}
	
	public void insertReview(int accountID, int productID, String contentReview) {
		ReviewDao.getInstance().insertReview(accountID, productID, contentReview);
	}
	
	//SoLuongDaBan
	
	public ArrayList<SoLuongDaBan> getTop10SanPhamBanChay(){
		return SoLuongDaBanDao.getInstance().getTop10SanPhamBanChay();
	}
	
	public SoLuongDaBan checkSoLuongDaBanExist(int productID) {
		return SoLuongDaBanDao.getInstance().checkSoLuongDaBanExist(productID);
	}
	
	public void insertSoLuongDaBan(int productID, int soLuongDaBan) {
		SoLuongDaBanDao.getInstance().insertSoLuongDaBan(productID, soLuongDaBan);
	}
	
	public void editSoLuongDaBan(int productID, int soLuongBanThem){
		SoLuongDaBanDao.getInstance().editSoLuongDaBan(productID, soLuongBanThem);
	}
	
	//Supplier
	
	public ArrayList<Supplier> getAllSupplier(){
		return SupplierDao.getInstance().getAllSupplier();
	}
	
	public void deleteSupplier(String idSupplier) {
		SupplierDao.getInstance().deleteSupplier(idSupplier);
	}
	
	public void insertSupplier(String nameSupplier, String phoneSupplier, String emailSupplier, String addressSupplier, String cateID) {
		SupplierDao.getInstance().insertSupplier(nameSupplier, phoneSupplier, emailSupplier, addressSupplier, cateID);
	}
	
	//TongChiTieuBanHang
	
	public ArrayList<TongChiTieuBanHang> getTop5KhachHang(){
		return TongChiTieuBanHangDao.getInstance().getTop5KhachHang();
	}
	
	public ArrayList<TongChiTieuBanHang> getTop5NhanVien(){
		return TongChiTieuBanHangDao.getInstance().getTop5NhanVien();
	}
	
	public TongChiTieuBanHang checkTongChiTieuBanHangExist(int userID) {
		return TongChiTieuBanHangDao.getInstance().checkTongChiTieuBanHangExist(userID);
	}
	
	public void deleteTongChiTieuBanHangByUserID(String id) {
		TongChiTieuBanHangDao.getInstance().deleteTongChiTieuBanHangByUserID(id);
	}
	
	public void insertTongChiTieuBanHang(int userID, double tongChiTieu, double tongBanHang) {
		TongChiTieuBanHangDao.getInstance().insertTongChiTieuBanHang(userID, tongChiTieu, tongBanHang);
	}
	
	public void editTongChiTieu(int accountID, double totalMoneyVAT) {
		TongChiTieuBanHangDao.getInstance().editTongChiTieu(accountID, totalMoneyVAT);
	}
	
	public void editTongBanHang(int sell_ID, double tongTienBanHangThem) {
		TongChiTieuBanHangDao.getInstance().editTongBanHang(sell_ID, tongTienBanHangThem);
	}
}

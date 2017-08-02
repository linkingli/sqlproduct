package service;

import java.util.List;

import dao.ProductDao;
import domain.Product;
import domain.pageBean;

public class ProductService {

	public ProductService() {
		// TODO Auto-generated constructor stub
	}
	public List<Product> findAll() throws Exception {
		return new ProductDao().getAll();
	}

	public void addProduct(Product product) throws Exception {
		new ProductDao().saveProduct(product);
		
	}

	public Product findById(String pid) throws Exception {
		
		return new ProductDao().getById(pid);
	}

	public void updateProduct(Product product) throws Exception {
		new ProductDao().update(product);
		
	}

	public void deleteById(String pid) throws Exception {
		new ProductDao().deleteById(pid);
		
	}

	public void deleteAll(String[] pids) throws Exception {
		ProductDao productDao = new ProductDao();
		for(String pid :pids){
			productDao.deleteById(pid);
		}
		
	}
	//逻辑层处理，
	public	pageBean<Product> searchProduct(int currentpage, int pagesize) throws Exception {
		ProductDao productDao = new ProductDao();
			//封装
		pageBean<Product> pageBean = new pageBean<>();
			//查询account;
		int count = 0;
		try {
			count = productDao.getcount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			//查询结果
	List<Product> plist=productDao.getbypage(currentpage,pagesize);
			//封装
	pageBean.setCurrentpage(currentpage);
	pageBean.setPagesize(pagesize);
	pageBean.setTotalcount(count);
	pageBean.setList(plist);
		
	return pageBean;
	}
	public List<Product> findByCondtion(String query) throws Exception {
		return  ProductDao.getByCcondition(query);
		
	}

}

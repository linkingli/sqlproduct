package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.Product;
import utils.DataSourceUtils;

public class ProductDao {

	public ProductDao() {
		// TODO Auto-generated constructor stub
	}
	public List<Product> getAll() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		return qr.query(sql, new BeanListHandler<>(Product.class));
	}

	public void saveProduct(Product product) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?)";
		qr.update(sql, product.getPid(),product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),product.getPdate(),product.getPdesc());
	}

	public Product getById(String pid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=? limit 1";
		return qr.query(sql, new BeanHandler<>(Product.class),pid);
	}

	public void update(Product product) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set pid=?,pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,pdesc=? where pid=?";

		qr.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),product.getPdate(),product.getPdesc(),product.getPid());
	}

	public void deleteById(String pid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where pid=?";
		qr.update(sql, pid);
	}
	public int getcount() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from product";
		return ((Long)qr.query(sql, new ScalarHandler())).intValue();
	}
	@SuppressWarnings("unchecked")
	public List<Product> getbypage(int currentpage, int pagesize) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product limit ?,?";
		
		return  qr.query(sql, new BeanListHandler<>(Product.class),(currentpage-1)*pagesize,pagesize);
		
	}
	public static List<Product> getByCcondition(String query) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="slect * from product where pdesc like ?";
		return qr.query(sql, new BeanListHandler<>(Product.class), "%"+query+"%");
	}

}

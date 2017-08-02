package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Product;
import service.ProductService;
import utils.UUIDUtils;

/**
 * Servlet implementation class AddProdcutServlet
 */
public class AddProdcutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		try {
			BeanUtils.populate(product, request.getParameterMap());
			//用uuid生成id 
			product.setPid(UUIDUtils.getUUID());
			product.setPdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			//调用productService
			new ProductService().addProduct(product);
			//重定向到
			response.sendRedirect(request.getContextPath()+"/findAll");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import domain.pageBean;
import service.ProductService;

/**
 * Servlet implementation class searchProductServlet
 */
@WebServlet("/searh")
public class searchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		//get请求的时候。
//		String name=request.getParameter("name");
//		name=new String(name.getBytes("iso-8859-1"),"utf-8");
//		
		//设置编码,这连中国设置有何不一样的地方？
//				response.setCharacterEncoding("utf-8");
//				response.setContentType("utf-8");
		//调用servie实现逻辑。
		//思考这里的参数设置。limit;(currentpage-1)*pagesize,pagesize;
		//思考这里的返回类型，pageBean
				//利用index.jsp传回的参数实现当页，
				int currentpage=Integer.parseInt(request.getParameter("currentpage"));
				int pagesize=3;
				pageBean <Product> bean =null;
				try {
					bean=new ProductService().searchProduct(currentpage, pagesize);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//plist放入域对象中。并且转发
				request.setAttribute("bean", bean);
				request.getRequestDispatcher("/jsp/searchProduct.jsp").forward(request, response);
				
		//转发与重定向关于域的问题。
				
		
		
		
		
	}

	private String getParameter(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

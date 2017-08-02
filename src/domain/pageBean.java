package domain;

import java.util.List;

public class pageBean <T>{
		private List<T> list;//返回的数据集合
		private Integer currentpage;//当前页
		private Integer pagesize;//每页大小
		private Integer totalcount;//总的查询数量
		private Integer totalpage;//总页数
		public List<T> getList() {
			return list;
		}
		public void setList(List<T> list) {
			this.list = list;
		}
		public Integer getCurrentpage() {
			return currentpage;
		}
		public void setCurrentpage(Integer currentpage) {
			this.currentpage = currentpage;
		}
		public Integer getPagesize() {
			return pagesize;
		}
		public void setPagesize(Integer pagesize) {
			this.pagesize = pagesize;
		}
		public Integer getTotalcount() {
			return totalcount;
		}
		public void setTotalcount(Integer totalcount) {
			this.totalcount = totalcount;
		}
		//ceil函数实现向上取余
		public Integer getTotalpage() {
			return (int)Math.ceil((totalcount*1.0/pagesize));
		}
//		这里的set不需要，
//		public void setTotalpage(Integer totalpage) {
//			this.totalpage = totalpage;
//		}
		
}

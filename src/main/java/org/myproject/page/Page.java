package org.myproject.page;
/**
 * ��ҳ��
 * @author Czw
 *
 */
public class Page {
	/**
	 * �ܼ�¼��
	 */
	private int totalCount;
	/**
	 * ��ҳ��
	 */
	private int totalPages;
	/**
	 * ��ǰҳ��
	 */
	private int currentPage;
	/**
	 * ÿҳ������
	 */
	private int pageCapacity;
	/**
	 * ���ݲ�ѯ����ʼ����
	 */
	private int offsetIndex;
	/**
	 * ÿ�β�ѯ��¼��
	 */
	private int queryNumber;
	
	public Page(int totalCount, int currentPage, int pageCapacity) {
		super();
		this.totalCount = totalCount;
		this.totalPages = (totalCount>0?Math.round(totalCount/pageCapacity+0.5f):1);
		if(currentPage < 1){
			this.currentPage = 1;
		}else if(currentPage > totalPages){
			this.currentPage = totalPages;
		}else{
			this.currentPage = currentPage;
		}
		this.pageCapacity = pageCapacity;
		this.offsetIndex = (this.currentPage-1) * pageCapacity;
		this.queryNumber = pageCapacity;
	}
	
	public Page() {
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCapacity() {
		return pageCapacity;
	}
	public void setPageCapacity(int pageCapacity) {
		this.pageCapacity = pageCapacity;
	}
	public int getOffsetIndex() {
		return offsetIndex;
	}
	public void setOffsetIndex(int offsetIndex) {
		this.offsetIndex = offsetIndex;
	}
	public int getQueryNumber() {
		return queryNumber;
	}
	public void setQueryNumber(int queryNumber) {
		this.queryNumber = queryNumber;
	}
	
}

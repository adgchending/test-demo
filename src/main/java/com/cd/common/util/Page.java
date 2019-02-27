/**   
 * Copyright © 2017 eaglesoul100 All rights reserved.
 * 
 * 功能描述：
 * @Package: com.es.app_common.util 
 * @author: lvyonggang  
 * @date: 2017年10月11日 上午11:21:56 
 */
package com.cd.common.util;

import java.util.List;

/**
* @Param:功能说明:分页工具类
* @parameter:参数说明:
* @return：返回结果描述:
* @Throws：返回异常结果:
* @Author: chenshangxian
* @Date: 2018-11-28 10:21
*/
public class Page {
	// 当前页
	private Long pageNo;
	// 单页大小
	private Long pageSize;
	// 总页数
	private Long totalPage;
	// 总记录数
	private Long totalCount;
	// 是否是第一页
	private Boolean firstPage;
	// 是否是最后一页
	private Boolean lastPage;
	// 记录列表
	private List<?> records;

	public Page(Long pageNo, Long pageSize, Long totalPage, Long totalCount,
				Boolean firstPage, Boolean lastPage, List<?> records) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.firstPage = firstPage;
		this.lastPage = lastPage;
		this.records = records;
	}

	/**
	 * 
	 * @Function: pageUtil(Long count, Long pageNo, Long pageSize,List<Object>
	 *            records)
	 * @Description: 分页静态工具方法
	 *
	 * @param:count 记录总数
	 * @param:pageNo 当前页
	 * @param:pageSize 每页的记录数
	 * @param:records 当前页的记录列表
	 * @return：com.es.app_common.util.Page
	 *
	 * @version: v1.0.0
	 * @author: lvyonggang
	 * @date: 2017年10月11日 上午11:49:53
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年10月11日 lvyonggang v1.0.0 创建
	 */
	public static Page pageUtil(Long count, Long pageNo, Long pageSize,
			List<?> records) {
		long tp = 0;
		// 如果页数不整除，页数加1
		if (count % pageSize > 0)
			tp = count / pageSize + 1;
		else
			tp = count / pageSize;

		return new Page(pageNo, pageSize, tp, count, pageNo == 1, pageNo == tp,
				records);
	}

	/**
	 * @return the pageNo
	 */
	public Long getPageNo() {
		return pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public Long getPageSize() {
		return pageSize;
	}

	/**
	 * @return the totalPage
	 */
	public Long getTotalPage() {
		return totalPage;
	}

	/**
	 * @return the totalCount
	 */
	public Long getTotalCount() {
		return totalCount;
	}

	/**
	 * @return the firstPage
	 */
	public Boolean getFirstPage() {
		return firstPage;
	}

	/**
	 * @return the lastPage
	 */
	public Boolean getLastPage() {
		return lastPage;
	}

	/**
	 * @return the records
	 */
	public List<?> getRecords() {
		return records;
	}
	
	

}

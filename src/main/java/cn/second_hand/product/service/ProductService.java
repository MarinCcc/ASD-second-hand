package cn.second_hand.product.service;

import java.util.List;

import org.bson.types.ObjectId;

import cn.second_hand.product.dao.ProductDao;
import cn.second_hand.product.domain.Product;
import cn.second_hand.query.AuditQueryObject;
import cn.second_hand.query.PageResult;

public class ProductService {

	private ProductDao productDao = new ProductDao();

	public void saveSaleApp(Product product) {
		productDao.saveSaleApp(product);
	}

	public PageResult query(AuditQueryObject auditQueryObject) {
		int count = productDao.queryForCount(auditQueryObject);
		if (count > 0) {
			List<Product> list = productDao.query(auditQueryObject);
			return new PageResult(list, count, auditQueryObject.getCurrentPage(), auditQueryObject.getPageSize());
		} else {
			return PageResult.empty(auditQueryObject.getPageSize());
		}
	}

	public PageResult query(AuditQueryObject auditQueryObject, Integer state) {
		int count = productDao.queryForCount(auditQueryObject, state);
		if (count > 0) {
			List<Product> list = productDao.query(auditQueryObject, state);
			return new PageResult(list, count, auditQueryObject.getCurrentPage(), auditQueryObject.getPageSize());
		} else {
			return PageResult.empty(auditQueryObject.getPageSize());
		}
	}

	public PageResult queryApplyingList(AuditQueryObject auditQueryObject,String currentUserEmail) {
		int count = productDao.queryApplyingListForCount(auditQueryObject,currentUserEmail);
		if (count > 0) {
			List<Product> list = productDao.queryApplyingList(auditQueryObject,currentUserEmail);
			return new PageResult(list, count, auditQueryObject.getCurrentPage(), auditQueryObject.getPageSize());
		} else {
			return PageResult.empty(auditQueryObject.getPageSize());
		}
	}

	public void editSaleApplyingListPage(Product product) {
		productDao.editSaleApplyingListPage(product);
		
	}

	public void hideSaleApplication(ObjectId id) {
		productDao.hideSaleApplication(id);
		
	}

}

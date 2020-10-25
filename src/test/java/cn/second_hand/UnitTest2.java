package cn.second_hand;

import org.junit.Test;

import cn.second_hand.category.dao.CategoryDao;
import cn.second_hand.category.domain.Category;
import cn.second_hand.user.utils.MongoDBUtils;

public class UnitTest2 {

   MongoDBUtils mangoDb;
   CategoryDao dao = new CategoryDao();
    
	
	@Test
	public void testMangoDBConnection() {
		mangoDb.getConnect();
	}
	
	
	@Test
	public void testAdd() {
		
		Category category = new Category();
	    category.setCategoriesName("python");
	    category.setDescription("this is a catrgory for python");
	    dao.add(category);

	}
	
	
	@Test
	public void testEdit() {

		Category category = new Category();
	    category.setCategoriesName("java2");
	    category.setDescription("this is a catrgory for java2");
	    dao.edit(category);
		
	
	}
	
	
	@Test
	public void testfindAll(){
		
		dao.findAll();
		
		
	}


}

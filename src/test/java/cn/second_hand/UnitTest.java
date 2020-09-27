package cn.second_hand;

import org.junit.Test;

import cn.second_hand.user.dao.UserDao;
import cn.second_hand.user.domain.User;
import cn.second_hand.user.utils.MongoDBUtils;

public class UnitTest {
	
	MongoDBUtils mangoDb;
	
	UserDao userDao = new UserDao();
	
//	@Test
//	public void testMangoDBConnection() {
//		mangoDb.getConnect();
//	}
	
	@Test
	public void testFindByEmail() {
		userDao.findByEmail("574811625@qq.com");
	}
	
	@Test
	public void testRegister() {
		User user =new User();
		user.setEmail("123@gmail.com");
		user.setActiveStatus(true);
		user.setPassword("123456");
		user.setVerifyCode("123");
		userDao.register(user);
	}
	
	@Test
	public void testupdateActiveState() {
		userDao.updateActiveState("123", true);
	}
}

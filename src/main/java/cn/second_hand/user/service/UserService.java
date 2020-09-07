package cn.second_hand.user.service;

import org.bson.Document;

import cn.second_hand.user.dao.UserDao;
import cn.second_hand.user.domain.User;
import cn.second_hand.user.domain.UserException;

public class UserService {
	private UserDao dao = new UserDao();
	
	public void active(String code) throws UserException{
		Document d =dao.findByVerifyCode(code);
		if(d==null) {
			throw new UserException("Incorrect verify code!");
		}
		if(d.getBoolean("status").equals(true)) {
			throw new UserException("You already actived account, please do not try again!");
		}
		dao.updateState(code, true);
	}

	public void register(User user) throws UserException{
		if(dao.findByEmail(user.getEmail())!=null) {
			throw new UserException("Email address already exists");
		}
		dao.register(user);
	}

	public User login(User user) throws UserException {
		Document d = dao.findByEmail(user.getEmail());
		System.out.println(d.getBoolean("status"));
		if(d==null) {
			throw new UserException("Email address not exists");
		}
		if(!d.getString("password").equals(user.getPassword())) {
			throw new UserException("Password is wrong");
		}
		if(!d.getBoolean("status")) {
			throw new UserException("Sorry, you account is not actived please active first");
		}
		User u = new User();
		u.setEmail(d.getString("email"));
		u.setPassword(d.getString("password"));
		return u;
	}


}

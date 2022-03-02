package Com.sonu.services;

import java.util.Set;

import Com.sonu.model.User;
import Com.sonu.model.UserRole;

public interface UserService {
	
	//create user
	public User createUser(User user, Set<UserRole> userRoles);

	//get user by username
	public User getUser(String username);
	
	//delete user by username
	public void deleteUser(Long userId);
}

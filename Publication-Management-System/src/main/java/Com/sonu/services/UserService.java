package Com.sonu.services;


import java.util.List;
import java.util.Set;


import Com.sonu.model.User;
import Com.sonu.model.UserRole;

public interface UserService {
	
	//create user
	public User createUser(User user, Set<UserRole> userRoles);
	
	// Get All User List
	User saveUser(User user);
	List<User> getAllUser();

	//get user by username
	public User getUser(String username);
	
	// update user by id
	
	
	User updateUser(User user, Long userId);
	
	//delete user by username
	public void deleteUser(Long userId);
}

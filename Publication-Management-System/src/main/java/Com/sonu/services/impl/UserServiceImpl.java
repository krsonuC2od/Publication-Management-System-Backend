package Com.sonu.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.sonu.model.User;
import Com.sonu.model.UserRole;
import Com.sonu.repo.RoleRepository;
import Com.sonu.repo.UserRepository;  
import Com.sonu.services.UserService;
@Service
public class UserServiceImpl implements UserService {
   
	@Autowired
	private UserRepository  userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null)
		{
			System.out.println("this User name is already taken ");
		//	throw new Exception("user already present");
		}else {
			//user create
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
				
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}
	
//geting user by user name
	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	
		
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}

}

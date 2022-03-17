package Com.sonu.services.impl;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Com.sonu.exception.ResourceNotFoundException;
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

	@Override
	public User updateUser(User user, Long userId) {
		User existingUser = userRepository.getById(userId);
				//.orElseThrow( ()->
		//new ResourceNotFoundException("User", "Id", id)	);
			
		
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		existingUser.setUsername(user.getUsername());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setPhone(user.getPhone());
		existingUser.setProfile(user.getProfile());
		userRepository.save(existingUser);
		
		return existingUser;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	

	
	

	
	
	

}

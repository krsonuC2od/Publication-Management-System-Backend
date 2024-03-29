package Com.sonu.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import Com.sonu.model.Role;
import Com.sonu.model.User;
import Com.sonu.model.UserRole;
import Com.sonu.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService UserService;
	@PostMapping("/")
	public User createUser( @RequestBody User user){
		
		Set<UserRole> roles=new HashSet<>();
		Role role=new Role();
		role.setRoleId(11L);
		role.setRoleName("FACULTY");
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		return this.UserService.createUser(user, roles);
		
	}
	
	@GetMapping
	public List<User>getAllUser(){
	return UserService.getAllUser();
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username")String username) {
		return this.UserService.getUser(username);

}
	@PutMapping("/{userId}")
	public ResponseEntity<User>updateUser(@PathVariable("userId") Long userId, @RequestBody User user){
		
		return new ResponseEntity<User>(UserService.updateUser(user, userId),HttpStatus.OK);
	}
		
	// delete user by id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId")Long userId) {
		this.UserService.deleteUser(userId);
	}
	
}
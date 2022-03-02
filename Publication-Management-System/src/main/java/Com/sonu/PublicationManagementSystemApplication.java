package Com.sonu;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Com.sonu.model.Role;
import Com.sonu.model.User;
import Com.sonu.model.UserRole;
import Com.sonu.services.UserService;



@SpringBootApplication
public class PublicationManagementSystemApplication  implements CommandLineRunner {
    @Autowired
	private UserService userService;

    
	
	public static void main(String[] args) {
		SpringApplication.run(PublicationManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started Your Server");
	
	/*	User user = new User();
		
		user.setFirstname("Sonu");
		user.setLastname("kumar");
		user.setUsername("krsanu");
		user.setPassword("Cutm123");
		user.setEmail("190101120062");
		user.setPhone("6201185264");
		user.setProfile("image.png");
		
		Role role1 = new Role();
		role1.setRoleId(10L);
		role1.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
		*/
		
	}

	
}

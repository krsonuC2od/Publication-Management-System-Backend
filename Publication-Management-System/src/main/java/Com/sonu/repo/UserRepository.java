package Com.sonu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.sonu.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}

package Com.sonu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.sonu.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

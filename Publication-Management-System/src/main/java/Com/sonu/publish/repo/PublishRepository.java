package Com.sonu.publish.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.sonu.publish.model.Publish;

public interface PublishRepository extends JpaRepository<Publish, Long> {

}
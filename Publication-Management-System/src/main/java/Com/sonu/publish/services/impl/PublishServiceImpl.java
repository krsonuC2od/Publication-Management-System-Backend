package Com.sonu.publish.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Com.sonu.exception.ResourceNotFoundException;
import Com.sonu.publish.model.Publish;
import Com.sonu.publish.repo.PublishRepository;
import Com.sonu.publish.services.PublishService;

@Service
public class PublishServiceImpl implements PublishService {
	private PublishRepository publishrepository;
	public PublishServiceImpl(PublishRepository publishRepository) {
		super();
		this.publishrepository = publishRepository;
	}

	@Override
	public Publish savePublish(Publish publish) {
		
		return publishrepository.save(publish);
	}

	@Override
	public List<Publish> getAllPublish() {
		
		return publishrepository.findAll();
	}

	@Override
	public void deletePublish(long id) {
		publishrepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Publish", "Id", id));
		publishrepository.deleteById(id);
		
	}

	@Override
	public Publish getPublishById(Long id) {
	Optional<Publish> publish = publishrepository.findById(id);
	if(publish.isPresent()) {
		return publish.get();
	}else {
		throw new ResourceNotFoundException("Publish", "Id", id);
	}
		
	}

	@Override
	public Publish updatePublish(Publish publish, long id) {
		Publish existingPublish = publishrepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Publish", "Id", id));
		
		existingPublish.setName(publish.getName());
		existingPublish.setPublisher(publish.getPublisher());
		existingPublish.setTittle(publish.getTittle());
		existingPublish.setType(publish.getType());
		existingPublish.setDescriction(publish.getDescriction());
		existingPublish.setDate(publish.getDate());
		existingPublish.setDocument(publish.getDocument());
		publishrepository.save(existingPublish);
		return existingPublish;
	}

	

	

}

package Com.sonu.publish.services;

import java.util.List;

import Com.sonu.publish.model.Publish;

public interface PublishService {
	
	Publish savePublish(Publish publish);
	List<Publish>getAllPublish();
	Publish getPublishById(Long id);
	Publish updatePublish(Publish publish,long id);
	void deletePublish(long id);

}

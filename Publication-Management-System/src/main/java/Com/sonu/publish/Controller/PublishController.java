package Com.sonu.publish.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Com.sonu.publish.model.Publish;
import Com.sonu.publish.services.PublishService;

@RestController
@RequestMapping("/publish")
public class PublishController {
	
	private PublishService publishService;
	public PublishController(PublishService publishService) {
	super();
	this.publishService = publishService;
	}
    @PostMapping
	public ResponseEntity<Publish>savePublish(@RequestBody Publish publish){
	return new ResponseEntity<Publish>(publishService.savePublish(publish),HttpStatus.CREATED);
	}
    @GetMapping
    public List<Publish>getAllPublish(){
    	return publishService.getAllPublish();
    }
   @GetMapping("{id}")
   public ResponseEntity<Publish>GetPublishById(@PathVariable("id")Long publishId){
   	 return new ResponseEntity<Publish>(publishService.getPublishById(publishId),HttpStatus.OK);
   }
   @PutMapping("{id}")
   public ResponseEntity<Publish>updatePublish(@PathVariable("id") long id,@RequestBody Publish publish){
	   return new ResponseEntity<Publish>(publishService.updatePublish(publish, id),HttpStatus.OK);
   }
   
    @DeleteMapping("{id}")
   public ResponseEntity<String>deletePublish(@PathVariable("id")long id){
	   publishService.deletePublish(id);
	   return new ResponseEntity<String>("Publish deleted sucessfully..!",HttpStatus.OK);
   }
    
    
}

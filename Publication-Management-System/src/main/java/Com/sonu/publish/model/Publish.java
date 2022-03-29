package Com.sonu.publish.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publish")
public class Publish {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String publisher;
	private String tittle;
	private String type;
	private String descriction;
	private String date;
	private String document;
	
	public Publish() {
		
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String getTittle() {
		return tittle;
	}



	public void setTittle(String tittle) {
		this.tittle = tittle;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getDescriction() {
		return descriction;
	}



	public void setDescriction(String descriction) {
		this.descriction = descriction;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getDocument() {
		return document;
	}



	public void setDocument(String document) {
		this.document = document;
	}



	public Publish(Long id, String name, String publisher, String tittle, String type, String descriction, String date,
			String document) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.tittle = tittle;
		this.type = type;
		this.descriction = descriction;
		this.date = date;
		this.document = document;
	}
	
	
	
	

}

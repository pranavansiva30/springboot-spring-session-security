package com.wavesdev.session.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="role")
@XmlRootElement
public class Role extends BaseObject{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String description;
	
	@Id
   	@GeneratedValue(strategy = IDENTITY)
   	@Column(name = "role_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "name",unique = true, nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

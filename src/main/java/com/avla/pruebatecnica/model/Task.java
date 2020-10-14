package com.avla.pruebatecnica.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String task_name;
	private String task_type;
	private String description;
	private Integer duration_hours;
	private String start_date;
	private String end_date;	
	private boolean mark;
	private boolean process;
	
	  @JoinTable(
	            name = "users_tasks",
	            joinColumns = @JoinColumn(name = "id_task", nullable = false),
	            inverseJoinColumns = @JoinColumn(name="id_user", nullable = false)
	        )
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JsonIgnore //ignora el bucle infinito
	private User users;
	/*@ManyToOne
	@JoinColumn(name="id_user")
	@JsonIgnore
	
	private User users;*/
	
}

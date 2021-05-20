package com.spring.boot.postgres.demo.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.spring.boot.postgres.demo.beans.OrdersBean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Orders")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String orderName;
	private String orderDescription;

	@OneToOne
	private Person personId;

}

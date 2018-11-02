package com.domain.ecommerce.customer.item;

import com.domain.ecommerce.customer.category.Category;
import com.domain.ecommerce.customer.model.BeanModel;
import com.domain.ecommerce.customer.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item extends BeanModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
    @Size(max = 100)
	private String name;
	private String description;
	private String price;
	private String countryMade;
	private String image;
	@NotNull
    @Size(max = 100)
	private String status;// New-like New-old
	private int rating;// 5 Stars
	private String tag;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id", nullable = false)// declare the foreign key column.
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Category category;
}

/* @(#)User 1.0 19/06/2017
 * Copyright (c) 2017, Embraer. All rights reserved. Embraer S/A
 * proprietary/confidential. Use is subject to license terms.
 */
package org.pedrohrr.ecomm.ecommerce.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * PRODUCT Entity
 */
@Data
@Entity(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;

}
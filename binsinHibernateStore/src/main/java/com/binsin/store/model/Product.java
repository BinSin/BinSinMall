package com.binsin.store.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 5089069556421543019L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MySQL에서는 AUTO로 주면 TABLE로 설정이 된다. 이 경우 Sequence number를 저장하는 테이블을 만든다.
	@Column(name="product_id")						  // IDENTITY로 설정하면 auto_increment로 설정하여 sequence number 테이블을 만들지 않아 퍼포먼스에 좋다.
	private int id;
	
	@NotEmpty(message="The product name must not be null")
	private String name;
	
	private String category;
	
	@Min(value=0, message="The product price must not e less than zero")
	private int price;
	
	@NotEmpty(message="The product manufacturer must not be null")
	private String manufacturer;
	
	@Min(value=0, message="The product unitInStock must not be less than zero")
	private int unitInStock;
	
	private String description;
	
	// DB에 실제로 저장하지 않고 file system에 저장한다.
	// Tomcat(8080) -> MySQL(3306), Image Server or Directory
	@Transient
	private MultipartFile productImage;
	
	// DB에는 이미지가 저장된 경로만 저장
	private String imageFilename;
	
}

package testHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="product")
public class Product {

	@Id // DB 레코드의 primary key 임을 명시
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 주키의 값을 위한 자동 생성 전략을 명시하는데 사용
	@Column(name="product_id")
	private int id;
	
	private String name;
	
	private int price;	
	
	private String description;
	
	// product 가 many 쪽
	// @ManyToOne(cascade=CascadeType.ALL) // 연관된 객체 persist, delete 같이 적용
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
}
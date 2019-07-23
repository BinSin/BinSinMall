package com.binsin.store.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Serialization : Object -> Byte Stream 으로 변환
// De-Serialization : Byte Stream -> Object 로 변환
// 네트워크를 통해 객체를 전달하려면 이러한 변환 과정이 필요하다.
// Object -> Byte Stream -> File, DB, Memory -> Byte Stream -> Object
// 여기서는 Object -> JSON(Byte Stream) 형식으로 변환한다.

@Getter
@Setter
@ToString
@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = -6107619654313164876L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	// mappedBy
	// 주인(Cart)은 mappedBy 속성을 사용하지 않습니다.
	// 주인이 아니면(CartItem) mappedBy 속성을 사용해서 속성의 값으로 연관관계의 주인을 정할 수 있습니다.
	//
	// fetch
	// OneToMany : lazy (여러 데이터를 합쳐 가져오면 성능에 문제가 생겨서 lazy)
	// ManyToOne : eager (하나만 가져오기 때문에 eager로 해도 무방하다)
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	private double grandTotal;
}

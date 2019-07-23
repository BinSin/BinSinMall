package com.binsin.store.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Serialization : Object -> Byte Stream 으로 변환
// De-Serialization : Byte Strea -> Object 로 변환
// 네트워크를 통해 객체를 전달하려면 이러한 변환 과정이 필요하다.
// Object -> Byte Stream -> File, DB, Memory -> Byte Stream -> Object
// 여기서는 Object -> JSON(Byte Stream) 형식으로 변환한다.

@Getter
@Setter
@ToString
@Entity
public class Cart implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	private double grandTotal;
}

package testHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	// fetch
	// Eager(즉시 로딩) : 엔티티를 조회할 때 자신과 연관되는 엔티티를 조인( join )을 통해 함께 조회하는 방식
	// Lazy(지연 로딩) : 신과 연관된 엔티티를 실제로 사용할 때 연관된 엔티티를 조회( SELECCT )하는 방식
	// 성능 면에서 지연 로딩을 사용하는 것이 더 좋기 때문에 애플리케이션 개발 시 모두 지연 로딩으로 한 뒤에, 성능 최적화가 필요한 부분을 즉시 로딩으로 바꿔주면 좋을 것
	@OneToMany(mappedBy = "category", cascade=CascadeType.ALL, fetch=FetchType.LAZY) // LAZY : 필요할 때만 Product 읽음 -> performance에 좋다.
	private Set<Product> products = new HashSet<Product>();
}

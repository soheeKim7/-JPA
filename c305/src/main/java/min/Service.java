package min;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//CRUD 생성
public class Service {
	
	static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("db1");

	
	//읽기
	public static Optional<User> read(String id){ //키를 이용해서 읽어오는데 없을수도 있으니까 Optional 객체를 이용해서 리턴해줘야함!
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User user=entityManager.find(User.class, id);
		entityManager.close();
		return Optional.ofNullable(user);  //null로 리턴안시키려고 Optional을 쓴거야! null이면 빈user객체로 리턴됨!
	}
	
	//저장
	public void save(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		//동일한게 있는지 확인
		User founduser=entityManager.find(User.class, user.getId());

		
		
	}
	
	
	
	
}

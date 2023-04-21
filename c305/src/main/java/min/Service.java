package min;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.DuplicateMappingException;

//CRUD 생성
public class Service {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db1");

	// 읽기
	public static Optional<User> read(String id) { // 키를 이용해서 읽어오는데 없을수도 있으니까 Optional 객체를 이용해서 리턴해줘야함!
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User user = entityManager.find(User.class, id);
		entityManager.close();
		return Optional.ofNullable(user); // null로 리턴안시키려고 Optional을 쓴거야! null이면 빈user객체로 리턴됨!
	}

	// 저장
//	public void save(User user) {
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction=entityManager.getTransaction();
//		
//		//동일한게 있는지 확인
//		User foundUser=entityManager.find(User.class, user.getId());
//
//		if(foundUser !=null) {
//			throw new DuplicateMappingException("앞은","뒤는");			
//		}
//		try {
//			entityTransaction.begin();
//			entityManager.persist(user);
//			entityTransaction.commit();
//		}catch(Exception e) {
//			entityTransaction.rollback();
//		}
//		entityManager.close();		
//	}

	// 저장, 업데이트
	public static void save(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		try {
			entityTransaction.begin();
			//동일한게 있는지 확인
			User foundUser=entityManager.find(User.class, user.getId());  //db에 있는지 확인해서 그 객체를 가져오는겨! find!
		
			if(foundUser !=null) {    //이미 있는거니까 수정해주기~
				foundUser.setPw(user.getPw());		
//				foundUser.setId("du");   //이렇게 추가하면, ID 키값이라서 안됨  //JPA는 기본키 변경 안됨
				//기본적으로도 키값은 변경 잘 안함!
				//만약 키값 바꾸려면, 그내용을 읽어놓고, 그내용은 삭제하고, 변경된 내용을 추가해서 새로 생성해주면 됨
				
			}else {   				 //없는거니까 새로 넣어주기~
				entityManager.persist(user);
			}			
			entityTransaction.commit();
		}catch(Exception e) {
			entityTransaction.rollback();
		}
		entityManager.close();		
	}

}

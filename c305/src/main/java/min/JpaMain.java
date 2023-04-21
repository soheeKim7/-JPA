package min;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		//JPA 사용법
		//1. EntityManagerFactory 객체 생성 (persistence.xml로 부터 persistence 단위별로 팩토리 생성) / (Persistence 객체를 이용해서)
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("db1");
		
		//2. EntityManager 객체 생성 (Persistence Context와 Entity를 관리) / (entityManagerFactory 객체를 이용해서)
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		//3. EntityTransaction 객체 생성 (트랜잭션을 관리하기 위해서) / (entityManager 객체를 이용해서) 
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		//예> DB조작(insert) 삽입
		try {
			entityTransaction.begin();  //트랜잭션을 시작해야 DB조작 가능
			
			System.out.println("--------------------삽입-----------------------------");
			User user = new User("aaa","1234");  //저장하고 하는 Entity 객체를 생성
			//try catch 안에서 만든거라서 지역변수!! 이거하고 사라짐!! 그래서 매번 새롭게 만드는 꼴!!
			
			//여기가 중요!!!
			entityManager.persist(user);  //User Entity를 persistence Context(EntityManger가 관리하는 공간)에 추가!
			
			System.out.println("--------------------수정-----------------------------");
			
//			user.setPw("aaaa");
			
			
			entityTransaction.commit();  //실제 DB반영			
			//이렇게 객체만 만들어주고, 커밋하면 알아서 db와 비교해서 반영 해줌!
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();  //문제가 생기면 트랜잭션 롤백
		}
//		finally {   //엔티티매니저 밑에서 계속 써야해서!! 밑에서 닫을거야~~
//			entityManager.close();
//		}
		
//		
//		//예> DB조작(update) 수정
//		try {
//			entityTransaction.begin();  //트랜잭션을 시작해야 DB조작 가능
//			
//			User user = new User("aaa","4568");  //저장하고 하는 Entity 객체를 생성
//			//다시 새롭게 만들어진겨!! 근데 키값이 겹쳐서!! 오류가 뜸!
//			
//			//여기가 중요!!!
//			entityManager.persist(user);  //User Entity를 persistence Context(EntityManger가 관리하는 공간)에 추가! 
//			
//			entityTransaction.commit();  //실제 DB반영			
//			//이렇게 객체만 만들어주고, 커밋하면 알아서 db와 비교해서 반영 해줌!
//		}catch(Exception e) {
//			e.printStackTrace();
//			entityTransaction.rollback();  //문제가 생기면 트랜잭션 롤백
//		}finally {
//			entityManager.close();
//		}
		
		
	}

}

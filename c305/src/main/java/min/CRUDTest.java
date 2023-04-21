package min;

import java.util.Optional;

public class CRUDTest {

	public static void main(String[] args) {
		/*
		//읽기 테스트
		Optional<User> ouser =Service.read("aaa5");
		if(ouser.isPresent()) { //isPresent null값이 있는지 확인 /존재할때 수행!
			User user=ouser.get();
			System.out.println("출력되는거 보자 : "+user);			
		}
		System.out.println("없다");
		*/
		
		//쓰기,업데이트
		Service.save(new User("cccc","233"));
		
		
		
	}

}

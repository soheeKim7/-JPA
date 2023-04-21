package min;

import javax.persistence.Entity;
import javax.persistence.Id;

//Entity 객체 : 필수조건 1.@Id가 꼭 있어야 된다. 2.기본생성자가 꼭 있어야 된다!
@Entity
//@Table(name="min_user")
public class User {
	
	@Id
	private String id;
	
//	@Column //특별한 조건 안정해주면 그냥 생략하면 알아서 컬럼으로 만들어줌
	private String pw;

	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	

}

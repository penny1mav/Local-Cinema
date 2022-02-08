package net.services.registration.model;
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    protected int id;

	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	public User() {}

    public User(String username) {
        super();
        this.username = username;
        
      
    }
    public User(int id,String username ) {
        super();
        this.username = username;
        this.id=id;
      
    }
	
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

// Student.java
import javax.persistence.*;

@Entity
@Table(name = "students")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "first_name")
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name = "email")
	public String email;

	// Constructors, getters, and setters (not shown for brevity)
}
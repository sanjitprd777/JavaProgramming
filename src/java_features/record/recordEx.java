package java_features.record;

/*
✅ Why Use Records?
- Reduces Boilerplate Code (No need for explicit getters, constructors, equals(), hashCode(), etc.)
- Immutable by Default (Fields are final and cannot be changed after creation)
- Good for Data-Transfer Objects (DTOs), Value Objects, and API Responses
- Automatic Implementations of toString(), equals(), and hashCode()

✅ Limitations of Records
- Cannot Extend Other Classes (Records are implicitly final).
- Cannot Modify Fields (Fields are final by default).
- Only Implements Interfaces, No Extending Other Classes.

📌 When to Use Records?
✅ Best For: DTOs (Data Transfer Objects), API Responses, Immutable Data Objects
❌ Avoid If You Need: Mutable Objects, Complex Inheritance
*/

public class recordEx {

	record Person(String name, int age) {
	}

	// Record class with constructor
	record Employee(String name, double salary) {
		// Custom constructor with validation
		public Employee {
			if (salary < 0) {
				throw new IllegalArgumentException("Salary cannot be negative");
			}
		}
	}

	// Record class with function
	record Rectangle(int length, int width) {
		public int area() {
			return length * width;
		}
	}

	public static void main(String[] args) {
		Person person = new Person("John", 30);
		System.out.println(person.name());

		Employee employee = new Employee("John", 30);
		System.out.println(employee.name());
//		Employee employee1 = new Employee("John", -1); -> Throws exception

		Rectangle rect = new Rectangle(5, 10);
		System.out.println(rect.area());  // Output: 50
	}
}

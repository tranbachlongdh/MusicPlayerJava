
public class Composer {
	private String name;
	private int age;
	private boolean isGroup = false;
	
	public Composer(String name) {
		this(name, 0, false);
	}
	
	public Composer(String name, int age, boolean isGroup) {
		this.name = name;
		this.age = age;
		this.isGroup = isGroup;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setIsGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}
	
	
	

}

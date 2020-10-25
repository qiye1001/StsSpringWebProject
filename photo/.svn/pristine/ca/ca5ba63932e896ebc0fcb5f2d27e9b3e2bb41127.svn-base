package LibraryManager;

public class StudentManagerSystem {
	
	StudentManager root;
	
	public void add(int id, String name) {
		if(root != null) {
			root.next.addStudentManager(id, name);
		} else {
			root = new StudentManager(id, name);
		}
	}
	public void delete() {}
	public void print() {}
	public void update() {}
	
	private class StudentManager{
		private int id;
		private String name;
		private StudentManager next;
		
		public StudentManager() {
			
		}
		
		public StudentManager(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public void addStudentManager(int id, String name) {
			if(this.next != null) {
				this.next.addStudentManager(id, name);
			} else {
				this.next = new StudentManager(id, name);
			}
		}
		
		public void deleteStudentManager() {
			
		}
		
		public void updateStudentManager() {
			
		}
		
		public void printAll() {
			
		}
	}
}

package StudentManagementSystem;

public class BinaryTree_StudentManagermentSystem {
	private StudentInformation2 root;

	// ÃÌº”
	public void add(StudentInformation date) {
		if (root == null) {
			root = new StudentInformation2(date);
		} else {
			root.addStudentInformation(date);
		}
	}

	// …æ≥˝
	public void delete(int id) {
		if (root != null) {
			if (root.date.getId() == id) {
				root = root.right;
			} else {
				root.deleteStudentInformation(id);
			}
		}
	}

	// ≤È’“
	public StudentInformation find(int id) {
		if (root.date.getId() == id) {
			return root.date;
		} else {
			return root.findStudentInformateion(id);
		}
	}
	
	public void update(StudentInformation date) {
		if (root.date == date) {
			root.date.setId(date.getId());
			root.date.setName(date.getName());
			root.date.setAge(date.getAge());
			root.date.setSex(date.getSex());
		} else {
			root.updateStudentInformation(date);
		}
	}

	// ¥Ú”°
	public void print() {
		if (root != null) {
			root.printAll();
		}
	}

	private class StudentInformation2 {
		private StudentInformation2 left;
		private StudentInformation2 right;
		private StudentInformation date;

		public StudentInformation2(StudentInformation date) {
			this.date = date;
		}

		// ÃÌº”
		public void addStudentInformation(StudentInformation date) {
			if (date.getId() < this.date.getId()) {
				if (this.left == null) {
					this.left = new StudentInformation2(date);
				} else {
					this.left.addStudentInformation(date);
				}
			} else {
				if (this.right == null) {
					this.right = new StudentInformation2(date);
				} else {
					this.right.addStudentInformation(date);
				}
			}
		}

		public void updateStudentInformation(StudentInformation date) {
			if(date.getId() < this.date.getId()) {
				if(this.left != null) {
					if(this.left.date.getId() == date.getId()) {
						this.left.date = date;
					} else {
						this.left.updateStudentInformation(date);
					}
				}
			} else {
				if (this.right != null) {
					if (this.left.date.getId() == date.getId()) {
						this.right.date = date;
					} else {
						this.right.updateStudentInformation(date);
					}
				}
			}
		}
		
		// …æ≥˝
		public void deleteStudentInformation(int id) {
			boolean isID = id < this.date.getId();
			System.out.println(isID);
			if (id < this.date.getId()) {
				if (this.left != null) {
					if (this.left.date.getId() != id) {
						this.left.deleteStudentInformation(id);
					} else {
						this.left = this.left.left;
					}
				}
			} else {
				System.out.println(this.right == null);
				if (this.right != null) {
					if (this.right.date.getId() != id) {
						this.right.deleteStudentInformation(id);
					} else {
						this.right = this.right.right;
					}
				}
			}
		}

		// ≤È’“
		public StudentInformation findStudentInformateion(int id) {
			if (id < this.date.getId()) {
				if (this.left != null) {
					if (this.left.date.getId() == id) {
						return this.left.date;
					} else {
						this.left.findStudentInformateion(id);
					}
				}
			} else {
				if (this.right != null) {
					if (this.right.date.getId() == id) {
						return this.right.date;
					} else {
						this.right.findStudentInformateion(id);
					}
				}
			}
			
			return null;
		}

		// ¥Ú”°
		public void printAll() {
			if (this.left != null) {
				this.left.printAll();
			}
			System.out.println(this.date);
			if (this.right != null) {
				this.right.printAll();
			}
		}
	}
}

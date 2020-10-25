package Enum;

public enum Color implements Info{
	BLUE(10) {
		@Override
		public String getColor2() {
			return "blue";
		}
	}, RED {
		@Override
		public String getColor2() {
			return "red";
		}
	}, GREEN(22) {
		@Override
		public String getColor2() {
			return "green";
		}
	};
	
	private int color;
	
	private Color() {
		System.out.println("无参构造器");
	}
	
	private Color(int color) {
		this.color = color;
	}

	@Override
	public int getColor() {
		return color;
	}
	
	public abstract String getColor2();
}

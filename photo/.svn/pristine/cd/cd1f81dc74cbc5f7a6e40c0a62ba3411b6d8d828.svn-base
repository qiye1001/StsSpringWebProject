package photo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {
	public static void main(String[] args) {
		new DateFormatDemo();

	}

	public DateFormatDemo() {
		DateFormat time = DateFormat.getDateInstance(1);
		DateFormat time2 = DateFormat.getDateTimeInstance(1, 1);
		String d1 = time.format(new Date());
		String d2 = time.format(DateFormat.FULL);

		String d3 = time2.format(new Date());

		DateFormat df = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’ HH:mm:ss");
		System.out.println(df.format(new Date()));

		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);

	}
}

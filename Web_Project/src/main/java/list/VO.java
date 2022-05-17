package list;

import lombok.Data;

@Data
public class VO {
	private String pic,giup_name,giup_title,giup_location,working_day,working_time;

	public VO(String pic, String giup_name, String giup_title, String giup_location, String working_day,
			String working_time) {
		super();
		this.pic = pic;
		this.giup_name = giup_name;
		this.giup_title = giup_title;
		this.giup_location = giup_location;
		this.working_day = working_day;
		this.working_time = working_time;
	}

	public VO() {
		super();
	}
	
	
	
	
}

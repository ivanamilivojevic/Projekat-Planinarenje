package planinarenje;

import java.util.Date;

public class PlaninaZaZbirku {
	private Planina planina;
	private Date datum;
	
	public PlaninaZaZbirku(Planina planina, Date datum) {
		super();
		this.planina = planina;
		this.datum = datum;
	}
	
	public Planina getPlanina() {
		return planina;
	}
	public Date getDatum() {
		return datum;
	}
	
	
}

package util.javabasic.sql;

public enum TestEnum {
	ANHOUR("anhour", 1800), 
	ADAY("aday", 86400), 
	AWEEK("aweek", 604800), 
	TWOWEEKS("twoweeks", 1209600), 
	AMONTH("amonth", 2592000);

	private String period;
	private int seconds;

	private TestEnum(String period, int seconds) {
		this.period = period;
		this.seconds = seconds;
	}

	public String getPeriod() {
		return period;
	}

	public int getSeconds() {
		return seconds;
	}
	
	public static void main(String[] args) {
		System.out.println(TestEnum.values()[0].getPeriod());
		System.out.println(TestEnum.valueOf("ANHOUR").period);
		for(TestEnum per:TestEnum.values()){
			if(per.getSeconds() == 604800){
				System.out.println(per.period);
			}
		}
	}
}

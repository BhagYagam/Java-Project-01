class Contact{
	private String id;
	private String name;
	private String pnum;
	private double salary;
	private String bday;
	private String coname;

	Contact(String id, String name, String pnum, double salary, String coname, String bday){
		this.id=id;
		this.name=name;
		this.pnum=pnum;
		this.coname=coname;
		this.salary=salary;
		this.bday=bday;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.pnum=pnum;
	}
	
	public void setCompanyName(String companyName){
		this.coname=coname;
	}
	
	public void setSalary(double salary){
		this.salary=salary;
	}
	
	public void setBirthday(String birthday){
		this.bday=bday;
	}
	
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getPnum(){
		return pnum;
	}
	public String getConum(){
		return coname;
	}
	public double getSalary(){
		return salary;
	}
	public String getBirthday(){
		return bday;
	}
}

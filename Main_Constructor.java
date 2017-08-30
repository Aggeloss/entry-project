public class Main_Constructor {
	
	private String Country;
	private String Contact;
	private String Name;
	private String Add1;
	private String Add2;
	private String Add3;
	private String City;
	private String Postal_Code;
	
	Main_Constructor(String Contact ,
					 String Country ,
					 String Name,
					 String Add1,
					 String Add2,
					 String Add3,
					 String City,
					 String Postal_Code) {
						
		Contact = this.Contact;
	    Country = this.Country;
	    //Date    = this.Date;
	    //ID      = this.ID;
	    Name    = this.Name;
	    Add1    = this.Add1;
	    Add2    = this.Add2;
	    Add3    = this.Add3;
	    City    = this.City;
		//Service = this.Service;
		//Content = this.Content;
		Postal_Code = this.Postal_Code;
		
	}
	
	Main_Constructor() {
		
		Contact = this.Contact;
	    Country = this.Country;
	    //Date    = this.Date;
	    //ID      = this.ID;
	    Name    = this.Name;
	    Add1    = this.Add1;
	    Add2    = this.Add2;
	    Add3    = this.Add3;
	    City    = this.City;
		//Service = this.Service;
		//Content = this.Content;
		Postal_Code = this.Postal_Code;
		
	}
	
	public void setContact(String contact) {
		
		Contact = contact;
		
	}
	
	public String getContact() {
		
		return Contact;
		
	}
	
	public void setCountry(String country) {
		
		Country = country;
		
	}
	
	public String getCountry() {
		
		return Country;
		
	}
	
	/*public void setDate(String date) {
		
		Date = date;
		
	}
	
	public String getDate() {
		
		return Date;
		
	}
	
	public void setID(String barcode) {
		
		ID = barcode;
		
	}
	
	public String getID() {
		
		return ID;
		
	}*/
	
	public void setAdd1(String add1) {
		
		Add1 = add1;
		
	}
	
	public String getAdd1() {
		
		return Add1;
		
	}
	
	public void setAdd2(String add2) {
		
		Add2 = add2;
		
	}
	
	public String getAdd2() {
		
		return Add2;
		
	}
	
	public void setAdd3(String add3) {
		
		Add3 = add3;
		
	}
	
	public String getAdd3() {
		
		return Add3;
		
	}
	
	public void setCity(String city) {
		
		City = city;
		
	}
	
	public String getCity() {
		
		return City;
		
	}
	
	public void setName(String name) {
		
		Name = name;
		
	}
	
	public String getName() {
		
		return Name;
		
	}
	
	public void setPostal_Code(String postal_code) {
		
		Postal_Code = postal_code;
		
	}
	
	public String getPostal_Code() {
		
		return Postal_Code;
		
	}
	
	/*public void setService(String service) {
		
		Service = service;
		
	}
	
	public String getService() {
		
		return Service;
		
	}
	
	public void setContent(String content) {
		
		Content = content;
		
	}
	
	public String getContent() {
		
		return Content;
		
	}*/
	
	protected static String Service;
	protected static String Content;
	protected static String Date;
	protected static String ID;
	
}

package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker=new Faker();
	public String generatefirstname() {
return faker.name().firstName();
	}

public String generateLastName()
{
	return faker.name().lastName();
}
public String addresss()
{
	return faker.address().fullAddress();
}
public String phonenumber()
{
	return  faker.phoneNumber().toString();
}
public long generaterandomnumber()
{
	return faker.number().randomNumber();
	
}
public String genaratejob()
{
	return faker.job().field();
	
}
public String generateemail() {
	return faker.internet().emailAddress();
}
public String generaterandomdigit() {
	return faker.number().digit();
}

}
	


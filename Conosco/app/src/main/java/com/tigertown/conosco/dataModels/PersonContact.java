package com.tigertown.conosco.dataModels;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.db.external.*;

public class PersonContact implements IPersonContact
{
    private ContactProvider externalProvider;
	private Integer id;
	private Integer type;
	private String value;
	
	public PersonContact(Integer id, Integer t, String v) {
		this.id = id;
		this.type = t;
		this.value = v;
        externalProvider = new ContactProvider();
	}

	public Integer getId()
	{
		return id;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

	public Integer getType()
	{
		return type;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
    
    public Uri getThumbnail()
    {
        return externalProvider.getContactImage(value);
    }
}

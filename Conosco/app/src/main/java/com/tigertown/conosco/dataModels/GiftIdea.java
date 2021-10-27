package com.tigertown.conosco.dataModels;
import com.tigertown.conosco.global.modelInterfaces.*;

public class GiftIdea implements IGiftIdea {
    public int personid;
    public String value;

    public GiftIdea(int p, String v) {
        this.personid = p;
        this.value = v;
    }

	public void setPersonid(int personid)
	{
		this.personid = personid;
	}

	public int getPersonid()
	{
		return personid;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
}

package com.tigertown.conosco.dataModels;
import com.tigertown.conosco.global.modelInterfaces.*;
import java.util.*;

public class Person implements IPerson
{
    private Integer id;
	private String name;
    private String howMet;
    private String hometown;
    private String residence;
    private String job;
    private String imageFile;
    private String interests;
    private String notes;
	//private List<IAnniversary> anniversaries;
	//private List<IGiftIdea> giftIdeas;

	//public void setGiftIdeas(List<IGiftIdea> giftIdeas)
	//{
	//	this.giftIdeas = giftIdeas;
	//}

	//public List<IGiftIdea> getGiftIdeas()
	//{
	//	return giftIdeas;
	//}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setHometown(String hometown)
	{
		this.hometown = hometown;
	}

	public String getHometown()
	{
		return hometown;
	}

	public void setResidence(String residence)
	{
		this.residence = residence;
	}

	public String getResidence()
	{
		return residence;
	}

	public void setJob(String job)
	{
		this.job = job;
	}

	public String getJob()
	{
		return job;
	}

	public void setImageFile(String imageFile)
	{
		this.imageFile = imageFile;
	}

	public String getImageFile()
	{
		return imageFile;
	}

	public void setInterests(String interests)
	{
		this.interests = interests;
	}

	public String getInterests()
	{
		return interests;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	public String getNotes()
	{
		return notes;
	}

	public Integer getId()
	{
		return id;
	}

	public String getHowMet()
	{
		return howMet;
	}

	public void setHowMet(String howMet)
	{
		this.howMet = howMet;
	}

	public Person()
	{}

    public Person(Integer i, String h, String ht, String r, String j, String im, String in, String n, String name)//, List<IGiftIdea> gi)
	{
        this.id = i;
		this.name = name;
        this.howMet = h;
        this.hometown = ht;
        this.residence = r;
        this.job = j;
        this.imageFile = im;
        this.interests = in;
        this.notes = n;
		//this.anniversaries = a;
		//this.giftIdeas = gi;
    }

    public Person(String h, String ht, String r, String j, String im, String i, String n, String name)//, List<IGiftIdea> gi)
	{
        this(null, h, ht, r, j, im, i, n, name);//, gi);
    }
}

package com.tigertown.conosco.global.modelInterfaces;
import java.util.*;

public interface IPerson
{
	public void setHometown(String hometown);
	public String getHometown();
	public void setResidence(String residence);
	public String getResidence();
	public void setJob(String job);
	public String getJob();
	public void setImageFile(String imageFile);
	public String getImageFile();
	public void setInterests(String interests);
	public String getInterests();
	public void setNotes(String notes);
	public String getNotes();
	public Integer getId();
	public String getHowMet();
	public void setHowMet(String howMet);
	//public void setAnniversaries(List<IAnniversary> anniversaries);
	//public List<IAnniversary> getAnniversaries();
	public String getName();
	public void setName(String name);
	//public void setGiftIdeas(List<IGiftIdea> giftIdeas);
	//public List<IGiftIdea> getGiftIdeas();
}

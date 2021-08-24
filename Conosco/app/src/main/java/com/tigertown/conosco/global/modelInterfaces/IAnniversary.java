package com.tigertown.conosco.global.modelInterfaces;
import java.time.*;

public interface IAnniversary
{
	public Integer getId();
	public String getType();
	public void setType(String s);
	public LocalDate getDate();
	public void setDate(LocalDate d);
	public Boolean getNotify();
	public void setNotify (Boolean n);
}

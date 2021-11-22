package com.tigertown.conosco.global.modelInterfaces;
import java.time.*;
import java.util.*;

public interface IPersonContact
{
	public Integer getId();
	public int getType();
	public void setType(int t);
	public String getValue();
	public void setValue(String v);
}

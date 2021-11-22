package com.tigertown.conosco.global.modelInterfaces;
import java.time.*;
import java.util.*;

public interface IPersonContact
{
	public Integer getId();
	public Integer getType();
	public void setType(Integer t);
	public String getValue();
	public void setValue(String v);
}

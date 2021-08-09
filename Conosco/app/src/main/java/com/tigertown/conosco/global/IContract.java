package com.tigertown.conosco.global;
import java.util.*;
import android.util.*;

public interface IContract
{
	public String GetName();
	public List<Pair<String, String>> GetColumns();
	public String GetPrimaryKey();
	public List<ForeignKey> GetForeignKeys();
}

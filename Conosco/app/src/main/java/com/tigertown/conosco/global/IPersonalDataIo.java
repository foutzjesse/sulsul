package com.tigertown.conosco.global;
import java.util.*;

public interface IPersonalDataIo<T>
{
	List<T> read(int id);
}

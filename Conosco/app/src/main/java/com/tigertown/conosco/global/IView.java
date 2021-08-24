package com.tigertown.conosco.global;
import java.util.*;

public interface IView<T>
{
	void load(T data);
	void update(T data);
}

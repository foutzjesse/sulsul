package com.tigertown.conosco.db.io;
import java.util.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;
import android.database.*;

public abstract class SingleColumnIoClient extends IoClientBase<String>
{

	@Override
	public String convertRow(Cursor c) {
		return c.getString(0);
	}
}

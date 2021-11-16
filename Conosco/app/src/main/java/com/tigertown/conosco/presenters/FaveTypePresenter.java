package com.tigertown.conosco.presenters;
import com.tigertown.conosco.db.io.*;
import com.tigertown.conosco.db.contracts.*;
import com.tigertown.conosco.global.*;

public class FaveTypePresenter extends StringPresenter<FaveTypesIoClient>
{
	public FaveTypePresenter(IView<String> v) {
		super(v, new FaveTypesIoClient(), FaveTypes.NAME);
	}
}

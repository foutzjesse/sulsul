package com.tigertown.conosco.presenters;
import com.tigertown.conosco.db.io.*;
import com.tigertown.conosco.db.contracts.*;
import com.tigertown.conosco.global.*;

public class AnniversaryTypePresenter extends StringPresenter<AnniversaryTypesIoClient>
{
	public AnniversaryTypePresenter(IView<String> v) {
		super(v, new AnniversaryTypesIoClient(), AnniversaryTypes.NAME);
	}
}

package com.tigertown.conosco.views;
import com.tigertown.conosco.presenters.*;
public class AnniversaryTypeEdit extends StringEdit<AnniversaryTypePresenter>
{

	@Override
	protected AnniversaryTypePresenter getPresenter()
	{
		return new AnniversaryTypePresenter(this);
	}
}

package com.tigertown.conosco.views;
import com.tigertown.conosco.presenters.*;
public class FaveTypeEdit extends StringEdit<FaveTypePresenter>
{

	@Override
	protected FaveTypePresenter getPresenter()
	{
		return new FaveTypePresenter(this);
	}
}

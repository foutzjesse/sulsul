package com.tigertown.conosco.presenters;
import com.tigertown.conosco.global.*;

public abstract class PresenterBase<T>
{
	protected T record;
	protected IView<T> view;
	
	public PresenterBase(IView<T> v) {
		this.view = v;
	}
	
	public void presentData() {
		view.load(record);
	}
	
	public abstract void save();
	
	//public abstract void update();
}

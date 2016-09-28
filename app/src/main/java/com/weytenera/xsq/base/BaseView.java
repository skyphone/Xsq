package com.weytenera.xsq.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;


/**
 * 基础自定义view
 *
 *  <br/> Description: TODO

 */
public abstract class BaseView extends RelativeLayout {
	
	/** 上下文*/
	protected Context context;
	/** 父视图*/
	protected View view_Parent;

	public BaseView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		inflaterView(context);
	}

	public BaseView(Context context, AttributeSet attrs) {
		super(context, attrs);
		inflaterView(context);
	}

	public BaseView(Context context) {
		super(context);
		inflaterView(context);
	}
	
	
	/**
	 * 初始化
	 *

	 * @param context
	 */
	private void inflaterView(Context context){
		this.context = context;
		view_Parent = LayoutInflater.from(this.context).inflate(getContentViewId(), null);
		this.addView(view_Parent);
		findViews();
		widgetListener();
		init();
	}
	
	/**
	 * 获取显示view的layout id
	 *

	 */
	protected  abstract int getContentViewId();
	
	/**
	 * 控件查找
	 *

	 *
	 */
	protected  abstract void findViews();
	
	/**
	 * 组件监听

	 *
	 */
	protected  abstract void widgetListener();
	
	/**
	 * 初始化

	 *
	 */
	protected  abstract void init();
	

}

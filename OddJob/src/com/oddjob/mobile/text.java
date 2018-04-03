package com.oddjob.mobile;

import java.util.ArrayList;
import java.util.List;

import com.oddjob.biz.WorkTypeBiz;
import com.oddjob.ibiz.IWorkTypeBiz;

public class text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List list = new ArrayList();
		IWorkTypeBiz iwtbiz = new WorkTypeBiz();
		list = iwtbiz.getWorkByName("");
		//list.add(iwtbiz);
		//System.out.println(list);
		
		for(int i = 0; i < list.size(); i++) {
			list.get(i);
			System.out.println(list.get(i));
		}
		
		
	}

}

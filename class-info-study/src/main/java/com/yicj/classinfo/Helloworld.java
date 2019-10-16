package com.yicj.classinfo;

class Hello{
	static {
		System.out.println("Loading Hello");
	}
}


public class Helloworld {
	
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		System.out.println("--------------");
		Class f =  Hello.class ;
		System.out.println("after Hello.class");
		f.newInstance() ;
	}

}

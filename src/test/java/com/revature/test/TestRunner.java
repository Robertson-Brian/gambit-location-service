package com.revature.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.revature.serviceTest.AllTest;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTest.class);
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}

}

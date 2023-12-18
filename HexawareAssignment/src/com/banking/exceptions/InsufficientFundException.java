package com.banking.exceptions;

public class InsufficientFundException extends Exception {
	public InsufficientFundException()
	{
		System.out.println("Insufficient fund constructor");
	}
	
	public String toString()
	{
		return "From IFE() toString()";
	}
}

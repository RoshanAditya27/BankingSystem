package com.banking.exceptions;

public class InvalidAccountException extends Exception {
	public InvalidAccountException()
	{
		System.out.println("");
	}
	
	public String toString()
	{
		return "From IAE toString()";
	}
}

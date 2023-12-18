package com.banking.exceptions;

public class OverDraftLimitExceededException extends Exception {
	public OverDraftLimitExceededException()
	{
		System.out.println("");
	}
	public String toString()
	{
		return "From ODLEE toString()";
	}
}

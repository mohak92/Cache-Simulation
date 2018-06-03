package com.hcl;

import java.util.Arrays;

public class cache_line_t {
	private int validBit;
	private int set;
	private int tag;
	private int datavalues[]=new int[16];
	public int getValidBit() {
		return validBit;
	}
	public void setValidBit(int validBit) {
		this.validBit = validBit;
	}
	public int getSet() {
		return set;
	}
	public void setSet(int set) {
		this.set = set;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public int[] getDatavalues() {
		return datavalues;
	}
	public void setDatavalues(int[] datavalues) {
		this.datavalues = datavalues;
	}
	@Override
	public String toString() {
		return "Cache [validBit=" + validBit + ", set=" + set + ", tag=" + tag
				+ ", datavalues=" + Arrays.toString(datavalues) + "]";
	}
	public cache_line_t(int validBit, int set, int tag, int[] datavalues) {
		super();
		this.validBit = validBit;
		this.set = set;
		this.tag = tag;
		this.datavalues = datavalues;
	}
	public cache_line_t()
	{
		
	}
	public void print_cache_lint_t() {
		System.out.println("validBit=" + validBit + ", set=" + set + ", tag=" + tag+"   "+Arrays.toString(datavalues));		
	}
	public int getDatavalues(int offSet) {
		return datavalues[offSet];
	}
	public void setDatavalues(int userData, int offSet) {
		datavalues[offSet]=userData;
	}
}

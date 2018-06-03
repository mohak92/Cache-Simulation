package com.hcl;

import java.util.Arrays;

public class Block {
	int data[]=new int[16];

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Block [data=" + Arrays.toString(data) + "]";
	}

	public Block(int[] data) {
		super();
		this.data = data;
	}
	public Block(int blockNumber)
	{
		for(int i=0;i<16;i++)
		{
			data[i]=(blockNumber*10)+i;
		}
	}

	public void setData(int offset, int value) {
		data[offset]=value;		
	}
}

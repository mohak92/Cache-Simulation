package com.hcl;


public class Memory {
	static Block block[]=new Block[16];

	public Block[] getBlock() {
		return block;
	}

	public void setBlock(Block[] block) {
		Memory.block = block;
	}

	public Memory(Block[] block) {
		super();
		Memory.block = block;
	}
	public Memory()
	{
		initMemory();
	}
	public void initMemory() {
		for(int i=0;i<16;i++)
		{
			block[i]=new Block(i);
		}
	}

	public void print_memory() {
		for(int i=0;i<16;i++)
		{
			System.out.println(block[i]);
		}
	}
	public Memory getMemory()
	{
		return this;
	}
}

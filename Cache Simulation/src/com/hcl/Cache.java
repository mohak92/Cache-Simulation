package com.hcl;

import java.util.Arrays;

public class Cache {
	cache_line_t data[]=new cache_line_t[8];
	OperationsImpl impl=new OperationsImpl();
	public cache_line_t[] getData() {
		return data;
	}

	public void setData(cache_line_t[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Cache [data=" + Arrays.toString(data) + "]";
	}
	public Cache(cache_line_t[] data) {
		super();
		this.data = data;
	}
	public Cache()
	{
		initCache(); 
	}
	public void initCache()
	{
		for(int i=0;i<8;i++)
		{
			data[i]=new cache_line_t();
			data[i].setSet(i/2);
			data[i].setValidBit(0);
			data[i].setTag(-99);
			int datavalues[]=new int[16];
			for(int j=0;j<16;j++)
			{
				datavalues[j]=0;
			}
			data[i].setDatavalues(datavalues);
		}
	}
	void print_cache()
	{
		for(int i=0;i<8;i++)
		{
			data[i].print_cache_lint_t();
		}
	}

	public boolean readData(int blockNumber, int offSet) {	
		int associativity=impl.getAssociativity(blockNumber,data);
		System.out.println("associativity "+associativity);
		int flag=impl.is_cache_hit(blockNumber, associativity, data);
		if(flag==1)
		{
			System.out.println("requested data is: "+data[associativity].getDatavalues(offSet));
			return true;
		}
		else
		{
			impl.load_from_mem(blockNumber, 16, data, associativity);
			return false;
		}
	}

	public boolean writeData(int blockNumber, int offSet, int userData) {
		int associativity=impl.getAssociativity(blockNumber,data);
		System.out.println(associativity);
		int flag=impl.is_cache_hit(blockNumber, associativity, data);
		if(flag==1)
		{
			impl.write_to_cache(blockNumber, offSet, userData, data, associativity);			
			impl.write_through_to_mem(blockNumber, 16, associativity, data);
			return true;
		}
		else
		{
			impl.store_to_mem(blockNumber, associativity, userData);
			impl.load_from_mem(blockNumber, 16, data, associativity);
			return false;
		}		
	}
	public Cache getCache()
	{
		return this;
	}
}

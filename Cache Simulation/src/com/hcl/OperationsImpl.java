package com.hcl;

import java.util.Random;

public class OperationsImpl implements ReadAndWrite{
	@Override
	public int map_mem_block_to_cacheline_for_replacement(int block_num,
			int associativity, cache_line_t[] my_cache) {
		if(my_cache[associativity].getValidBit()==0)
		{
			return associativity;
		}
		else
		{
			//return cache.getAssociativity(block_num);
			return 0;
		}
	}

	@Override
	public void write_to_cache(int block_num, int offset, int value,
			cache_line_t[] my_cache, int associativity) {
		
		my_cache[associativity].setDatavalues(value,offset);
		
	}

	@Override
	public void load_from_mem(int block_num, int block_size,
			cache_line_t[] my_cache, int associativity) {
		my_cache[associativity].setDatavalues(Memory.block[block_num].getData());
		my_cache[associativity].setTag(block_num);
		my_cache[associativity].setValidBit(1);
	}

	@Override
	public void write_through_to_mem(int block_num, int block_size,
			int associativity, cache_line_t[] my_cache) {
		Memory.block[associativity].setData(my_cache[associativity].getDatavalues());
	}

	@Override
	public int is_cache_hit(int block_num, int associativity,
			cache_line_t[] my_cache) {
		if(my_cache[associativity].getTag()==block_num)
		{
			return 1;
		}
		return 0;
	}

	@Override
	public int calc_number_of_sets(int associativity) {		
		return associativity*4;
	}

	@Override
	public int calc_my_set_number(int cache_line_num, int num_lines,
			int associativity) {		
		return associativity/2;
	}

	@Override
	public int map_mem_block_to_set(int block_num, int associativity) {		
		return 0;
	}

	@Override
	public void store_to_mem(int block_num, int offset, int value) {
		Memory.block[block_num].setData(offset,value);
		
	}
	public int getAssociativity(int blockNumber,cache_line_t[] data) {
		for(int i=0;i<8;i++)
		{
			if(data[i].getTag()==blockNumber)
			{
				return i;
			}
		}
		Random random=new Random();
		int associativity=random.nextInt(6);
		associativity=map_mem_block_to_cacheline_for_replacement(blockNumber, associativity, data);
		return associativity;			
				
	}
}

package com.hcl;

public interface ReadAndWrite {
	int map_mem_block_to_cacheline_for_replacement(int block_num, int associativity, cache_line_t  	my_cache[]);
	
	void write_to_cache(int block_num, int offset, int value, cache_line_t my_cache[], int associativity);
	
	void load_from_mem(int block_num, int block_size, cache_line_t my_cache[], int associativity);  
	
	void write_through_to_mem(int block_num, int block_size, int associativity, cache_line_t my_cache[]);  
	
	int is_cache_hit(int block_num, int associativity, cache_line_t my_cache[]);  
	
	int calc_number_of_sets(int associativity);  
	
	int calc_my_set_number(int cache_line_num, int num_lines, int associativity);   
	
	int map_mem_block_to_set(int block_num, int associativity); 
	
	void store_to_mem(int block_num, int offset, int value);  
	
}

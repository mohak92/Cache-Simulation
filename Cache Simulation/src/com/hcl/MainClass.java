package com.hcl;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
	
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int choice;
		int blockNumber;
		int offSet;
		int num_read_hits=0;
		int num_read_misses=0;
		int num_write_hits=0;
		int num_write_misses=0;
		int data;
		Cache cache=new Cache();
		Memory memory=new Memory();
		cache.initCache(); 
		memory.initMemory();
		while(true) 
		{  
			System.out.println("2-way Set Associative Map Cache... "); 
			System.out.println("Set Associativity of this cache: 2 "); 
			System.out.println("Number of sets in this cache: 4 "); 
			System.out.println("=============== cache performance ===============          read misses =     "+num_read_misses+"            read hits =     "+num_read_hits+"          write misses =    "+num_write_misses+"          write hits =      "+num_write_hits);  
			System.out.println("================================== MEM ========================== ");
			memory.print_memory();
			System.out.println("================================== CACHE ========================== ");
			cache.print_cache();
			System.out.println("[0]	to read from mem  ");
			System.out.println("[1]	to write to mem  ");
			System.out.println("[2]	to quit  ");	
			choice=scanner.nextInt();
			switch(choice)
			{
			case 0:
					System.out.println("enter block number:");
					blockNumber=scanner.nextInt();
					System.out.println("enter offset: ");
					offSet=scanner.nextInt();
					boolean flag=cache.readData(blockNumber,offSet);
					if(flag)
					{
						num_read_hits++;
					}
					else
					{
						num_read_misses++;
					}
					break;
			case 1:
					System.out.println("enter block number:");
					blockNumber=scanner.nextInt();
					System.out.println("enter offset: ");
					offSet=scanner.nextInt();
					System.out.println("enter data to insert");
					data=scanner.nextInt();
					boolean writeflag=cache.writeData(blockNumber,offSet,data);
					if(writeflag)
					{
						num_write_hits++;
					}
					else
					{
						num_write_misses++;
					}
					break;
			case 2:
					System.exit(0);
					break;
			default:
				System.out.println("choose correct option");
			}
			/*If the command is READ, get the block number, and offset. Then   if ( is_cache_hit)  
			  increment num_read_hits counter   else  
			  increment num_read_misses counter    load_from_mem  
			 print the value of the memory location requested  
			If the command is WRITE, get the block number, offset, and value. Then   if ( is_cache_hit)  
			  increment num_write_hits counter  
			 	write_to_cache  
			write_thru_to_mem  
			 else  
			  increment num_write_misses counter    load_from_mem  
			 print the value of the memory location written  
			if the command is QUIT, exit the loop  */
		}

	}
}

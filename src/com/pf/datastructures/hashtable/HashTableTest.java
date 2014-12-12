package com.pf.datastructures.hashtable;

public class HashTableTest {
	public static void main(String[] args) {
		HashTable<String, String> table = new HashTable<>(5);
		
		table.insert("Philli", "Friedrich");
		table.insert("Andrea", "Flexer");
		table.insert("Stepy", "Manschein");
		table.insert("Bruno", "Bär");
		table.insert("Philli", "Friedrich2");
		
		table.delete("Philli");
		
		System.out.println(table.find("Philli"));
	}
}

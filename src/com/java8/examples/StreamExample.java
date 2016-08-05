package com.java8.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StreamExample {

	public static void main(String[] args) {
		
		Runnable run = null;
		
		boolean isPresent = false;
		
		List<String> strCollection = new ArrayList<>();
		strCollection.add("riaan");
		strCollection.add("nitin");
		strCollection.add("pratik");
		strCollection.add("subin");
		strCollection.add("pankaj");
		strCollection.add("amit");
		strCollection.add("sushil");
		
		// filter
		run = () -> System.out.println("Filter Demo");
		run.run();
		
		strCollection
		.stream()
		.filter((s) -> s.startsWith("s"))
		.forEach(System.out::println);
		
		//Sorted
		run = () -> System.out.println("Sorted Demo");
		run.run();
		
		strCollection
		.stream()
		.sorted()
		.filter((s) -> s.startsWith("p"))
		.forEach(System.out::println);
		
		//MAP
		run = () -> System.out.println("Map Demo");
		run.run();		
		
		strCollection
		.stream()
		.map(String::toUpperCase)
		.sorted((a, b) -> b.compareTo(a))
		.forEach(System.out::println);
		
		//Match
		run = () -> System.out.println("Match Demo");
		run.run();
		
		isPresent = strCollection
		.stream()
		.anyMatch((s) -> s.startsWith("n"));
		
		System.out.println("Any Name in collection starting with char 'n' are present: " + isPresent);
		
		isPresent = strCollection
		.stream()
		.allMatch((s) -> s.startsWith("n"));
		
		System.out.println("All Names in collection starting with char 'n' are present: " + isPresent);
		
		isPresent = strCollection
		.stream()
		.noneMatch((s) -> s.startsWith("z"));
				
		System.out.println("No Names in collection starting with char 'y' are present: " + isPresent);
		
		//COUNT
		run = () -> System.out.println("COUNT Demo");
		run.run();
		
		long count = strCollection
		.stream().filter((s) -> s.startsWith("p"))
		.count();
		
		System.out.println("Total Names in collection starting with char 'p': " + count);
		
		//Reduce
		run = () -> System.out.println("Reduce Demo");
		run.run();
		
		Optional<String> reduced = 
				strCollection
					.stream()
					.sorted()
					.reduce((s1, s2) -> s1 + "#" + s2);
		
		reduced.ifPresent(System.out::println);
		
		//Map
		Map<Integer, String> map = new HashMap<>();
		
		for(int i=0 ; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}
		
		map.forEach((id, val) -> System.out.println(val));
		
		map.computeIfPresent(3,  (num, val) -> val + num);
		System.out.println(map.get(3));
		
		map.computeIfPresent(9, (num , val) -> null);
		System.out.println(map.containsKey(9));
		
		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23));
		
		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3));
		
		map.remove(3, "val3");
		System.out.println(map.get(3));
		
		map.remove(3, "val33");
		System.out.println(map.get(3));
		
		System.out.println(map.getOrDefault(42, "not found"));
		
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));
		
		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));
		
	}

}

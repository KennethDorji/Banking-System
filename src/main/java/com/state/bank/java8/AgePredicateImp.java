package com.state.bank.java8;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class AgePredicateImp {

	public static void greetingMsg(String type, String name) {
		System.out.println("Hey " + name + " your age is valid for " + type);
	}

	public static void main(String[] args) {
		AgePredicate<Integer> dlAgePredicate = (age) -> age >= 18;
		AgePredicate<Integer> mrgPredicate = (age) -> age >= 21;
		AgePredicate<Integer> rtrPredicate = (age) -> age >= 60;

		Map<String, Integer> ageGroupMap = new HashedMap<String, Integer>();
		//here left side which is name is a Key and right side which is age is Value in this Map
		ageGroupMap.put("Ken", 20);
		ageGroupMap.put("Ram", 40);
		ageGroupMap.put("Dolker", 18);
		ageGroupMap.put("Kamla", 21);
		ageGroupMap.put("Selena", 22);
		ageGroupMap.put("Chida", 16);
		ageGroupMap.put("Yahoda", 19);
		ageGroupMap.put("Raj", 65);

		ageGroupMap.entrySet().stream().forEach(pair -> {
			String key = pair.getKey();
			StringBuffer types = new StringBuffer();

			if (dlAgePredicate.checkValidAge(ageGroupMap.get(key))) {
				types.append("DL");

			}
			if (mrgPredicate.checkValidAge(ageGroupMap.get(key))) {
				types.append(" Marriage");
			}
			if (rtrPredicate.checkValidAge(ageGroupMap.get(key))) {
				types.append(" Retirement");
			} else {
				types.append(" sports");
			}
			greetingMsg(types.toString(), key);
		});

		ageGroupMap.values().stream().filter((age) -> dlAgePredicate.checkValidAge(age)).forEach(elgblAge -> {
			// System.out.println(elgblAge);
		});

		ageGroupMap.entrySet().stream().filter((pair) -> !dlAgePredicate.checkValidAge(pair.getValue()))
				.forEach(agrp -> {
					// System.out.println("name: "+agrp.getKey() +" age :"+agrp.getValue());
				});

		ageGroupMap.entrySet().stream().filter((pair) -> !rtrPredicate.checkValidAge(pair.getValue()))
				.forEach(agrp -> {
					// System.out.println("name: " + agrp.getKey() + " age :" + agrp.getValue());
				});

		// get pair of all keys and values
		ageGroupMap.entrySet().stream().forEach(agrp -> {
			// System.out.println(agrp);
		});
		// .filter((agGrp)->dlAgePredicate.checkDLValidAge(agGrp.))

		// just get all keys only

		ageGroupMap.keySet().stream().forEach(k -> {
			// System.out.println(k);
		});

		// just get all values only

		ageGroupMap.values().stream().forEach(value -> {
			// System.out.println(value);
		});
	}
}

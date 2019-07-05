package br.com.vinicius.springboot.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}	
	
	public static List<String> decodeStringList(String s) {
		String[] vet = s.split(",");
		List<String> list = new ArrayList<>();
		for (int i=0; i<vet.length; i++) {
			list.add(vet[i]);
		}
		return list;
		//return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
	}

	public static Iterable<String> decodeStringIterable(String s) {
		String[] vet = s.split(",");
		List<String> list = new ArrayList<>();
		for (int i=0; i<vet.length; i++) {
			list.add(vet[i]);
		}
		Iterable<String> iterable = list;
		return iterable;
	}
}
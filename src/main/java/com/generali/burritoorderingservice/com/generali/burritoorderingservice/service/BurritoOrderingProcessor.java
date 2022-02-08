package com.generali.burritoorderingservice.com.generali.burritoorderingservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.generali.burritoorderingservice.com.generali.burritoorderingservice.exception.BarritOrderException;

public class BurritoOrderingProcessor {
	
	public static void validateOrder(HashMap<String, ArrayList<String> > order) throws BarritOrderException {
		List<String> tortilla = order.get(IConstants.ORDERLINE.Tortilla.name());
		List<String> protein = order.get(IConstants.ORDERLINE.Protein.name());
		List<String> vegetables = order.get(IConstants.ORDERLINE.Vegetables.name());
		List<String> salsa = order.get(IConstants.ORDERLINE.Salsa.name());
		List<String> extras = order.get(IConstants.ORDERLINE.Extras.name());
	
		if(tortilla != null) {
			if(tortilla.size() != 1) throw new BarritOrderException("Tortilla size one missing");
			if(!tortilla.stream().anyMatch(s -> "corn".equals(s) ||"flour".equals(s) )) {
				throw new BarritOrderException("Bad Tortilla input");
			};
		}
		if(protein != null) {
			if(protein.size() != 1) throw new BarritOrderException("Protein size one missing"); 
			if(!protein.stream().anyMatch(s -> "bean".equals(s) ||"beaf".equals(s) || "chicken".equals(s)
												||"pork".equals(s) || "shrimp".equals(s) || "steak".equals(s))) {
				throw new BarritOrderException("Bad Protein input");
			}
		}
		if(vegetables != null) {
			if(!vegetables.stream().anyMatch(s -> "cabbage".equals(s) ||"corn".equals(s) || "jalapenos".equals(s))) {
				throw new BarritOrderException("Bad Vegy input");
			}
			
		}
		if(salsa != null) {
			if(salsa.size() != 1) throw new BarritOrderException("Salsa size one missing");
			if(!salsa.stream().anyMatch(s -> "mild".equals(s) ||"medium".equals(s) || "hot".equals(s))) {
				throw new BarritOrderException("Bad Salsa input");
			}

		}
	}

}

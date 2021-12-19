package sii.maroc;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private static List<Ingredient> ingredientStocks;

    public String ingredient,ingredient2,ingredient3,ingredient4,ingredient5,ingredient6;
	private String string1;
	public Restaurant(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
    	this.ingredient=string;
    	this.ingredient2=string2;
    	this.ingredient3=string3;
    	this.ingredient4=string4;
	}

	public Restaurant(String string, String string2, String string3, String string4, String string5, String string6) {
		this.ingredient=string;
    	this.ingredient2=string2;
    	this.ingredient3=string3;
    	this.ingredient4=string4;
    	this.ingredient5=string5;
    	this.ingredient6=string6;
    	
	}
	
	public Restaurant(String... ingredientInformations) {
        ingredientStocks = new ArrayList<>();
        for (String ingredientInfo : ingredientInformations) {
            ingredientStocks.add(IngredientFactory.getIngredient(ingredientInfo));
        }
    }
	
	

	public Ticket order(String orderDescription) {
        Ticket returnedTicket = new Ticket(orderDescription);
        if (orderDescription.contains("Tomato Mozzarella Salad")) {
            ingredientStocks.stream().forEach(ingredient -> ingredient.reduceQuantity(orderDescription));
        }
        return returnedTicket;
    }


	public Meal retrieve(Ticket ticket) {
		Meal orderdMeal ;
        orderdMeal = new MealBuilder().withDishes(ticket).withTicket(ticket).build();
        return orderdMeal;
	}

	public static int getMinimumIngredientQuantity() {
		// TODO Auto-generated method stub
		  return ingredientStocks.stream().mapToInt(Ingredient::getQuantity).min().orElse(1000000); 
	}

	
	
}

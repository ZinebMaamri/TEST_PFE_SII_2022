package sii.maroc;

public class Meal {
	private Ticket ticket;
	private static final int dish_first =6;
	private int nmb_dish;
	private int cookduration;


	public int servedDishes() {
	
		return nmb_dish;   
	}

	public int cookingDuration() {
		this.setCookTime();
		return cookduration;
	}
	
	public void setCookTime() {
		if(ticket.checkIfOrderIsPizza()) {
			cookduration +=20;
		}
		if(nmb_dish >1) {
			int addDish=nmb_dish -1;
			int durationAnadditionDish=3;
			cookduration= dish_first+durationAnadditionDish*addDish;
			
		}
		else if(nmb_dish==1) {
			cookduration=dish_first;
		}
		
	}
	public void setNumbreDishes(int nmbreDishes) {
		this.nmb_dish=nmbreDishes;
	}
	public void setTicket(Ticket t) {
		this.ticket=t;
	}

}

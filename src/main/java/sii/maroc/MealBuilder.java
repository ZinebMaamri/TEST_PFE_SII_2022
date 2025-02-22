package sii.maroc;

import sii.maroc.OutOfStockException;

public class MealBuilder {
    private Meal meal = new Meal();

    public MealBuilder withTicket(Ticket ticket) {
        {
            meal.setTicket(ticket);
            return this;
        }
    }

    public MealBuilder withDishes(Ticket ticket) throws OutOfStockException {

        this.meal.setNumbreDishes(ticket.getNumberOfDishesInOrder());
        return this;
    }

    // todo with ...

    public Meal build() {
        return meal;

    }


}

class FoodFactory {
    public Food getFood(String order) {
        // Factory pattern: returning instances based on input string
        if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (order.equalsIgnoreCase("cake")) {
            return new Cake();
        }
        return null;
    }
}

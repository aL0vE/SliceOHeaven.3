public class SliceOHaven {
    private String orderID;
    private String pizzaIngredients;
    private double orderTotal;
    private String sides;
    private String drinks;

    public static final String DEF_ORDER_ID = "DEF - SOH - 099";
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public static final double DEF_ORDER_TOTAL = 15.00;

    public SliceOHaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    public SliceOHaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
        this.sides = "";
        this.drinks = "";
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(String pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    private void printReceipt() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Order Total:" + orderTotal);
        System.out.println("Sides: " + sides);
        System.out.println("Drinks: " + drinks);
    }

    public void displayReceipt() {
        printReceipt();
    }

    public void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        int cardLength = cardNumber.length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
            return;
        }

        int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));
        String blacklistedNumber = "12345678901234";
        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
            return;
        }

        int lastFourDigits = Integer.parseInt(cardNumber.substring(cardNumber.length() - 4));
        String cardNumberToDisplay = cardNumber.substring(0, 1) + "****" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Card Number to Display: " + cardNumberToDisplay);
    }

    public void specialofTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder details = new StringBuilder();
        details.append("Pizza of the Day: ").append(pizzaOfTheDay).append("\n")
               .append("Side of the Day: ").append(sideOfTheDay).append("\n")
               .append("Special Price: ").append(specialPrice);
        System.out.println(details.toString());
    }

    public static void main(String[] args) {
        SliceOHaven order = new SliceOHaven();
        order.setOrderID("DEF-SOH-099");
        order.setPizzaIngredients("Mozzarella Cheese");
        order.setOrderTotal(15.00);
        order.sides = "Fries";
        order.drinks = "Coke";
        order.displayReceipt(); 
        order.processCardPayment("123", "3/1", 123);
        order.specialofTheDay("Durian Pizza", "beef", "$9.99");
    }
}

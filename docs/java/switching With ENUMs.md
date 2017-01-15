# ENUM
  
  nice example of a switch with enums in proEE design patterns p.67
  
    public enum CoffeeType {
      ESPRESSO, LATTE
    }
    
    public Drink dispenseDrink(CoffeeType type) { 
      Drink coffee = null;
      switch (type) {
        case ESPRESSO: coffee = new Espresso();
        case LATTE: coffee = new Latte(); }
    return coffee; }
SINGLETON

  there are different ways to construct a singleton. according to bloch, 
  effective java, p.18 the best method is to use an enum. 
  but the call to that singletons constructor can't be parametrized says 
  stackoverflow (see below). but the way I do it - with the reference to the 
  main.args hardcoded into the class - it should work
  
  proEE design patterns p.37 f
  
      public enum MySingletonEnum { 
        INSTANCE;
        
        //  stackoverflow - https://stackoverflow.com/questions/427902
        private int age;
        public int getAge() {
            return age;
        }
        
        public void doSomeMoreInterestingStuff(){} 
      }
      
  In this example, a reference to the instance of the singleton object is 
  obtained by the following:
    
      MySingletonEnum mse = MySingletonEnum.INSTANCE;
    
  Once you have the singleton’s reference, you can call any of its methods 
  like so: 
    
      mse.getAge();
  
  But of course you can also access it directly:
  
      MySingletonEnum.INSTANCE.getAge()
      MySingletonEnum.INSTANCE.doSomeMoreInterestingStuff()
      
      
  Also, (from the same stackoverflow thread) a great advantage is when your 
  singleton implements an interface e.g. to help with setting up Unit tests.
        
        public enum Elvis implements HasAge {
            INSTANCE;
            private int age;
        
            @Override
            public int getAge() {
                return age;
            }
        }
        
  With:
        
        public interface HasAge {
            public int getAge();
        }
        
        
  Also check https://stackoverflow.com/questions/12697726 for
  how-to-initialize-java-enum-based-singleton
  It's perfectly possible to create constructor for enum:
  
      public enum BitCheck {
          INSTANCE;
          BitCheck() {
              props = new HashMap<String, String>();
          }
          private final Map<String, String> props;
          //..
      }
  
  "Note that:
      - props field can be final (we like final)
      - props doesn't have to be static
      - constructor is called automatically and eagerly for you
  Pay attention to the last point. Since enum-singletons are created eagerly 
  when the enum BitCheck class is loaded, you have no way to pass any arguments
  to the constructor."
  
  It's not clear to me what the last sentence means. It is possible to pass 
  arguments to an Enum constructor. It just can't be arguments that refer to a 
  field (even a static one) in the enum class since they won't be initialized
  when the enum get's ininitialized, because: "The first entry in an enum class 
  must be the (enum) constants which are actually static final instances of 
  type enum. Thus for enums it's always guaranteed that the enum constants are 
  initialized first, before the static fields." so they can't access those 
  static fields. but they can (i guess) access (only static?) fields from other 
  classes that have already be initialized, since - why not?!
  
  
  OH: https://stackoverflow.com/questions/4829068   
  Enums are compile-time constants, so you can not initialize them using 
  non-constant values, which means that you can't do this:
  
    SQUARE(SomeClass.getSquareValue())
  
  well, that settles it :(
  
  
  see here for the full explanation in one of the comments far below:  
  https://stackoverflow.com/questions/443980/why-cant-enums-constructor-access-static-fields
  and:
  https://stackoverflow.com/questions/5842273/java-lazy-initializing-singleton
  
  Enum singletons are lazy -  the INSTANCE will not be loaded until the Class 
  is accessed. (https://stackoverflow.com/questions/5842273)
  
  And, btw, why not just use a static variable? Because singletons are easier 
  to test!
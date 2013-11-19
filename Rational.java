// BENEDICT BOLTON
// HW#27
// PD08
// 2013-11-18

public class Rational {
    
    private int numer; //numerator
    private int denom; //denominater (sometimes are switched around for gcd)
    
    public Rational () {
	numer = 0;
	denom = 1;
    }
    

    //Pre: bot != 0
    //post: Rational object
    public Rational ( int top, int bot ) {
	this();
	if (bot == 0) {
	    System.out.println( "One cannot have a denominator equal to zero. The Rational has been reset to 0");
	}
	else {
	    numer = top;
	    denom = bot;
	}
    }
    
    //~~~~~~~~~~~~~ ACCESSOR METHODS ~~~~~~~~~~~~
    public int getDenom () {
	return denom;
    }
    
    public int getNumer () {
	return numer;
    }
    //end accessors

    //================ MUTATOR METHODS =============
    public int setDenom( int inp) {
	int oldDenom = denom;
	denom = inp;
	return oldDenom;
    }

    public int setNumer( int inp) {
	int oldNumer = numer;
	numer = inp;
	return oldNumer;
    }

    //Post: returns the rational number in double form 
    public double floatValue () {
	return (numer *1.0)/(denom); //multiple by 1.0 to prevent int div
    }
    
    public String toString() {
	return (numer + "/" + denom + " -- which equals: " + this.floatValue());
    }

    //multiplies the calling object by the input
    public void multiply ( Rational multiplier) {
	denom *=  multiplier.getDenom();
	numer *=  multiplier.getNumer();
    }

    //divides the calling object by the input
    public void divide ( Rational divisor) {
	denom *=  divisor.getNumer();
	numer *=  divisor.getDenom();
    }

    //adds the input to the calling object
    public void add ( Rational adder ) {
	numer =  ( (numer * adder.getDenom()) + (adder.getNumer() * denom) );
	denom *= adder.getDenom();
    }


    //subtracts the input from the calling object
    public void subtract ( Rational reducter ) {
	numer = ( (numer * reducter.getDenom()) - (reducter.getNumer() * denom) );
	denom *= reducter.getDenom();
    }
	
    //private version meant for reduce function
   private int gcd ( int a, int b) { //GCD with recursion vie Euclid's method
	if (b == 0) {
	    return a;
	}
	else {
	    return gcd ( b, a%b );
	}

    }

    //public version (didnt know which version wanted so made both)
    //for use by individual objects
    public int gcd () {

 //GCD with while loop, both done via euclids method
	while (denom != 0) {
	    int k = denom;
	    denom = numer%k;
	    numer = k;
	}
	return numer;
    }

  

    //reduces rational number to simplest form via GCD
    public void reduce() {
	int gCD = gcd ( numer, denom );
	denom /= gCD;
	numer /= gCD;
    }

   public static int gcdUni ( int num, int den) { //GCD with recursion vie Euclid's method
	if (den == 0) {
	    return num;
	}
	else {
	    return gcdUni ( den, num%den );
	}

    }

    //Rational compareTo()
    //Pre: input = Rational object
    //post: return positive int (42) if caller > input
    //      return negative int (-42) if caller < input
    //      return 0 if caller == input
    public int compareTo ( Rational inputOb ) {
	int inpDen = inputOb.getDenom();
	int num2 = denom * inputOb.getNumer();
	int num1 = numer * inpDen;
	int den1 = denom * inpDen;
	int den2 = denom * inpDen;
	if ( num1 == num2 ) {
	    return 0;
	}
	else if ( num1 > num2) {
	    return 42;
	}
	else {
	    return -42;
	}
    }



    public static void main (String[] args) {
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	System.out.println(r);
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	System.out.println(s);
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains 1/2
	System.out.println(r);
	r.divide(s); //divides r by s, changes r to 4/6. s remains 1/2
	System.out.println(r);
	System.out.println(s);
	Rational t = new Rational(4,18); //Stores the rational number 4/18
	System.out.println(t);
	Rational w = new Rational( 2, 3); //Stores the rational number 2/3
	System.out.println(w);
	w.add(s);  //Adds w to s, changes w to 7/6.  s remains 1/2 
	System.out.println(w);
	w.subtract(s); // subtracts s from w, changes w to 8/12. s remains 1/2
	System.out.println(w);
	System.out.println(s);
	t.reduce(); //Changes t to 2/9
	System.out.println(t);
	System.out.println( w.compareTo(t) ); //should return 42
	System.out.println( t.compareTo(s) ); //should return -42
	Rational k = new Rational (4, 8);
	System.out.println( s.compareTo(k) ); //should return 0;
	System.out.println( gcdUni( 28, 32) ); //should return 4
    }//end main

}//end class
    



    

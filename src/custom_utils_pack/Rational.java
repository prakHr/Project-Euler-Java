/*
 * The MIT License
 *
 * Copyright 2020 Prakhar Gandhi.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package custom_utils_pack;

/**
 *
 * @author Prakhar Gandhi
 */
public class Rational extends Number{
    public long n;
    public long d;
    
    public Rational() {
		this(0, 1);
	}
    public Rational(long n,long d){
        this.n=n;
        this.d=d;
        simplify();
    }
    public Rational multiply(Rational rational2){
        return new Rational(n*rational2.n,d*rational2.d);
    }
    public Rational divide(Rational r2){
            return multiply(new Rational(r2.d,r2.n));
    }
    
    public Rational add(Rational rational2) {
        long newNumerator = this.n * rational2.d
                        + this.d * rational2.n;
        long newDenominator = this.d * rational2.d;
        Rational newRational = new Rational(newNumerator, newDenominator);
        return newRational;
	}
    
    public void simplify(){
        long t = gcd();
        if (t == 0)
            return;
	    n /= t;
	    d /= t;
	
	    if (d < 0) {
	        n *= -1;
	        d *= -1;
	    }
    }
    public boolean isLessThan(Rational r){
        return(r.n*d>n*r.d);
    }
    private long gcd() {
        long a = n;
        if (a < 0) {
            a *= -1;
        }
        long b = d;
        if (b < 0) {
            b *= -1;
        }
        while (b != 0) {
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    
     @Override
	public String toString() {
            if (d == 1)
                return ""+n;
            return ""+n+"/"+d;
	}

    @Override
    public int intValue() {
        return (int)(n/d);
    }

    @Override
    public long longValue() {
        return n/d;
    }

    @Override
    public float floatValue() {
        return (float)n/(float)d;
    }

    @Override
    public double doubleValue() {
       return (double)n/(double)d;
    }
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rational)) {
            return false;
        }
        Rational r = (Rational)o;
        return this.n == r.n && this.d == r.d;
    }
    
}

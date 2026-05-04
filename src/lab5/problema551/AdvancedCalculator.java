package lab5.problema551;

public class AdvancedCalculator extends IntCalculator {
    public AdvancedCalculator(int state){
        super(state);
    }

    public AdvancedCalculator divide(int value) {
        if(value != 0) {
            this.state /= value;
        }
                else {
                System.out.println("Impartire la 0");
            }
                return this;
            }

            public AdvancedCalculator power(int exponent){
                this.state = (int) Math.pow(this.state, exponent);
                return this;
            }

            public AdvancedCalculator root(int n){
                if(n != 0){
                    this.state = (int) Math.round(Math.pow(this.state, 1.0 / n));
                }
                return this;
            }

            @Override
                    public AdvancedCalculator add(int value){
                super.add(value);
                return this;
            }
            @Override
                    public AdvancedCalculator substract(int value) {
                super.substract(value);
                return this;
            }
            @Override
                    public AdvancedCalculator multiply(int value){
                super.multiply(value);
                return this;
            }
            @Override
                    public AdvancedCalculator clear(){
                super.clear();
                return this;
            }
        }



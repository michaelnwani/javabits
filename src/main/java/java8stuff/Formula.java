// default -> non-abstract method implementations that can be added to interfaces
// NOTE: default methods cannot be accessed from inside lambda expressions
interface Formula {
	
	double calculate(int a);
	
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
	
	public static void main(String[] args) {
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		
		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16));
	}
}
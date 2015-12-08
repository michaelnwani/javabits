// Variant 1: Using the container annotation (old school)
// @Hints({@Hint("hint1"), @Hint("hint2")})

// Variant 2: Using repeatable annotations (new school)
@Hint("hint1")
@Hint("hint2")
public class HintClient {
	public static void main(String[] args) {
		// Using variant 2 the java compiler implicitly sets up the @Hints
		// annotation under the hood. Important for reading annotation information
		// via reflection.
		
		Hint hint = HintClient.class.getAnnotation(Hint.class);
		System.out.println(hint);					// 'null'
		
		Hints hints1 = HintClient.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length);	// 2
		
		//getAnnotationsByType(): grants direct access to all annotated @Hint
		// annotations
		Hint[] hints2 = HintClient.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);			// 2
		
		// the usage of annotations in Java 8 is expanded to two new targets:
		// @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
		// @interface MyAnnotation {}
	}
}
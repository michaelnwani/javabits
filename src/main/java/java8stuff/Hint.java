// Annotations in Java 8 are repeatable
import java.lang.annotation.*;

// wrapper annotation that holds an array of the actual annotations:
@interface Hints {
	Hint[] value();
}


@Repeatable(Hints.class)
public @interface Hint {
	String value();
}
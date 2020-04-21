package stream.supplier;

import java.util.function.Function;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupplierTest {

	private static final Logger LOG = LoggerFactory.getLogger(SupplierTest.class);
	
	public static void main(String[] args) {
		new SupplierTest().supplier();
	}
	
	private void supplier() {
		
		Supplier<Integer> intSupplier = () -> new Integer(5);

		Integer i1 = intSupplier.get();
		Integer i2 = intSupplier.get();
		LOG.debug("{}, {}", i1.hashCode(), i2.hashCode());

		
		Supplier<Object> objSupplier = Object::new;
		
		Object o1 = objSupplier.get();
		Object o2 = objSupplier.get();
		LOG.debug("{}, {}", o1.hashCode(), o2.hashCode());	//not equals
		
		
		Function<String, Integer> objFunc = (String s) -> Integer.parseInt(s);
		
		Integer apply = objFunc.apply("5");
		LOG.debug("{}", apply);
	}
}

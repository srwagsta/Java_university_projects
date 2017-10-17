import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wagstaff
 *
 */
public class DynArrayDriver extends DynArray{
	public static void main(String[] args){
		DynArray testArr1 = new DynArray();
		DynArray testArr2 = testArr1;

		System.out.print("Size of Array1: " + testArr1.arraySize() +
				"\nNext index of Array1 :" + testArr1.elements()+
				"\n\nSize of Array2: " + testArr2.arraySize() +
				"\nNext index of Array2: " + testArr2.elements());
		
		
// use a reflection call to call the private method outside the class, ONLY FOR TEST CASE.
		Method m = null;
		try {
			m = DynArray.class.getDeclaredMethod("grow");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();                                          // Had to have a dirty catch, no need to handle it
		}
		m.setAccessible(true);                                            // Let's make our private method accessible
		try {
			m.invoke(testArr1);                                           // Now we use our now accessible grow() method on testArr1
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();                                          // Had to have a dirty catch, no need to handle it
		}
// There is a reason you don't use that outside of test cases ... 
		
		System.out.print("\n\n******************** After a grow on Array1 ****************" + 
				"\nSize of Array1: " + testArr1.arraySize() +
				"\nNext index of Array1: " + testArr1.elements()+
				"\n\nSize of Array2: " + testArr2.arraySize() +
				"\nNext index of Array2: " + testArr2.elements());
		
	}

}

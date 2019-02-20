
import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Testing05 {

	DynArray a;
	DynArray b;
	DynArray c;

	private Object getField(Object instance, String name) throws Exception {
		Class c = instance.getClass();
		Field f = c.getDeclaredField(name);
		f.setAccessible(true);
		return f.get(instance);
	}

	public static boolean setField(Object targetObject, String fieldName, Object fieldValue) {
		Field field;
		try {
			field = targetObject.getClass().getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			field = null;
		}
		Class superClass = targetObject.getClass().getSuperclass();
		while (field == null && superClass != null) {
			try {
				field = superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				superClass = superClass.getSuperclass();
			}
		}
		if (field == null) {
			return false;
		}
		field.setAccessible(true);
		try {
			field.set(targetObject, fieldValue);
			return true;
		} catch (IllegalAccessException e) {
			return false;
		}
	}

	@Before
	public void setUp() {
		a = new DynArray();
		b = new DynArray();
		c = new DynArray();

	}

	@After
	public void tearDown() {
		a = null;
		b = null;
		c = null;

	}

	@Test
	public void TestConstructor() {

		assertEquals(DynArray.class, a.getClass());

	}

	@Test
	public void TestInitialFields1() {

		assertEquals(1, a.arraySize());
		assertEquals(0, a.elements());

	}

	@Test
	public void TestSetters1() {

		assertEquals(1, b.arraySize());
		assertEquals(0, b.elements());
		b.insert(15.0);
		assertEquals(1, b.arraySize());
		assertEquals(1, b.elements());
		b.insert(15.0);
		assertEquals(2, b.arraySize());
		assertEquals(2, b.elements());
		b.insert(100.0);
		assertEquals(4, b.arraySize());
		assertEquals(3, b.elements());

	}

	@Test
	public void TestSet1() {

		c.insertAt(0, 15.0);
		c.insertAt(0, 15.0);
		c.insertAt(2, 90.0);
		c.insertAt(60, 15.0);// should not be inserted
		assertEquals(4, c.arraySize());
		assertEquals(3, c.elements());
		c.insertAt(0, 500.0);

		
		
		assertEquals(500.0, c.at(0), 0.0);
		assertEquals(15.0, c.at(1), 0.0);
		assertEquals(15.0, c.at(2), 0.0);
		assertEquals(90.0, c.at(3), 0.0);
		assertEquals(Double.NaN, c.at(4), 0.0);
		assertEquals(Double.NaN, c.at(5), 0.0);

	}

	@Test
	public void TestSet2() throws Exception {

		double[] arr = ((double[]) getField(c, "array"));

		arr[0] = 10.0;
		setField(c, "nextIndex", 1);

		assertEquals(10.0, c.remove(), 0.0);
		assertEquals(Double.NaN, c.remove(), 0.0);

		arr[0] = 100.0;
		setField(c, "nextIndex", 1);
		assertEquals(Double.NaN, c.removeAt(300), 0.0);
		assertEquals(Double.NaN, c.removeAt(1), 0.0);
		assertEquals(100, c.removeAt(0), 0.0);

	}

	@Test
	public void printTest() throws Exception {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		c.insert(1);
		c.insert(2);
		c.insert(3);
		c.insert(4);
		c.insert(5);

		c.printArray();
		String captured = outContent.toString();
		int found1 =captured.indexOf("1.0");
		int found2 = captured.indexOf("2.0");
		int found3 = captured.indexOf("3.0");
		int found4 = captured.indexOf("4.0");
		int found5 = captured.indexOf("5.0");
		
	
		int countOfArrayAt = captured.split("array.at").length - 1;



		assertEquals(true, (found1 < found2) && (found2 < found3) && (found3 < found4) && (found4 < found5));

		assertEquals(true, (found1 != -1) && (found2 != -1) && (found3 != -1) && (found4 != -1) && (found5 != -1));
		assertEquals(true,countOfArrayAt==5 );

	}

}

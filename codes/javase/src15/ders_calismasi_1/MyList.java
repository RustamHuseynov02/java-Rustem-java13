package ders_calismasi_1;

public class MyList<T> {
	Object[] array = null;
	int index = 0;
	int inc = 0;

	public MyList(int initial, int increment) {
		array = new Object[initial];
		this.inc = increment;

	}

	public void addNew(T a) {
		// System.out.println(index);
		if (index == array.length) {
			Object[] newMassiv = new Object[array.length + inc];
			for (int i = 0; i < array.length; i++) {
				newMassiv[i] = array[i];
			}
			array = newMassiv;
		}
		array[index] = a;
		index++;

	}

	public String strReturn() {
		String s = "[";
		for (int i = 0; i < index; i++) {
			if (index == i + 1) {
				s = s + array[i];
			} else {
				s = s + array[i] + ",";
			}
		}
		return s + "]";
	}

//	public void removeMethod(int a) {
//		if (a < index) {
//			Object[] newMassiv = new Object[index - 1];
//			for (int i = 0, newIndex = 0; i < index; i++) { //0,1,2,3
//				if (i == a) {
//					continue;
//				}
//				newMassiv[newIndex++] = array[i];
//			}
//			array = newMassiv;
//			index--;
//		}
//
//		else {
//			System.out.println("yerlesmir");
//		}
//	}

	int newIndex = 0;

	public void removeMethod(int a) {
		if (a < index) {
			Object[] newArray = new Object[index - 1];
			for (int i = 0; i < index; i++) {
				// System.out.println(index);
				if (a == i) {
					continue;
				}
				newArray[newIndex++] = array[i];

			}
			array = newArray;
			index--;
		} else {
			System.out.println("if-e girmir");
		}
	}

}

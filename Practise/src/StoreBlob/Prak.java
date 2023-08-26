	package StoreBlob;


class A{
	int v=34;
	int c=31;
}
class B extends A {
	int v=34;
	int c=22;
}
public  class Prak{
	public static void main() {
		A a=new B();
		System.out.println(a.c);
	}
	
}


public class Singleton {

	private static Singleton inst;
	private int stanKontaKasyna;

	private Singleton(int x) {
		stanKontaKasyna = x;
	}

	public static synchronized Singleton getReference() {
		if (inst == null) {
			inst = new Singleton(10000);
		}
		return inst;
	}

	public int getStanKonta() {
		return stanKontaKasyna;
	}

	public void setStanKonta(int x) {
		stanKontaKasyna = x;
	}

	public void gra(int stawka) {

		double x = Math.random() * 2;
		System.out.println("Stan konta kasyna wynosi: " + getStanKonta());

		if (x > 1) {
			System.out.println("Gracz Przegra³! Zyski Wzros³y");
			setStanKonta(getStanKonta() + stawka);
			System.out.println("Stan konta kasyna wynosi: " + getStanKonta());
		}

		if (x <= 1) {
			System.out.println("Gracz Wygra³! Zyski Spad³y");
			setStanKonta(getStanKonta() - stawka);
			System.out.println("Stan konta kasyna wynosi: " + getStanKonta());
		}

		System.out.println("");

	}

	public static void main(String[] args) {

		Singleton GraczWBlackjacka = Singleton.getReference();
		Singleton GraczWJednorêkiego = Singleton.getReference();
		System.out.println("Rozpoczeto gre w blackjacka ze stawk¹ 200.");
		GraczWBlackjacka.gra(200);
		System.out.println("Rozpoczeto gre w jednorêkigo bandytê ze stawk¹ 500.");
		GraczWJednorêkiego.gra(500);

	}
}

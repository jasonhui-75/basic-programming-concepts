package doggenetics;

public class DogGenetics {
	private String name;
	private double bernard;
	private double chihuahua;
	private double pug;
	private double cur;
	private double doberman;
	
	public DogGenetics(String name)
	{
		this.name = name;
		this.bernard = Math.floor(Math.random() *25);
		this.chihuahua = Math.floor(Math.random() *25);
		this.pug = Math.floor(Math.random() *25);
		this.cur = Math.floor(Math.random() *25);
		this.doberman = 100 - bernard - chihuahua - pug - cur;
	}
	@Override
	public String toString() {
		return String.format("%s is:\n\n"
							+ "%d%% St. Bernard\n"
							+ "%d%% Chihuahua\n"
							+ "%d%% Dramatic RedNosed Asian Pug\n"
							+ "%d%% Common Cur\n"
							+ "%d%% King Doberman\n\n"
							+ "Wow, that's QUITE the dog!"  ,this.name, (int)this.bernard, (int)this.chihuahua, (int)this.pug, (int)this.cur, (int)this.doberman );
	}
	public static void main(String[] args) {
		DogGenetics dg1 = new DogGenetics("Mango");
		DogGenetics dg2 = new DogGenetics("CoCo");
		System.out.println(dg1);
		System.out.println(dg2);
	}

}

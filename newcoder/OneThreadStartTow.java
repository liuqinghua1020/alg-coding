
public class OneThreadStartTow {

	
	public static void main(String[] args) {
		Runnable r = new Runnable(){

			@Override
			public void run() {
				System.out.println("start...");
			}
			
		};
		
		Thread t1 = new Thread(r);
		t1.start();
		t1.start();
	}

}

import java.util.concurrent.TimeUnit;

public class Interrupted {

	public static void main(String[] args) throws InterruptedException {
		Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
		sleepThread.setDaemon(true);
		
		Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
		
		sleepThread.start();
		busyThread.start();
		
		TimeUnit.SECONDS.sleep(5);
		
		sleepThread.interrupt();
		busyThread.interrupt();
		
		System.out.println("SleepThread interruped is "+sleepThread.isInterrupted());
		System.out.println("BusyThread interruped is "+busyThread.isInterrupted());
		
		TimeUnit.SECONDS.sleep(2);
		
	}

	static class SleepRunner implements Runnable {

		@Override
		public void run() {
			
			//发生中断会自动复位interrupted标志位
			while(true){
				SleepUtils.second(10);
			}
		}
	}

	static class BusyRunner implements Runnable {

		@Override
		public void run() {
			while (true) {

			}
		}

	}

}

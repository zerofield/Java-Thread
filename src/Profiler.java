import java.util.concurrent.TimeUnit;

public class Profiler {

	private static final ThreadLocal<Long> TIME_THREAD_LOCAL = new ThreadLocal<>();

	protected long initialTime() {
		return System.currentTimeMillis();
	}

	public static void begin() {
		TIME_THREAD_LOCAL.set(System.currentTimeMillis());
	}

	public static long end() {
		return System.currentTimeMillis() - TIME_THREAD_LOCAL.get();
	}

	public static void main(String[] args) throws InterruptedException {
		Profiler.begin();
		TimeUnit.SECONDS.sleep(1);
		System.out.println(Profiler.end());
	}
}

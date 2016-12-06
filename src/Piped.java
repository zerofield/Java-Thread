import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {

	public static void main(String[] args) throws IOException {
		PipedWriter out = new PipedWriter();
		PipedReader in = new PipedReader();

		out.connect(in);

		Thread thread = new Thread(new Print(in), "Print");
		thread.start();

		int receive = 0;

		while ((receive = System.in.read()) != -1) {
			out.write(receive);
		}

	}

	static class Print implements Runnable {

		PipedReader in;

		public Print(PipedReader in) {
			this.in = in;
		}

		@Override
		public void run() {

			int receive = 0;
			try {
				while ((receive = in.read()) != -1) {
					System.out.print((char) receive);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}

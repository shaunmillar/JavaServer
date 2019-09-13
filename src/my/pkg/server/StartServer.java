package my.pkg.server;

/**
 * see: http://tutorials.jenkov.com/java-multithreaded-servers/singlethreaded-server.html
 * @author 176899
 *
 */
public class StartServer {

	public StartServer() {
	}

	public static void main(String[] args) {
		
		SingleThreadedServer server = new SingleThreadedServer();
		System.out.println("Starting the Server");
		new Thread(server).start();

		// This holds the main thread for 60 seconds before exiting which will take down the server thread with it.
		// this could be replaced with a static variable, 'isStopping' which may be tripped from anywhere in the
		// project and cause the server to be shut down gracefully (e.g. main completes).
		try {
		    Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();  
		}
		
		System.out.println("Stopping Server");
		server.stop();
	}

}

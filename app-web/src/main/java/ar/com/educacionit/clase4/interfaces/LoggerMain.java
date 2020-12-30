package ar.com.educacionit.clase4.interfaces;

public class LoggerMain {

	public static void main(String[] args) {
		
		ILogger fsl = new FileSystemLogger();		
		ILogger el = new EmailLogger();		
		ILogger nubeLogger = new NubeLogger();
				
		ILogger[] loggers = new ILogger[3];
		loggers[0] = fsl;
		loggers[1] = el;
		loggers[2] = nubeLogger;
		
		for(ILogger logger : loggers ) {
			//polimorfismo!
			System.out.println(logger.getClass());
			logger.log();
		}
	} 

}

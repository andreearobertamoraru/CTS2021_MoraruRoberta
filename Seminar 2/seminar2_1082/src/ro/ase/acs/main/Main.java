package ro.ase.acs.main;

import ro.ase.acs.readers.ConsoleReader;
import ro.ase.acs.services.Orchestrator;
import ro.ase.acs.writers.ConsoleWriter;
import ro.ase.acs.writers.Writable;
import ro.ase.acs.readers.Readable;

public class Main {

	public static void main(String[] args) {
		 IOCContainer IocContainer=new IOCContainer();
	
		 
		 IocContainer.register(Readable.class,ConsoleReader.class);
		 IocContainer.register(Writable.class,ConsoleWriter.class);
		 
		
		 Orchestrator orchestrator = new Orchestrator(IocContainer);
		orchestrator.execute();
		
	}

}
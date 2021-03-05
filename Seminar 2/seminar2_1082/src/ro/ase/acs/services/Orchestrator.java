package ro.ase.acs.services;

import ro.ase.acs.writers.Writable;
import ro.ase.acs.main.IOCContainer;
import ro.ase.acs.readers.Readable;

public class Orchestrator {
	private IOCContainer IocContainer;
	private Readable reader; 
	private Writable writer;
	
	public Orchestrator()
	{
	
	}
	
	public Orchestrator(Readable reader, Writable writer )
	{
		this.reader=reader;
		this.writer=writer;
	}
	
	public Orchestrator(IOCContainer IocContainer) {
		this.reader = IocContainer.resolve(Readable.class);
		this.writer = IocContainer.resolve(Writable.class);
	}
	
	
	public void execute() {
		writer.write(reader.read());
	}
}
package ro.ase.acs.main;

import java.util.HashMap;
import java.util.Map;

public class IOCContainer {

   private 	Map<Class<?>, Class<?>> implementationMap = new HashMap<>();
			
			public void register(Class<?> contract, Class<?> implementation) 
			{
				implementationMap.put(contract, implementation);
				
			}	
			public <T> T resolve(Class<?> contract) {
				try {
					return (T) implementationMap.get(contract).newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				return null;
			}
		}






package fr.epita.tutorial.DAO.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurator {
	private final Properties properties;
	
	private static Configurator instance;


	public static Configurator getInstance() {
		if (instance == null) {
			instance = new Configurator();
		}
		return instance;
	}

	private Configurator() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(System.getProperty("conf")));
		} catch (final IOException e) {
			System.out.println("error while loading the configurator" + e.getMessage());
		}
	}
	public String getProperty(String key) {

		return properties.getProperty(key);

	}
}

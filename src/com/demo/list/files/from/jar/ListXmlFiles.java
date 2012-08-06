/**
 * 
 */
package com.demo.list.files.from.jar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * List the name of all xml which is in given jars
 * 
 * @author abdul
 */
public class ListXmlFiles {

	List<String> list = new ArrayList<String>();

	public List<String> getList() {
		return list;
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ListXmlFiles xmlFiles = new ListXmlFiles();
		JarFile jarFile = new JarFile("./lib/dummyJar.jar");
		Enumeration<JarEntry> e = jarFile.entries();
		while (e.hasMoreElements()) {
			xmlFiles.process(e.nextElement());
		}
		System.out.println("List:" + xmlFiles.getList());
	}

	private void process(Object obj) {
		JarEntry entry = (JarEntry)obj;
		String name = entry.getName();
		if(name.endsWith(".xml")) {
			list.add(name);		
		}
	}
}

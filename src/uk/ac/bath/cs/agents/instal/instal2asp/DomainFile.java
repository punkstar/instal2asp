package uk.ac.bath.cs.agents.instal.instal2asp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uk.ac.bath.cs.agents.instal.Domain;
import uk.ac.bath.cs.agents.instal.Type;

public class DomainFile {
    protected Pattern _pInitial = Pattern.compile("(\\w+)\\s*:\\s*(.*)");
    protected Pattern _pParts = Pattern.compile("([\\w\\d])+");
    protected File _f;
    
    public DomainFile(String file) {
        this._f = new File(file);
    }
    
    public Domain getDomain() throws FileNotFoundException, IOException {
    	Domain d = new Domain();
		FileInputStream f = new FileInputStream(this._f);
		BufferedReader r = new BufferedReader(new InputStreamReader(f));
		
		String line;
		while ((line = r.readLine()) != null) {
			Matcher m = _pInitial.matcher(line);
			
			while (m.find()) {
				if (m.groupCount() == 2) {
					String type = m.group(1);
					String parameters = m.group(2);
					
					Matcher m_parts = _pParts.matcher(parameters);
					while (m_parts.find()) {
						for (int i = 0; i < m_parts.groupCount(); i++) {
							d.concreteType(new Type(type), m_parts.group(i));
						}
					}
				} else {
					System.err.println("Couldn't recognise line");
				}
			}
		}
		
		f.close();
		r.close();
		
		return d;
    }
}

package com.pendulum101.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class XMLAccess {
	private ArrayList<JournalEntry> entries;
	private NodeList doc;
	public boolean readXML(String xml) {
        entries = new ArrayList<JournalEntry>();
        Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the    
            // XML file
            dom = db.parse(xml);

            //Element doc = dom.getDocumentElement();
            doc = dom.getDocumentElement().getElementsByTagName("entry");
//         	System.out.println(doc);
            for (int i = 0; i < doc.getLength(); i++) {
            	Element anEntry = (Element) doc.item(i);
            	JournalEntry entry = new JournalEntry();
            	entry.setTitle(getTextValue(anEntry, "title"));
            	entry.setDate(getTextValue(anEntry, "date"));
            	entry.setEntryContents(getTextValue(anEntry, "entryContents"));
            	entry.setMood(getTextValue(anEntry,"mood"));
            
                entries.add(entry);
			}
//           
//          each iteration adds one journal entry to the arrayList
//			For loop ending with: enties.add(JournalEntry);
//                  
            return true;

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return false;
    }
	
	public void saveToXML(String xml) {
	    Document dom;
	    Element e = null;

	    // instance of a DocumentBuilderFactory
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
	        // use factory to get an instance of document builder
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        // create instance of DOM
	        dom = db.newDocument();

	        // create the root element
	        Element rootEle = dom.createElement("journal");

	        for (int i = 0; i < doc.getLength(); i++) {
	        	
	        }
	        
	        for (int i = 0; i < doc.getLength(); i++) {
	        	JournalEntry anEntry = (JournalEntry) entries.get(i); 
	        	
	        	Element elem = (Element) rootEle.appendChild(dom.createElement("entry"));
	        	
	        	e = dom.createElement("title");
	        	e.appendChild(dom.createTextNode(anEntry.getTitle()));
	        	elem.appendChild(e);

	        	e = dom.createElement("date");
	        	e.appendChild(dom.createTextNode(anEntry.getDate()));
	        	elem.appendChild(e);

	        	e = dom.createElement("entryContents");
	        	e.appendChild(dom.createTextNode(anEntry.getEntryContents()));
	        	elem.appendChild(e);

	        	e = dom.createElement("mood");
	        	e.appendChild(dom.createTextNode(anEntry.getMood()));
	        	elem.appendChild(e);

	        } 

	        // create data elements and place them under root
	       
	        dom.appendChild(rootEle);

	        try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "journal.dtd");
	            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	            // send DOM to file
	            tr.transform(new DOMSource(dom), 
	                                 new StreamResult(new FileOutputStream(xml)));

	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    } catch (ParserConfigurationException pce) {
	        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
	    }
	}
	
	private String getTextValue( Element doc, String tag) {
	    String value = "";
	    NodeList nl;
	    nl = doc.getElementsByTagName(tag);
	    if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
	        value = nl.item(0).getFirstChild().getNodeValue();
	    }
	    return value;
	}
	
	public static void main(String[] args){
		XMLAccess test = new XMLAccess();
		test.readXML("resources/data/journal.xml");
		
		test.saveToXML("resources/data/journal2.xml");
	}
	
}

package com.dbcom;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

class dbErrorHandler implements ErrorHandler {
  public void warning(SAXParseException e) throws SAXException {
    show("Warning", e);
    throw (e);
  }
  public void error(SAXParseException e) throws SAXException {
    show("Error", e);
    throw (e);
  }
  public void fatalError(SAXParseException e) throws SAXException {
    show("Fatal Error", e);
    throw (e);
  }
  private void show(String type, SAXParseException e) {   
  }
}
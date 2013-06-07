
package com.mikalai.spring.editor;

import java.beans.PropertyEditorSupport;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateTimeEditor extends PropertyEditorSupport {
	
	private DateTimeFormatter dateTimeFormatter;
	
	public DateTimeEditor(String dateFormatPattern) {	
		dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
	}
	
	public void setAsText(String text) throws IllegalArgumentException {		
		setValue(DateTime.parse(text, dateTimeFormatter));
	}

}

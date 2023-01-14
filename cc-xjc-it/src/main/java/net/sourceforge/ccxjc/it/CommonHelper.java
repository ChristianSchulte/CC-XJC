package net.sourceforge.ccxjc.it;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

final class CommonHelper {
    static final double FLOAT_EPSILON = 0.001F;
    static final double DOUBLE_EPSILON = 0.00000001D;

    static Duration createDurationFromMillis( long millis ) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newDuration( millis );
    }

    static XMLGregorianCalendar now() throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
    }
}

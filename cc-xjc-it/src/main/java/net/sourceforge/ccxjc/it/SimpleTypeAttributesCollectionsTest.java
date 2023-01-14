/*
 * Copyright (C) 2009 The CC-XJC Project. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   o Redistributions of source code must retain the above copyright
 *     notice, this  list of conditions and the following disclaimer.
 *
 *   o Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in
 *     the documentation and/or other materials provided with the
 *     distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE CC-XJC PROJECT AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE CC-XJC PROJECT OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * $Id$
 */
package net.sourceforge.ccxjc.it;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import net.sourceforge.ccxjc.it.model.priv.collections.valueclass.ccxjcit.SimpleTypeAttributes;
import org.apache.commons.lang.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the {@code SimpleTypeAttributes} complex type.
 *
 * @author <a href="mailto:cs@schulte.it">Christian Schulte</a>
 * @version $Id$
 */
public class SimpleTypeAttributesCollectionsTest
{

    private static final String CCXJC_NS = "http://sourceforge.net/ccxjc/it";

    private XMLGregorianCalendar testCalendar;

    private Duration testDuration;

    private byte[] testBytes;

    private List<String> testEntities;

    private List<Object> testIdRefs;

    private List<String> testTokens;

    private QName testQName;

    public XMLGregorianCalendar getTestCalendar() throws DatatypeConfigurationException
    {
        if ( this.testCalendar == null )
        {
            this.testCalendar = CommonHelper.now();
        }

        return this.testCalendar;
    }

    public Duration getTestDuration() throws DatatypeConfigurationException
    {
        if ( this.testDuration == null )
        {
            this.testDuration = CommonHelper.createDurationFromMillis( 1000L );
        }

        return this.testDuration;
    }

    public byte[] getTestBytes()
    {
        if ( this.testBytes == null )
        {
            this.testBytes = new byte[ 256 ];
            for ( int i = 255; i >= 0; i-- )
            {
                this.testBytes[i] = (byte) i;
            }
        }

        return this.testBytes;
    }

    public List<String> getTestEntities()
    {
        if ( this.testEntities == null )
        {
            this.testEntities = Arrays.asList( "ENTITY 1", "ENTITY 2", "ENTITY 3" );

        }

        return this.testEntities;
    }

    public List<Object> getTestIdRefs()
    {
        if ( this.testIdRefs == null )
        {
            this.testIdRefs = Collections.singletonList( "ID" );

        }

        return this.testIdRefs;
    }

    public List<String> getTestTokens()
    {
        if ( this.testTokens == null )
        {
            this.testTokens = Arrays.asList( "NMTOKEN 1", "NMTOKEN 2", "NMTOKEN 3" );

        }

        return this.testTokens;
    }

    public QName getTestQName()
    {
        if ( this.testQName == null )
        {
            this.testQName = new QName( CCXJC_NS, "ID" );
        }

        return this.testQName;
    }

    public void assertTestBytes( final byte[] bytes )
    {
        Assert.assertArrayEquals(this.getTestBytes(), bytes);
    }

    public SimpleTypeAttributes getTestSimpleTypeAttributes() throws DatatypeConfigurationException
    {
        final SimpleTypeAttributes t = new SimpleTypeAttributes();

        t.setAnySimpleType( "any" );
        t.setAnyURI( "anyURI" );
        t.setBase64Binary( this.getTestBytes() );
        t.setBoolean( true );
        t.setByte( (byte) 1 );
        t.setDate( this.getTestCalendar() );
        t.setDateTime( this.getTestCalendar() );
        t.setDecimal( BigDecimal.TEN );
        t.setDouble( 100.0D );
        t.setDuration( this.getTestDuration() );
        t.setENTITY( "ENTITY" );
        t.setFloat( 100.0F );
        t.setGDay( this.getTestCalendar() );
        t.setGMonth( this.getTestCalendar() );
        t.setGMonthDay( this.getTestCalendar() );
        t.setGYear( this.getTestCalendar() );
        t.setGYearMonth( this.getTestCalendar() );
        t.setHexBinary( this.getTestBytes() );
        t.setID( "ID" );
        t.setIDREF( "ID" );
        t.setInt( 100 );
        t.setInteger( BigInteger.TEN );
        t.setLanguage( "en" );
        t.setLong( 100L );
        t.setNCName( "NCName" );
        t.setNMTOKEN( "NMTOKEN" );
        t.setNOTATION( this.getTestQName() );
        t.setName( "name" );
        t.setNegativeInteger( BigInteger.valueOf( -100L ) );
        t.setNonNegativeInteger( BigInteger.TEN );
        t.setNonPositiveInteger( BigInteger.valueOf( -100L ) );
        t.setNormalizedString( "normalized" );
        t.setPositiveInteger( BigInteger.TEN );
        t.setQName( this.getTestQName() );
        t.setShort( (short) 100 );
        t.setString( "String" );
        t.setTime( this.getTestCalendar() );
        t.setToken( "Token" );
        t.setUnsignedByte( (short) 100 );
        t.setUnsignedInt( 100L );
        t.setUnsignedLong( BigInteger.TEN );
        t.setUnsignedShort( 100 );

        t.getENTITIES().addAll( this.getTestEntities() );
        t.getIDREFS().addAll( this.getTestIdRefs() );
        t.getNMTOKENS().addAll( this.getTestTokens() );

        return t;
    }

    public void assertTestSimpleTypeAttributes( final SimpleTypeAttributes a ) throws DatatypeConfigurationException
    {
        Assert.assertEquals( "any", a.getAnySimpleType() );
        Assert.assertEquals( "anyURI", a.getAnyURI() );
        this.assertTestBytes( a.getBase64Binary() );
        Assert.assertTrue( a.isBoolean() );
        Assert.assertEquals( 1, a.getByte() );
        Assert.assertEquals( this.getTestCalendar(), a.getDate() );
        Assert.assertEquals( this.getTestCalendar(), a.getDateTime() );
        Assert.assertEquals( BigDecimal.TEN, a.getDecimal() );
        Assert.assertEquals(100.0D, a.getDouble(), CommonHelper.DOUBLE_EPSILON );
        Assert.assertEquals( this.getTestDuration(), a.getDuration() );
        Assert.assertEquals( this.getTestEntities(), a.getENTITIES() );
        Assert.assertEquals( "ENTITY", a.getENTITY() );
        Assert.assertEquals(100.0F, a.getFloat(), CommonHelper.FLOAT_EPSILON );
        Assert.assertEquals( this.getTestCalendar(), a.getGDay() );
        Assert.assertEquals( this.getTestCalendar(), a.getGMonth() );
        Assert.assertEquals( this.getTestCalendar(), a.getGMonthDay() );
        Assert.assertEquals( this.getTestCalendar(), a.getGYear() );
        Assert.assertEquals( this.getTestCalendar(), a.getGYearMonth() );
        this.assertTestBytes( a.getHexBinary() );
        Assert.assertEquals( "ID", a.getID() );
        Assert.assertEquals( "ID", a.getIDREF() );
        Assert.assertEquals( this.getTestIdRefs(), a.getIDREFS() );
        Assert.assertEquals( 100, a.getInt() );
        Assert.assertEquals( BigInteger.TEN, a.getInteger() );
        Assert.assertEquals( "en", a.getLanguage() );
        Assert.assertEquals( 100L, a.getLong() );
        Assert.assertEquals( "NCName", a.getNCName() );
        Assert.assertEquals( "NMTOKEN", a.getNMTOKEN() );
        Assert.assertEquals( this.getTestTokens(), a.getNMTOKENS() );
        Assert.assertEquals( this.getTestQName(), a.getNOTATION() );
        Assert.assertEquals( "name", a.getName() );
        Assert.assertEquals( BigInteger.valueOf( -100L ), a.getNegativeInteger() );
        Assert.assertEquals( BigInteger.TEN, a.getNonNegativeInteger() );
        Assert.assertEquals( BigInteger.valueOf( -100L ), a.getNonPositiveInteger() );
        Assert.assertEquals( "normalized", a.getNormalizedString() );
        Assert.assertEquals( BigInteger.TEN, a.getPositiveInteger() );
        Assert.assertEquals( this.getTestQName(), a.getQName() );
        Assert.assertEquals( 100, a.getShort() );
        Assert.assertEquals( "String", a.getString() );
        Assert.assertEquals( this.getTestCalendar(), a.getTime() );
        Assert.assertEquals( "Token", a.getToken() );
        Assert.assertEquals( 100, a.getUnsignedByte() );
        Assert.assertEquals( 100, a.getUnsignedInt() );
        Assert.assertEquals( BigInteger.TEN, a.getUnsignedLong() );
        Assert.assertEquals( 100, a.getUnsignedShort() );
    }

    @Test public void testSimpleTypeAttributesNull() throws Exception
    {
        new SimpleTypeAttributes( null );
    }

    @Test public void testSimpleTypeAttributesDefaults() throws Exception
    {
        new SimpleTypeAttributes( new SimpleTypeAttributes() );
    }

    @Test public void testSimpleTypeAttributes() throws Exception
    {
        this.assertTestSimpleTypeAttributes( new SimpleTypeAttributes( this.getTestSimpleTypeAttributes() ) );
    }

    @Test public void testSerializable() throws Exception
    {
        final int runs = 100000;

        System.gc();
        System.gc();
        System.gc();

        final SimpleTypeAttributes a = this.getTestSimpleTypeAttributes();

        long start = System.currentTimeMillis();
        for ( int i = runs; i >= 0; i-- )
        {
            this.assertTestSimpleTypeAttributes( (SimpleTypeAttributes) SerializationUtils.clone( a ) );
        }
        final long serializableMillis = System.currentTimeMillis() - start;

        System.gc();
        System.gc();
        System.gc();

        start = System.currentTimeMillis();
        for ( int i = runs; i >= 0; i-- )
        {
            this.assertTestSimpleTypeAttributes( (SimpleTypeAttributes) a.copyTo( null ) );
        }
        final long jaxbMillis = System.currentTimeMillis() - start;

        System.gc();
        System.gc();
        System.gc();

        start = System.currentTimeMillis();
        for ( int i = runs; i >= 0; i-- )
        {
            this.assertTestSimpleTypeAttributes( new SimpleTypeAttributes( a ) );
        }
        final long copyMillis = System.currentTimeMillis() - start;

        System.gc();
        System.gc();
        System.gc();

        System.out.println( "Creating " + runs + " copies using serialization took " + serializableMillis +
                            "ms. (100%)" );

        System.out.println( "Creating " + runs + " copies using jaxb2_commons took " + jaxbMillis + "ms. (" +
                            ( 100L * jaxbMillis / serializableMillis ) + "%)" );

        System.out.println( "Creating " + runs + " copies using copy constructor took " + copyMillis + "ms. (" +
                            ( 100L * copyMillis / serializableMillis ) + "%)" );

        Assert.assertTrue( copyMillis < serializableMillis );
    }

}

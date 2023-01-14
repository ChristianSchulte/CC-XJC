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

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import net.sourceforge.ccxjc.it.model.priv.collections.valueclass.ccxjcit.ChoiceComplexType;
import org.junit.Test;

/**
 * Tests the {@code ChoiceComplexType} complex type.
 *
 * @author <a href="mailto:cs@schulte.it">Christian Schulte</a>
 * @version $Id$
 */
public class ChoiceComplexTypeTest
{

    @Test public void testChoiceComplexType() throws Exception
    {
        final JAXBElement<ChoiceComplexType> e = (JAXBElement<ChoiceComplexType>) JAXBContext.newInstance(
            ChoiceComplexType.class ).createUnmarshaller().unmarshal( this.getClass().getResource(
            "ChoiceComplexTypeTest.xml" ) );

        final ChoiceComplexType copy = new ChoiceComplexType( e.getValue() );
        for ( Object o : copy.getStringItemOrIntItemOrBase64BinaryItem() )
        {
            System.out.println( o );
        }
    }

}

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

import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

/**
 * Class referenced by {@code &lt;jaxb:class ref="net.sourceforge.ccxjc.it.ReferencedClass"&gt;} test customizations.
 *
 * @author <a href="mailto:cs@schulte.it">Christian Schulte</a>
 * @version $Id$
 */
public class ReferencedClass implements Cloneable
{

    public ReferencedClass()
    {
        super();
    }

    public ReferencedClass( final ReferencedClass o )
    {
        super();
    }

    @Override
    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch ( final CloneNotSupportedException e )
        {
            throw new AssertionError( e );
        }
    }

    public StringBuilder appendFields( final ObjectLocator locator, final StringBuilder buffer, final ToStringStrategy2 strategy ) {
        return buffer;
    }

    public boolean equals( final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object, final EqualsStrategy2 strategy ) {
        return true;
    }

    public int hashCode( final ObjectLocator locator, final HashCodeStrategy2 strategy ) {
        return 0;
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        return target;
    }
}

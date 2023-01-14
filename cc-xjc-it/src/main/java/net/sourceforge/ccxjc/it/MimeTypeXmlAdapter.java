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

import jakarta.activation.MimeType;
import jakarta.activation.MimeTypeParseException;
import jakarta.xml.bind.DataBindingException;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@code XmlAdapter} adapting {@code String} to {@code MimeType}.
 *
 * @author <a href="mailto:schulte2005@users.sourceforge.net">Christian Schulte</a>
 * @version $Id$
 */
public final class MimeTypeXmlAdapter extends XmlAdapter<String, MimeType>
{

    /** Creates a new {@code MimeTypeXmlAdapter} instance. */
    public MimeTypeXmlAdapter()
    {
        super();
    }

    /**
     * Converts a {@code String} to a {@code MimeType}.
     *
     * @param s The {@code String} to convert or {@code null}.
     *
     * @return A new {@code MimeType} instance created by parsing {@code s} or {@code null}.
     *
     * @throws DataBindingException if parsing {@code s} fails.
     */
    @Override
    public MimeType unmarshal( final String s ) throws DataBindingException
    {
        return parseMimeType( s );
    }

    /**
     * Converts a {@code MimeType} instance to a {@code String}.
     *
     * @param mimeType The {@code MimeType} to convert or {@code null}.
     *
     * @return The string representation of {@code mimeType} or {@code null}.
     */
    @Override
    public String marshal( final MimeType mimeType )
    {
        return printMimeType( mimeType );
    }

    /**
     * Converts a {@code String} to a {@code MimeType}.
     *
     * @param s The {@code String} to convert or {@code null}.
     *
     * @return A new {@code MimeType} instance created by parsing {@code s} or {@code null}.
     *
     * @throws DataBindingException if parsing {@code s} fails.
     */
    public static MimeType parseMimeType( final String s )
    {
        try
        {
            return s != null ? new MimeType( s ) : null;
        }
        catch ( final MimeTypeParseException e )
        {
            throw new DataBindingException( e );
        }
    }

    /**
     * Converts a {@code MimeType} instance to a {@code String}.
     *
     * @param mimeType The {@code MimeType} to convert or {@code null}.
     *
     * @return The string representation of {@code mimeType} or {@code null}.
     */
    public static String printMimeType( final MimeType mimeType )
    {
        return mimeType != null ? mimeType.toString() : null;
    }

}

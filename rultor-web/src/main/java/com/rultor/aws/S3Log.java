/**
 * Copyright (c) 2009-2013, rultor.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the rultor.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.rultor.aws;

import com.jcabi.aspects.Immutable;
import com.jcabi.aspects.Loggable;
import com.jcabi.urn.URN;
import com.rultor.spi.Conveyer;
import com.rultor.spi.Pulse;
import com.rultor.spi.Work;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Logs in temp files.
 *
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id$
 * @since 1.0
 */
@Immutable
@ToString
@EqualsAndHashCode(of = "client")
@Loggable(Loggable.DEBUG)
public final class S3Log implements Conveyer.Log {

    /**
     * S3 client.
     */
    private final transient S3Client client;

    /**
     * Bucket name.
     */
    private final transient String bucket;

    /**
     * Public ctor.
     * @param key AWS key
     * @param secret AWS secret
     * @param bkt Bucket name
     */
    public S3Log(final String key, final String secret, final String bkt) {
        this(new S3Client.Simple(key, secret), bkt);
    }

    /**
     * Public ctor.
     * @param clnt Client
     * @param bkt Bucket name
     */
    protected S3Log(final S3Client clnt, final String bkt) {
        this.client = clnt;
        this.bucket = bkt;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(final Work work, final Conveyer.Line line) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get pulses.
     * @param owner Owner
     * @param unit Unit name
     * @return All pulses of this unit
     */
    public Iterable<Pulse> pulses(final URN owner, final String unit) {
        return null;
    }

}

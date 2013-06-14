package com.epickrram.ipc.inmemory;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static java.nio.ByteBuffer.wrap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InMemoryDataChannelTest
{
    private static final byte[] DATA = new byte[]{1, 2, 3, 4};
    private InMemoryDataChannel dataChannel;
    private byte[] receiverBuffer = new byte[4];

    @Before
    public void setup()
    {
        dataChannel = new InMemoryDataChannel();
    }

    @Test
    public void shouldPublishMessage() throws Exception
    {
        final long nextWriteSequence = dataChannel.publisherControl().getNextWriteSequence();
        dataChannel.publish(nextWriteSequence, wrap(DATA));

        final long publishedWriteSequence = dataChannel.subscriberControl().getPublishedWriteSequence();

        assertThat(publishedWriteSequence, is(nextWriteSequence));
        assertThat(publishedWriteSequence, is(0L));

        dataChannel.receive(publishedWriteSequence, wrap(receiverBuffer));

        assertThat(receiverBuffer, is(sameByteSequence(DATA)));
    }

    @Test
    public void shouldPublishMultipleMessages() throws Exception
    {
        long nextWriteSequence = dataChannel.publisherControl().getNextWriteSequence();
        dataChannel.publish(nextWriteSequence, wrap(DATA));

        nextWriteSequence = dataChannel.publisherControl().getNextWriteSequence();
        dataChannel.publish(nextWriteSequence, wrap(DATA));

        final long publishedWriteSequence = dataChannel.subscriberControl().getPublishedWriteSequence();

        assertThat(publishedWriteSequence, is(nextWriteSequence));
        assertThat(publishedWriteSequence, is(1L));

        dataChannel.receive(publishedWriteSequence, wrap(receiverBuffer));

        assertThat(receiverBuffer, is(sameByteSequence(DATA)));
    }

    private Matcher<byte[]> sameByteSequence(final byte[] data)
    {
        return new TypeSafeMatcher<byte[]>()
        {
            @Override
            public boolean matchesSafely(final byte[] bytes)
            {
                return Arrays.equals(data, bytes);
            }

            @Override
            public void describeTo(final Description description)
            {
                description.appendText(Arrays.toString(data));
            }
        };
    }
}

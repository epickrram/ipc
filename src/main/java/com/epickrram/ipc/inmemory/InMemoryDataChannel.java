package com.epickrram.ipc.inmemory;

import com.epickrram.ipc.ChannelPublisherControl;
import com.epickrram.ipc.ChannelSubscriberControl;
import com.epickrram.ipc.ReadableDataChannel;
import com.epickrram.ipc.WritableDataChannel;

import java.nio.ByteBuffer;

public class InMemoryDataChannel implements WritableDataChannel, ReadableDataChannel
{
    private final InMemoryChannelPublisherControl channelControl = new InMemoryChannelPublisherControl();
    private final byte[][] store = new byte[64][];

    public InMemoryDataChannel()
    {
        for(int i = 0; i < store.length; i++)
        {
            store[i] = new byte[4];
        }
    }

    @Override
    public void publish(final long sequence, final ByteBuffer data)
    {
        data.get(element(sequence));
        channelControl.onPublish(sequence);
    }

    @Override
    public void receive(final long sequence, final ByteBuffer data)
    {
        data.put(element(sequence));
        data.flip();
    }

    @Override
    public ChannelPublisherControl publisherControl()
    {
        return channelControl;
    }

    @Override
    public ChannelSubscriberControl subscriberControl()
    {
        return channelControl;
    }

    private byte[] element(final long sequence)
    {
        return store[(int) (sequence % store.length)];
    }
}

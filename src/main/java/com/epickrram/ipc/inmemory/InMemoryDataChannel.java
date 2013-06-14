package com.epickrram.ipc.inmemory;

import com.epickrram.ipc.ChannelPublisherControl;
import com.epickrram.ipc.DataChannel;

import java.nio.ByteBuffer;

public class InMemoryDataChannel implements DataChannel
{
    private final ChannelPublisherControl publisherControl = new InMemoryChannelPublisherControl();

    @Override
    public void publish(final ByteBuffer data, final int offset, final int length)
    {
    }

    @Override
    public ChannelPublisherControl publisherControl()
    {
        return publisherControl;
    }
}

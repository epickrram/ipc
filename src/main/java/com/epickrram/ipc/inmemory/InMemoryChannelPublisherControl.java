package com.epickrram.ipc.inmemory;

import com.epickrram.ipc.ChannelPublisherControl;
import com.epickrram.ipc.ChannelSubscriberControl;

public class InMemoryChannelPublisherControl implements ChannelPublisherControl, ChannelSubscriberControl
{
    private long nextWriteSequence = 0;
    private long lowestReadSequence = 0;

    @Override
    public long getNextWriteSequence()
    {
        return nextWriteSequence;
    }

    @Override
    public long getLowestReadSequence()
    {
        return lowestReadSequence;
    }

    @Override
    public long getPublishedWriteSequence()
    {
        return 0;
    }

    @Override
    public void updateLastReadSequence(final long sequence)
    {
    }
}

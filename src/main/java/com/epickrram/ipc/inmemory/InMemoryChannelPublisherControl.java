package com.epickrram.ipc.inmemory;

import com.epickrram.ipc.ChannelPublisherControl;

public class InMemoryChannelPublisherControl implements ChannelPublisherControl
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
}

package com.epickrram.ipc.inmemory;

import com.epickrram.ipc.ChannelPublisherControl;
import com.epickrram.ipc.ChannelSubscriberControl;

public class InMemoryChannelPublisherControl implements ChannelPublisherControl, ChannelSubscriberControl
{
    private long nextWriteSequence = -1;
    private long lowestReadSequence = -1;
    private long highestPublishedSequence = -1;

    @Override
    public long getNextWriteSequence()
    {
        return ++nextWriteSequence;
    }

    @Override
    public long getLowestReadSequence()
    {
        return lowestReadSequence;
    }

    @Override
    public long getPublishedWriteSequence()
    {
        return highestPublishedSequence;
    }

    @Override
    public void updateLastReadSequence(final long sequence)
    {
    }

    void onPublish(final long sequence)
    {
        highestPublishedSequence = sequence;
    }
}

package com.epickrram.ipc;

public interface ChannelSubscriberControl
{
    long getPublishedWriteSequence();
    void updateLastReadSequence(final long sequence);
}

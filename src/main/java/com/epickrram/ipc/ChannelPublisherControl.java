package com.epickrram.ipc;

public interface ChannelPublisherControl
{
    long getNextWriteSequence();
    long getLowestReadSequence();
}

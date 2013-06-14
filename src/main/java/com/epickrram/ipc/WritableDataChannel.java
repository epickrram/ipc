package com.epickrram.ipc;

import java.nio.ByteBuffer;

public interface WritableDataChannel
{
    void publish(final long sequence, final ByteBuffer data);
    ChannelPublisherControl publisherControl();
}
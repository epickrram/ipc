package com.epickrram.ipc;

import java.nio.ByteBuffer;

public interface DataChannel
{
    void publish(final ByteBuffer data, final int offset, final int length);
    ChannelPublisherControl publisherControl();
}
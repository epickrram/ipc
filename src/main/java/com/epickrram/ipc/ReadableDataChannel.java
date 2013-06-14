package com.epickrram.ipc;

import java.nio.ByteBuffer;

public interface ReadableDataChannel
{
    void receive(final long sequence, final ByteBuffer data);
    ChannelSubscriberControl subscriberControl();
}
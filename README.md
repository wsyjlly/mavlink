# mavlink
Java parsing toolkit for mavlink protocol
---
**MessageBuffer**
> 读取多包消息字节数组，返回消息列表对象
> List<T> readMessageList(byte[] packetsBytes, Class<T> messageType)
> 读取消息列表，返回void,回调可获取消息列表对象
> void readMessageList(byte[] packetsBytes, Class<T> messageType, Consumer<List<T>> consumer)
> 读取单包消息字节数组，返回消息对象
> T readMessage(byte[] packetBytes,Class<T> messageClass)
> 读取单包消息字节数组，返回void,回调可获取消息对象
> void readMessage(byte[] packetBytes, Class<T> messageType, Consumer<T> consumer)

# mavlink
Java parsing toolkit for mavlink protocol
---

**使用**

1. 引入Maven依赖

    ```xml
    <dependency>
        <groupId>cn.wsyjlly</groupId>
        <artifactId>mavlink</artifactId>
        <version>1.0.0</version>
    </dependency>
    ```

2. Mavlink数据包解析

    **Packet**

    > Mavlink数据包解析

    - Mavlink版本1数据包解析

        ```java
        void readV1Packet(byte[] packetBytes, Consumer<Packet<T>> consumer);
        Packet<T> readV1Packet(byte[] packetBytes);
        ```

    - Mavlink版本2数据包解析

        ```java
        
        void readV2Packet(byte[] packetBytes, Consumer<Packet<T>> consumer);
        Packet<T> readV2Packet(byte[] packetBytes);
        ```

        

    **MessageBuilder**

    > 二层消息（数据包载荷）解析

    - 读取多包消息字节数组，返回消息列表对象

        ```java
        List<T> readMessageList(byte[] packetsBytes, Class<T> messageType)  
        ```

    - 读取消息列表，返回void,回调可获取消息列表对象 

        ```java
        void readMessageList(byte[] packetsBytes, Class<T> messageType, Consumer<List<T>> consumer)  
        ```

    - 读取单包消息字节数组，返回消息对象

        ```java
        T readMessage(byte[] packetBytes,Class<T> messageClass)      
        ```

    - 读取单包消息字节数组，返回void,回调可获取消息对象

        ```java
        void readMessage(byte[] packetBytes, Class<T> messageType, Consumer<T> consumer)
        ```


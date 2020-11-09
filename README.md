# Mavlink解析工具包
Java parsing toolkit for mavlink protocol
---

**使用流程**

### 一、引入Maven依赖

```xml
<dependency>
    <groupId>cn.wsyjlly</groupId>
    <artifactId>mavlink</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 二、Mavlink数据包解析使用方式

#### **MessageBuilder静态工具类**

> 二层消息（数据包载荷）解析

- 方法一：读取多包消息字节数组，返回消息列表对象

    ```java
    /**
     * @param packetsBytes 多包多消息数据字节数组
     * @param messageType 接收的消息类型对应的Java类
     * @Return 返回Java接收对象的消息对象列表
     */
    List<T> readMessageList(byte[] packetsBytes, Class<T> messageType)  
    ```

- 方法二：读取消息列表，返回void,回调可获取消息列表对象 

    ```java
    /**
     * @param packetsBytes 多包多消息数据字节数组
     * @param messageType 接收的消息类型对应的Java类
     * @param consumer 消费类型的回调，接收参数为包解析的处理对象
     * @Return 返回void
     */
    void readMessageList(byte[] packetsBytes, Class<T> messageType, Consumer<List<T>> consumer)  
    ```

- 方法三：读取单包消息字节数组，返回消息对象

    ```java
    /**
     * @param packetBytes 单包单消息数据字节数组
     * @param messageType 接收的消息类型对应的Java类
     * @Return 返回Java接收对象的消息对象
     */
    T readMessage(byte[] packetBytes,Class<T> messageClass)      
    ```

- 方法四：读取单包消息字节数组，返回void,回调可获取消息对象

    ```java
    /**
     * @param packetsBytes 单包单消息数据字节数组
     * @param messageType 接收的消息类型对应的Java类
     * @param consumer 消费类型的回调，接收参数为包解析的处理对象
     * @Return 返回void
     */
    void readMessage(byte[] packetBytes, Class<T> messageType, Consumer<T> consumer)
    ```

#### **Packet静态工具类**

> Mavlink数据包解析

- Mavlink版本1数据包解析

    ```java
    /**
     * @param packetBytes 单包消息数据字节数组（V1版本）
     * @param consumer 消费类型的回调，接收参数为包解析对象
     * @Return 返回void
     */
    void readV1Packet(byte[] packetBytes, Consumer<Packet<T>> consumer);
    /**
     * @param packetBytes 单包消息数据字节数组
     * @Return 返回包解析对象（解析出消息ID，载荷，载荷长度等数据）
     */
    Packet<T> readV1Packet(byte[] packetBytes);
    ```

- Mavlink版本2数据包解析

    ```java
    /**
     * @param packetBytes 单包消息数据字节数组（V2版本）
     * @param consumer 消费类型的回调，接收参数为包解析对象
     * @Return 返回void
 */
    void readV2Packet(byte[] packetBytes, Consumer<Packet<T>> consumer);
    /**
     * @param packetBytes 单包消息数据字节数组
     * @Return 返回包解析对象（解析出消息ID，载荷，载荷长度等数据）
     */
    Packet<T> readV2Packet(byte[] packetBytes);
    ```
    
- Mavlink版本1数据包构建
- Mavlink版本2数据包无签名构建
- Mavlink版本2数据包解析有签名构建
#### **FileGenerator**

> 如需自定义mavlink协议消息，需使用该工具类生成自定义消息Java映射类，注意：自定义消息的XML文件格式需符合官方定义规范。

```java
/**
 * @param srcFile 自定义消息XML描述文件位置
 * @param targetFolder 生成Java映射类文件夹位置
 */
void generator(String srcFile, String targetFolder);
```

### 三、使用示例

- 多消息字节数组解析

```java
//lambda式回调接收解析对象列表
MessageBuilder.readMessageList(bytes, GpsRawInt.class,(gpsRawIntList -> gpsRawIntList.forEach(System.out::println)));
//返回值式式回调接收解析对象列表
List<GpsRawInt> gpsRawIntList = MessageBuilder.readMessageList(bytes, GpsRawInt.class);
gpsRawIntList.forEach(System.out::println);
```

- 单消息字节数组解析

```java
//lambda式回调接收解析对象列表
MessageBuilder.readMessage(bytes, SysStatus.class,(System.out::println));
//返回值式式回调接收解析对象
SysStatus sysStatus = MessageBuilder.readMessage(bytes, SysStatus.class);
System.out.println(sysStatus);
```

### 四、消息ID对应Java类型

|  id  |     JavaClass     | dexcription |
| :--: | :---------------: | :---------: |
|  0   | `Heartbeat.class` |  The heartbeat message shows that a system is present and responding. The type of the MAV and Autopilot hardware allow the receiving system to treat further messages from this system appropriate (e.g. by laying out the user interface based on the autopilot).  |
|  1   | `SysStatus.class` |  The general system state. If the system is following the MAVLink standard, the system state is mainly defined by three orthogonal states/modes: The system mode, which is either LOCKED (motors shut down and locked), MANUAL (system under RC control), GUIDED (system with autonomous position control, position setpoint controlled manually) or AUTO (system guided by path/waypoint planner). The NAV_MODE defined the current flight state: LIFTOFF (often an open-loop maneuver), LANDING, WAYPOINTS or VECTOR. This represents the internal navigation state machine. The system status shows wether the system is currently active or not and if an emergency occured. During the CRITICAL and EMERGENCY states the MAV is still considered to be active, but should start emergency procedures autonomously. After a failure occured it should first move from active to critical to allow manual intervention and then move to emergency after a certain timeout.  |
|  2   | `SystemTime.class` |  The system time is the time of the master clock, typically the computer clock of the main onboard computer.  |
|  4   | `Ping.class` |  A ping message either requesting or responding to a ping. This allows to measure the system latencies, including serial port, radio modem and UDP connections.  |
|  5   | `ChangeOperatorControl.class` |  Request to control this MAV  |
|  6   | `ChangeOperatorControlAck.class` |  Accept / deny control of this MAV  |
|  7   | `AuthKey.class` |  Emit an encrypted signature / key identifying this system. PLEASE NOTE: This protocol has been kept simple, so transmitting the key requires an encrypted channel for true safety.  |
|  11   | `SetMode.class` |  Set the system mode, as defined by enum MAV_MODE. There is no target component id as the mode is by definition for the overall aircraft, not only for one component.  |
|  20   | `ParamRequestRead.class` |  Request to read the onboard parameter with the param_id string id. Onboard parameters are stored as key[const char*] -> value[float]. This allows to send a parameter to any other component (such as the GCS) without the need of previous knowledge of possible parameter names. Thus the same GCS can store different parameters for different autopilots. See also http://qgroundcontrol.org/parameter_interface for a full documentation of QGroundControl and IMU code.  |
|  21   | `ParamRequestList.class` |  Request all parameters of this component. After his request, all parameters are emitted.  |
|  22   | `ParamValue.class` |  Emit the value of a onboard parameter. The inclusion of param_count and param_index in the message allows the recipient to keep track of received parameters and allows him to re-request missing parameters after a loss or timeout.  |
|  23   | `ParamSet.class` |  Set a parameter value TEMPORARILY to RAM. It will be reset to default on system reboot. Send the ACTION MAV_ACTION_STORAGE_WRITE to PERMANENTLY write the RAM contents to EEPROM. IMPORTANT: The receiving component should acknowledge the new parameter value by sending a param_value message to all communication partners. This will also ensure that multiple GCS all have an up-to-date list of all parameters. If the sending GCS did not receive a PARAM_VALUE message within its timeout time, it should re-send the PARAM_SET message.  |
|  24   | `GpsRawInt.class` |  The global position, as returned by the Global Positioning System (GPS). This is NOT the global position estimate of the sytem, but rather a RAW sensor value. See message GLOBAL_POSITION for the global position estimate. Coordinate frame is right-handed, Z-axis up (GPS frame).  |
|  25   | `GpsStatus.class` |  The positioning status, as reported by GPS. This message is intended to display status information about each satellite visible to the receiver. See message GLOBAL_POSITION for the global position estimate. This message can contain information for up to 20 satellites.  |
|  26   | `ScaledImu.class` |  The RAW IMU readings for the usual 9DOF sensor setup. This message should contain the scaled values to the described units  |
|  27   | `RawImu.class` |  The RAW IMU readings for the usual 9DOF sensor setup. This message should always contain the true raw values without any scaling to allow data capture and system debugging.  |
|  28   | `RawPressure.class` |  The RAW pressure readings for the typical setup of one absolute pressure and one differential pressure sensor. The sensor values should be the raw, UNSCALED ADC values.  |
|  29   | `ScaledPressure.class` |  The pressure readings for the typical setup of one absolute and differential pressure sensor. The units are as specified in each field.  |
|  30   | `Attitude.class` |  The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right).  |
|  31   | `AttitudeQuaternion.class` |  The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0).  |
|  32   | `LocalPositionNed.class` |  The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)  |
|  33   | `GlobalPositionInt.class` |  The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the resolution of float is not sufficient.  |
|  34   | `RcChannelsScaled.class` |  The scaled values of the RC channels received. (-100%) -10000, (0%) 0, (100%) 10000. Channels that are inactive should be set to UINT16_MAX.  |
|  35   | `RcChannelsRaw.class` |  The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.  |
|  36   | `ServoOutputRaw.class` |  The RAW values of the servo outputs (for RC input from the remote, use the RC_CHANNELS messages). The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%.  |
|  37   | `MissionRequestPartialList.class` |  Request a partial list of mission items from the system/component. http://qgroundcontrol.org/mavlink/waypoint_protocol. If start and end index are the same, just send one waypoint.  |
|  38   | `MissionWritePartialList.class` |  This message is sent to the MAV to write a partial list. If start index == end index, only one item will be transmitted / updated. If the start index is NOT 0 and above the current list size, this request should be REJECTED!  |
|  39   | `MissionItem.class` |  Message encoding a mission item. This message is emitted to announce the presence of a mission item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is Z-up, right handed (ENU). See also http://qgroundcontrol.org/mavlink/waypoint_protocol.  |
|  40   | `MissionRequest.class` |  Request the information of the mission item with the sequence number seq. The response of the system to this message should be a MISSION_ITEM message. http://qgroundcontrol.org/mavlink/waypoint_protocol  |
|  41   | `MissionSetCurrent.class` |  Set the mission item with sequence number seq as current item. This means that the MAV will continue to this mission item on the shortest path (not following the mission items in-between).  |
|  42   | `MissionCurrent.class` |  Message that announces the sequence number of the current active mission item. The MAV will fly towards this mission item.  |
|  43   | `MissionRequestList.class` |  Request the overall list of mission items from the system/component.  |
|  300   | `ProtocolVersion.class` |  Version and capability of protocol version. This message can be requested with MAV_CMD_REQUEST_MESSAGE and is used as part of the handshaking to establish which MAVLink version should be used on the network. Every node should respond to a request for PROTOCOL_VERSION to enable the handshaking. Library implementers should consider adding this into the default decoding state machine to allow the protocol core to respond directly.  |
|  44   | `MissionCount.class` |  This message is emitted as response to MISSION_REQUEST_LIST by the MAV and to initiate a write transaction. The GCS can then request the individual mission item based on the knowledge of the total number of MISSIONs.  |
|  45   | `MissionClearAll.class` |  Delete all mission items at once.  |
|  46   | `MissionItemReached.class` |  A certain mission item has been reached. The system will either hold this position (or circle on the orbit) or (if the autocontinue on the WP was set) continue to the next MISSION.  |
|  47   | `MissionAck.class` |  Ack message during MISSION handling. The type field states if this message is a positive ack (type=0) or if an error happened (type=non-zero).  |
|  48   | `SetGpsGlobalOrigin.class` |  As local waypoints exist, the global MISSION reference allows to transform between the local coordinate frame and the global (GPS) coordinate frame. This can be necessary when e.g. in- and outdoor settings are connected and the MAV should move from in- to outdoor.  |
|  49   | `GpsGlobalOrigin.class` |  Once the MAV sets a new GPS-Local correspondence, this message announces the origin (0,0,0) position  |
|  54   | `SafetySetAllowedArea.class` |  Set a safety zone (volume), which is defined by two corners of a cube. This message can be used to tell the MAV which setpoints/MISSIONs to accept and which to reject. Safety areas are often enforced by national or competition regulations.  |
|  55   | `SafetyAllowedArea.class` |  Read out the safety zone the MAV currently assumes.  |
|  61   | `AttitudeQuaternionCov.class` |  The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0).  |
|  62   | `NavControllerOutput.class` |  Outputs of the APM navigation controller. The primary use of this message is to check the response and signs of the controller before actual flight and to assist with tuning controller parameters.  |
|  63   | `GlobalPositionIntCov.class` |  The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the resolution of float is not sufficient. NOTE: This message is intended for onboard networks / companion computers and higher-bandwidth links and optimized for accuracy and completeness. Please use the GLOBAL_POSITION_INT message for a minimal subset.  |
|  64   | `LocalPositionNedCov.class` |  The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)  |
|  65   | `RcChannels.class` |  The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.  |
|  66   | `RequestDataStream.class` |  The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.  |
|  67   | `DataStream.class` |  The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.  |
|  69   | `ManualControl.class` |  This message provides an API for manually controlling the vehicle using standard joystick axes nomenclature, along with a joystick-like input device. Unused axes can be disabled an buttons are also transmit as boolean values of their  |
|  70   | `RcChannelsOverride.class` |  The RAW values of the RC channels sent to the MAV to override info received from the RC radio. A value of UINT16_MAX means no change to that channel. A value of 0 means control of that channel should be released back to the RC radio. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.  |
|  73   | `MissionItemInt.class` |  Message encoding a mission item. This message is emitted to announce the presence of a mission item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is Z-up, right handed (ENU). See alsohttp://qgroundcontrol.org/mavlink/waypoint_protocol.  |
|  74   | `VfrHud.class` |  Metrics typically displayed on a HUD for fixed wing aircraft  |
|  75   | `CommandInt.class` |  Message encoding a command with parameters as scaled integers. Scaling depends on the actual command value.  |
|  76   | `CommandLong.class` |  Send a command with up to seven parameters to the MAV  |
|  77   | `CommandAck.class` |  Report status of a command. Includes feedback wether the command was executed.  |
|  81   | `ManualSetpoint.class` |  Setpoint in roll, pitch, yaw and thrust from the operator  |
|  82   | `SetAttitudeTarget.class` |  Set the vehicle attitude and body angular rates.  |
|  83   | `AttitudeTarget.class` |  Set the vehicle attitude and body angular rates.  |
|  84   | `SetPositionTargetLocalNed.class` |  Set vehicle position, velocity and acceleration setpoint in local frame.  |
|  85   | `PositionTargetLocalNed.class` |  Set vehicle position, velocity and acceleration setpoint in local frame.  |
|  86   | `SetPositionTargetGlobalInt.class` |  Set vehicle position, velocity and acceleration setpoint in the WGS84 coordinate system.  |
|  87   | `PositionTargetGlobalInt.class` |  Set vehicle position, velocity and acceleration setpoint in the WGS84 coordinate system.  |
|  89   | `LocalPositionNedSystemGlobalOffset.class` |  The offset in X, Y, Z and yaw between the LOCAL_POSITION_NED messages of MAV X and the global coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)  |
|  90   | `HilState.class` |  DEPRECATED PACKET! Suffers from missing airspeed fields and singularities due to Euler angles. Please use HIL_STATE_QUATERNION instead. Sent from simulation to autopilot. This packet is useful for high throughput applications such as hardware in the loop simulations.  |
|  91   | `HilControls.class` |  Sent from autopilot to simulation. Hardware in the loop control outputs  |
|  92   | `HilRcInputsRaw.class` |  Sent from simulation to autopilot. The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.  |
|  100   | `OpticalFlow.class` |  Optical flow from a flow sensor (e.g. optical mouse sensor)  |
|  101   | `GlobalVisionPositionEstimate.class` |  Optical flow from a flow sensor (e.g. optical mouse sensor)  |
|  102   | `VisionPositionEstimate.class` |  Optical flow from a flow sensor (e.g. optical mouse sensor)  |
|  103   | `VisionSpeedEstimate.class` |  Optical flow from a flow sensor (e.g. optical mouse sensor)  |
|  104   | `ViconPositionEstimate.class` |  Optical flow from a flow sensor (e.g. optical mouse sensor)  |
|  105   | `HighresImu.class` |  The IMU readings in SI units in NED body frame  |
|  106   | `OpticalFlowRad.class` |  Optical flow from an angular rate flow sensor (e.g. PX4FLOW or mouse sensor)  |
|  107   | `HilSensor.class` |  The IMU readings in SI units in NED body frame  |
|  108   | `SimState.class` |  Status of simulation environment, if used  |
|  109   | `RadioStatus.class` |  Status generated by radio  |
|  110   | `FileTransferProtocol.class` |  File transfer message  |
|  111   | `Timesync.class` |  Time synchronization message.  |
|  113   | `HilGps.class` |  The global position, as returned by the Global Positioning System (GPS). This is NOT the global position estimate of the sytem, but rather a RAW sensor value. See message GLOBAL_POSITION for the global position estimate. Coordinate frame is right-handed, Z-axis up (GPS frame).  |
|  114   | `HilOpticalFlow.class` |  Simulated optical flow from a flow sensor (e.g. PX4FLOW or optical mouse sensor)  |
|  115   | `HilStateQuaternion.class` |  Sent from simulation to autopilot, avoids in contrast to HIL_STATE singularities. This packet is useful for high throughput applications such as hardware in the loop simulations.  |
|  116   | `ScaledImu2.class` |  The RAW IMU readings for secondary 9DOF sensor setup. This message should contain the scaled values to the described units  |
|  117   | `LogRequestList.class` |  Request a list of available logs. On some systems calling this may stop on-board logging until LOG_REQUEST_END is called.  |
|  118   | `LogEntry.class` |  Reply to LOG_REQUEST_LIST  |
|  119   | `LogRequestData.class` |  Request a chunk of a log  |
|  120   | `LogData.class` |  Reply to LOG_REQUEST_DATA  |
|  121   | `LogErase.class` |  Erase all logs  |
|  122   | `LogRequestEnd.class` |  Stop log transfer and resume normal logging  |
|  123   | `GpsInjectData.class` |  data for injecting into the onboard GPS (used for DGPS)  |
|  124   | `Gps2Raw.class` |  Second GPS data. Coordinate frame is right-handed, Z-axis up (GPS frame).  |
|  125   | `PowerStatus.class` |  Power supply status  |
|  126   | `SerialControl.class` |  Control a serial port. This can be used for raw access to an onboard serial peripheral such as a GPS or telemetry radio. It is designed to make it possible to update the devices firmware via MAVLink messages or change the devices settings. A message with zero bytes can be used to change just the baudrate.  |
|  127   | `GpsRtk.class` |  RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting  |
|  128   | `Gps2Rtk.class` |  RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting  |
|  130   | `DataTransmissionHandshake.class` |  RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting  |
|  131   | `EncapsulatedData.class` |  RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting  |
|  132   | `DistanceSensor.class` |  RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting  |
|  133   | `TerrainRequest.class` |  Request for terrain data and terrain status  |
|  134   | `TerrainData.class` |  Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a TERRAIN_REQUEST  |
|  135   | `TerrainCheck.class` |  Request that the vehicle report terrain height at the given location. Used by GCS to check if vehicle has all terrain data needed for a mission.  |
|  136   | `TerrainReport.class` |  Response from a TERRAIN_CHECK request  |
|  147   | `BatteryStatus.class` |  Battery information  |
|  148   | `AutopilotVersion.class` |  Version and capability of autopilot software  |
|  248   | `V2Extension.class` |  Message implementing parts of the V2 payload specs in V1 frames for transitional support.  |
|  249   | `MemoryVect.class` |  Send raw controller memory. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output.  |
|  250   | `DebugVect.class` |  Send raw controller memory. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output.  |
|  251   | `NamedValueFloat.class` |  Send a key-value pair as float. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output.  |
|  252   | `NamedValueInt.class` |  Send a key-value pair as integer. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output.  |
|  253   | `Statustext.class` |  Status text message. These messages are printed in yellow in the COMM console of QGroundControl. WARNING: They consume quite some bandwidth, so use only for important status and error messages. If implemented wisely, these messages are buffered on the MCU and sent only at a limited rate (e.g. 10 Hz).  |
|  254   | `Debug.class` |  Send a debug value. The index is used to discriminate between values. These values show up in the plot of QGroundControl as DEBUG N.  |


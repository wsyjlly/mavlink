package cn.wsyjlly.mavlink.protocol;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.common.Message;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.04 - 20:01
 **********************************/

public class MavlinkConfig {
	private static final HashSet<Class<? extends Message>> FILTER_MESSAGE = new HashSet<>();
	private static final HashMap<Integer,Integer> CRC_BOX = new HashMap<>();
	private static final HashMap<Integer,Class<? extends Message>> MESSAGE_BOX = new HashMap<>();

	static {
		setVersion(Version.MAVLINK_V1);
		setCrcBox();
	}

	public static void setVersion(Version version){
		MESSAGE_BOX.clear();
		if (version.equals(Version.MAVLINK_V1)){
			setMessageBoxVersion1();
		}else if (version.equals(Version.MAVLINK_V2)){
			setMessageBoxVersion2();
		}
	}

	public static void registerMessage(Class<? extends Message> messageClass){
		Type[] genericInterfaces = messageClass.getGenericInterfaces();
		if (Arrays.asList(genericInterfaces).contains(Message.class)){
			int id = messageClass.getAnnotation(MavlinkMessage.class).id();
			MESSAGE_BOX.put(id,messageClass);
		}
	}

	public static HashMap<Integer,Class<? extends Message>> allType(){
		return MESSAGE_BOX;
	}

	public static boolean isContainsType(int id){
		return MESSAGE_BOX.containsKey(id);
	}

	public static boolean isContainsType(Class<?> messageType){
		return MESSAGE_BOX.containsValue(messageType);
	}

	@SafeVarargs
	public static HashSet<Class<? extends Message>> addFilter(Class<? extends Message>... messageType) {
		if (Objects.nonNull(messageType)) {
			FILTER_MESSAGE.addAll(Arrays.asList(messageType));
		}
		return FILTER_MESSAGE;
	}

	public static HashMap<Integer,Integer> getCrcBox(){
		  return CRC_BOX;
	}

	private static void setMessageBoxVersion2(){
		MESSAGE_BOX.put(1, cn.wsyjlly.mavlink.common.v2.messages.SysStatus.class);
		MESSAGE_BOX.put(2, cn.wsyjlly.mavlink.common.v2.messages.SystemTime.class);
		MESSAGE_BOX.put(4, cn.wsyjlly.mavlink.common.v2.messages.Ping.class);
		MESSAGE_BOX.put(5, cn.wsyjlly.mavlink.common.v2.messages.ChangeOperatorControl.class);
		MESSAGE_BOX.put(6, cn.wsyjlly.mavlink.common.v2.messages.ChangeOperatorControlAck.class);
		MESSAGE_BOX.put(7, cn.wsyjlly.mavlink.common.v2.messages.AuthKey.class);
		MESSAGE_BOX.put(8, cn.wsyjlly.mavlink.common.v2.messages.LinkNodeStatus.class);
		MESSAGE_BOX.put(11, cn.wsyjlly.mavlink.common.v2.messages.SetMode.class);
		MESSAGE_BOX.put(19, cn.wsyjlly.mavlink.common.v2.messages.ParamAckTransaction.class);
		MESSAGE_BOX.put(20, cn.wsyjlly.mavlink.common.v2.messages.ParamRequestRead.class);
		MESSAGE_BOX.put(21, cn.wsyjlly.mavlink.common.v2.messages.ParamRequestList.class);
		MESSAGE_BOX.put(22, cn.wsyjlly.mavlink.common.v2.messages.ParamValue.class);
		MESSAGE_BOX.put(23, cn.wsyjlly.mavlink.common.v2.messages.ParamSet.class);
		MESSAGE_BOX.put(24, cn.wsyjlly.mavlink.common.v2.messages.GpsRawInt.class);
		MESSAGE_BOX.put(25, cn.wsyjlly.mavlink.common.v2.messages.GpsStatus.class);
		MESSAGE_BOX.put(26, cn.wsyjlly.mavlink.common.v2.messages.ScaledImu.class);
		MESSAGE_BOX.put(27, cn.wsyjlly.mavlink.common.v2.messages.RawImu.class);
		MESSAGE_BOX.put(28, cn.wsyjlly.mavlink.common.v2.messages.RawPressure.class);
		MESSAGE_BOX.put(29, cn.wsyjlly.mavlink.common.v2.messages.ScaledPressure.class);
		MESSAGE_BOX.put(30, cn.wsyjlly.mavlink.common.v2.messages.Attitude.class);
		MESSAGE_BOX.put(31, cn.wsyjlly.mavlink.common.v2.messages.AttitudeQuaternion.class);
		MESSAGE_BOX.put(32, cn.wsyjlly.mavlink.common.v2.messages.LocalPositionNed.class);
		MESSAGE_BOX.put(33, cn.wsyjlly.mavlink.common.v2.messages.GlobalPositionInt.class);
		MESSAGE_BOX.put(34, cn.wsyjlly.mavlink.common.v2.messages.RcChannelsScaled.class);
		MESSAGE_BOX.put(35, cn.wsyjlly.mavlink.common.v2.messages.RcChannelsRaw.class);
		MESSAGE_BOX.put(36, cn.wsyjlly.mavlink.common.v2.messages.ServoOutputRaw.class);
		MESSAGE_BOX.put(37, cn.wsyjlly.mavlink.common.v2.messages.MissionRequestPartialList.class);
		MESSAGE_BOX.put(38, cn.wsyjlly.mavlink.common.v2.messages.MissionWritePartialList.class);
		MESSAGE_BOX.put(39, cn.wsyjlly.mavlink.common.v2.messages.MissionItem.class);
		MESSAGE_BOX.put(40, cn.wsyjlly.mavlink.common.v2.messages.MissionRequest.class);
		MESSAGE_BOX.put(41, cn.wsyjlly.mavlink.common.v2.messages.MissionSetCurrent.class);
		MESSAGE_BOX.put(42, cn.wsyjlly.mavlink.common.v2.messages.MissionCurrent.class);
		MESSAGE_BOX.put(43, cn.wsyjlly.mavlink.common.v2.messages.MissionRequestList.class);
		MESSAGE_BOX.put(44, cn.wsyjlly.mavlink.common.v2.messages.MissionCount.class);
		MESSAGE_BOX.put(45, cn.wsyjlly.mavlink.common.v2.messages.MissionClearAll.class);
		MESSAGE_BOX.put(46, cn.wsyjlly.mavlink.common.v2.messages.MissionItemReached.class);
		MESSAGE_BOX.put(47, cn.wsyjlly.mavlink.common.v2.messages.MissionAck.class);
		MESSAGE_BOX.put(48, cn.wsyjlly.mavlink.common.v2.messages.SetGpsGlobalOrigin.class);
		MESSAGE_BOX.put(49, cn.wsyjlly.mavlink.common.v2.messages.GpsGlobalOrigin.class);
		MESSAGE_BOX.put(50, cn.wsyjlly.mavlink.common.v2.messages.ParamMapRc.class);
		MESSAGE_BOX.put(51, cn.wsyjlly.mavlink.common.v2.messages.MissionRequestInt.class);
		MESSAGE_BOX.put(52, cn.wsyjlly.mavlink.common.v2.messages.MissionChanged.class);
		MESSAGE_BOX.put(54, cn.wsyjlly.mavlink.common.v2.messages.SafetySetAllowedArea.class);
		MESSAGE_BOX.put(55, cn.wsyjlly.mavlink.common.v2.messages.SafetyAllowedArea.class);
		MESSAGE_BOX.put(61, cn.wsyjlly.mavlink.common.v2.messages.AttitudeQuaternionCov.class);
		MESSAGE_BOX.put(62, cn.wsyjlly.mavlink.common.v2.messages.NavControllerOutput.class);
		MESSAGE_BOX.put(63, cn.wsyjlly.mavlink.common.v2.messages.GlobalPositionIntCov.class);
		MESSAGE_BOX.put(64, cn.wsyjlly.mavlink.common.v2.messages.LocalPositionNedCov.class);
		MESSAGE_BOX.put(65, cn.wsyjlly.mavlink.common.v2.messages.RcChannels.class);
		MESSAGE_BOX.put(66, cn.wsyjlly.mavlink.common.v2.messages.RequestDataStream.class);
		MESSAGE_BOX.put(67, cn.wsyjlly.mavlink.common.v2.messages.DataStream.class);
		MESSAGE_BOX.put(69, cn.wsyjlly.mavlink.common.v2.messages.ManualControl.class);
		MESSAGE_BOX.put(70, cn.wsyjlly.mavlink.common.v2.messages.RcChannelsOverride.class);
		MESSAGE_BOX.put(73, cn.wsyjlly.mavlink.common.v2.messages.MissionItemInt.class);
		MESSAGE_BOX.put(74, cn.wsyjlly.mavlink.common.v2.messages.VfrHud.class);
		MESSAGE_BOX.put(75, cn.wsyjlly.mavlink.common.v2.messages.CommandInt.class);
		MESSAGE_BOX.put(76, cn.wsyjlly.mavlink.common.v2.messages.CommandLong.class);
		MESSAGE_BOX.put(77, cn.wsyjlly.mavlink.common.v2.messages.CommandAck.class);
		MESSAGE_BOX.put(80, cn.wsyjlly.mavlink.common.v2.messages.CommandCancel.class);
		MESSAGE_BOX.put(81, cn.wsyjlly.mavlink.common.v2.messages.ManualSetpoint.class);
		MESSAGE_BOX.put(82, cn.wsyjlly.mavlink.common.v2.messages.SetAttitudeTarget.class);
		MESSAGE_BOX.put(83, cn.wsyjlly.mavlink.common.v2.messages.AttitudeTarget.class);
		MESSAGE_BOX.put(84, cn.wsyjlly.mavlink.common.v2.messages.SetPositionTargetLocalNed.class);
		MESSAGE_BOX.put(85, cn.wsyjlly.mavlink.common.v2.messages.PositionTargetLocalNed.class);
		MESSAGE_BOX.put(86, cn.wsyjlly.mavlink.common.v2.messages.SetPositionTargetGlobalInt.class);
		MESSAGE_BOX.put(87, cn.wsyjlly.mavlink.common.v2.messages.PositionTargetGlobalInt.class);
		MESSAGE_BOX.put(89, cn.wsyjlly.mavlink.common.v2.messages.LocalPositionNedSystemGlobalOffset.class);
		MESSAGE_BOX.put(90, cn.wsyjlly.mavlink.common.v2.messages.HilState.class);
		MESSAGE_BOX.put(91, cn.wsyjlly.mavlink.common.v2.messages.HilControls.class);
		MESSAGE_BOX.put(92, cn.wsyjlly.mavlink.common.v2.messages.HilRcInputsRaw.class);
		MESSAGE_BOX.put(93, cn.wsyjlly.mavlink.common.v2.messages.HilActuatorControls.class);
		MESSAGE_BOX.put(100, cn.wsyjlly.mavlink.common.v2.messages.OpticalFlow.class);
		MESSAGE_BOX.put(101, cn.wsyjlly.mavlink.common.v2.messages.GlobalVisionPositionEstimate.class);
		MESSAGE_BOX.put(102, cn.wsyjlly.mavlink.common.v2.messages.VisionPositionEstimate.class);
		MESSAGE_BOX.put(103, cn.wsyjlly.mavlink.common.v2.messages.VisionSpeedEstimate.class);
		MESSAGE_BOX.put(104, cn.wsyjlly.mavlink.common.v2.messages.ViconPositionEstimate.class);
		MESSAGE_BOX.put(105, cn.wsyjlly.mavlink.common.v2.messages.HighresImu.class);
		MESSAGE_BOX.put(106, cn.wsyjlly.mavlink.common.v2.messages.OpticalFlowRad.class);
		MESSAGE_BOX.put(107, cn.wsyjlly.mavlink.common.v2.messages.HilSensor.class);
		MESSAGE_BOX.put(108, cn.wsyjlly.mavlink.common.v2.messages.SimState.class);
		MESSAGE_BOX.put(109, cn.wsyjlly.mavlink.common.v2.messages.RadioStatus.class);
		MESSAGE_BOX.put(110, cn.wsyjlly.mavlink.common.v2.messages.FileTransferProtocol.class);
		MESSAGE_BOX.put(111, cn.wsyjlly.mavlink.common.v2.messages.Timesync.class);
		MESSAGE_BOX.put(112, cn.wsyjlly.mavlink.common.v2.messages.CameraTrigger.class);
		MESSAGE_BOX.put(113, cn.wsyjlly.mavlink.common.v2.messages.HilGps.class);
		MESSAGE_BOX.put(114, cn.wsyjlly.mavlink.common.v2.messages.HilOpticalFlow.class);
		MESSAGE_BOX.put(115, cn.wsyjlly.mavlink.common.v2.messages.HilStateQuaternion.class);
		MESSAGE_BOX.put(116, cn.wsyjlly.mavlink.common.v2.messages.ScaledImu2.class);
		MESSAGE_BOX.put(117, cn.wsyjlly.mavlink.common.v2.messages.LogRequestList.class);
		MESSAGE_BOX.put(118, cn.wsyjlly.mavlink.common.v2.messages.LogEntry.class);
		MESSAGE_BOX.put(119, cn.wsyjlly.mavlink.common.v2.messages.LogRequestData.class);
		MESSAGE_BOX.put(120, cn.wsyjlly.mavlink.common.v2.messages.LogData.class);
		MESSAGE_BOX.put(121, cn.wsyjlly.mavlink.common.v2.messages.LogErase.class);
		MESSAGE_BOX.put(122, cn.wsyjlly.mavlink.common.v2.messages.LogRequestEnd.class);
		MESSAGE_BOX.put(123, cn.wsyjlly.mavlink.common.v2.messages.GpsInjectData.class);
		MESSAGE_BOX.put(124, cn.wsyjlly.mavlink.common.v2.messages.Gps2Raw.class);
		MESSAGE_BOX.put(125, cn.wsyjlly.mavlink.common.v2.messages.PowerStatus.class);
		MESSAGE_BOX.put(126, cn.wsyjlly.mavlink.common.v2.messages.SerialControl.class);
		MESSAGE_BOX.put(127, cn.wsyjlly.mavlink.common.v2.messages.GpsRtk.class);
		MESSAGE_BOX.put(128, cn.wsyjlly.mavlink.common.v2.messages.Gps2Rtk.class);
		MESSAGE_BOX.put(129, cn.wsyjlly.mavlink.common.v2.messages.ScaledImu3.class);
		MESSAGE_BOX.put(130, cn.wsyjlly.mavlink.common.v2.messages.DataTransmissionHandshake.class);
		MESSAGE_BOX.put(131, cn.wsyjlly.mavlink.common.v2.messages.EncapsulatedData.class);
		MESSAGE_BOX.put(132, cn.wsyjlly.mavlink.common.v2.messages.DistanceSensor.class);
		MESSAGE_BOX.put(133, cn.wsyjlly.mavlink.common.v2.messages.TerrainRequest.class);
		MESSAGE_BOX.put(134, cn.wsyjlly.mavlink.common.v2.messages.TerrainData.class);
		MESSAGE_BOX.put(135, cn.wsyjlly.mavlink.common.v2.messages.TerrainCheck.class);
		MESSAGE_BOX.put(136, cn.wsyjlly.mavlink.common.v2.messages.TerrainReport.class);
		MESSAGE_BOX.put(137, cn.wsyjlly.mavlink.common.v2.messages.ScaledPressure2.class);
		MESSAGE_BOX.put(138, cn.wsyjlly.mavlink.common.v2.messages.AttPosMocap.class);
		MESSAGE_BOX.put(139, cn.wsyjlly.mavlink.common.v2.messages.SetActuatorControlTarget.class);
		MESSAGE_BOX.put(140, cn.wsyjlly.mavlink.common.v2.messages.ActuatorControlTarget.class);
		MESSAGE_BOX.put(141, cn.wsyjlly.mavlink.common.v2.messages.Altitude.class);
		MESSAGE_BOX.put(142, cn.wsyjlly.mavlink.common.v2.messages.ResourceRequest.class);
		MESSAGE_BOX.put(143, cn.wsyjlly.mavlink.common.v2.messages.ScaledPressure3.class);
		MESSAGE_BOX.put(144, cn.wsyjlly.mavlink.common.v2.messages.FollowTarget.class);
		MESSAGE_BOX.put(146, cn.wsyjlly.mavlink.common.v2.messages.ControlSystemState.class);
		MESSAGE_BOX.put(147, cn.wsyjlly.mavlink.common.v2.messages.BatteryStatus.class);
		MESSAGE_BOX.put(148, cn.wsyjlly.mavlink.common.v2.messages.AutopilotVersion.class);
		MESSAGE_BOX.put(149, cn.wsyjlly.mavlink.common.v2.messages.LandingTarget.class);
		MESSAGE_BOX.put(162, cn.wsyjlly.mavlink.common.v2.messages.FenceStatus.class);
		MESSAGE_BOX.put(192, cn.wsyjlly.mavlink.common.v2.messages.MagCalReport.class);
		MESSAGE_BOX.put(225, cn.wsyjlly.mavlink.common.v2.messages.EfiStatus.class);
		MESSAGE_BOX.put(230, cn.wsyjlly.mavlink.common.v2.messages.EstimatorStatus.class);
		MESSAGE_BOX.put(231, cn.wsyjlly.mavlink.common.v2.messages.WindCov.class);
		MESSAGE_BOX.put(232, cn.wsyjlly.mavlink.common.v2.messages.GpsInput.class);
		MESSAGE_BOX.put(233, cn.wsyjlly.mavlink.common.v2.messages.GpsRtcmData.class);
		MESSAGE_BOX.put(234, cn.wsyjlly.mavlink.common.v2.messages.HighLatency.class);
		MESSAGE_BOX.put(235, cn.wsyjlly.mavlink.common.v2.messages.HighLatency2.class);
		MESSAGE_BOX.put(241, cn.wsyjlly.mavlink.common.v2.messages.Vibration.class);
		MESSAGE_BOX.put(242, cn.wsyjlly.mavlink.common.v2.messages.HomePosition.class);
		MESSAGE_BOX.put(243, cn.wsyjlly.mavlink.common.v2.messages.SetHomePosition.class);
		MESSAGE_BOX.put(244, cn.wsyjlly.mavlink.common.v2.messages.MessageInterval.class);
		MESSAGE_BOX.put(245, cn.wsyjlly.mavlink.common.v2.messages.ExtendedSysState.class);
		MESSAGE_BOX.put(246, cn.wsyjlly.mavlink.common.v2.messages.AdsbVehicle.class);
		MESSAGE_BOX.put(247, cn.wsyjlly.mavlink.common.v2.messages.Collision.class);
		MESSAGE_BOX.put(248, cn.wsyjlly.mavlink.common.v2.messages.V2Extension.class);
		MESSAGE_BOX.put(249, cn.wsyjlly.mavlink.common.v2.messages.MemoryVect.class);
		MESSAGE_BOX.put(250, cn.wsyjlly.mavlink.common.v2.messages.DebugVect.class);
		MESSAGE_BOX.put(251, cn.wsyjlly.mavlink.common.v2.messages.NamedValueFloat.class);
		MESSAGE_BOX.put(252, cn.wsyjlly.mavlink.common.v2.messages.NamedValueInt.class);
		MESSAGE_BOX.put(253, cn.wsyjlly.mavlink.common.v2.messages.Statustext.class);
		MESSAGE_BOX.put(254, cn.wsyjlly.mavlink.common.v2.messages.Debug.class);
		MESSAGE_BOX.put(256, cn.wsyjlly.mavlink.common.v2.messages.SetupSigning.class);
		MESSAGE_BOX.put(257, cn.wsyjlly.mavlink.common.v2.messages.ButtonChange.class);
		MESSAGE_BOX.put(258, cn.wsyjlly.mavlink.common.v2.messages.PlayTune.class);
		MESSAGE_BOX.put(259, cn.wsyjlly.mavlink.common.v2.messages.CameraInformation.class);
		MESSAGE_BOX.put(260, cn.wsyjlly.mavlink.common.v2.messages.CameraSettings.class);
		MESSAGE_BOX.put(261, cn.wsyjlly.mavlink.common.v2.messages.StorageInformation.class);
		MESSAGE_BOX.put(262, cn.wsyjlly.mavlink.common.v2.messages.CameraCaptureStatus.class);
		MESSAGE_BOX.put(263, cn.wsyjlly.mavlink.common.v2.messages.CameraImageCaptured.class);
		MESSAGE_BOX.put(264, cn.wsyjlly.mavlink.common.v2.messages.FlightInformation.class);
		MESSAGE_BOX.put(265, cn.wsyjlly.mavlink.common.v2.messages.MountOrientation.class);
		MESSAGE_BOX.put(266, cn.wsyjlly.mavlink.common.v2.messages.LoggingData.class);
		MESSAGE_BOX.put(267, cn.wsyjlly.mavlink.common.v2.messages.LoggingDataAcked.class);
		MESSAGE_BOX.put(268, cn.wsyjlly.mavlink.common.v2.messages.LoggingAck.class);
		MESSAGE_BOX.put(269, cn.wsyjlly.mavlink.common.v2.messages.VideoStreamInformation.class);
		MESSAGE_BOX.put(270, cn.wsyjlly.mavlink.common.v2.messages.VideoStreamStatus.class);
		MESSAGE_BOX.put(271, cn.wsyjlly.mavlink.common.v2.messages.CameraFovStatus.class);
		MESSAGE_BOX.put(275, cn.wsyjlly.mavlink.common.v2.messages.CameraTrackingImageStatus.class);
		MESSAGE_BOX.put(276, cn.wsyjlly.mavlink.common.v2.messages.CameraTrackingGeoStatus.class);
		MESSAGE_BOX.put(280, cn.wsyjlly.mavlink.common.v2.messages.GimbalManagerInformation.class);
		MESSAGE_BOX.put(281, cn.wsyjlly.mavlink.common.v2.messages.GimbalManagerStatus.class);
		MESSAGE_BOX.put(282, cn.wsyjlly.mavlink.common.v2.messages.GimbalManagerSetAttitude.class);
		MESSAGE_BOX.put(283, cn.wsyjlly.mavlink.common.v2.messages.GimbalDeviceInformation.class);
		MESSAGE_BOX.put(284, cn.wsyjlly.mavlink.common.v2.messages.GimbalDeviceSetAttitude.class);
		MESSAGE_BOX.put(285, cn.wsyjlly.mavlink.common.v2.messages.GimbalDeviceAttitudeStatus.class);
		MESSAGE_BOX.put(286, cn.wsyjlly.mavlink.common.v2.messages.AutopilotStateForGimbalDevice.class);
		MESSAGE_BOX.put(287, cn.wsyjlly.mavlink.common.v2.messages.GimbalManagerSetPitchyaw.class);
		MESSAGE_BOX.put(288, cn.wsyjlly.mavlink.common.v2.messages.GimbalManagerSetManualControl.class);
		MESSAGE_BOX.put(290, cn.wsyjlly.mavlink.common.v2.messages.EscInfo.class);
		MESSAGE_BOX.put(291, cn.wsyjlly.mavlink.common.v2.messages.EscStatus.class);
		MESSAGE_BOX.put(299, cn.wsyjlly.mavlink.common.v2.messages.WifiConfigAp.class);
		MESSAGE_BOX.put(301, cn.wsyjlly.mavlink.common.v2.messages.AisVessel.class);
		MESSAGE_BOX.put(310, cn.wsyjlly.mavlink.common.v2.messages.UavcanNodeStatus.class);
		MESSAGE_BOX.put(311, cn.wsyjlly.mavlink.common.v2.messages.UavcanNodeInfo.class);
		MESSAGE_BOX.put(320, cn.wsyjlly.mavlink.common.v2.messages.ParamExtRequestRead.class);
		MESSAGE_BOX.put(321, cn.wsyjlly.mavlink.common.v2.messages.ParamExtRequestList.class);
		MESSAGE_BOX.put(322, cn.wsyjlly.mavlink.common.v2.messages.ParamExtValue.class);
		MESSAGE_BOX.put(323, cn.wsyjlly.mavlink.common.v2.messages.ParamExtSet.class);
		MESSAGE_BOX.put(324, cn.wsyjlly.mavlink.common.v2.messages.ParamExtAck.class);
		MESSAGE_BOX.put(325, cn.wsyjlly.mavlink.common.v2.messages.ParamExtValueTrimmed.class);
		MESSAGE_BOX.put(326, cn.wsyjlly.mavlink.common.v2.messages.ParamExtSetTrimmed.class);
		MESSAGE_BOX.put(327, cn.wsyjlly.mavlink.common.v2.messages.ParamExtAckTrimmed.class);
		MESSAGE_BOX.put(330, cn.wsyjlly.mavlink.common.v2.messages.ObstacleDistance.class);
		MESSAGE_BOX.put(331, cn.wsyjlly.mavlink.common.v2.messages.Odometry.class);
		MESSAGE_BOX.put(332, cn.wsyjlly.mavlink.common.v2.messages.TrajectoryRepresentationWaypoints.class);
		MESSAGE_BOX.put(333, cn.wsyjlly.mavlink.common.v2.messages.TrajectoryRepresentationBezier.class);
		MESSAGE_BOX.put(334, cn.wsyjlly.mavlink.common.v2.messages.CellularStatus.class);
		MESSAGE_BOX.put(335, cn.wsyjlly.mavlink.common.v2.messages.IsbdLinkStatus.class);
		MESSAGE_BOX.put(336, cn.wsyjlly.mavlink.common.v2.messages.CellularConfig.class);
		MESSAGE_BOX.put(339, cn.wsyjlly.mavlink.common.v2.messages.RawRpm.class);
		MESSAGE_BOX.put(340, cn.wsyjlly.mavlink.common.v2.messages.UtmGlobalPosition.class);
		MESSAGE_BOX.put(350, cn.wsyjlly.mavlink.common.v2.messages.DebugFloatArray.class);
		MESSAGE_BOX.put(360, cn.wsyjlly.mavlink.common.v2.messages.OrbitExecutionStatus.class);
		MESSAGE_BOX.put(370, cn.wsyjlly.mavlink.common.v2.messages.SmartBatteryInfo.class);
		MESSAGE_BOX.put(373, cn.wsyjlly.mavlink.common.v2.messages.GeneratorStatus.class);
		MESSAGE_BOX.put(375, cn.wsyjlly.mavlink.common.v2.messages.ActuatorOutputStatus.class);
		MESSAGE_BOX.put(380, cn.wsyjlly.mavlink.common.v2.messages.TimeEstimateToTarget.class);
		MESSAGE_BOX.put(385, cn.wsyjlly.mavlink.common.v2.messages.Tunnel.class);
		MESSAGE_BOX.put(390, cn.wsyjlly.mavlink.common.v2.messages.OnboardComputerStatus.class);
		MESSAGE_BOX.put(395, cn.wsyjlly.mavlink.common.v2.messages.ComponentInformation.class);
		MESSAGE_BOX.put(400, cn.wsyjlly.mavlink.common.v2.messages.PlayTuneV2.class);
		MESSAGE_BOX.put(401, cn.wsyjlly.mavlink.common.v2.messages.SupportedTunes.class);
		MESSAGE_BOX.put(9000, cn.wsyjlly.mavlink.common.v2.messages.WheelDistance.class);
		MESSAGE_BOX.put(9005, cn.wsyjlly.mavlink.common.v2.messages.WinchStatus.class);
		MESSAGE_BOX.put(12900, cn.wsyjlly.mavlink.common.v2.messages.OpenDroneIdBasicId.class);
		MESSAGE_BOX.put(12901, cn.wsyjlly.mavlink.common.v2.messages.OpenDroneIdLocation.class);
		MESSAGE_BOX.put(12902, cn.wsyjlly.mavlink.common.v2.messages.OpenDroneIdAuthentication.class);
		MESSAGE_BOX.put(12903, cn.wsyjlly.mavlink.common.v2.messages.OpenDroneIdSelfId.class);
		MESSAGE_BOX.put(12904, cn.wsyjlly.mavlink.common.v2.messages.OpenDroneIdSystem.class);
		MESSAGE_BOX.put(12905, cn.wsyjlly.mavlink.common.v2.messages.OpenDroneIdOperatorId.class);
		MESSAGE_BOX.put(12915, cn.wsyjlly.mavlink.common.v2.messages.OpenDroneIdMessagePack.class);
		MESSAGE_BOX.put(0, cn.wsyjlly.mavlink.common.v2.messages.Heartbeat.class);
		MESSAGE_BOX.put(300, cn.wsyjlly.mavlink.common.v2.messages.ProtocolVersion.class);
	}

	private static void setMessageBoxVersion1(){
		MESSAGE_BOX.put(1, cn.wsyjlly.mavlink.common.v1.messages.SysStatus.class);
		MESSAGE_BOX.put(2, cn.wsyjlly.mavlink.common.v1.messages.SystemTime.class);
		MESSAGE_BOX.put(4, cn.wsyjlly.mavlink.common.v1.messages.Ping.class);
		MESSAGE_BOX.put(5, cn.wsyjlly.mavlink.common.v1.messages.ChangeOperatorControl.class);
		MESSAGE_BOX.put(6, cn.wsyjlly.mavlink.common.v1.messages.ChangeOperatorControlAck.class);
		MESSAGE_BOX.put(7, cn.wsyjlly.mavlink.common.v1.messages.AuthKey.class);
		MESSAGE_BOX.put(11, cn.wsyjlly.mavlink.common.v1.messages.SetMode.class);
		MESSAGE_BOX.put(20, cn.wsyjlly.mavlink.common.v1.messages.ParamRequestRead.class);
		MESSAGE_BOX.put(21, cn.wsyjlly.mavlink.common.v1.messages.ParamRequestList.class);
		MESSAGE_BOX.put(22, cn.wsyjlly.mavlink.common.v1.messages.ParamValue.class);
		MESSAGE_BOX.put(23, cn.wsyjlly.mavlink.common.v1.messages.ParamSet.class);
		MESSAGE_BOX.put(24, cn.wsyjlly.mavlink.common.v1.messages.GpsRawInt.class);
		MESSAGE_BOX.put(25, cn.wsyjlly.mavlink.common.v1.messages.GpsStatus.class);
		MESSAGE_BOX.put(26, cn.wsyjlly.mavlink.common.v1.messages.ScaledImu.class);
		MESSAGE_BOX.put(27, cn.wsyjlly.mavlink.common.v1.messages.RawImu.class);
		MESSAGE_BOX.put(28, cn.wsyjlly.mavlink.common.v1.messages.RawPressure.class);
		MESSAGE_BOX.put(29, cn.wsyjlly.mavlink.common.v1.messages.ScaledPressure.class);
		MESSAGE_BOX.put(30, cn.wsyjlly.mavlink.common.v1.messages.Attitude.class);
		MESSAGE_BOX.put(31, cn.wsyjlly.mavlink.common.v1.messages.AttitudeQuaternion.class);
		MESSAGE_BOX.put(32, cn.wsyjlly.mavlink.common.v1.messages.LocalPositionNed.class);
		MESSAGE_BOX.put(33, cn.wsyjlly.mavlink.common.v1.messages.GlobalPositionInt.class);
		MESSAGE_BOX.put(34, cn.wsyjlly.mavlink.common.v1.messages.RcChannelsScaled.class);
		MESSAGE_BOX.put(35, cn.wsyjlly.mavlink.common.v1.messages.RcChannelsRaw.class);
		MESSAGE_BOX.put(36, cn.wsyjlly.mavlink.common.v1.messages.ServoOutputRaw.class);
		MESSAGE_BOX.put(37, cn.wsyjlly.mavlink.common.v1.messages.MissionRequestPartialList.class);
		MESSAGE_BOX.put(38, cn.wsyjlly.mavlink.common.v1.messages.MissionWritePartialList.class);
		MESSAGE_BOX.put(39, cn.wsyjlly.mavlink.common.v1.messages.MissionItem.class);
		MESSAGE_BOX.put(40, cn.wsyjlly.mavlink.common.v1.messages.MissionRequest.class);
		MESSAGE_BOX.put(41, cn.wsyjlly.mavlink.common.v1.messages.MissionSetCurrent.class);
		MESSAGE_BOX.put(42, cn.wsyjlly.mavlink.common.v1.messages.MissionCurrent.class);
		MESSAGE_BOX.put(43, cn.wsyjlly.mavlink.common.v1.messages.MissionRequestList.class);
		MESSAGE_BOX.put(44, cn.wsyjlly.mavlink.common.v1.messages.MissionCount.class);
		MESSAGE_BOX.put(45, cn.wsyjlly.mavlink.common.v1.messages.MissionClearAll.class);
		MESSAGE_BOX.put(46, cn.wsyjlly.mavlink.common.v1.messages.MissionItemReached.class);
		MESSAGE_BOX.put(47, cn.wsyjlly.mavlink.common.v1.messages.MissionAck.class);
		MESSAGE_BOX.put(48, cn.wsyjlly.mavlink.common.v1.messages.SetGpsGlobalOrigin.class);
		MESSAGE_BOX.put(49, cn.wsyjlly.mavlink.common.v1.messages.GpsGlobalOrigin.class);
		MESSAGE_BOX.put(54, cn.wsyjlly.mavlink.common.v1.messages.SafetySetAllowedArea.class);
		MESSAGE_BOX.put(55, cn.wsyjlly.mavlink.common.v1.messages.SafetyAllowedArea.class);
		MESSAGE_BOX.put(61, cn.wsyjlly.mavlink.common.v1.messages.AttitudeQuaternionCov.class);
		MESSAGE_BOX.put(62, cn.wsyjlly.mavlink.common.v1.messages.NavControllerOutput.class);
		MESSAGE_BOX.put(63, cn.wsyjlly.mavlink.common.v1.messages.GlobalPositionIntCov.class);
		MESSAGE_BOX.put(64, cn.wsyjlly.mavlink.common.v1.messages.LocalPositionNedCov.class);
		MESSAGE_BOX.put(65, cn.wsyjlly.mavlink.common.v1.messages.RcChannels.class);
		MESSAGE_BOX.put(66, cn.wsyjlly.mavlink.common.v1.messages.RequestDataStream.class);
		MESSAGE_BOX.put(67, cn.wsyjlly.mavlink.common.v1.messages.DataStream.class);
		MESSAGE_BOX.put(69, cn.wsyjlly.mavlink.common.v1.messages.ManualControl.class);
		MESSAGE_BOX.put(70, cn.wsyjlly.mavlink.common.v1.messages.RcChannelsOverride.class);
		MESSAGE_BOX.put(73, cn.wsyjlly.mavlink.common.v1.messages.MissionItemInt.class);
		MESSAGE_BOX.put(74, cn.wsyjlly.mavlink.common.v1.messages.VfrHud.class);
		MESSAGE_BOX.put(75, cn.wsyjlly.mavlink.common.v1.messages.CommandInt.class);
		MESSAGE_BOX.put(76, cn.wsyjlly.mavlink.common.v1.messages.CommandLong.class);
		MESSAGE_BOX.put(77, cn.wsyjlly.mavlink.common.v1.messages.CommandAck.class);
		MESSAGE_BOX.put(81, cn.wsyjlly.mavlink.common.v1.messages.ManualSetpoint.class);
		MESSAGE_BOX.put(82, cn.wsyjlly.mavlink.common.v1.messages.SetAttitudeTarget.class);
		MESSAGE_BOX.put(83, cn.wsyjlly.mavlink.common.v1.messages.AttitudeTarget.class);
		MESSAGE_BOX.put(84, cn.wsyjlly.mavlink.common.v1.messages.SetPositionTargetLocalNed.class);
		MESSAGE_BOX.put(85, cn.wsyjlly.mavlink.common.v1.messages.PositionTargetLocalNed.class);
		MESSAGE_BOX.put(86, cn.wsyjlly.mavlink.common.v1.messages.SetPositionTargetGlobalInt.class);
		MESSAGE_BOX.put(87, cn.wsyjlly.mavlink.common.v1.messages.PositionTargetGlobalInt.class);
		MESSAGE_BOX.put(89, cn.wsyjlly.mavlink.common.v1.messages.LocalPositionNedSystemGlobalOffset.class);
		MESSAGE_BOX.put(90, cn.wsyjlly.mavlink.common.v1.messages.HilState.class);
		MESSAGE_BOX.put(91, cn.wsyjlly.mavlink.common.v1.messages.HilControls.class);
		MESSAGE_BOX.put(92, cn.wsyjlly.mavlink.common.v1.messages.HilRcInputsRaw.class);
		MESSAGE_BOX.put(100, cn.wsyjlly.mavlink.common.v1.messages.OpticalFlow.class);
		MESSAGE_BOX.put(101, cn.wsyjlly.mavlink.common.v1.messages.GlobalVisionPositionEstimate.class);
		MESSAGE_BOX.put(102, cn.wsyjlly.mavlink.common.v1.messages.VisionPositionEstimate.class);
		MESSAGE_BOX.put(103, cn.wsyjlly.mavlink.common.v1.messages.VisionSpeedEstimate.class);
		MESSAGE_BOX.put(104, cn.wsyjlly.mavlink.common.v1.messages.ViconPositionEstimate.class);
		MESSAGE_BOX.put(105, cn.wsyjlly.mavlink.common.v1.messages.HighresImu.class);
		MESSAGE_BOX.put(106, cn.wsyjlly.mavlink.common.v1.messages.OpticalFlowRad.class);
		MESSAGE_BOX.put(107, cn.wsyjlly.mavlink.common.v1.messages.HilSensor.class);
		MESSAGE_BOX.put(108, cn.wsyjlly.mavlink.common.v1.messages.SimState.class);
		MESSAGE_BOX.put(109, cn.wsyjlly.mavlink.common.v1.messages.RadioStatus.class);
		MESSAGE_BOX.put(110, cn.wsyjlly.mavlink.common.v1.messages.FileTransferProtocol.class);
		MESSAGE_BOX.put(111, cn.wsyjlly.mavlink.common.v1.messages.Timesync.class);
		MESSAGE_BOX.put(113, cn.wsyjlly.mavlink.common.v1.messages.HilGps.class);
		MESSAGE_BOX.put(114, cn.wsyjlly.mavlink.common.v1.messages.HilOpticalFlow.class);
		MESSAGE_BOX.put(115, cn.wsyjlly.mavlink.common.v1.messages.HilStateQuaternion.class);
		MESSAGE_BOX.put(116, cn.wsyjlly.mavlink.common.v1.messages.ScaledImu2.class);
		MESSAGE_BOX.put(117, cn.wsyjlly.mavlink.common.v1.messages.LogRequestList.class);
		MESSAGE_BOX.put(118, cn.wsyjlly.mavlink.common.v1.messages.LogEntry.class);
		MESSAGE_BOX.put(119, cn.wsyjlly.mavlink.common.v1.messages.LogRequestData.class);
		MESSAGE_BOX.put(120, cn.wsyjlly.mavlink.common.v1.messages.LogData.class);
		MESSAGE_BOX.put(121, cn.wsyjlly.mavlink.common.v1.messages.LogErase.class);
		MESSAGE_BOX.put(122, cn.wsyjlly.mavlink.common.v1.messages.LogRequestEnd.class);
		MESSAGE_BOX.put(123, cn.wsyjlly.mavlink.common.v1.messages.GpsInjectData.class);
		MESSAGE_BOX.put(124, cn.wsyjlly.mavlink.common.v1.messages.Gps2Raw.class);
		MESSAGE_BOX.put(125, cn.wsyjlly.mavlink.common.v1.messages.PowerStatus.class);
		MESSAGE_BOX.put(126, cn.wsyjlly.mavlink.common.v1.messages.SerialControl.class);
		MESSAGE_BOX.put(127, cn.wsyjlly.mavlink.common.v1.messages.GpsRtk.class);
		MESSAGE_BOX.put(128, cn.wsyjlly.mavlink.common.v1.messages.Gps2Rtk.class);
		MESSAGE_BOX.put(130, cn.wsyjlly.mavlink.common.v1.messages.DataTransmissionHandshake.class);
		MESSAGE_BOX.put(131, cn.wsyjlly.mavlink.common.v1.messages.EncapsulatedData.class);
		MESSAGE_BOX.put(132, cn.wsyjlly.mavlink.common.v1.messages.DistanceSensor.class);
		MESSAGE_BOX.put(133, cn.wsyjlly.mavlink.common.v1.messages.TerrainRequest.class);
		MESSAGE_BOX.put(134, cn.wsyjlly.mavlink.common.v1.messages.TerrainData.class);
		MESSAGE_BOX.put(135, cn.wsyjlly.mavlink.common.v1.messages.TerrainCheck.class);
		MESSAGE_BOX.put(136, cn.wsyjlly.mavlink.common.v1.messages.TerrainReport.class);
		MESSAGE_BOX.put(147, cn.wsyjlly.mavlink.common.v1.messages.BatteryStatus.class);
		MESSAGE_BOX.put(148, cn.wsyjlly.mavlink.common.v1.messages.AutopilotVersion.class);
		MESSAGE_BOX.put(248, cn.wsyjlly.mavlink.common.v1.messages.V2Extension.class);
		MESSAGE_BOX.put(249, cn.wsyjlly.mavlink.common.v1.messages.MemoryVect.class);
		MESSAGE_BOX.put(250, cn.wsyjlly.mavlink.common.v1.messages.DebugVect.class);
		MESSAGE_BOX.put(251, cn.wsyjlly.mavlink.common.v1.messages.NamedValueFloat.class);
		MESSAGE_BOX.put(252, cn.wsyjlly.mavlink.common.v1.messages.NamedValueInt.class);
		MESSAGE_BOX.put(253, cn.wsyjlly.mavlink.common.v1.messages.Statustext.class);
		MESSAGE_BOX.put(254, cn.wsyjlly.mavlink.common.v1.messages.Debug.class);
		MESSAGE_BOX.put(0, cn.wsyjlly.mavlink.common.v1.messages.Heartbeat.class);
		MESSAGE_BOX.put(300, cn.wsyjlly.mavlink.common.v1.messages.ProtocolVersion.class);
	}

	private static void setCrcBox(){
		CRC_BOX.put(0,50);
		CRC_BOX.put(1,124);
		CRC_BOX.put(2,137);
		CRC_BOX.put(4,237);
		CRC_BOX.put(5,217);
		CRC_BOX.put(6,104);
		CRC_BOX.put(7,119);
		CRC_BOX.put(8,117);
		CRC_BOX.put(11,89);
		CRC_BOX.put(20,214);
		CRC_BOX.put(21,159);
		CRC_BOX.put(22,220);
		CRC_BOX.put(23,168);
		CRC_BOX.put(24,24);
		CRC_BOX.put(25,23);
		CRC_BOX.put(26,170);
		CRC_BOX.put(27,144);
		CRC_BOX.put(28,67);
		CRC_BOX.put(29,115);
		CRC_BOX.put(30,39);
		CRC_BOX.put(31,246);
		CRC_BOX.put(32,185);
		CRC_BOX.put(33,104);
		CRC_BOX.put(34,237);
		CRC_BOX.put(35,244);
		CRC_BOX.put(36,222);
		CRC_BOX.put(37,212);
		CRC_BOX.put(38,9);
		CRC_BOX.put(39,254);
		CRC_BOX.put(40,230);
		CRC_BOX.put(41,28);
		CRC_BOX.put(42,28);
		CRC_BOX.put(43,132);
		CRC_BOX.put(44,221);
		CRC_BOX.put(45,232);
		CRC_BOX.put(46,11);
		CRC_BOX.put(47,153);
		CRC_BOX.put(48,41);
		CRC_BOX.put(49,39);
		CRC_BOX.put(50,78);
		CRC_BOX.put(51,196);
		CRC_BOX.put(52,132);
		CRC_BOX.put(54,15);
		CRC_BOX.put(55,3);
		CRC_BOX.put(61,167);
		CRC_BOX.put(62,183);
		CRC_BOX.put(63,119);
		CRC_BOX.put(64,191);
		CRC_BOX.put(65,118);
		CRC_BOX.put(66,148);
		CRC_BOX.put(67,21);
		CRC_BOX.put(69,243);
		CRC_BOX.put(70,124);
		CRC_BOX.put(73,38);
		CRC_BOX.put(74,20);
		CRC_BOX.put(75,158);
		CRC_BOX.put(76,152);
		CRC_BOX.put(77,143);
		CRC_BOX.put(81,106);
		CRC_BOX.put(82,49);
		CRC_BOX.put(83,22);
		CRC_BOX.put(84,143);
		CRC_BOX.put(85,140);
		CRC_BOX.put(86,5);
		CRC_BOX.put(87,150);
		CRC_BOX.put(89,231);
		CRC_BOX.put(90,183);
		CRC_BOX.put(91,63);
		CRC_BOX.put(92,54);
		CRC_BOX.put(93,47);
		CRC_BOX.put(100,175);
		CRC_BOX.put(101,102);
		CRC_BOX.put(102,158);
		CRC_BOX.put(103,208);
		CRC_BOX.put(104,56);
		CRC_BOX.put(105,93);
		CRC_BOX.put(106,138);
		CRC_BOX.put(107,108);
		CRC_BOX.put(108,32);
		CRC_BOX.put(109,185);
		CRC_BOX.put(110,84);
		CRC_BOX.put(111,34);
		CRC_BOX.put(112,174);
		CRC_BOX.put(113,124);
		CRC_BOX.put(114,237);
		CRC_BOX.put(115,4);
		CRC_BOX.put(116,76);
		CRC_BOX.put(117,128);
		CRC_BOX.put(118,56);
		CRC_BOX.put(119,116);
		CRC_BOX.put(120,134);
		CRC_BOX.put(121,237);
		CRC_BOX.put(122,203);
		CRC_BOX.put(123,250);
		CRC_BOX.put(124,87);
		CRC_BOX.put(125,203);
		CRC_BOX.put(126,220);
		CRC_BOX.put(127,25);
		CRC_BOX.put(128,226);
		CRC_BOX.put(129,46);
		CRC_BOX.put(130,29);
		CRC_BOX.put(131,223);
		CRC_BOX.put(132,85);
		CRC_BOX.put(133,6);
		CRC_BOX.put(134,229);
		CRC_BOX.put(135,203);
		CRC_BOX.put(136,1);
		CRC_BOX.put(137,195);
		CRC_BOX.put(138,109);
		CRC_BOX.put(139,168);
		CRC_BOX.put(140,181);
		CRC_BOX.put(141,47);
		CRC_BOX.put(142,72);
		CRC_BOX.put(143,131);
		CRC_BOX.put(144,127);
		CRC_BOX.put(146,103);
		CRC_BOX.put(147,154);
		CRC_BOX.put(148,178);
		CRC_BOX.put(149,200);
		CRC_BOX.put(162,189);
		CRC_BOX.put(230,163);
		CRC_BOX.put(231,105);
		CRC_BOX.put(232,151);
		CRC_BOX.put(233,35);
		CRC_BOX.put(234,150);
		CRC_BOX.put(235,179);
		CRC_BOX.put(241,90);
		CRC_BOX.put(242,104);
		CRC_BOX.put(243,85);
		CRC_BOX.put(244,95);
		CRC_BOX.put(245,130);
		CRC_BOX.put(246,184);
		CRC_BOX.put(247,81);
		CRC_BOX.put(248,8);
		CRC_BOX.put(249,204);
		CRC_BOX.put(250,49);
		CRC_BOX.put(251,170);
		CRC_BOX.put(252,44);
		CRC_BOX.put(253,83);
		CRC_BOX.put(254,46);
		CRC_BOX.put(256,71);
		CRC_BOX.put(257,131);
		CRC_BOX.put(258,187);
		CRC_BOX.put(259,92);
		CRC_BOX.put(260,146);
		CRC_BOX.put(261,179);
		CRC_BOX.put(262,12);
		CRC_BOX.put(263,133);
		CRC_BOX.put(264,49);
		CRC_BOX.put(265,26);
		CRC_BOX.put(266,193);
		CRC_BOX.put(267,35);
		CRC_BOX.put(268,14);
		CRC_BOX.put(269,109);
		CRC_BOX.put(270,59);
		CRC_BOX.put(299,19);
		CRC_BOX.put(300,217);
		CRC_BOX.put(301,243);
		CRC_BOX.put(310,28);
		CRC_BOX.put(311,95);
		CRC_BOX.put(320,243);
		CRC_BOX.put(321,88);
		CRC_BOX.put(322,243);
		CRC_BOX.put(323,78);
		CRC_BOX.put(324,132);
		CRC_BOX.put(330,23);
		CRC_BOX.put(331,91);
		CRC_BOX.put(332,236);
		CRC_BOX.put(333,231);
		CRC_BOX.put(334,135);
		CRC_BOX.put(335,225);
		CRC_BOX.put(340,99);
		CRC_BOX.put(350,232);
		CRC_BOX.put(360,11);
		CRC_BOX.put(365,36);
		CRC_BOX.put(370,98);
		CRC_BOX.put(371,161);
		CRC_BOX.put(375,251);
		CRC_BOX.put(380,232);
		CRC_BOX.put(385,147);
		CRC_BOX.put(390,156);
		CRC_BOX.put(395,231);
		CRC_BOX.put(400,110);
		CRC_BOX.put(401,183);
		CRC_BOX.put(9000,113);
		CRC_BOX.put(12900,197);
		CRC_BOX.put(12901,16);
		CRC_BOX.put(12902,181);
		CRC_BOX.put(12903,149);
		CRC_BOX.put(12904,238);
		CRC_BOX.put(12905,56);
		CRC_BOX.put(12915,67);
	}
}

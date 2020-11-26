package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_RESULT")
public enum  MavResult {
	
	/**
	 * Command is valid (is supported and has valid parameters), and was executed.
	 */
	@MavlinkEnumEntry(value = 0,description = "Command is valid (is supported and has valid parameters), and was executed.")
	MAV_RESULT_ACCEPTED(),
	
	/**
	 * Command is valid, but cannot be executed at this time. This is used to indicate a problem that should be fixed just by waiting (e.g. a state machine is busy, can't arm because have not got GPS lock, etc.). Retrying later should work.
	 */
	@MavlinkEnumEntry(value = 1,description = "Command is valid, but cannot be executed at this time. This is used to indicate a problem that should be fixed just by waiting (e.g. a state machine is busy, can't arm because have not got GPS lock, etc.). Retrying later should work.")
	MAV_RESULT_TEMPORARILY_REJECTED(),
	
	/**
	 * Command is invalid (is supported but has invalid parameters). Retrying same command and parameters will not work.
	 */
	@MavlinkEnumEntry(value = 2,description = "Command is invalid (is supported but has invalid parameters). Retrying same command and parameters will not work.")
	MAV_RESULT_DENIED(),
	
	/**
	 * Command is not supported (unknown).
	 */
	@MavlinkEnumEntry(value = 3,description = "Command is not supported (unknown).")
	MAV_RESULT_UNSUPPORTED(),
	
	/**
	 * Command is valid, but execution has failed. This is used to indicate any non-temporary or unexpected problem, i.e. any problem that must be fixed before the command can succeed/be retried. For example, attempting to write a file when out of memory, attempting to arm when sensors are not calibrated, etc.
	 */
	@MavlinkEnumEntry(value = 4,description = "Command is valid, but execution has failed. This is used to indicate any non-temporary or unexpected problem, i.e. any problem that must be fixed before the command can succeed/be retried. For example, attempting to write a file when out of memory, attempting to arm when sensors are not calibrated, etc.")
	MAV_RESULT_FAILED(),
	
	/**
	 * Command is valid and is being executed. This will be followed by further progress updates, i.e. the component may send further COMMAND_ACK messages with result MAV_RESULT_IN_PROGRESS (at a rate decided by the implementation), and must terminate by sending a COMMAND_ACK message with final result of the operation. The COMMAND_ACK.progress field can be used to indicate the progress of the operation.
	 */
	@MavlinkEnumEntry(value = 5,description = "Command is valid and is being executed. This will be followed by further progress updates, i.e. the component may send further COMMAND_ACK messages with result MAV_RESULT_IN_PROGRESS (at a rate decided by the implementation), and must terminate by sending a COMMAND_ACK message with final result of the operation. The COMMAND_ACK.progress field can be used to indicate the progress of the operation.")
	MAV_RESULT_IN_PROGRESS(),
	
	/**
	 * Command has been cancelled (as a result of receiving a COMMAND_CANCEL message).
	 */
	@MavlinkEnumEntry(value = 6,description = "Command has been cancelled (as a result of receiving a COMMAND_CANCEL message).")
	MAV_RESULT_CANCELLED(),
}
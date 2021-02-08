package com.vamosys.drs.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.RawValue

@kotlinx.parcelize.Parcelize
data class DrsResponse(
	val exception: @RawValue Any? = null,
	val result: @RawValue Any? = null,
	val pagination: @RawValue Any? = null,
	val excCode: @RawValue Any? = null,
	val data: Data? = null,
	val errorDesc: @RawValue Any? = null,
	val errorCode: Int? = null,
	val successDesc: @RawValue Any? = null,
	val message: String? = null
) : Parcelable

@Parcelize
data class DataStatusItem(
	val bodyType: String? = null,
	val subPlanNum: Int? = null,
	val driverTripAttentionCount: Int? = null,
	val startOdo: Int? = null,
	val loadingLocationList: @RawValue Any? = null,
	val documents: String? = null,
	val own: String? = null,
	val unLoadingLocationList: @RawValue Any? = null,
	val planName: String? = null,
	val managerName: String? = null,
	val eta: Int? = null,
	val attentiontype: @RawValue Any? = null,
	val tripStartedTime: Long? = null,
	val currentOdo: String? = null,
	val gpsStatus: @RawValue Any? = null,
	val draft: Boolean? = null,
	val endLocation: String? = null,
	val driverTripNum: Int? = null,
	val vehicleType: String? = null,
	val contactPersonname: String? = null,
	val planRestrictStartTime: Int? = null,
	val startFuelLevel: Int? = null,
	val planStartTime: Int? = null,
	val planRestrictEndTime: Int? = null,
	val count: Int? = null,
	val vehicleMake: String? = null,
	val mobileNum: String? = null,
	val driverId: String? = null,
	val handOverDriverStatus1: String? = null,
	val gpsFuel: String? = null,
	val driverName: String? = null,
	val installStatus: Int? = null,
	val lastTransactionTime: Long? = null,
	val handOverType: String? = null,
	val simTracking: Int? = null,
	val contactPersonNumber: String? = null,
	val vehicleStatus: String? = null,
	val vehicleName: String? = null,
	val nextTripNum: String? = null,
	val simconsent: String? = null,
	val attentionStatus: String? = null,
	val link: String? = null,
	val error: String? = null,
	val driverStatus: String? = null,
	val duration: Int? = null,
	val startLocation: String? = null,
	val endLocationType: String? = null,
	val availableAmount: Int? = null,
	val nextTransactionStatus: @RawValue Any? = null,
	val simTrackingEnabled: Boolean? = null,
	val checkListNum: String? = null,
	val vehicleId: String? = null,
	val currentVehicleStatusType: String? = null,
	val countDetails: @RawValue Any? = null,
	val lastFuelFill: Int? = null,
	val handover: Boolean? = null,
	val address: @RawValue Any? = null,
	val checkListSubmission: Int? = null,
	val attentionList: List<@RawValue Any?>? = null,
	val docType: String? = null,
	val nextPoint: @RawValue Any? = null,
	val dlNum: String? = null,
	val driverType: Int? = null,
	val fragileMaterial: String? = null,
	val gpsTracking: Boolean? = null,
	val time: Long? = null,
	val fmd: @RawValue Any? = null,
	val handOverDetails: @RawValue Any? = null,
	val vehicleLoadStatus: String? = null,
	val latlng: String? = null
) : Parcelable

@Parcelize
data class VehCountDetailsItem(
	val count: Int? = null,
	val type: String? = null
) : Parcelable

@Parcelize
data class UnLoadingLocationListItem(
	val dateTime: String? = null,
	val seqNum: Int? = null,
	val tripPlannerNum: Int? = null,
	val locationType: String? = null,
	val location: String? = null,
	val lastUpdatedTime: Int? = null,
	val completedStatus: Int? = null,
	val time: Long? = null,
	val completedBy: @RawValue Any? = null,
	val locationPlannedTime: Long? = null
) : Parcelable

@Parcelize
data class Data(
	val vehCountDetails: List<VehCountDetailsItem?>? = null,
	val dataStatus: List<DataStatusItem?>? = null
) : Parcelable

@Parcelize
data class LoadingLocationListItem(
	val dateTime: String? = null,
	val seqNum: Int? = null,
	val tripPlannerNum: Int? = null,
	val locationType: String? = null,
	val location: String? = null,
	val lastUpdatedTime: Int? = null,
	val completedStatus: Int? = null,
	val time: Long? = null,
	val completedBy: @RawValue Any? = null,
	val locationPlannedTime: Long? = null
) : Parcelable

@Parcelize
data class NextPoint(
	val dateTime: String? = null,
	val seqNum: Int? = null,
	val tripPlannerNum: Int? = null,
	val locationType: String? = null,
	val location: String? = null,
	val lastUpdatedTime: Int? = null,
	val completedStatus: Int? = null,
	val time: Long? = null,
	val completedBy: @RawValue Any? = null,
	val locationPlannedTime: Long? = null
) : Parcelable

package it.adami.api.user.converters

import java.sql.Timestamp
import java.time.LocalDateTime

import it.adami.api.user.domain.User
import it.adami.api.user.http.json.{CreateUserRequest, UserDetailResponse, UserProfileResponse}
import it.adami.api.user.util.StringUtils

object UserConverters {

  implicit def convertToUser(req: CreateUserRequest): User =
    User(
      firstname = req.firstname,
      lastname = req.lastname,
      email = req.email,
      password = req.password,
      dateOfBirth = StringUtils.getDateFromString(req.dateOfBirth),
      creationDate = Timestamp.valueOf(LocalDateTime.now()),
      gender = req.gender,
      enabled = false
    )

  implicit def convertToUserDetail(user: User): UserDetailResponse =
    UserDetailResponse(
      firstname = user.firstname,
      lastname = user.lastname,
      email = user.email,
      dateOfBirth = user.dateOfBirth.toString,
      gender = user.gender,
      creationDate = user.creationDate.toString
    )

  implicit def convertToUserProfile(user: User): UserProfileResponse =
    UserProfileResponse(
      id = user.id.get,
      firstname = user.firstname,
      lastname = user.lastname,
      email = user.email,
      dateOfBirth = user.dateOfBirth.toString,
      gender = user.gender,
      creationDate = user.creationDate.toString,
      enabled = user.enabled
    )

}

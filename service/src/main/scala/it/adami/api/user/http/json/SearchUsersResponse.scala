package it.adami.api.user.http.json

case class SearchUserItem(
    id: Int,
    firstname: String,
    lastname: String,
    email: String,
    dateOfBirth: String,
    gender: String,
    creationDate: String
)

case class SearchUsersResponse(items: Seq[SearchUserItem])

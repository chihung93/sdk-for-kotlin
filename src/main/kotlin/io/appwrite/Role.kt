package io.appwrite

class Role {
    companion object {
        fun any(): String = "any"

        fun user(id: String, status: String = ""): String = if(status.isEmpty()) {
            "user:$id"
        } else {
            "user:$id/$status"
        }

        fun users(status: String = ""): String = if(status.isEmpty()) {
            "users"
        } else {
            "users/$status"
        }

        fun guests(): String = "guests"

        fun team(id: String, role: String = ""): String = if(role.isEmpty()) {
            "team:$id"
        } else {
            "team:$id/$role"
        }

        fun member(id: String): String = "member:$id"

        fun status(status: String): String = "status:$status"
    }
}
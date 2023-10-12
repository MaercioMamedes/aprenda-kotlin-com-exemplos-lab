package app.models

import java.util.*
import kotlin.random.Random

data class User(val id: String, val name: String) {

    override fun toString(): String {
        return "User: id=$id, name=$name"
    }

    companion object{

        fun creteUser(name: String): User {
            val id = name.take(2) + Random.nextInt(100,1000)
            val user = User(id= id.uppercase(Locale.getDefault()), name=name)
            ListUsers.listUsers.add(user)

            return user
        }
    }
}

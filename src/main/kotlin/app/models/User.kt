package app.models

data class User(val id: Int, val name: String) {
    override fun toString(): String {

        return "{'id': '${this.id}', 'name: '${this.name}'}"
    }
}

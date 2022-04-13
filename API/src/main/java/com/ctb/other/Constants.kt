package com.ctb.other

data class Constants(
    var ERROR_MESSAGE: String = "Errör",
)

class URL {
    companion object Factory {
        const val ACCOUNT: String = "/account"
        const val RECIPE: String = "/recipe"
        const val INGREDIENT: String = "/ingredient"
        const val FEEDBACK: String = "/feedback"
    }
}

class API {
    companion object Factory {
        const val INSERT: String = "/insert"
        const val GET: String = "/get"
        const val UPDATE: String = "/update"
        const val DELETE: String = "/delete"

        const val LOGIN: String = "/login"
        const val REGISTER: String = "/register"

        const val ALL: String = "-all"
        const val RECOMMENDED: String = "-recommended"
    }
}

class DB {
    companion object Factory {
        const val ACCOUNT: String = "account"
        const val RECIPE: String = "recipe"
        const val INGREDIENT: String = "ingredient"
        const val FEEDBACK: String = "feedback"
        const val RECIPE_INGREDIENT: String = "recipe_ingredient"
    }
}

class ERROR {
    companion object Factory {
        const val INVALID_PASSWORD: String = "Invalid username and/or password"
    }
}
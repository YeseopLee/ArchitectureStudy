package com.example.architecture.data.model

data class RepoSearchResponse(
    var total_count: Int,
    val items: ArrayList<RepoItem>
) {
    data class RepoItem(
        var full_name: String,
        val owner: Owner

    ) {
        data class Owner(
            var login: String,
            val avatar_url: String
        )
    }
}


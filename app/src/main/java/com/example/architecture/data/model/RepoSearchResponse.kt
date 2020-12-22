package com.example.architecture.data.model

data class RepoSearchResponse(
    var total_count: Int,
    val items: List<RepoItem>
) {
    data class RepoItem(
        var archive_url: String,
        var full_name: String,
        var name: String,
        var private: Boolean,
        val owner: Owner

    ) {
        data class Owner(
            var login: String,
            val avatar_url: String
        )
    }
}


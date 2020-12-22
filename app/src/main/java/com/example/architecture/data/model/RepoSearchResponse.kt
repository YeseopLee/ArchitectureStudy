package com.example.architecture.data.model

data class RepoSearchResponse(
    val total_count: Int,
    val items: List<RepoItem>
) {
    data class RepoItem(
        val archive_url: String,
        val full_name: String,
        val name: String,
        val private: Boolean,
        val owner: Owner
    ) {
        data class Owner(
            val login: String,
            val avatar_url: String
        )
    }
}


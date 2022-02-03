package com.example.android.multiactivitygithubsearch.data

import com.squareup.moshi.Json
import java.io.Serializable

data class GitHubRepo(
    @Json(name = "full_name") val name: String,
    val description: String,
    @Json(name = "html_url") val url: String,
    @Json(name = "stargazers_count") val stars: Int
) : Serializable

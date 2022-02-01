package com.example.android.multiactivitygithubsearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.multiactivitygithubsearch.data.GitHubRepo

class GitHubRepoListAdapter(private val onGitHubRepoClick: (GitHubRepo) -> Unit)
    : RecyclerView.Adapter<GitHubRepoListAdapter.GitHubRepoViewHolder>() {
    var gitHubRepoList = listOf<GitHubRepo>()

    fun updateRepoList(newRepoList: List<GitHubRepo>?) {
        gitHubRepoList = newRepoList ?: listOf()
        notifyDataSetChanged()
    }

    override fun getItemCount() = gitHubRepoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubRepoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.github_repo_list_item, parent, false)
        return GitHubRepoViewHolder(itemView, onGitHubRepoClick)
    }

    override fun onBindViewHolder(holder: GitHubRepoViewHolder, position: Int) {
        holder.bind(gitHubRepoList[position])
    }

    class GitHubRepoViewHolder(itemView: View, val onClick: (GitHubRepo) -> Unit)
        : RecyclerView.ViewHolder(itemView) {
        private val nameTV: TextView = itemView.findViewById(R.id.tv_name)
        private var currentGitHubRepo: GitHubRepo? = null

        init {
            itemView.setOnClickListener {
                currentGitHubRepo?.let(onClick)
            }
        }

        fun bind(gitHubRepo: GitHubRepo) {
            currentGitHubRepo = gitHubRepo
            nameTV.text = gitHubRepo.name
        }
    }
}